package com.wafe.android3rdlib.frame.bmob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 7/4/17.
 */

public class FrameBmobTestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mUpBtn = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.frame_bmob_test_activity);

        //第一：默认初始化
        Bmob.initialize(FrameBmobTestActivity.this, "2e10342f8b99bb0d08e3b64bc05220a4");
        mUpBtn = (Button) findViewById(R.id.bmob_btn_up);
        mUpBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmob_btn_up:

                FrameBmobPerson p2 = new FrameBmobPerson();
                p2.setName("lucky1");
                p2.setAddress("北京海淀1");
                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            Toast.makeText(FrameBmobTestActivity.this,"添加数据成功，返回objectId为："+objectId,Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(FrameBmobTestActivity.this,"创建数据失败：" + e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            default:
                break;
        }
    }
}
