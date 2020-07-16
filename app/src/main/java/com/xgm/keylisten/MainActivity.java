package com.xgm.keylisten;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.hardware.input.InputManager.*;

public class MainActivity extends AppCompatActivity {

    Context mainCt;
    Button btnExit;
    Button btnAction;
    private    KeyBroadReceiver innerReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//        startService()
        btnAction=findViewById(R.id.btn_action);
        btnExit=findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(this::btnClick);
        btnAction.setOnClickListener(this::btnClick);

    }

    private void btnClick(View view) {
        switch (view.getId()){
            case R.id.btn_exit:
                this.finish();
              System.exit(0);
                break;
            case R.id.btn_action:
                Log.i("btnAction","开启服务！");
                Intent intent = null;
                try {
                    intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                } catch (Exception e) {
                    intent = new Intent(Settings.ACTION_SETTINGS);
                    e.printStackTrace();

                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
                //创建广播
//                 innerReceiver = new KeyBroadReceiver();
//                //动态注册广播
//                IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
//                //启动广播
//                registerReceiver(innerReceiver, intentFilter);


                break;
            default:
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.i("MainInfo","返回按键监听1");
            return true;//return true;拦截事件传递,从而屏蔽back键。
        }
        if (KeyEvent.KEYCODE_HOME == keyCode) {
            Log.i("MainInfo","home按键禁用");
            return true;//同理
        }
//        if(KeyEvent.KEYCODE_F3==keycode)
//            Toast.makeText(this,"发送按键值",Toast.LENGTH_SHORT);
//        sendKeyCode(4000);
        return super.onKeyDown(keyCode, event);
    }

}