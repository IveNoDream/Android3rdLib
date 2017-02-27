package com.wafe.android3rdlib.main;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.recyclerview.RVActivityMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/6/17.
 */
public class MainRVDataFactory {
    public static List<MainRVDataModel> RV_DATAS = new ArrayList<>();

    static {
        RV_DATAS.add(new MainRVDataModel(RVActivityMain.class, R.string.rv_title,R.string.rv_describtion));
    }
}