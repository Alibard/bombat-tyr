package com.example.bomba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

public class PhotoKarpatHol {
	Button zakr;
	Button lviv;
	Button karpat1;
	Button karpat2;
	Button kampod;
	Button volman;
	ListView fotol;

	public static void main (){
		
	 MyTask mt = new MyTask();
     mt.execute();
     
	 }
}
//Izmeneniya
//2e izment 
/*class MyTask extends AsyncTask<Void, Void, Void> {
	 final String LOG_TAG = "myLogs";
  @Override
  protected void onPreExecute() {
    super.onPreExecute();
   
  }

  @Override
  protected Void doInBackground(Void... params) {
    try {
      TimeUnit.SECONDS.sleep(1);
      try { 
          
          Class.forName("com.mysql.jdbc.Driver"); 
          Log.d(LOG_TAG, "--- Driver is conected!!! ---"); 
      } catch (ClassNotFoundException e) { 
          Log.d(LOG_TAG, "--- Driver is NOT conected!!! ---"); 
          Log.d(LOG_TAG,e.toString()); 
          e.printStackTrace(); 
          return null; 
      } 
      Connection conn = null; 
     
      
       
      String url1 = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql576935"; 
     String name = "sql576935"; 
      String password = "gH2!jG2!"; 
      //String url1 = "jdbc:mysql://sql108.byethost11.com:3306/b11_16189699_bomba"; 
     //  String name = "b11_16189699"; 
    //   String password = "Omen1991"; 
      try { 
          conn = DriverManager.getConnection(url1, name, password); 
         // Toast.makeText(this, "есть подключение к БД", Toast.LENGTH_SHORT).show(); 
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT big FROM photo_travhol");
          rs.next();
          rs.getString("big");
         Log.d(LOG_TAG,rs.getString("big"));
          Log.d(LOG_TAG,"есть подключение к БД"); 
         
      } catch (java.sql.SQLException e) { 
           
          Log.d(LOG_TAG,e.toString()); 
        //  Toast.makeText(this, "ошибка подключения к БД", Toast.LENGTH_SHORT).show(); 
          Log.d(LOG_TAG,"ошибка подключения к БД");
      } 

      if (conn == null) { 
        //  Toast.makeText(this, "нет данных БД", Toast.LENGTH_SHORT).show(); 
      	 Log.d(LOG_TAG,"нет данных БД");
      } else { 
       //   Toast.makeText(this, "есть данные!", Toast.LENGTH_SHORT).show(); 
      	 Log.d(LOG_TAG,"есть данные!");
      } 
      
      
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  protected void onPostExecute(Void result) {
    super.onPostExecute(result);
   
  }
}*/