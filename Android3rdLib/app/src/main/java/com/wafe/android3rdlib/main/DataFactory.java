package com.wafe.android3rdlib.main;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.recyclerview.ActivityRVMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/6/17.
 */
public class DataFactory {
    public static List<DataModel> RV_DATAS = new ArrayList<>();

    static {
        RV_DATAS.add(new DataModel(ActivityRVMain.class, R.string.rv_title,R.string.rv_describtion));
    }
}
