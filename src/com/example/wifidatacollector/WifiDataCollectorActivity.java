package com.example.wifidatacollector;

import java.util.List;

import com.example.wifidatacollector.R;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

public class WifiDataCollectorActivity extends Activity implements OnClickListener{
	
	WifiManager wifi;
	BroadcastReceiver receiver;

	TextView textStatus;
	Button buttonScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_data_collector);
        // Show the Up button in the action bar.
        setupActionBar();
        
        // Setup UI
     	textStatus = (TextView) findViewById(R.id.textStatus);
     	buttonScan = (Button) findViewById(R.id.buttonScan);
     	buttonScan.setOnClickListener(this);

     	// Setup WiFi
     	wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

     	// Get WiFi status
     	WifiInfo info = wifi.getConnectionInfo();
     	textStatus.append("\n\nWiFi Status: " + info.toString());

     	// List available networks
     	List<WifiConfiguration> configs = wifi.getConfiguredNetworks();
     	
     	for (WifiConfiguration config : configs) {
     		
     		textStatus.append("\n\n" + config.toString());
     	}

     	// Register Broadcast Receiver
     	if (receiver == null)
     		receiver = new WifiScan(this);

     	registerReceiver(receiver, new IntentFilter(
     		WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
     		//Log.d(TAG, "onCreate()");
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "On Click Clicked. Toast to that!!!",
				Toast.LENGTH_LONG).show();

		if (view.getId() == R.id.buttonScan) {
			Log.d("Wifi Data Collector", "onClick() wifi.startScan()");
			wifi.startScan();
		}
		
	}

}
