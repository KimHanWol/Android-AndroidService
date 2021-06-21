package kr.ac.jbnu.se.mobile.test_androidservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch(intent.getAction()){
            //배터리 부족
            case "android.intent.action.BATTERY_LOW":
                break;
            //배터리 양호
            case "android.intent.action.BATTETY_OKAY":
                break;
        }
    }
}
