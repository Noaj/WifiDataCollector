package com.example.wifidatacollector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Collect Wifi Data button */
    public void collectWifiData(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, WifiDataCollectorActivity.class);
    	startActivity(intent);
    	
    }
    
    /** Called when the user clicks the Collect Network Data button */
    public void collectNetworkData(View view) {
        // Do something in response to button
    	//Intent intent = new Intent(this, WifiDataCollectorActivity.class);
    	
    }
    
    /** Called when the user clicks the Settings button */
    public void settings(View view) {
        // Do something in response to button
    	//Intent intent = new Intent(this, WifiDataCollectorActivity.class);
    	
    }

}
