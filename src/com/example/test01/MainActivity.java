package com.example.test01;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity{
	
	static final String[] text1 = {"Search"};
	static final String[] text2 = {"Now Position"};
	static final String[] text3 = {"Other"};
	static final String[] text4 = {"Quit"};
	
	
	TextToSpeech tts;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		
		
		Button bt1 = (Button)this.findViewById(R.id.button1);
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
				
				Random r = new Random();
				String random = text1[r.nextInt(1)];
				tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
				
				
				return true;
			}
		});
		
		
		
		
		Button bt2 = (Button)this.findViewById(R.id.button2);
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
				
				Random r = new Random();
				String random = text2[r.nextInt(1)];
				tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
				
				
				return true;
			}
		});
		
		Button bt3 = (Button)this.findViewById(R.id.button3);
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
				
				Random r = new Random();
				String random = text3[r.nextInt(1)];
				tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
				
				
				return true;
			}
		});
		
		Button bt4 = (Button)this.findViewById(R.id.button4);
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	
        bt4.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				
				Random r = new Random();
				String random = text4[r.nextInt(1)];
				tts.speak(random, TextToSpeech.QUEUE_FLUSH, null);
				
				
				return true;
			}
		});

		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status != TextToSpeech.ERROR){
					tts.setLanguage(Locale.ENGLISH);
				}
			}
		});
	
	
	}
	


}
