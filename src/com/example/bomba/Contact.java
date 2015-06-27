package com.example.bomba;



import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

@SuppressLint("NewApi")
public class Contact extends  FragmentActivity {
	
	SupportMapFragment mapFragment;
	GoogleMap map;
	final String TAG = "myLogs";
	
	
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.contact);
	        mapFragment = (SupportMapFragment) getSupportFragmentManager()
	                .findFragmentById(R.id.map);
	            map = mapFragment.getMap();
	            if (map == null) {
	              finish();
	              return;
	            }
	            
	       	        init();
	       	     ActionBar bar = getActionBar();
	             bar.setDisplayHomeAsUpEnabled(true);
	}


	private void init() {
		map.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng arg0) {
				// TODO Auto-generated method stub
				Log.d(TAG,"OnMapClick:");
				
			}}
		);
		 map.setOnMapLongClickListener(new OnMapLongClickListener() {
		      
		      @Override
		      public void onMapLongClick(LatLng latLng) {
		        Log.d(TAG, "onMapLongClick: " + latLng.latitude + "," + latLng.longitude);
		      }
		    });
		      
		      map.setOnCameraChangeListener(new OnCameraChangeListener() {
		      
		      @Override
		      public void onCameraChange(CameraPosition camera) {
		        Log.d(TAG, "onCameraChange: " + camera.target.latitude + "," + camera.target.longitude);
		      }
		    });
		      CameraPosition cameraPosition = new CameraPosition.Builder()
		      .target(new LatLng(49.232818, 28.462676))
		      .zoom(17)
		      .tilt(20)
		      .build();
		  CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
		  map.animateCamera(cameraUpdate);
		  map.addMarker(new MarkerOptions()
		  .position(new LatLng(49.232818, 28.462676))
		  .title("анлаю-рсп"));
		
	}
	 
	 
	 
	 
	 public void onClickGo(View view) {
		   CameraPosition cameraPosition = new CameraPosition.Builder()
		      .target(new LatLng(49.232818, 28.462676))
		      .zoom(17)
		      .tilt(20)
		      .build();
		   CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
			  map.animateCamera(cameraUpdate);
	    }
	 
	 
	  public boolean onCreateOptionsMenu(Menu menu) {
		    getMenuInflater().inflate(R.menu.main, menu);
		    
		    return true;
		  }
	  public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();
			if (id == R.id.action_settings) {
				return true;
			}
			switch (id) {
	  		case android.R.id.home:
		    this.finish();
		    break;
			}
			return super.onOptionsItemSelected(item);
		}
	   protected void onDestroy() {
	        super.onDestroy();
	        
	      }
}
