package com.example.bomba;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkListener;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKBatchRequest;
import com.vk.sdk.api.VKBatchRequest.VKBatchRequestListener;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.dialogs.VKCaptchaDialog;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Authoriz extends Activity implements OnClickListener {
	private static final String[] sMyScope = new String[] {
		 VKScope.FRIENDS,
        VKScope.WALL,
        VKScope.PHOTOS,
        VKScope.NOHTTPS,
        };
	  final String LOG_TAG = "myLogs";
	  DBHelper dbHelper;
	
     VKAccessToken token;
//
     Button loginButton;
     Button logoutButton;
     Button his;
     TextView names;
     String usrname;
     String usrLname;
     ListView listView; 
     boolean info=true;
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	    // создаем объект для создания и управления версиями БД
		    dbHelper = new DBHelper(this);
	       setContentView(R.layout.authoriz);
	     VKUIHelper.onCreate(this);
	     
	     
	     
	     VKSdk.initialize(sdkListener, "4885302",token);
	     ActionBar bar = getActionBar();
         bar.setDisplayHomeAsUpEnabled(true);
         loginButton = (Button)findViewById(R.id.btnaut);
         loginButton.setOnClickListener(this);
         logoutButton = (Button)findViewById(R.id.btnNaut);
         logoutButton.setOnClickListener(this);
         his = (Button)findViewById(R.id.his);
         his.setOnClickListener(this);
         listView = (ListView)findViewById(R.id.hislist);
         names =(TextView)findViewById(R.id.name);
         names.setVisibility(View.INVISIBLE);
         loginButton.setVisibility(View.INVISIBLE);
         logoutButton.setVisibility(View.INVISIBLE);
         his.setVisibility(View.INVISIBLE);
         if (VKSdk.wakeUpSession()) {
        	 Log.d(LOG_TAG, "avtorizovan");
        	 logoutButton.setVisibility(View.VISIBLE);
        		names.setVisibility(View.VISIBLE);
        		his.setVisibility(View.VISIBLE);
        	} 
         else {
        	    loginButton.setVisibility(View.VISIBLE);
        	    Log.d(LOG_TAG, "ne avtorizovan");
        	    his.setVisibility(View.INVISIBLE);
        	}
         VKParameters params = new VKParameters();
         params.put(VKApiConst.FIELDS, "last_name");
	     VKRequest request = null;
	      request = new VKRequest("users.get",params);
	     Log.d(LOG_TAG,"param");
	     
	     VKParameters params1 = new VKParameters();
	     params1.put(VKApiConst.FIELDS,"first_name");
	     VKRequest request1 = null;
	     request1 = new VKRequest("users.get",params1);
	     
	     VKParameters params2 = new VKParameters();
	     params2.put(VKApiConst.FIELDS,"photo_max_orig");
	     VKRequest request2 = null;
	     request2 = new VKRequest("users.get",params2);
	
	     VKBatchRequest batch_req = new VKBatchRequest(request,request1,request2);
	     batch_req.executeWithListener(new VKBatchRequestListener() {
	    	
	         @Override
	         public void onComplete(VKResponse[] responses) {
	        
	             super.onComplete(responses);
	             JSONArray resp = new JSONArray();
	             JSONArray resp1 = new JSONArray();
	            JSONArray resp2 = new JSONArray();
				try {
					
					resp = responses[0].json.getJSONArray("response");
					resp1 = responses[0].json.getJSONArray("response");
					resp2 = responses[0].json.getJSONArray("response");
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             JSONObject user = new JSONObject();
	             JSONObject user1 = new JSONObject();
	             
				try {
					
					user = resp.getJSONObject(0);
					user = resp1.getJSONObject(0);
				    user1 = resp2.getJSONObject(0);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             try {
	            	 
	            	 String[] rea = {"first_name","last_name","photo_max_orig"};
	            	 String[] info = new String[responses.length]; 
	            	 for (int i = 0; i < responses.length-1; i++) { 
	            	 info[i]=user.getString(rea[i]);
				
	            	 }
					names.setVisibility(View.VISIBLE);
					names.setText(info[0]+" "+info[1]);
					usrname=info[0];
					usrLname=info[1];
	             } catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }

	         @Override
	         public void onError(VKError error) {
	             super.onError(error);
	         }
	 });
	}
        

	
	 private final VKSdkListener sdkListener = new VKSdkListener() {
	        @Override
	        public void onCaptchaError(VKError captchaError) {
	            new VKCaptchaDialog(captchaError).show();
	        }

	        @Override
	        public void onTokenExpired(VKAccessToken expiredToken) {
	            VKSdk.authorize(sMyScope);
	        }

	        @Override
	        public void onAccessDenied(final VKError authorizationError) {
	            new AlertDialog.Builder(VKUIHelper.getTopActivity())
	                    .setMessage(authorizationError.toString())
	                    .show();
	        }

	        @Override
	        public void onReceiveNewToken(VKAccessToken newToken) {
	          //  startTestActivity();
	        	Log.d(LOG_TAG, "onReceiveNewToken");
	        	recr();
	        }

	        @Override
	        public void onAcceptUserToken(VKAccessToken token) {
	          //  startTestActivity();
	        	Log.d(LOG_TAG, "onAcceptUserToken");
	        }
	       
	    };
	 
	 
	    ////////////
		 ////////////
		 ////////////Возврат назат в екшен баре
		 //////////// 
		 ////////////
	    public void recr(){
	    	 super.recreate();
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
	  
	  
	  
	  @Override
	     protected void onResume() {
	        super.onResume();
	        VKUIHelper.onResume(this);
	    	
	    }
	  
	 
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        VKUIHelper.onActivityResult(this, requestCode, resultCode, data);
	      
	    }
	 
	    @Override
	    protected void onDestroy() {
	        super.onDestroy();
	        VKUIHelper.onDestroy(this);
	        
	    }
	    public void logout (){
	    	VKSdk.logout();
          if (!VKSdk.isLoggedIn()) {
        	  //перерисовка екрана
        	
              super.recreate();
          }
	    }
	    
	    
	    public void login (){
	    	VKSdk.authorize(sMyScope, true, false);
	    	Dbwriter dbwriter;
	    
            //  ((LoginActivity)getActivity()).showLogin();
          	Log.d(LOG_TAG, "Login");
          	super.recreate();
       
	    }
	    
	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		if(v.getId()==R.id.btnaut){
			login ();
		}else 
		if(v.getId()==R.id.btnNaut){
			logout();
		}else
		if(v.getId()==R.id.his){
			if(info){
			histori();
			} else dishis();
		}
	  
		
	}
	public void dishis(){
		listView = (ListView)findViewById(R.id.hislist);
		his.setText("Показати історію подорожей");
		listView.setVisibility(View.INVISIBLE);
		info=true;
	}
	public void histori(){
		String [] hiss;
		hiss = new String[1];
		hiss[0]="Опція не активна, або ви не користувались нашими послугами.";
		
		listView = (ListView)findViewById(R.id.hislist);
		his = (Button)findViewById(R.id.his);
		his.setText("Cкрити інформацію");
		
			// используем адаптер данных
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,	R.layout.autor_item, hiss);
			listView.setVisibility(View.VISIBLE);
			listView.setAdapter(adapter);
			info=false;
	}
	
	class Dbwriter {
		Dbwriter (String name, String lname){
			 ContentValues cv = new ContentValues();
			    ContentValues cv1 = new ContentValues();
			    
			    // получаем данные из полей ввода
			 //   String name = etName.getText().toString();
			 //   String lname =etlname.getText().toString();
			  //  String data = etdata.getText().toString();
			  //  String location =etlocation.getText().toString();
			    String[][] names = null ;
			    
			    // переменные для query
			    String[] columns = null;
			    String selection = null;
			    String[] selectionArgs = null;
			    String groupBy = null;
			    String having = null;
			    String orderBy = null;
			    
			    // Для вставки в 2ю таблицу
			    boolean dublikat=false;
			    int id = 0;
			    
			    
			    // подключаемся к БД
			    SQLiteDatabase db = dbHelper.getWritableDatabase();
			    
			    Cursor  quer = null;
			 Log.d(LOG_TAG, "--- Insert in mytable: ---");
		      // подготовим данные для вставки в виде пар: наименование столбца - значение
		     
		      cv.put("name", name);
		      cv.put("lname", lname);
		    
		      columns = new String[] {"name","lname","id"};
		      
		      //Проверка сущестующих записей 
		      quer=db.query("mytable", columns, null, null, null, null, null);
		      if (quer != null) {
		          if (quer.moveToFirst()) {
		            String str;
		            names = new String [quer.getCount()][3];
		            int i = 0;
		            int j = 0;
		            do {
		            	j=0;
		              str = "";
		              for (String cn : quer.getColumnNames()) {         
		                names[i][j]=quer.getString(quer.getColumnIndex(cn));
		                j++;
		              }
		                i++;
		            } while (quer.moveToNext());
		            Log.d(LOG_TAG, names[0][0]+" "+names[0][1]+" "+names[0][2]);
		          }
		          quer.close();
		        } else
		          Log.d(LOG_TAG, "Cursor is null");
		      
		      //Нахождение ИД ПИБ того что вставляем
		      for (int i=0;i<quer.getCount();i++){
		    	  
		    	  if(name.equals(names[i][0])&lname.equals(names[i][1])){
		    		  dublikat=true;
		    		  id = Integer.parseInt(names[i][2]);
		    	  }
		    	  
		      }
		      
		      // ПРоверка на дубликатьі
		      if(dublikat){
		    	  Log.d(LOG_TAG, "takoi yje est'");
		    //	 cv1.put("location", location);
		      //   cv1.put("data", data);
		      	  cv1.put("id", id);
		    	  db.insert("loc",null,cv1);
		    	  
		      }else{
		    	  Log.d(LOG_TAG, "Net takogo");
		          db.insert("mytable", null, cv);
		       //   cv1.put("location", location);
		       //   cv1.put("data", data);
		       	  cv1.put("id", id);
		     	  db.insert("loc",null,cv1);
		      }
		    //  Log.d(LOG_TAG, "row inserted, ID = " + rowID);
		      db.close();
		}
	}
	class DBHelper extends SQLiteOpenHelper {

	    public DBHelper(Context context) {
	      // конструктор суперкласса
	      super(context, "myDB", null, 1);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {

	      // создаем таблицу с полями
	      db.execSQL("create table mytable ("
	          + "id integer primary key autoincrement," 
	          + "name text,"
	          + "lname text" + ");");
	      Log.d(LOG_TAG, "--- onCreate database tabl ---");
	     
	      // таблица путишестий
	      db.execSQL("create table loc ("
	              + "id integer," 
	              + "data text,"
	              + "location text" + ");");
	      Log.d(LOG_TAG, "--- onCreate database loc ---");
	    }
	    

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    	 
	    }
	  }
}