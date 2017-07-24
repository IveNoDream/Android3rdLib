package com.wafe.android3rdlib.other.sysinfo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wafe.android3rdlib.R;


public class SysInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_sysinfo_main);
        TextView textView = (TextView) findViewById(R.id.text);
        String systemInfoStr = SystemInfoTools.getBuildInfo();
        systemInfoStr += "-------------------------------------\r\n";
        systemInfoStr += SystemInfoTools.getSystemPropertyInfo();
        textView.setText(systemInfoStr);
    }
}
