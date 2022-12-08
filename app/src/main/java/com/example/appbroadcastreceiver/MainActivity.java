package com.example.appbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyBroadCastReceiver.OnReceivedAction {

    private String TAG ="MainActivity";
   private MyBroadCastReceiver myBroadCastReceiver;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.name);
        Log.d(TAG, "onCreate: ");

    }

    public void registerReceiver() {
        Log.d(TAG, "registerReceiver: ");
        myBroadCastReceiver = new MyBroadCastReceiver(this);
        IntentFilter customIntentFilter = new IntentFilter();
        customIntentFilter.addAction("android.CUSTOM_ACTION");
        this.registerReceiver(myBroadCastReceiver, customIntentFilter);
    }

    @Override
    public void event(Intent intent) {
        Log.d(TAG, "event:1 ");
        Toast.makeText(this, "Event Triggered", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "event:2 ");
        String receivedText = intent.getStringExtra("name");
        Log.d(TAG, "event:3 ");
          if(receivedText !=null) {
              Log.d(TAG, "event:4 ");
            textView.setText(receivedText);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        unregisterReceiver(myBroadCastReceiver);
    }
}