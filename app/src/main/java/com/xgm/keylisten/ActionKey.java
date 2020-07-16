package com.xgm.keylisten;

import android.content.Intent;
import android.provider.Settings;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.core.content.ContextCompat.startForegroundService;

class ActionKey {

    public ActionKey(){
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

    }
}
