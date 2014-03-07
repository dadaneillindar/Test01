package com.example.test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
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
 	String returnAddress;
 	Location l;
 	double lat;
 	double lng;
 	
 	
    private GoogleMap map;
    
    
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
				MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.translate_tts_back);
			    mp.start();
			    
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
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng), 18));
		Marker marker = map.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("現在位置"));
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
		   	map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng), 18));
			Marker marker = map.addMarker(new MarkerOptions().position(new LatLng(lat,lng)).title("現在位置"));
		   	
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
		 	
		 	@Override
		    public boolean onCreateOptionsMenu(Menu menu) {
		        // Inflate the menu; this adds items to the action bar if it is present.
		        getMenuInflater().inflate(R.menu.main, menu);
		        return true;
		    }
		    
		    public void queryHTTP(View nameIsNotImportant) 
		    		throws MalformedURLException, UnsupportedEncodingException
		    {
		    	lat = l.getLatitude();
		    	lng = l.getLongitude();
		    	URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" +
		    			lat+","+lng+"&sensor=false&language=zh-TW");
		    	
		    	DownloadAsyncTask task = new DownloadAsyncTask();
		    	task.referenceToMainActivity = this;
		    	task.execute(url);
		    	
		    }
		    
		    
		    private class DownloadAsyncTask extends AsyncTask<URL, Void, String> {
		    	
		    	public MainActivity_NowPosition referenceToMainActivity;

				@Override
				protected String doInBackground(URL... urls) {
					if (urls.length <= 0)
						throw new java.lang.ArrayIndexOutOfBoundsException();
					
					try {
						InputStream stream = urls[0].openStream();
						InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
						
						StringBuilder builder = new StringBuilder();
						int ch;
						while ((ch = reader.read()) != -1) { // 從網路讀取一個個字元
							builder.append((char) ch);
						}
						
						return builder.toString(); // 轉成字串
					} catch (IOException e) {
						return "";
					}
				}
		    	
				@Override
				protected void onPostExecute(String result) {
					TextView ra=((TextView) referenceToMainActivity.findViewById(R.id.text0));

					if (result == "") {
						ra.setText("無法連網  QAQ");
					} else {
						try {
							JSONObject obj = new JSONObject(result);
							
							StringBuilder builder = new StringBuilder();
							
							JSONObject address = (JSONObject) obj.getJSONArray("results").get(0);
							builder.append(address.getString("formatted_address"));
							builder.append("\n");
							
							ra.setText(builder.toString());
							String tts = builder.toString();
							MediaPlayer mp=new MediaPlayer();
							
					        mp.setDataSource("http://translate.google.com/translate_tts?q="
							+ tts +"&tl=zh&ie=UTF-8");	
					        mp.prepare();
					        mp.start();
							
							
						} catch (JSONException e) {
							ra.setText("JSON錯誤");
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		    }	 	
		 	

}


