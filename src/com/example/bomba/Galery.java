package com.example.bomba;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.squareup.picasso.Picasso;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Galery extends Activity{
	ImageView qq;
	Picasso pic;
	static ImageAapter adapter;

	private Context context;	
	
		
		final String LOG_TAG = "myLogs";
		ListView mLvImages;
		ImageView img;
		Button btn;
		 String[] str = null;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.galery);
		    mLvImages = (ListView) findViewById(R.id.lvImages);
		    img =(ImageView)findViewById(R.id.bigimg);
		    img.setVisibility(View.INVISIBLE);
		    adapter =null;
		    ActionBar bar = getActionBar();
	         bar.setDisplayHomeAsUpEnabled(true);
		    Intent intent = getIntent();
			 String dbqeru = intent.getStringExtra("dbqeru");
			 MyTask mt = new MyTask();
		     mt.execute(dbqeru);
		     Log.d(LOG_TAG, dbqeru); 
		   
		 
		   try {
				 str= mt.get();
			//	 Log.d(LOG_TAG, str[0]); 
				 run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
			}
		    
			
			 
			 mLvImages.setOnItemClickListener(new OnItemClickListener() {
			   

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					img.setVisibility(View.VISIBLE);
					mLvImages.setVisibility(View.INVISIBLE);
					pic.with(context).load(str[position]).into(img);
				
					 Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "
					            + id);
					 Log.d(LOG_TAG, str[position]); 
					}
			 });
			 img.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						img.setVisibility(View.INVISIBLE);
						mLvImages.setVisibility(View.VISIBLE);
					}
				});
			
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
public void run(){
	 if (str != null) {
		 ImageAapter adapter = new ImageAapter(this, str);
	      mLvImages.setAdapter(adapter);
	      //Log.d(LOG_TAG, Integer.toString(str.length));
	      Log.d(LOG_TAG, str[2]);
	      Log.d(LOG_TAG, str[3]);
	      }
}

	class ImageAapter extends ArrayAdapter<String> {

	    LayoutInflater mInflater;
	    Picasso mPicasso;
	    
	    public ImageAapter(Context context, String[] imagesurls) {
	    	super(context, R.layout.list_item, imagesurls);
		      mInflater = LayoutInflater.from(context); 
		      mPicasso = Picasso.with(context);
		    }
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	      View view = convertView;
	      if (view == null) {
	        view = mInflater.inflate(R.layout.list_item, parent, false);
	      }
	      ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
	      
	      mPicasso.load(getItem(position)).resizeDimen(R.dimen.image_size, R.dimen.image_size). centerInside().into(imageView);
	      return view;
	      
	    }
	   
	}

	}
class MyTask extends AsyncTask<String, String, String[]> {
	 final String LOG_TAG = "myLogs";
	 int i=0;
	 private String[] photo_arr = null;
	
	 
 @Override
 protected void onPreExecute() {
   super.onPreExecute();
  
 }

 protected String[] doInBackground(String... params) {
	try {    
         Class.forName("com.mysql.jdbc.Driver"); 
         Log.d(LOG_TAG, "--- Driver is conected!!! ---"); 
     } catch (ClassNotFoundException e) { 
         Log.d(LOG_TAG, "--- Driver is NOT conected!!! ---"); 
         Log.d(LOG_TAG,e.toString()); 
         e.printStackTrace(); 
         return  null; 
     } 
     Connection conn = null; 
     
     String url1 = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql579919"; 
     String name = "sql579919"; 
     String password = "sP8%hH4!"; 
     int i=0;
     String ss=params[0];
     String qury="SELECT img, id FROM "+ss;
     
     	try { 
     		conn = DriverManager.getConnection(url1, name, password); 
     
     		Statement stmt = conn.createStatement();
     		ResultSet rs = stmt.executeQuery(qury);
         
     		Log.d(LOG_TAG,"есть подключение к БД");    
     		rs.last();
     		int qwe = rs.getInt("id");
     		rs.first();
     		rs.beforeFirst();
     		
     		photo_arr = new String[qwe];
     			while (rs.next()) {
     				String lastName = rs.getString("img");
     				photo_arr[i]=lastName;
     				i++;
     			//	downloadFile(lastName);
        	
     			}
     		Log.d(LOG_TAG,"есть подключение к БД"); 
        
     	} catch (java.sql.SQLException e) { 
          
        Log.d(LOG_TAG,e.toString()); 
        Log.d(LOG_TAG,"ошибка подключения к БД");
     } 

     if (conn == null) { 
       	 Log.d(LOG_TAG,"нет данных БД");
     } else { 
     	 Log.d(LOG_TAG,"есть данные!");
     } 
     return photo_arr;
 }
 
 	
 
 
 	protected void onProgressUpdate(String values) {
 		super.onProgressUpdate(values);
    }
 
 
 	protected void onPostExecute(String[] result) {
 		super.onPostExecute(result);
 		Log.d(LOG_TAG, "End. Result = " + result);
 	}
}
