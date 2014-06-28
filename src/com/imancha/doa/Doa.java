package com.imancha.doa;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

public class Doa extends Activity implements OnItemClickListener,
		OnItemLongClickListener, OnQueryTextListener {
	private ListView list;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doa);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.setTitle("Doa");

		list = (ListView) findViewById(R.id.listView1);

		list.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_list_item_1, DB.doa) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView text = (TextView) view.findViewById(android.R.id.text1);

				text.setTextColor(Color.BLACK);
				return view;
			}
		});

		list.setOnItemClickListener(this);
		list.setOnItemLongClickListener(this);
		list.setTextFilterEnabled(true);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent = new Intent(getApplicationContext(), ViewDoa.class);
		Bundle bundle = new Bundle();

		bundle.putString("doa", arg0.getItemAtPosition(arg2).toString());
		bundle.putInt("pos", DB.index(arg0.getItemAtPosition(arg2).toString()));
		
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		Toast.makeText(getApplicationContext(), DB.doa[arg2], Toast.LENGTH_SHORT)
				.show();

		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();

		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
		searchView.setSubmitButtonEnabled(false);
		searchView.setOnQueryTextListener(this);		
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

	@Override
	public boolean onQueryTextChange(String arg0) {
		if (TextUtils.isEmpty(arg0))
			list.clearTextFilter();
		else
			list.setFilterText(arg0.toString());

		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		return false;
	}

}
