package com.example.bomba;




import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class Country extends Activity implements OnClickListener{
    Button button1;
	
	Button button3;

	Button button5;
	Button button6;
	Button button7;
	Button button8;
	Button button9;
	Button button10;
	Button button11;
	Button button12;
	
	String id = null;
	 public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.country);
	       ActionBar bar = getActionBar();
           bar.setDisplayHomeAsUpEnabled(true);
	button1 = (Button)findViewById(R.id.ukr);
		
		button3 = (Button)findViewById(R.id.button3);
	
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		button7 = (Button)findViewById(R.id.button7);
		button8 = (Button)findViewById(R.id.button8);
		button9 = (Button)findViewById(R.id.button9);
		button10 = (Button)findViewById(R.id.button10);
		button11 = (Button)findViewById(R.id.button11);
		button12 = (Button)findViewById(R.id.button12);
		button1.setOnClickListener(this);
		
		button3.setOnClickListener(this);
		
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		button10.setOnClickListener(this);
		button11.setOnClickListener(this);
		button12.setOnClickListener(this);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
				 Intent intent = new Intent(this, Opus.class); 
				switch (v.getId()) {
				 case R.id.ukr:
				 				   id = "1";
				 				   intent.putExtra("Oid", id);
				 				   startActivity(intent);
				 	break; 
				
				 case R.id.button3:
					 			   id="3";
					 			   intent.putExtra("Oid", id);
				 				   startActivity(intent);
				   break;
				
				 case R.id.button5:
					 				id="5";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button6:
					 				id="6";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button7:
					 				id="7";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button8:
					 				id="8";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button9:
					 				id="9";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button10:
					 				id="10";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button11:
					 				id="11";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				 case R.id.button12:
					 				id="12";
					 				intent.putExtra("Oid", id);
					 				startActivity(intent);
				   break;
				   
				 }
			
					
				
				}
				
			}