package com.xgm.keylisten;

import android.accessibilityservice.AccessibilityService;
import android.app.Instrumentation;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

class KeyService extends AccessibilityService {

    private static final String TAG = KeyService.class.getSimpleName();
    public static KeyService mService;
    @Override
    public boolean onKeyEvent(KeyEvent event) {
        Log.i(TAG, "onKeyEvent");
        Toast.makeText(getApplicationContext(),"显示键盘",Toast.LENGTH_SHORT);
        int key = event.getKeyCode();
        switch(key){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.i(TAG, "KEYCODE_VOLUME_DOWN");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.i(TAG, "KEYCODE_VOLUME_UP");
                break;
            case KeyEvent.KEYCODE_F2:
               Toast.makeText(getApplicationContext(),"您已按下F2键",Toast.LENGTH_SHORT);
                sendKeyCode(4000);
        }
        return super.onKeyEvent(event);
    }

    private void sendKeyCode(final int keyCode) {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(keyCode);
                } catch (Exception e) {
                    Log.e("Exception when sendPointerSync", e.toString());
                }
            }
        }.start();
    }


    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        mService = this;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String pkgName = event.getPackageName().toString();
        String className = event.getClassName().toString();
        int eventType = event.getEventType();

        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                break;
        }
    }

    /**
     * 辅助功能是否启动
     */
    public static boolean isStart() {

        return mService != null;

    }

    @Override
    public void onInterrupt() {

    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
