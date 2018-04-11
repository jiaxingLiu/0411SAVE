package com.example.jiaxing.clear;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView usedMemory;
    private TextView freeMemory;
    private TextView allMemory;
    //    private TextView usedRam;
//    private TextView freeRma;
//    private TextView allRam;
    private Button clear;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        initView();  //初始化界面
        updateMemoryInfo(); //初始化内存数据

        Log.d("getTotalRam:", SystemInfoUtil.getTotalRam(context) + "");
        Log.d("getAvailMemory:", SystemInfoUtil.getAvailMemory(context) + "");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SystemInfoUtil.clearMemory(context);
                SystemInfoUtil.clearMem(context);
                updateMemoryInfo();

                Log.d("getTotalRam------->:", SystemInfoUtil.getTotalRam(context) + "");
                Log.d("getAvailMemory------>:", SystemInfoUtil.getAvailMemory(context) + "M");
            }
        });
    }

    /**
     * 更新内存信息
     */
    private void updateMemoryInfo() {
        allMemory.setText(SystemInfoUtil.getTotalRam(context));
        freeMemory.setText(SystemInfoUtil.getAvailRam(context));
    }


    /**
     * 初始化View
     */
    private void initView() {
        freeMemory = findViewById(R.id.free_memory);
        allMemory = findViewById(R.id.all_memory);
        clear = findViewById(R.id.clear);
    }


}
