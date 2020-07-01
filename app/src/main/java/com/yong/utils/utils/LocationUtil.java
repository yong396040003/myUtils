package com.yong.utils.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import static android.content.Context.LOCATION_SERVICE;

/**
 * 判断定位是否开启
 */
public class LocationUtil {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean isLocated(Context context) {
        //得到系统的位置服务，判断GPS是否激活
        LocationManager locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void openSettings(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        activity.startActivity(intent);
    }
}

