package com.example.test7_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean isConnected = networkInfo !=null && networkInfo.isConnectedOrConnecting();
        if(isConnected){
            boolean isWifi = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            Log.d("NetWork","网络类型："+(isWifi?"Wifi":"移动网络"));
        }else{
            Log.d("NetWork","网络连接断开");
        }
    }
}
