package tzach.example.exampleorderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver1 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// 
		Bundle extras = intent.getExtras();
		
		boolean abort = extras.getBoolean("abort");
		
		Toast.makeText(context, "boradcast 1", Toast.LENGTH_LONG).show();
		if (abort){
			abortBroadcast();
		}
		
		
	}

}
