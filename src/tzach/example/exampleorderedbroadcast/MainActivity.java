package tzach.example.exampleorderedbroadcast;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static String PERMISSION1 = "tzach.example.exampleorderedbroadcast.permission1"; 
	private static String ACTION1= "tzach.example.exampleorderedbroadcast.action1";
	private Button buttonSendBroadcast1;
	private Button buttonSendBroadcast2;
	private BroadcastReceiver mBroadcastReceiver;
	private CheckBox checkBoxBroadcastActivity;
	private Button buttonBroadcastActivityAbort;
	private CheckBox checkBoxBroadcastActivityRegister;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonSendBroadcast1 = (Button)findViewById(R.id.buttonSendBroadcast1);
        buttonSendBroadcast1.setOnClickListener(this);
        
        buttonSendBroadcast2 = (Button)findViewById(R.id.buttonSendBroadcast2);
        buttonSendBroadcast2.setOnClickListener(this);
        
        checkBoxBroadcastActivity = (CheckBox)findViewById(R.id.checkBoxBroadcastActivity);
        checkBoxBroadcastActivity.setOnClickListener(this);
        
        checkBoxBroadcastActivityRegister = (CheckBox)findViewById(R.id.checkBoxBroadcastActivityRegister);
        checkBoxBroadcastActivityRegister.setOnClickListener(this);
        
        mBroadcastReceiver = new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context context, Intent intent) {
				// 
				Bundle extras = intent.getExtras();
				
				Toast.makeText(context, "Dynamic Broadcast from activity", Toast.LENGTH_LONG).show();
				if (extras.getBoolean("abort1")){
					abortBroadcast();
					Toast.makeText(context, "Other (static) broadcasts have been aborted", Toast.LENGTH_LONG).show();
				}
				
			}
		};
		
			
		
		
        
        
    }
    
    @Override
    protected void onResume() {
    	// 
    	super.onResume();
    	
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// 
		Intent intent = new Intent();
		switch (v.getId()){
		case R.id.buttonSendBroadcast1:
			
	        intent.setAction(ACTION1);
	        if (checkBoxBroadcastActivity.isChecked()){
	        	intent.putExtra("abort1",true);
	        }else{
	        intent.putExtra("abort1",false);
	        }
	        intent.putExtra("abort",false);
	        
	        
	        //intent.setClass(getApplicationContext(), MyReceiver1.class);
	        sendOrderedBroadcast(intent, null);

			break;
		case R.id.buttonSendBroadcast2:
			
	        intent.setAction(ACTION1);
	        intent.putExtra("abort",true);
	        if (checkBoxBroadcastActivity.isChecked()){
	        	intent.putExtra("abort1",true);
	        }else{
	        intent.putExtra("abort1",false);
	        }
	        
	        //intent.setClass(getApplicationContext(), MyReceiver1.class);
	        
	        sendOrderedBroadcast(intent, null);

			break;
		
		case R.id.checkBoxBroadcastActivityRegister:
			if (checkBoxBroadcastActivityRegister.isChecked()){
				IntentFilter filter = new IntentFilter(ACTION1);
		    	filter.setPriority(3);
		    	registerReceiver(mBroadcastReceiver, filter);
		    	Toast.makeText(MainActivity.this, "Registered dynamic broadcast in activity", Toast.LENGTH_LONG).show();
			}else{
				unregisterReceiver(mBroadcastReceiver);
				Toast.makeText(MainActivity.this, "Unregistered dynamic broadcast in activity", Toast.LENGTH_LONG).show();
			}
			break;
		}
		
	}
}
