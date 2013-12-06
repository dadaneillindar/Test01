package com.example.test01;

import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity{
	
	TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		setContentView(R.layout.activity_main);
		
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
				
				tts.speak("Search", TextToSpeech.QUEUE_FLUSH, null);		
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
				
				tts.speak("Now Position", TextToSpeech.QUEUE_FLUSH, null);		
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
				
				tts.speak("Other", TextToSpeech.QUEUE_FLUSH, null);	
				return true;
			}
		});
		
		ImageButton bt4 = (ImageButton)this.findViewById(R.id.imagebutton4);
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
	
        bt4.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				
				tts.speak("Quit", TextToSpeech.QUEUE_FLUSH, null);
				return true;
			}
		});

		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				
				if(status != TextToSpeech.ERROR){
					tts.setLanguage(Locale.ENGLISH);
				}
			}
		});
	}
}