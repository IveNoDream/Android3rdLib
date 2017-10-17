package com.wafe.android3rdlib.frame.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

/**
 * Created by root on 10/17/17.
 */

public class FrameSqlMainActivity extends AppCompatActivity {
    private static final String TAG = "SqlMain";
    private FrameDBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_sql_main_activity);
        dbHelper = new FrameDBHelper(this,"BookStore.db",null,1);
        Button mBtnCreate = (Button) findViewById(R.id.btn_frame_sql_create);
        mBtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        Button mBtnAdd = (Button) findViewById(R.id.btn_frame_sql_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //first database
                values.put("name","LOL yeah");
                values.put("author", "vava");
                values.put("pages","888");
                values.put("price",69.88);
                db.insert("Book",null,values);
                values.clear();

                //second database
                values.put("name","Don't Touch me");
                values.put("author", "Joker");
                values.put("pages","786");
                values.put("price",99.80);
                db.insert("Book",null,values);
            }
        });

        Button btnUpdate = (Button) findViewById(R.id.btn_frame_sql_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book",values,"name = ?", new String[] {"Don't Touch me"});
            }
        });

        Button btnDel = (Button) findViewById(R.id.btn_frame_sql_del);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                db.delete("Book","pages > ?", new String[] { "800" });
            }
        });

        Button btnQuery = (Button) findViewById(R.id.btn_frame_sql_query);
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                StringBuilder sb = new StringBuilder();
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        sb.append(name).append("  ").append(author).append("  ").append(pages).append("  ").append(price).append("\n");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                TextView tv = (TextView) findViewById(R.id.tv_frame_sql_query);
                tv.setText(sb.toString());
            }
        });
    }
}
