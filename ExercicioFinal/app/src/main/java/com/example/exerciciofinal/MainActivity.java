package com.example.exerciciofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivity.MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> list =
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        int i = 0;
        while (i < list.size()){
            Log.d("HSS","Package ID: "+list.get(i).packageName);
            i++;
        }

        BatteryManager bm = (BatteryManager) this.getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        Log.d("HSS","Porcentagem da bateria: "+batLevel+"%");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            boolean charging = bm.isCharging();
            if (charging == true){
                long batTimeCharging = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                    batTimeCharging = bm.computeChargeTimeRemaining();
                }
                Log.d("HSS","Tempo restante de carregamento: "+batTimeCharging);
            }
        }

        Intent intent = new Intent(this,MyIntentService.class);
        startService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new MainActivity.MyBroadcastReceiver();
        IntentFilter filter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("HSS", "O Status do Wi-Fi Mudou");
        }
    }}