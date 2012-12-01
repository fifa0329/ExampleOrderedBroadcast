package tzach.example.exampleorderedbroadcast;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private static String PERMISSION1 = "tzach.example.exampleorderedbroadcast.permission1"; 
	private static String ACTION1= "tzach.example.exampleorderedbroadcast.action1";
	private Button buttonSendBroadcast1;
	private Button buttonSendBroadcast2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonSendBroadcast1 = (Button)findViewById(R.id.buttonSendBroadcast1);
        buttonSendBroadcast1.setOnClickListener(this);
        
        buttonSendBroadcast2 = (Button)findViewById(R.id.buttonSendBroadcast2);
        buttonSendBroadcast2.setOnClickListener(this);
        
        
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
	        
	        intent.putExtra("abort",false);
	        //intent.setClass(getApplicationContext(), MyReceiver1.class);
	        sendOrderedBroadcast(intent, null);

			break;
		case R.id.buttonSendBroadcast2:
			
	        intent.setAction(ACTION1);
	        
	        intent.putExtra("abort",true);
	        //intent.setClass(getApplicationContext(), MyReceiver1.class);
	        
	        sendOrderedBroadcast(intent, null);

			break;
		}
		
	}
}
