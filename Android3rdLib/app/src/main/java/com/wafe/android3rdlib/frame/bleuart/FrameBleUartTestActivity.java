package com.wafe.android3rdlib.frame.bleuart;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.siasun.blelib.BleManager;
import com.siasun.blelib.BleManagerCallbacks;
import com.siasun.blelib.uart.UARTManager;
import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

import java.util.UUID;

import no.nordicsemi.android.log.ILogSession;
import no.nordicsemi.android.log.LocalLogSession;
import no.nordicsemi.android.log.Logger;

/**
 * Created by wafej on 2018/4/9.
 */

public class FrameBleUartTestActivity extends AppCompatActivity implements ScannerFragment.OnDeviceSelectedListener {
    private final static String TAG = LogUtils.TAG + "BLE";
    private static final String SIS_CONNECTION_STATUS = "connection_status";
    private static final String SIS_DEVICE_NAME = "device_name";
    private BluetoothAdapter mBluetoothAdapter;
    private final static int REQUEST_ENABLE_BT = 1;
    private boolean mDeviceConnected = false;
    private BleManager<? extends BleManagerCallbacks> mBleManager;
    private ILogSession mLogSession;
    private String mDeviceName;
    private UARTService.UARTBinder mServiceBinder;
    private BluetoothDevice mBluetoothDevice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_bleuart_main_activity);

        // Use this check to determine whether BLE is supported on the device. Then
        // you can selectively disable BLE-related features.
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(this, "BLE not support", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Initializes Bluetooth adapter.
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        // Ensures Bluetooth is available on the device and it is enabled. If not,
        // displays a dialog requesting user permission to enable Bluetooth.
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            //Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            showBLEDialog();
        }

        mBleManager = UARTManager.getInstance(getApplicationContext());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BT && resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "canceled", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onSendClicked(final View view) {
        if (null != mServiceBinder) {
            mServiceBinder.send("OK");
            //mBleManager
        }
    }

    /**
     * Called when user press CONNECT or DISCONNECT button. See layout files -> onClick attribute.
     */
    public void onConnectClicked(final View view) {
        if (isBLEEnabled()) {
            if (!mDeviceConnected) {
                //setDefaultUI();
                showDeviceScanningDialog(getFilterUUID());
            } else {
                mBleManager.disconnect();
            }
        } else {
            showBLEDialog();
        }
    }

    private UUID getFilterUUID() {
        return null;
    }


    protected boolean isBLEEnabled() {
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        final BluetoothAdapter adapter = bluetoothManager.getAdapter();
        return adapter != null && adapter.isEnabled();
    }


    protected void showBLEDialog() {
        final Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
    }

    /**
     * Shows the scanner fragment.
     *
     * @param filter               the UUID filter used to filter out available devices. The fragment will always show all bonded devices as there is no information about their
     *                             services
     * @see #getFilterUUID()
     */
    private void showDeviceScanningDialog(final UUID filter) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final ScannerFragment dialog = ScannerFragment.getInstance(filter);
                dialog.show(getSupportFragmentManager(), "scan_fragment");
            }
        });
    }

    @Override
    public void onDeviceSelected(BluetoothDevice device, String name) {
        final int titleId = getLoggerProfileTitle();
        if (titleId > 0) {
            mLogSession = Logger.newSession(getApplicationContext(), getString(titleId), device.getAddress(), name);
            // If nRF Logger is not installed we may want to use local logger
            if (mLogSession == null && getLocalAuthorityLogger() != null) {
                mLogSession = LocalLogSession.newSession(getApplicationContext(), getLocalAuthorityLogger(), device.getAddress(), name);
            }
        }
        mDeviceName = name;

        // The device may not be in the range but the service will try to connect to it if it reach it
        Logger.d(mLogSession, "Creating service...");
        final Intent service = new Intent(this, UARTService.class);
        service.putExtra(BleProfileService.EXTRA_DEVICE_ADDRESS, device.getAddress());
        service.putExtra(BleProfileService.EXTRA_DEVICE_NAME, name);
        if (mLogSession != null)
            service.putExtra(BleProfileService.EXTRA_LOG_URI, mLogSession.getSessionUri());
        startService(service);
        Logger.d(mLogSession, "Binding to the service...");
        bindService(service, mServiceConnection, Context.BIND_AUTO_CREATE);

        mBleManager.setLogger(mLogSession);
        Log.i(TAG,"onDeviceSelected end");
        //mBleManager.connect(device);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @SuppressWarnings("unchecked")
        @Override
        public void onServiceConnected(final ComponentName name, final IBinder service) {
            Log.i(TAG,"onServiceConnected start");
            mServiceBinder = (UARTService.UARTBinder) service;
            mBluetoothDevice = mServiceBinder.getBluetoothDevice();
            mLogSession = mServiceBinder.getLogSession();
            Logger.d(mLogSession, "Activity bound to the service");
            //onServiceBinded(bleService);
            //mServiceBinder.connect();
            //mBleManager.connect(mBluetoothDevice);

            // Update UI
            mDeviceName = mServiceBinder.getDeviceName();
            //mDeviceNameView.setText(mDeviceName);
            //mConnectButton.setText(R.string.action_disconnect);

            // And notify user if device is connected
            if (mServiceBinder.isConnected()) {
                //onDeviceConnected(mBluetoothDevice);
                Log.i(TAG,"device: " + mDeviceName + " connected");
            } else {
                // If the device is not connected it means that either it is still connecting,
                // or the link was lost and service is trying to connect to it (autoConnect=true).
                //onDeviceConnecting(mBluetoothDevice);
                Log.i(TAG,"device: " + mDeviceName + " connecting");
            }
        }

        @Override
        public void onServiceDisconnected(final ComponentName name) {
            // Note: this method is called only when the service is killed by the system,
            // not when it stops itself or is stopped by the activity.
            // It will be called only when there is critically low memory, in practice never
            // when the activity is in foreground.
            Log.i(TAG,"Activity disconnected from the service");
            Logger.d(mLogSession, "Activity disconnected from the service");
            //mDeviceNameView.setText(getDefaultDeviceName());
            //mConnectButton.setText(R.string.action_connect);

            mServiceBinder = null;
            mDeviceName = null;
            mBluetoothDevice = null;
            mLogSession = null;
            //onServiceUnbinded();
        }
    };

    @Override
    public void onBackPressed() {
        mBleManager.disconnect();
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SIS_CONNECTION_STATUS, mDeviceConnected);
        outState.putString(SIS_DEVICE_NAME, mDeviceName);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mDeviceConnected = savedInstanceState.getBoolean(SIS_CONNECTION_STATUS);
        mDeviceName = savedInstanceState.getString(SIS_DEVICE_NAME);

        if (mDeviceConnected) {
            //mConnectButton.setText(R.string.action_disconnect);
        } else {
            //mConnectButton.setText(R.string.action_connect);
        }
    }

    @Override
    public void onDialogCanceled() {

    }

    /**
     * Returns the title resource id that will be used to create logger session. If 0 is returned (default) logger will not be used.
     *
     * @return the title resource id
     */
    protected int getLoggerProfileTitle() {
        return 0;
    }

    /**
     * This method may return the local log content provider authority if local log sessions are supported.
     *
     * @return local log session content provider URI
     */
    protected Uri getLocalAuthorityLogger() {
        return null;
    }
}
