package com.wafe.android3rdlib.other.checkpermission;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wafe.android3rdlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 5/5/17.
 */
public class CheckPermissionActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int PERMISSION_REQUEST_CODE_KEY = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_check_permission_activity);

        Button btnCheckOne = (Button) findViewById(R.id.btn_check_one);
        Button btnCheckOneMore = (Button) findViewById(R.id.btn_check_onemore);
        Button btnGoSetting = (Button) findViewById(R.id.btn_goto_setting);

        btnCheckOne.setOnClickListener(this);
        btnCheckOneMore.setOnClickListener(this);
        btnGoSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check_one:
                requestRuntimePermission(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE});
                break;
            case R.id.btn_check_onemore:
                requestRuntimePermission(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE});
                break;
            case R.id.btn_goto_setting:
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:"+ getPackageName()));
                startActivity(intent);
                break;
        }
    }

    private void requestRuntimePermission(Context context, String[] permissions) {
        //int readExtStorage = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        //int writeExtStorage = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> permissionStrings = new ArrayList<String>();
        boolean isNeedRequest = false;   //is need request or not

        for (int i = 0; i < permissions.length; i++) {
            int isGranted = checkSelfPermission(permissions[i]);
            if (PackageManager.PERMISSION_GRANTED != isGranted) {
                permissionStrings.add(permissions[i]);
                isNeedRequest = true;
            }
        }

        if (isNeedRequest == true) {
            String[] mPermissionList = new String[permissionStrings.size()];
            mPermissionList = permissionStrings.toArray(mPermissionList);
            requestPermissions(mPermissionList,
                    PERMISSION_REQUEST_CODE_KEY);
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean granted = true;
        boolean mShowPermission = true;
        if (requestCode == PERMISSION_REQUEST_CODE_KEY) {
            granted = (grantResults[0] == PackageManager.PERMISSION_GRANTED);
            if (!granted) {
                mShowPermission = shouldShowRequestPermissionRationale(permissions[0]);
                //refused
                Toast.makeText(CheckPermissionActivity.this,
                        getString(R.string.cp_refused_permission), Toast.LENGTH_SHORT).show();
            }

            if (granted == true) {
                //request permission success, do something
                Toast.makeText(CheckPermissionActivity.this,
                        getString(R.string.cp_required_permission_success), Toast.LENGTH_SHORT).show();
            } else if (!mShowPermission) {
                //Permission refused Toast no longer asked
                Toast.makeText(CheckPermissionActivity.this,
                        getString(R.string.cp_denied_required_permission), Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * used:
     * checkPermission(this, "Manifest.permission.READ_EXTERNAL_STORAGE", "com.android.music")
     * true mean has this permission
     * @param context
     * @param permissionName
     * @param pkgName
     * @return
     */
    private boolean checkPermission(Context context, String permissionName, String pkgName) {
        PackageManager pm = context.getPackageManager();
        if (PackageManager.PERMISSION_GRANTED == pm.checkPermission(permissionName, pkgName)) {
            return true;
        } else {
            return false;
        }
    }
}
