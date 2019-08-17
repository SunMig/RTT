package com.example.rtt;

import android.net.wifi.ScanResult;
import android.net.wifi.rtt.RangingResult;

import java.util.ArrayList;
import java.util.List;

public class RttResultClass {
    List<RangingResult> rlist=new ArrayList<>();

    public RttResultClass(List<RangingResult> rttresult) {
        this.rlist=rttresult;
    }

}
