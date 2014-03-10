package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity_Home extends Activity{
	
	MediaPlayer mp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_home);
		
		mp = new MediaPlayer();
        mp = MediaPlayer.create(getBaseContext(), R.raw.enter_home_new);
        mp.start();
		
		
		ImageButton bt1 = (ImageButton)this.findViewById(R.id.imagebutton1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				
				Intent intent = new Intent(v1.getContext(),MainActivity_Search.class);
				startActivity(intent);
			}
		});
		
		bt1.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				
				MediaPlayer mp = MediaPlayer.create(getBaseContext(),
						R.raw.translate_tts_search_new);
			    mp.start();
				
			    return true;
			}
		});
		
		ImageButton bt2 = (ImageButton)this.findViewById(R.id.imagebutton2);
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v2) {
		
				Intent intent = new Intent(v2.getContext(),MainActivity_NowPosition.class);
				startActivity(intent);
				
			}
		});
		
        bt2.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {

				MediaPlayer mp = MediaPlayer.create(getBaseContext(),
						R.raw.translate_tts_now_position_new);
			    mp.start();
			    
			    return true;
			}
		});
		
		ImageButton bt3 = (ImageButton)this.findViewById(R.id.imagebutton3);
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v3) {
				
				Intent intent = new Intent(v3.getContext(),MainActivity_Other.class);
				startActivity(intent);
			}
		});
		
        bt3.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				
				MediaPlayer mp = MediaPlayer.create(getBaseContext(),
						R.raw.translate_tts_other_new);
			    mp.start();
				
			    return true;
			}
		});
		
		ImageButton bt4 = (ImageButton)this.findViewById(R.id.imagebutton4);
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mp = new MediaPlayer();
		        mp = MediaPlayer.create(getBaseContext(), R.raw.translate_tts_enter_quit_new);
		        mp.start();
				
				finish();
				//android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
	
        bt4.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				
				MediaPlayer mp = MediaPlayer.create(getBaseContext(),
						R.raw.translate_tts_quit_new);
			    mp.start();
			    
			    return true;
			}
		});
	}
}
