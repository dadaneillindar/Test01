package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v){
		Intent intent = new Intent(this,MainActivity_Search.class);
		startActivity(intent);
	}


}
