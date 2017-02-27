package com.wafe.android3rdlib.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wafe.android3rdlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/14/17.
 */
public class MainActivityMain extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    private LinearLayout mTabFrame;
    private LinearLayout mTab3rd;
    private LinearLayout mTabCustomUI;
    private LinearLayout mTabOther;

    private ImageButton mFrameImg;
    private ImageButton m3rdImg;
    private ImageButton mCustomImg;
    private ImageButton mOtherImg;

    Fragment tab3rd;
    Fragment tabUI;
    Fragment tabOther;
    Fragment tabFrame;

    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);
        initView();
        initEvent();
    }

    private void initView() {
        viewPager = (ViewPager)findViewById(R.id.container);

        mTabFrame = (LinearLayout)findViewById(R.id.ll_tab_frame);
        mTabCustomUI = (LinearLayout)findViewById(R.id.ll_tab_custom_ui);
        mTab3rd = (LinearLayout)findViewById(R.id.ll_tab_3rd);
        mTabOther = (LinearLayout)findViewById(R.id.ll_tab_other);

        mFrameImg = (ImageButton)findViewById(R.id.ib_tab_frame);
        m3rdImg = (ImageButton)findViewById(R.id.ib_tab_3rd);
        mCustomImg = (ImageButton)findViewById(R.id.ib_tab_custom_ui);
        mOtherImg = (ImageButton)findViewById(R.id.ib_tab_other);

        tab3rd = new Main3rdLibFragment();
        tabUI = new MainCustomUIFragment();
        tabOther = new MainOtherFragment();
        tabFrame = new MainFrameFragment();

        mFragments.add(tabFrame);
        mFragments.add(tab3rd);
        mFragments.add(tabUI);
        mFragments.add(tabOther);

        mTitle = (TextView) findViewById(R.id.main_title);

        mAdapter = new FragmentPagerAdapter( getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        viewPager.setAdapter(mAdapter);
    }
    private void initEvent() {

        mTabCustomUI.setOnClickListener(this);
        mTab3rd.setOnClickListener(this);
        mTabOther.setOnClickListener(this);
        mTabFrame.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {

                int currentItem = viewPager.getCurrentItem();

                resetImg();
                switch (currentItem) {
                    case 0:
                        mFrameImg.setImageResource(R.mipmap.tab_frame_pressed);
                        break;
                    case 1:
                        m3rdImg.setImageResource(R.mipmap.tab_3rd_pressed);
                        break;
                    case 2:
                        mCustomImg.setImageResource(R.mipmap.tab_custom_ui_pressed);
                        break;
                    case 3:
                        mOtherImg.setImageResource(R.mipmap.tab_other_pressed);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.ll_tab_frame:
                setSelect(0);
                break;
            case R.id.ll_tab_3rd:
                setSelect(1);
                break;
            case R.id.ll_tab_custom_ui:
                setSelect(2);
                break;
            case R.id.ll_tab_other:
                setSelect(3);
                break;
            default:
                break;
        }
    }
    private void setSelect(int i){

        switch (i) {
            case 0:
                mFrameImg.setImageResource(R.mipmap.tab_frame_pressed);
                break;
            case 1:
                m3rdImg.setImageResource(R.mipmap.tab_3rd_pressed);
                break;
            case 2:
                mCustomImg.setImageResource(R.mipmap.tab_custom_ui_pressed);
                break;
            case 3:
                mOtherImg.setImageResource(R.mipmap.tab_other_pressed);
                break;

            default:
                break;
        }

        viewPager.setCurrentItem(i);
    }

    private void resetImg(){
        mFrameImg.setImageResource(R.mipmap.tab_frame_normal);
        mCustomImg.setImageResource(R.mipmap.tab_custom_ui_normal);
        m3rdImg.setImageResource(R.mipmap.tab_3rd_normal);
        mOtherImg.setImageResource(R.mipmap.tab_other_normal);
    }

}
