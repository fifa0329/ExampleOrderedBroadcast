package tzach.example.exampleorderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle extras = intent.getExtras();
		
		
		Toast.makeText(context, "boradcast 2", Toast.LENGTH_LONG).show();
		
	}
	
	
	
}
