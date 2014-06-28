package com.imancha.doa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.setTitle("About");

		TextView TV = (TextView) findViewById(R.id.textView3);
		TV.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				break;
		}

		return true;
	}
}
