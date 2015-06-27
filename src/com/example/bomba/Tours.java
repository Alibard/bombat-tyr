package com.example.bomba;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tours extends Activity implements OnClickListener{
	Button ukr;
	Button border;
	Button fire;
	 public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.tours);
	       ActionBar bar = getActionBar();
           bar.setDisplayHomeAsUpEnabled(true);
           ukr = (Button)findViewById(R.id.ukr);
           ukr.setOnClickListener(this);
           border = (Button)findViewById(R.id.border);
           border.setOnClickListener(this);
           fire = (Button)findViewById(R.id.button3);
           fire.setOnClickListener(this);

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
		Intent intent = new Intent(this, TurInfo.class);
		 switch (v.getId()) {
		 case R.id.ukr:
			   intent.putExtra("Oid", "ukr");
			   startActivity(intent);
			 break;
		 case R.id.border:
			   intent.putExtra("Oid", "border");
			   startActivity(intent);
			 break;
		 case R.id.button3:
			   intent.putExtra("Oid", "fire");
			   startActivity(intent);
			 break;
		 }
	}

}
