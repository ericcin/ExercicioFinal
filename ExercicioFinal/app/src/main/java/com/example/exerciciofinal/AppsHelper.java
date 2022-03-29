/*
package com.example.exerciciofinal;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class AppsHelper {
    public static List<MyApp> getContacts(Context context) {

        List<MyApp> apps = new ArrayList<MyApp>();

        ContentResolver contentResolver = context.getContentResolver();
        PackageManager packageManager = context.getPackageManager();

        if (contentResolver != null){
            Cursor cursor = contentResolver.query(
                    (Uri) packageManager.getInstalledApplications(PackageManager.GET_META_DATA), null, null, null, null
            );

            if ((cursor != null ? cursor.getCount(): 0) > 0) {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range")
                    String id = cursor.getString(cursor.getColumnIndex(
                            packageManager.getInstalledApplications(PackageManager.GET_META_DATA)._ID
                    ));

                    @SuppressLint("Range")
                    String name = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.Contacts.DISPLAY_NAME
                    ));

                    MyApp app = new MyApp(Integer.parseInt(id), name);

                    apps.add(app);
                }
            }

            if (cursor != null){
                cursor.close();
            }
        }

        return apps;
    }
}
*/
