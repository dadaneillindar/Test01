package com.example.test01;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity_NowPosition extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_now_position);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity__now_position, menu);
		return true;
	}

}
