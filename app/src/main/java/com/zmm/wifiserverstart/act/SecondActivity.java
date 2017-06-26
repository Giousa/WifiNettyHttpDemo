package com.zmm.wifiserverstart.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.zmm.wifiserverstart.MainActivity;
import com.zmm.wifiserverstart.R;
import com.zmm.wifiserverstart.model.DeviceModel;
import com.zmm.wifiserverstart.netty.NettyManager;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/6/26
 * Time:下午4:00
 */

public class SecondActivity extends AppCompatActivity implements NettyManager.ReadListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    private void init() {

        Button start = (Button) findViewById(R.id.btn_start);
        Button quit = (Button) findViewById(R.id.btn_quit);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startServer();

            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void startServer() {
        NettyManager nettyManager = new NettyManager();
        nettyManager.setReadListener(this);
//        nettyManager.start();
    }

    @Override
    public void onReadListener(String msg) {
        final DeviceModel deviceModel = JSON.parseObject(msg, DeviceModel.class);
        System.out.println("第二界面: "+deviceModel.toString());
    }
}
