package com.example.bomba;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

import com.squareup.picasso.Picasso;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Opus extends Activity{
	TextView txt1;
	TextView txt2;
	TextView txt3;
	TextView txt4;
	TextView txt5;
	TextView txt6;
	TextView txt7;
	TextView txt8;
	String[] info  ={"Державна мова: ",
			        "Населення: ",
					"Телефонний код: ",
					"Грошова одиниця: ",
					"Віза: ",
					"Вартість «типової» вечері: ",
					"Чайові: ",
					"Оренда авто за добу: "};
	ImageView img;
	String str=null;
	  Picasso pic;
	//	private Context context;	
	  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.opus);
	         txt1 = (TextView)findViewById(R.id.textView1);
	         txt2 = (TextView)findViewById(R.id.textView2);
	         txt3 = (TextView)findViewById(R.id.textView3);
	         txt4 = (TextView)findViewById(R.id.textView4);
	         txt5 = (TextView)findViewById(R.id.textView5);
	         txt6 = (TextView)findViewById(R.id.textView6);
	         txt7 = (TextView)findViewById(R.id.textView7);
	         txt8 = (TextView)findViewById(R.id.textView8);
	         img = (ImageView)findViewById(R.id.imageView1);
	         ActionBar bar = getActionBar();
	         bar.setDisplayHomeAsUpEnabled(true);
	        
	        Intent intent = getIntent();
	        String Oid = intent.getStringExtra("Oid");
	        OpusTask opus = new OpusTask();
	        opus.execute(Oid);
	        
	        txt1.setText(Oid);
	        try {
	        		str=opus.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        pic.with(this).load(str).resize(90, 90).into(img);
	        
	        switch (Integer.parseInt(Oid)) {
	        case 1:   txt1.setText("AВСТІЯ   "+info[0]+"німецька (з характерною австрійською вимовою)");
	                  txt2.setText(""+info[1]+"близько 8,2 млн. чоловік");
	                  txt3.setText(info[2]+"43");
	                  txt4.setText(info[3]+"євро (EUR), 1 EUR = 100 євроцентів");
	                  txt5.setText(info[4]+"потрібна шенгенська віза, консульський збір 35 EUR");
	                  txt6.setText(info[5]+"в кафе від 15 EUR, в ресторані від 25 EUR");
	                  txt7.setText(info[6]+"5-10% від суми замовлення");
	                  txt8.setText(info[7]+"від 35 EUR (при оренді на тиждень і більше)"); 
	         break;
	        case 3:   txt1.setText("БОЛГАРІЯ   "+info[0]+"болгарська, розповсюджена російська");
            		  txt2.setText(info[1]+"більше 7 млн. чоловік");
            		  txt3.setText(info[2]+"359");
            		  txt4.setText(info[3]+"Болгарський лев (BGN), 1 BGN = 100 стотинок, 1 USD ≅ 1,36 BGN, 1 EUR ≅ 1,95 BGN");
            		  txt5.setText(info[4]+"потрібна, вартість 35 EUR. Додатково сплачуються послуги візового центру від 15 до 22 EUR");
            		  txt6.setText(info[5]+"5-8 EUR");
            		  txt7.setText(info[6]+"10% від суми замовлення");
            		  txt8.setText(info[7]+"від 40 EUR в Софії, від 25 EUR на курортах"); 
             break;
	        case 5:   txt1.setText("ДОМІНІКАНСЬКА РЕСПУБЛІКА   "+info[0]+"іспанська");
  		  			  txt2.setText(info[1]+"близько 9,9 млн. чоловік");
  		  			  txt3.setText(info[2]+"1809");
  		  			  txt4.setText(info[3]+"Домініканське песо (DOP), 1 DOP = 100 сентаво, 1 USD ≅ 38,1 DOP, 1 EUR ≅ 54,7 DOP");
  		  			  txt5.setText(info[4]+"віза до 21 день оформляється на кордоні. Потрібен зворотній квиток або бронь готелю та підвердження наявності достатніх коштів на перебування у країні.");
  		  			  txt6.setText(info[5]+"35-40 USD");
  		  			  txt7.setText(info[6]+"~ 10%");
  		  			  txt8.setText(info[7]+"від 60 USD"); 
  		     break;
	        case 6:   txt1.setText("ЄГИПЕТ   "+info[0]+"єгипетський діалект арабської мови");
  			          txt2.setText(info[1]+"близько 82 млн. чоловік");
  			          txt3.setText(info[2]+"20");
  			          txt4.setText(info[3]+"єгипетський фунт (LE), 1 LE = 100 піастрів, 1 USD ≅ 5,9 LE, 1 EUR ≅ 8,5 LE");
  			          txt5.setText(info[4]+"15 USD, оформляється по прильоту в аеропорт");
  			          txt6.setText(info[5]+"в готелі - від 15 до 50 USD");
  			          txt7.setText(info[6]+"1-2 LE");
  			          txt8.setText(info[7]+"від 30 USD"); 
             break;
	        case 7:   txt1.setText("ІНДІЯ   "+info[0]+"хінді, англійська");
	                  txt2.setText(info[1]+"близько 1,18 млрд. чоловік");
	                  txt3.setText(info[2]+"91");
	                  txt4.setText(info[3]+"Індійська рупія (INR), 1 INR = 100 пайс, 1 USD ≅ 45 INR, 1 EUR ≅ 64 INR");
	                  txt5.setText(info[4]+"потрібна");
	                  txt6.setText(info[5]+" в готелі 4-5 * - 10-15 USD");
	                  txt7.setText(info[6]+"10%");
	                  txt8.setText(info[7]+"інформція відсутня"); 
	         break;
	        case 8:   txt1.setText("ІНДОНЕЗІЯ   "+info[0]+"індонезійська, широко поширена англійська");
             		  txt2.setText(info[1]+"близько 246 млн. чоловік");
             		  txt3.setText(info[2]+"62");
             		  txt4.setText(info[3]+"Індонезійська рупія (IDR), 1 IDR = 100 сен, 1 USD ≅ 9000 IDR, 1 EUR ≅ 11 500 IDR");
             		  txt5.setText(info[4]+"інформція відсутня ");
             		  txt6.setText(info[5]+"10-20 USD");
             		  txt7.setText(info[6]+"10% від вартості послуги");
             		  txt8.setText(info[7]+"інформція відсутня"); 
             break;
	        case 9:   txt1.setText("АОЄ   "+info[0]+"арабська, широко поширена англійська");
   		  	 	      txt2.setText(info[1]+"близько 5,1 млн. чоловік");
   		  	 	      txt3.setText(info[2]+"971");
   		  	 	      txt4.setText(info[3]+"Дірхам (DHS), 1 DHS = 100 філсів, 1 USD ≅ 3,7 DHS, 1 EUR ≅ 5 DHS");
   		  	 	      txt5.setText(info[4]+"потрібна");
   		  	 	      txt6.setText(info[5]+"20-25 USD");
   		  	 	      txt7.setText(info[6]+"~ 10%");
   		  	 	      txt8.setText(info[7]+"від 30 USD (зі страховкою)"); 
   		  	 break;
	        case 10:   txt1.setText("ТАЇЛАНД   "+info[0]+"тайська");
	  	 	      	   txt2.setText(info[1]+"більше 66 млн. чоловік");
	  	 	      	   txt3.setText(info[2]+"66");
	  	 	      	   txt4.setText(info[3]+"Бат (THB), 1 THB = 100 сатангів, 1 USD ≅ 29,7, курс часто залежить від величини купюри, 100 і 50 міняють трохи дорожче THB, 1 EUR ≅ 42,8 THB");
	  	 	      	   txt5.setText(info[4]+"безкоштовна віза в аеропорту до 15 діб. Візу не оформлюють на стаціонарних переходах із сусідніми державами.");
	  	 	      	   txt6.setText(info[5]+"5-10 USD (без спиртного)");
	  	 	      	   txt7.setText(info[6]+"10% від суми замовлення");
	  	 	      	   txt8.setText(info[7]+"від 30 USD"); 
	  	     break;
	        case 11:   txt1.setText("ТУРЕЧЧИНА   "+info[0]+"турецька");
	  	 	           txt2.setText(info[1]+"близько 78,7 млн. людей");
	  	 	           txt3.setText(info[2]+"90");
	  	 	           txt4.setText(info[3]+"Турецька ліра (TRY), 1 турецьких лір = 100 курушів, 1 USD ≅ 1,6 TRY 1 EUR ≅ 2,3 турецьких лір");
	  	 	           txt5.setText(info[4]+"безвізово до 30 днів");
	  	 	           txt6.setText(info[5]+"«типової» вечері: в кафе близько 4 USD, в ресторані - від 6 USD");
	  	 	           txt7.setText(info[6]+"10% від суми замовлення");
	  	 	           txt8.setText(info[7]+"від 40 USD на добу"); 
	  	     break;
	        case 12:   txt1.setText("ШРІ-ЛАНКА   "+info[0]+"англійська, сингальська і тамільська");
	                   txt2.setText(info[1]+"більше 21 млн. чоловік");
	                   txt3.setText(info[2]+"94");
	                   txt4.setText(info[3]+"Ланкійська рупія (LKR), 1 LKR = 100 центів, 1 USD ≅ 110 LKR, 1 EUR ≅ 159 LKR");
	                   txt5.setText(info[4]+"35$ на 30 днів на кордоні за наявності зворотніх квитків");
	                   txt6.setText(info[5]+"інформація відсутня");
	                   txt7.setText(info[6]+"чайові не обов'язково");
	                   txt8.setText(info[7]+"від 30 USD"); 
	         break;
	        
	        }
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
	  
}


class OpusTask extends AsyncTask<String, String, String> {
	 final String LOG_TAG = "myLogs";
	
	 String str=null;
		
@Override
protected void onPreExecute() {
  super.onPreExecute();
 
}

protected String doInBackground(String... params) {
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
    String qury="SELECT img FROM countri WHERE id="+ss;
    
    	try { 
    		conn = DriverManager.getConnection(url1, name, password); 
    
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(qury);
        rs.next();
    		Log.d(LOG_TAG,"есть подключение к БД");    
    		
    				str = rs.getString("img");
    				
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
    return str;
}

	


	protected void onProgressUpdate(String values) {
		super.onProgressUpdate(values);
   }


	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Log.d(LOG_TAG, "End. Result = " + result);
	}
}

