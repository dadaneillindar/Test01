package com.example.test01;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity_Search extends Activity{
	
	TextView colorRGB;
	ImageView imgSource1;
	
	
	//static final LatLng latLng = new LatLng(25.110480, 121.526229);
    private GoogleMap map;
    MediaPlayer mp;
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_search);
		
		
		colorRGB = (TextView)findViewById(R.id.textView1);
		
		imgSource1 = (ImageView)findViewById(R.id.image1);
		imgSource1.setOnTouchListener(imgSourceOnTouchListener);
		
		
		mp = new MediaPlayer();
		mp.stop();
        mp = MediaPlayer.create(getBaseContext(), R.raw.enter_search_new);
        mp.start();
		
		
		
		ImageButton bt1 = (ImageButton)this.findViewById(R.id.imagebutton1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				
				mp.stop();
				
				mp = new MediaPlayer();
		        mp = MediaPlayer.create(getBaseContext(), R.raw.enter_home_new);
		        mp.start();
		        
				finish();
				
			}
		});
		
		bt1.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				
				mp.stop();
				
				MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.translate_tts_back_new);
			    mp.start();
				
				
				return true;
			}
		});
		
		ImageButton bt2 = (ImageButton)this.findViewById(R.id.imagebutton2);
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		bt2.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				
				mp.stop();
				
				MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.translate_tts_search_new);
			    mp.start();
			    return true;
			}
		});
		
		
		
		
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        //Marker marker = map.addMarker(new MarkerOptions().position(latLng).title("家").snippet("中山北路6段290巷7弄5-1號5樓"));
        Marker marker_2 = map.addMarker(new MarkerOptions().position(new LatLng(22.996650,120.216862)).title("搜尋地點").snippet("台南市東區大學路1號"));
        //Circle circle = map.addCircle(new CircleOptions().center(new LatLng(25.110700, 121.526229)).radius(100).strokeColor(Color.RED).fillColor(Color.CYAN));
        // Move the camera instantly to latLng with a zoom of 16.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(22.996650,120.216862), 17));
    
	}
	OnTouchListener imgSourceOnTouchListener
    = new OnTouchListener(){

  @Override
  public boolean onTouch(View view, MotionEvent event) {
   
   float eventX = event.getX();
   float eventY = event.getY();
   float[] eventXY = new float[] {eventX, eventY};
   
   Matrix invertMatrix = new Matrix();
   ((ImageView)view).getImageMatrix().invert(invertMatrix);
   
   invertMatrix.mapPoints(eventXY);
   int x = Integer.valueOf((int)eventXY[0]);
   int y = Integer.valueOf((int)eventXY[1]);
   
   
   Drawable imgDrawable = ((ImageView)view).getDrawable();
   Bitmap bitmap = ((BitmapDrawable)imgDrawable).getBitmap();
   
   
   
   //Limit x, y range within bitmap
   if(x < 0){
    x = 0;
   }else if(x > bitmap.getWidth()-1){
    x = bitmap.getWidth()-1;
   }
   
   if(y < 0){
    y = 0;
   }else if(y > bitmap.getHeight()-1){
    y = bitmap.getHeight()-1;
   }

   int touchedRGB = bitmap.getPixel(x, y);
   
   colorRGB.setText("touched color: " + Integer.toHexString(touchedRGB));
   colorRGB.setTextColor(touchedRGB);
   
   return true;
  }};
}
