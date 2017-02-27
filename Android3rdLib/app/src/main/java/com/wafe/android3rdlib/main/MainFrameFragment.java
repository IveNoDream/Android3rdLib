package com.wafe.android3rdlib.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 2/14/17.
 */
public class MainFrameFragment extends Fragment {

    private View mFragmentView;
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.main_tab_frame,container,false);
        mContext = getActivity();

        return mFragmentView;
    }
}
