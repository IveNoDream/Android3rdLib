package com.wafe.android3rdlib.custom.TreeView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.custom.TreeView.lib.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangfeng2@siasun.com on 2018/8/20.
 */
public class TreeViewActivity extends AppCompatActivity {

    private List<FileBean> mDatas = new ArrayList<FileBean>();
    private ListView mTree;
    private TreeListViewAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_tree_view_activity);
        initDatas();
        mTree = (ListView) findViewById(R.id.id_tree);
        try
        {
            mAdapter = new SimpleTreeAdapter<FileBean>(mTree, this, mDatas, 10);

            mAdapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener()
            {
                @Override
                public void onClick(com.wafe.android3rdlib.custom.TreeView.lib.Node node, int position) {
                    {
                        if (node.isLeaf())
                        {
                            Toast.makeText(getApplicationContext(), node.getName(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });

            mTree.setAdapter(mAdapter);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }


    private void initDatas()
    {

        // id , pid , label , 其他属性
        mDatas.add(new FileBean(1, 0, "文件管理系统"));
        mDatas.add(new FileBean(2, 1, "游戏"));
        mDatas.add(new FileBean(3, 1, "文档"));
        mDatas.add(new FileBean(4, 1, "程序"));
        mDatas.add(new FileBean(5, 2, "war3"));
        mDatas.add(new FileBean(6, 2, "刀塔传奇"));

        mDatas.add(new FileBean(7, 4, "面向对象"));
        mDatas.add(new FileBean(8, 4, "非面向对象"));

        mDatas.add(new FileBean(9, 7, "C++"));
        mDatas.add(new FileBean(10, 7, "JAVA"));
        mDatas.add(new FileBean(11, 7, "Javascript"));
        mDatas.add(new FileBean(12, 8, "C语言"));
        mDatas.add(new FileBean(13, 8, "C语言"));
        mDatas.add(new FileBean(14, 8, "C语言"));
        mDatas.add(new FileBean(15, 8, "C语言"));
        mDatas.add(new FileBean(16, 8, "C语言"));
        mDatas.add(new FileBean(17, 8, "C语言"));
        mDatas.add(new FileBean(18, 8, "C语言"));
        mDatas.add(new FileBean(19, 8, "C语言"));
        mDatas.add(new FileBean(20, 8, "C语言"));
        mDatas.add(new FileBean(21, 8, "C语言"));
        mDatas.add(new FileBean(22, 8, "C语言"));
        mDatas.add(new FileBean(23, 8, "C语言"));
        mDatas.add(new FileBean(24, 8, "C语言"));
        mDatas.add(new FileBean(25, 8, "C语言"));
        mDatas.add(new FileBean(26, 8, "C语言"));
        mDatas.add(new FileBean(27, 8, "C语言"));

    }
}
