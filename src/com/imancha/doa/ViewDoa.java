package com.imancha.doa;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Typeface;

public final class ViewDoa extends Activity {
	private String doa = new String();
	private int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_doa);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		TextView TV1 = (TextView) findViewById(R.id.textView1);
		TextView TV2 = (TextView) findViewById(R.id.textView2);
		TextView TV3 = (TextView) findViewById(R.id.textView3);

		Bundle bundle = getIntent().getExtras();
		doa = bundle.getString("doa").toString();
		pos = bundle.getInt("pos");

		super.setTitle(doa);

		Typeface type = Typeface.createFromAsset(getAssets(), "KacstOffice.ttf");

		TV1.setTypeface(type, Typeface.BOLD);
		TV2.setTypeface(type);
		TV3.setTypeface(type, Typeface.ITALIC);

		TV2.setGravity(Gravity.CENTER_HORIZONTAL);
		TV3.setGravity(Gravity.CENTER_HORIZONTAL);

		TV2.setText(DB.arab[pos]);
		TV3.setText(DB.arti[pos]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				break;
			case R.id.bookmark:
				DBHelper mydb = new DBHelper(getApplicationContext());
				ArrayList<String> list = mydb.getAllBookmark();

				if (!list.contains(doa))
					mydb.insertBookmark(pos, doa);

				Toast.makeText(this, doa + " Added to Bookmark", Toast.LENGTH_SHORT)
						.show();
				break;
		}

		return true;
	}
}
