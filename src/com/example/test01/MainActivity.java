package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final VideoView videoView = (VideoView) this.findViewById(R.id.videoview);
		MediaController mc = new MediaController(this);
		videoView.setMediaController(mc);
		
		videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nitro_logo));   
		videoView.requestFocus();
		videoView.start();
		
		Button bt1 = (Button)this.findViewById(R.id.button1);
		
		bt1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//要做的事
				
				Intent intent = new Intent(v.getContext(),MainActivity_Home.class);
				startActivity(intent);
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
