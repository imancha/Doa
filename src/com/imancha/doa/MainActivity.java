package com.imancha.doa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnLongClickListener {
	private View B1, B2, B3, B4, B5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		B1 = findViewById(R.id.button1);
		B1.setOnClickListener(this);
		B1.setOnLongClickListener(this);
		B2 = findViewById(R.id.button2);
		B2.setOnClickListener(this);
		B2.setOnLongClickListener(this);
		B3 = findViewById(R.id.button3);
		B3.setOnClickListener(this);
		B3.setOnLongClickListener(this);
		B4 = findViewById(R.id.button4);
		B4.setOnClickListener(this);
		B4.setOnLongClickListener(this);
		B5 = findViewById(R.id.button5);
		B5.setOnClickListener(this);
		B5.setOnLongClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
	}

	@Override
	public void onClick(View v) {
		Intent i;
		switch (v.getId()) {
			case R.id.button1:
				i = new Intent(this, Doa.class);
				startActivity(i);
				break;
			case R.id.button2:
				i = new Intent(this, Bookmark.class);
				startActivity(i);
				break;
			case R.id.button3:
				i = new Intent(this, Help.class);
				startActivity(i);
				break;
			case R.id.button4:
				i = new Intent(this, About.class);
				startActivity(i);
				break;
			case R.id.button5:
				finish();
				break;
		}
	}

	@Override
	public boolean onLongClick(View arg0) {
		switch (arg0.getId()) {
			case R.id.button1:
				Toast.makeText(getApplicationContext(), "Doa", Toast.LENGTH_SHORT)
				.show();
				break;
			case R.id.button2:
				Toast.makeText(getApplicationContext(), "Bookmark", Toast.LENGTH_SHORT)
				.show();
				break;
			case R.id.button3:
				Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT)
				.show();
				break;
			case R.id.button4:
				Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT)
				.show();
				break;
			case R.id.button5:
				Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT)
				.show();
				break;
		}
		return false;
	}
}
