package com.example.wifidatacollector;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;


public class WifiScan extends BroadcastReceiver{
	private static final String TAG = "WiFiScan";
	WifiDataCollectorActivity wifiDemo;

	  public WifiScan(WifiDataCollectorActivity wifiDemo) {
	    super();
	    this.wifiDemo = wifiDemo;
	  }

	  public void onReceive(Context c, Intent intent) {
	    List<ScanResult> results = wifiDemo.wifi.getScanResults();
	    ScanResult bestSignal = null;
	    for (ScanResult result : results) {
	      if (bestSignal == null
	          || WifiManager.compareSignalLevel(bestSignal.level, result.level) < 0)
	        bestSignal = result;
	    }

	    String message = String.format("%s networks found. %s is the strongest.",
	        results.size(), bestSignal.SSID);
	    Toast.makeText(wifiDemo, message, Toast.LENGTH_LONG).show();

	    Log.d(TAG, "onReceive() message: " + message);
	  }

}
