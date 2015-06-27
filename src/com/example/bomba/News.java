package com.example.bomba;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;




import com.squareup.picasso.Picasso;

@SuppressLint("NewApi")
public class News extends Activity {
public	ArrayList<Product> products = new ArrayList<Product>();
	  BoxAdapter boxAdapter;
	  ListView lvMain;
	  TextView txt;
	  Picasso pic;
	  private Context context;
	ScrollView scrollView1;
	 final String LOG_TAG = "myLogs";
    @Override //Конструктор
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.news);
       ActionBar bar = getActionBar();
       bar.setDisplayHomeAsUpEnabled(true);
       //fillData();
       MMyTask my = new MMyTask();;
       my.execute("s");
       try {
		products=my.get();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       boxAdapter = new BoxAdapter(this, products);

       // настраиваем список
      lvMain = (ListView) findViewById(R.id.lvMain);
     txt = (TextView) findViewById(R.id.text1);
       lvMain.setAdapter(boxAdapter);
       scrollView1 = (ScrollView)findViewById(R.id.scrollView1);
       txt.setVisibility(View.INVISIBLE);
       scrollView1.setVisibility(View.INVISIBLE);
    //  img =(ImageView)findViewById(R.id.bigimg);
       
       
       
       lvMain.setOnItemClickListener(new OnItemClickListener() {
   		   

   			@Override
   			public void onItemClick(AdapterView<?> parent, View view,
   				int position, long id) {
   				txt.setVisibility(View.VISIBLE);
   				lvMain.setVisibility(View.INVISIBLE);
   				scrollView1.setVisibility(View.VISIBLE);
   				MyBigText mbt = new MyBigText();
   				String txt1=null;
   				Log.d(LOG_TAG, Integer.toString(position+1)); 
   				mbt.execute(Integer.toString(position+1));
   				try {
					 txt1=mbt.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   				txt.setText(txt1);
   			///	pic.with(context).load(str[position]).into(img);
   			
   				
   				}
   		 });
   		 txt.setOnClickListener(new OnClickListener() {
   				@Override
   				public void onClick(View v) {
   					txt.setVisibility(View.INVISIBLE);
   					lvMain.setVisibility(View.VISIBLE);
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
    class MMyTask extends AsyncTask<String, String, ArrayList<Product>> {
   	 final String LOG_TAG = "myLogs";
   	 int i=0;
   	
   	
   	
   @Override
   protected void onPreExecute() {
     super.onPreExecute();
    
   }

   protected ArrayList<Product> doInBackground(String... params) {
   //	ArrayList<Product> products = new ArrayList<Product>();
   	try {    
           Class.forName("com.mysql.jdbc.Driver"); 
           Log.d(LOG_TAG, "--- Driver is conected!!! ---"); 
       } catch (ClassNotFoundException e) { 
           Log.d(LOG_TAG, "--- Driver is NOT conected!!! ---"); 
           Log.d(LOG_TAG,e.toString()); 
    
           return  null; 
       } 
       Connection conn = null; 
       
       String url1 = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql579919"; 
       String name = "sql579919"; 
       String password = "sP8%hH4!"; 
       int i=0;
       String ss;
       String qury="SELECT img, text, text2	 FROM news";
       
       	try { 
       		conn = DriverManager.getConnection(url1, name, password); 
       
       		Statement stmt = conn.createStatement();
       		ResultSet rs = stmt.executeQuery(qury);
           
       		Log.d(LOG_TAG,"есть подключение к БД");    
       		rs.last();
       //		int qwe = rs.getInt("id");
       		rs.first();
       		rs.beforeFirst();
       	
       			while (rs.next()) {
       				String img = rs.getString("img");
       				String text =rs.getString("text");
       				String text2 =rs.getString("text2");
       				
       				products.add(new Product(text, text2,
       				         img));
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
       return products;
   }

   	


   	protected void onProgressUpdate(String values) {
   		super.onProgressUpdate(values);
      }


   	protected void onPostExecute(ArrayList<Product> result) {
   		super.onPostExecute(result);
   		Log.d(LOG_TAG, "End. Result = " + result);
   	}
   }
    class MyBigText extends AsyncTask<String, String, String> {
      	 final String LOG_TAG = "myLogs";
      	 int i=0;
      	 String text2;
      	
      	
      @Override
      protected void onPreExecute() {
        super.onPreExecute();
       
      }

      protected String doInBackground(String... params) {
      //	ArrayList<Product> products = new ArrayList<Product>();
      	try {    
              Class.forName("com.mysql.jdbc.Driver"); 
              Log.d(LOG_TAG, "--- Driver is conected!!! ---"); 
          } catch (ClassNotFoundException e) { 
              Log.d(LOG_TAG, "--- Driver is NOT conected!!! ---"); 
              Log.d(LOG_TAG,e.toString()); 
       
              return  null; 
          } 
          Connection conn = null; 
          
          String url1 = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql579919"; 
          String name = "sql579919"; 
          String password = "sP8%hH4!"; 
        
          String ss=params[0];
          String text2 = null;
          String qury="SELECT bigText FROM news WHERE id="+ss;
          
          	try { 
          		conn = DriverManager.getConnection(url1, name, password); 
          
          		Statement stmt = conn.createStatement();
          		ResultSet rs = stmt.executeQuery(qury);
              
          		Log.d(LOG_TAG,"есть подключение к БД");    
          		rs.last();
        
          		rs.first();
          		rs.beforeFirst();
          	
          			rs.next();
          				
          			 text2 =rs.getString("bigText");
          			
          			
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
          return text2;
      }

      	


      	protected void onProgressUpdate(String values) {
      		super.onProgressUpdate(values);
         }


      	protected void onPostExecute(String result) {
      		super.onPostExecute(result);
      		Log.d(LOG_TAG, "End. Result = " + result);
      	}

	
      }
}
