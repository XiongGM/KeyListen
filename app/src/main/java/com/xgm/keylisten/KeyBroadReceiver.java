package com.xgm.keylisten;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class KeyBroadReceiver extends BroadcastReceiver {
    final String SYSTEM_DIALOG_REASON_KEY = "reason";

    final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

    final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
            String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
            Log.d("MainInfo", "onReceive: 此按键为："+reason);
            if (reason != null) {
                if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                    Log.i("MainInfo","home按键监听1");
                } else if (reason.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                    Log.i("MainInfo","多任务键被监听");
                }
            }
        }
    }
}
