package com.example.bomba;




import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkListener;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.dialogs.VKCaptchaDialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener {
	
	Button btnCont;
	Button btnNews;
	Button btntour;
	Button btnphoto;
	Button btncoutry;
	Button btnautor;
	Button myprof;
private static final String[] sMyScope = new String[] {
		 VKScope.FRIENDS,
         VKScope.WALL,
         VKScope.PHOTOS,
         VKScope.NOHTTPS,
         };
	VKApiUser user ;
	  final String LOG_TAG = "myLogs";
	
    VKAccessToken token;

  
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
       VKSdk.initialize(sdkListener, "4887143");
       VKUIHelper.onCreate(this);
        btnCont = (Button)findViewById(R.id.btnContatct);
        btnCont.setOnClickListener(this);
        btnNews = (Button)findViewById(R.id.btnNews);
        btnNews.setOnClickListener(this);
        btntour = (Button)findViewById(R.id.btntour);
        btntour.setOnClickListener(this);
        btnphoto = (Button)findViewById(R.id.btnphoto);
        btnphoto.setOnClickListener(this);
        btncoutry = (Button)findViewById(R.id.btncoutry);
        btncoutry.setOnClickListener(this);
        btnautor = (Button)findViewById(R.id.btnautor);
        btnautor.setOnClickListener(this);
       
    
        btnautor.setText("sdsd");
     
   
    }


    @Override
    public void onClick(View v) {
   if(v.getId()==R.id.btnContatct){
	   Intent intent = new Intent(this, Contact.class);
		startActivity(intent);
   }else
	   if(v.getId()==R.id.btnNews){
		   Intent intent1 = new Intent(this, News.class);
	    	  startActivity(intent1);
	   }else
		   if(v.getId()==R.id.btncoutry){
			   Intent intent2 = new Intent(this, Country.class);
				startActivity(intent2);
		   }else
			   if(v.getId()==R.id.btnphoto){
				   Intent intent3 = new Intent(this, Photo.class);
					startActivity(intent3);
			   }else
				   if(v.getId()==R.id.btntour){
					   Intent intent4 = new Intent(this, Tours.class);
						startActivity(intent4);
				   }else
					   if(v.getId()==R.id.btnautor){
						   Intent intent5 = new Intent(this, Authoriz.class);
					    	  startActivity(intent5);
					   }
					   /*  switch (v.getId()){
      case R.id.btnContatct:
    	  Intent intent = new Intent(this, Contact.class);
  			startActivity(intent);
  		break;
      case R.id.btnNews:
    	  Intent intent1 = new Intent(this, News.class);
    	  startActivity(intent1);
    	  break;
      case R.id.btncoutry:
    	  Intent intent2 = new Intent(this, Country.class);
			startActivity(intent2);
			  break;
      case R.id.btnphoto:
    	  Intent intent3 = new Intent(this, Photo.class);
			startActivity(intent3);
			  break;
      case R.id.btntour:
    	  Intent intent4 = new Intent(this, Tours.class);
			startActivity(intent4);
			break;
      case R.id.btnautor:
    	  Intent intent5 = new Intent(this, Authoriz.class);
    	  startActivity(intent5);
    	 /* VKSdk.authorize(sMyScope, true, false);
    	  if (VKSdk.wakeUpSession()) {

              //  startTestActivity();
            	//Если авторизировался.
           	 Log.d(LOG_TAG, "АВТОРИЗОВАН");
                return;
            }*/
  	  	/*	default:
  		break;
      }*/
    
    }
    private final VKSdkListener sdkListener = new VKSdkListener() {
        @Override
        public void onCaptchaError(VKError captchaError) {
            new VKCaptchaDialog(captchaError).show();
        }

        @Override
        public void onTokenExpired(VKAccessToken expiredToken) {
           VKSdk.authorize(sMyScope);
           Log.d(LOG_TAG, "он токен");
        }

        @Override
        public void onAccessDenied(final VKError authorizationError) {
            new AlertDialog.Builder(VKUIHelper.getTopActivity())
                    .setMessage(authorizationError.toString())
                    .show();
        }
        public void onReceiveNewToken(VKAccessToken newToken) {
	          //  startTestActivity();
	        	Log.d(LOG_TAG, "onReceiveNewToken");
	        	recr();
	        }

     
    };
    public void recr(){
   	 super.recreate();
   }
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "resum");
       if ( VKSdk.wakeUpSession(this)) {
         	 Log.d(LOG_TAG, "avtorizovan");
         	btnautor.setText("Мій профіль");
         	
         	} 
          else {
         	 
         	  Log.d(LOG_TAG, "ne avtorizovan");
         	btnautor.setText("Авторизація");
         	
         	}
      }
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "destroy");
      }
    protected void onStart() {
        super.onStart();
      
        Log.d(LOG_TAG, "start");
      }
  }
  

