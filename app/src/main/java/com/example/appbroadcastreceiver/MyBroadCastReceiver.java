package com.example.appbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyBroadCastReceiver extends BroadcastReceiver {

    private OnReceivedAction onReceivedAction;

    public MyBroadCastReceiver(){}

    public MyBroadCastReceiver(OnReceivedAction onReceivedAction) {
        this.onReceivedAction = onReceivedAction;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

            if(onReceivedAction !=null) {

                if ("android.CUSTOM_ACTION".equals(intent.getAction())) {
                    Log.d("TAG", "onReceive: Action ");
                    onReceivedAction.event(intent);
                }
            }
       }
       // am broadcast -a android.CUSTOM_ACTION --es name "Sandeep"

    public interface OnReceivedAction {
        void event(Intent intent);
    }


}
