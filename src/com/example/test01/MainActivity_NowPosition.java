package com.example.test01;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity_NowPosition extends Activity{
	
	
	LocationManager lm;
 	TextView lt, ln;
 	String provider;
 	Location l;
 	double lat;
 	double lng;
 	
 	
    private GoogleMap map;
    
    TextToSpeech tts;
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		setContentView(R.layout.activity_now_position);
		
		
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				
				if(status != TextToSpeech.ERROR){
					tts.setLanguage(Locale.ENGLISH);
				}
			}
		});
		ImageButton bt1 = (ImageButton)this.findViewById(R.id.imagebutton1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				finish();
				
			}
		});
		bt1.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				
				tts.speak("Back", TextToSpeech.QUEUE_FLUSH, null);
				return true;
			}
		});
		
		
		ln=(TextView)findViewById(R.id.text1);
		lt=(TextView)findViewById(R.id.text2);
		lm=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		Criteria c=new Criteria();
		provider=lm.getBestProvider(c, false);
		l=lm.getLastKnownLocation(provider);
		lng=l.getLongitude();
   	    lat=l.getLatitude();
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng), 17));
		Marker marker = map.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("²{¦b¦ì¸m"));
		if(l!=null)
			{
		    	 
		    	 ln.setText(""+lng);
		    	 lt.setText(""+lat);
		    
			}
		  	 else
		  	 {
		   	 ln.setText("No Provider");
		   	 lt.setText("No Provider");
		  	 }
		 	}
	
		  	
	public void onLocationChanged(Location arg0)
		  	{
		   	 lng=l.getLongitude();
		   	 lat=l.getLatitude();
		   	 ln.setText(""+lng);
		   	 lt.setText(""+lat);
		   	
		  	}
	

		 	public void onProviderDisabled(String arg0) {
		  	 // TODO Auto-generated method stub
		 	}
		 	public void onProviderEnabled(String arg0) {
		  	 // TODO Auto-generated method stub
		 	}

		 	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		  	 // TODO Auto-generated method stub*/
		
		
	}

}


