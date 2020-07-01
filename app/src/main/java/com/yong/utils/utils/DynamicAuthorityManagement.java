package com.yong.utils.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

/**
 * 动态权限管理
 */
public class DynamicAuthorityManagement {

    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"
    };

    private static String[] PERMISSIONS_GPS = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    /**
     * 手机存储权限
     *
     * @param activity
     */
    public static void verifyStoragePermissions(final Activity activity) {
        // Check if we have write permission
        int write_permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        // Check if we have read permission
        int read_permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (read_permission != PackageManager.PERMISSION_GRANTED && write_permission != PackageManager.PERMISSION_GRANTED) {
            //没有权限
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, Constant.NOT_READ_AND_WRITE);
        } else if (read_permission == PackageManager.PERMISSION_GRANTED && write_permission == PackageManager.PERMISSION_GRANTED) {
            //已拥有存储存储权限
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, Constant.READ_AND_WRITE);
        }
    }

    /**
     * Gps权限
     *
     * @param activity
     */
    public static void verifyGpsPermissions(final Activity activity) {
        int count = 0;

        for (int i = 0; i < PERMISSIONS_GPS.length; i++) {
            //如果没有权限
            if (ActivityCompat.checkSelfPermission(activity,
                    PERMISSIONS_GPS[i]) == PackageManager.PERMISSION_GRANTED) {
                //继续申请
                count++;
            }
        }
        if (count == PERMISSIONS_GPS.length) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_GPS, Constant.WAKE_LOCK);
        } else {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_GPS, Constant.NOT_WAKE_LOCK);
        }
    }
}
