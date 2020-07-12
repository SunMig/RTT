package com.example.rtt;

import android.os.Environment;

import java.io.File;

/**
 * Created by Lenovo on 2018/11/3.
 */

public class LocalPath {
    public static String SystemDirPath= Environment.getExternalStorageDirectory().toString();
    public static String FirstLocalPath=SystemDirPath+File.separator+"sun";
//    public static String SecondLocalPath=FirstLocalPath+File.separator+"RadioMap";
    public static String wifi_mac_txt=FirstLocalPath+File.separator+"wifi_ftm_mac.txt";
    public static String wifi_ftm_position=FirstLocalPath+File.separator+"wifi_ftm_position.txt";
//    public static String wifi_RM=SecondLocalPath+File.separator+"wifi_RM.txt";
}
