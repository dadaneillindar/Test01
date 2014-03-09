package com.example.test01;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity_Other extends Activity {
	
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_other);
		
		mp = new MediaPlayer();
        mp = MediaPlayer.create(getBaseContext(), R.raw.translate_tts_enter_other);
        mp.start();
		
		Button bt4 = (Button)this.findViewById(R.id.button4);
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mp = new MediaPlayer();
		        mp = MediaPlayer.create(getBaseContext(), R.raw.enter_home);
		        mp.start();
		        
				finish();
			}
		});
	}

}
