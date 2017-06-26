package com.zmm.wifiserverstart.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmm.wifiserverstart.MainActivity;
import com.zmm.wifiserverstart.R;
import com.zmm.wifiserverstart.wifi.WifiManager;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2017/6/26
 * Time:下午3:58
 */

public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {

        try {
            Thread.sleep(2000);
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        wifiStart();
    }

    private void wifiStart() {
        WifiManager wifiManager = new WifiManager();
        wifiManager.start(getApplicationContext(),"HOT-Dev");


    }

}
