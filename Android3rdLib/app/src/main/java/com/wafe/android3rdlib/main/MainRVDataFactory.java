package com.wafe.android3rdlib.main;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.butterknife.BKMainActivity;
import com.wafe.android3rdlib.eventbus.EBFirstActivity;
import com.wafe.android3rdlib.other.checkpermission.CheckPermissionActivity;
import com.wafe.android3rdlib.recyclerview.RVActivityMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/6/17.
 */
public class MainRVDataFactory {
    public static List<MainRVDataModel> RV_DATAS = new ArrayList<>();
    public static List<MainRVDataModel> RV_OTHER_DATAS = new ArrayList<>();

    static {
        RV_DATAS.add(new MainRVDataModel(RVActivityMain.class, R.string.rv_title,R.string.rv_describtion));
        RV_DATAS.add(new MainRVDataModel(EBFirstActivity.class, R.string.eventbus_title, R.string.eventbus_details));
        RV_DATAS.add(new MainRVDataModel(BKMainActivity.class, R.string.butterknife_title, R.string.butterknife_details));
    }

    static {
        RV_OTHER_DATAS.add(new MainRVDataModel(CheckPermissionActivity.class, R.string.check_permission_title, R.string.check_permission_details));
    }
}
