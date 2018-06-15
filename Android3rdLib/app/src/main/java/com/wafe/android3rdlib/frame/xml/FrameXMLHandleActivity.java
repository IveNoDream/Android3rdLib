package com.wafe.android3rdlib.frame.xml;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.frame.xml.data.XMLA;
import com.wafe.android3rdlib.frame.xml.data.XMLBase;

import java.util.LinkedList;

/**
 * Created by wafej on 2018/4/30.
 */

public class FrameXMLHandleActivity extends AppCompatActivity {
    LinkedList<XMLBase> mData = new LinkedList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_xml_handle_activity);
        collectData();
    }

    private void collectData() {
        mData.add(new XMLA("XMLA",1,1));
        mData.add(new XMLA("XMLB",23,2));
        mData.add(new XMLA("XMLB",45,3));
        mData.add(new XMLA("XMLA",67,4));
        mData.add(new XMLA("XMLB",89,5));

    }
}
