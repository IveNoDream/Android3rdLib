package com.wafe.android3rdlib.main;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.custom.view.CustomAnimatorActivity;
import com.wafe.android3rdlib.custom.view.CustomClockActivity;
import com.wafe.android3rdlib.custom.view.CustomSurfaceViewActivity;
import com.wafe.android3rdlib.custom.view.CustomViewActivity;
import com.wafe.android3rdlib.custom.view.CustomViewShapeActivity;
import com.wafe.android3rdlib.frame.bmob.FrameBmobTestActivity;
import com.wafe.android3rdlib.other.sysinfo.SysInfoActivity;
import com.wafe.android3rdlib.other.systest.SysTestMainActivity;
import com.wafe.android3rdlib.thirdpartylibs.butterknife.BKMainActivity;
import com.wafe.android3rdlib.thirdpartylibs.eventbus.EBFirstActivity;
import com.wafe.android3rdlib.other.checkpermission.CheckPermissionActivity;
import com.wafe.android3rdlib.thirdpartylibs.recyclerview.RVActivityMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/6/17.
 */
public class MainRVDataFactory {
    public static List<MainRVDataModel> RV_DATAS = new ArrayList<>();
    public static List<MainRVDataModel> RV_OTHER_DATAS = new ArrayList<>();
    public static List<MainRVDataModel> RV_FRAME_DATAS = new ArrayList<>();
    public static List<MainRVDataModel> RV_CUSTOM_DATS = new ArrayList<>();

    static {
        RV_DATAS.add(new MainRVDataModel(RVActivityMain.class, R.string.rv_title,R.string.rv_describtion));
        RV_DATAS.add(new MainRVDataModel(EBFirstActivity.class, R.string.eventbus_title, R.string.eventbus_details));
        RV_DATAS.add(new MainRVDataModel(BKMainActivity.class, R.string.butterknife_title, R.string.butterknife_details));
    }

    static {
        RV_OTHER_DATAS.add(new MainRVDataModel(CheckPermissionActivity.class, R.string.check_permission_title, R.string.check_permission_details));
        RV_OTHER_DATAS.add(new MainRVDataModel(SysInfoActivity.class, R.string.other_sysinfo_title, R.string.other_sysinfo_details));
        RV_OTHER_DATAS.add(new MainRVDataModel(SysTestMainActivity.class, R.string.other_systest_title, R.string.other_systest_details));
    }

    static {
        RV_FRAME_DATAS.add(new MainRVDataModel(FrameBmobTestActivity.class,R.string.frame_bmob_test_title,R.string.frame_bmob_test_details));
    }

    static {
        RV_CUSTOM_DATS.add(new MainRVDataModel(CustomViewActivity.class,R.string.custom_view_test_title, R.string.custom_view_test_details));
        RV_CUSTOM_DATS.add(new MainRVDataModel(CustomClockActivity.class, R.string.custom_view_clock_title,R.string.custom_view_clock_details));
        RV_CUSTOM_DATS.add(new MainRVDataModel(CustomSurfaceViewActivity.class, R.string.custom_view_surfaceview_title, R.string.custom_view_surfaceview_details));
        RV_CUSTOM_DATS.add(new MainRVDataModel(CustomAnimatorActivity.class, R.string.custom_view_animation_title, R.string.custom_view_animation_details));
    }
}
