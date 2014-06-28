package com.imancha.doa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Opening extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opening);

		TextView TV = (TextView) findViewById(R.id.textView1);
		TV.setTextColor(Color.GRAY);
		TV.setTypeface(Typeface.createFromAsset(getAssets(), "KacstOffice.ttf"));

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent i = new Intent(Opening.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, 2000);
	}
}
