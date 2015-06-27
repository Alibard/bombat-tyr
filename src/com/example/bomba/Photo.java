package com.example.bomba;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Photo extends Activity implements OnClickListener{
	Button zakr;
	Button lviv;
	Button karpat1;
	Button karpat2;
	Button kampod;
	Button volman;
	ListView fotol;
	final String LOG_TAG = "myLogs";
	 @SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.photo);
	       ActionBar bar = getActionBar();
           bar.setDisplayHomeAsUpEnabled(true);
           zakr = (Button)findViewById(R.id.zkp);
           zakr.setOnClickListener(this);
           lviv = (Button)findViewById(R.id.lviv);
           lviv.setOnClickListener(this);
           karpat1 = (Button)findViewById(R.id.karpat1);
           karpat1.setOnClickListener(this);
           karpat2 = (Button)findViewById(R.id.karpat2);
           karpat2.setOnClickListener(this);
           kampod = (Button)findViewById(R.id.kampod);
           kampod.setOnClickListener(this);
           volman = (Button)findViewById(R.id.volman);
           volman.setOnClickListener(this);
       

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
	  public void zkp (){
		  Intent intent = new Intent(this, Galery.class); 
		    intent.putExtra("dbqeru", "photo_travhol");
		
	  }
	  public void lviv (){
		  
	  }
	  public void volman(){
		  
	  }
	  public void kampod(){
		  
	  }
	  public void karpat1(){
		  
	  }
	  public void karpat2(){
		  
	  }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 Intent intent = new Intent(this, Galery.class); 
		  switch (v.getId()) {
		  case R.id.zkp:  
			 
			  intent.putExtra("dbqeru", "zkp");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  case R.id.volman:  
			 
			  intent.putExtra("dbqeru", "volman");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  case R.id.kampod:  
			  
			  intent.putExtra("dbqeru", "kampod");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  case R.id.lviv:  
			
			  intent.putExtra("dbqeru", "lviv");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  case R.id.karpat1:  
			
			  intent.putExtra("dbqeru", "karpat1");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  case R.id.karpat2:  
			
			  intent.putExtra("dbqeru", "karpat2");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  case R.id.koblevo:  
			
			  intent.putExtra("dbqeru", "koblevo");
			  startActivity(intent);
		  Log.d(LOG_TAG, "закарпаття");
		  break; 
		  default:
		  break; 
		  }
	}
}
