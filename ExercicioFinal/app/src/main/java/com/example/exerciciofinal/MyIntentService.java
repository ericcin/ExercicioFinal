package com.example.exerciciofinal;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            //String name = intent.getStringExtra("TELA");

            ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);

            if (activityManager != null) {
                List<ActivityManager.AppTask> tasks = activityManager.getAppTasks();

                String name;
                try {
                    Thread.sleep(1000);
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        name = tasks.get(0).getTaskInfo().topActivity.getClassName();
                    } else {
                        name = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
                    }

                    Toast.makeText(this, "Nome da Tela: " + name, Toast.LENGTH_LONG).show();
                    Thread.sleep(1000);
                }catch(Exception e) {

                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("HSS", "service on destroy");
    }
}
