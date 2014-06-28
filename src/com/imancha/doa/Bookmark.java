package com.imancha.doa;

import java.util.ArrayList;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
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

public class Bookmark extends Activity implements OnItemClickListener,
		OnQueryTextListener, OnItemLongClickListener {

	ListView list;
	TextView TV;
	ArrayList<String> doa = new ArrayList<String>();
	ArrayList<Integer> pos = new ArrayList<Integer>();
	DBHelper mydb;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doa);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.setTitle("Bookmark");

		mydb = new DBHelper(getApplicationContext());
		doa = mydb.getAllBookmark();
		pos = mydb.getAllIndex();

		TV = (TextView) findViewById(R.id.textView1);
		list = (ListView) findViewById(R.id.listView1);

		if (doa.isEmpty()) {
			TV.setText("Doa Tidak Ditemukan");
			list.setVisibility(View.INVISIBLE);
		} else {
			list.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_list_item_1, doa) {
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
			registerForContextMenu(list);
			list.setTextFilterEnabled(true);
			TV.setVisibility(View.INVISIBLE);
		}
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

	private String s;
	private int p;
	
	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		s = arg0.getItemAtPosition(arg2).toString();
		p = DB.index(arg0.getItemAtPosition(arg2).toString());
		return false;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		if (v.getId() == R.id.listView1) {
			menu.setHeaderTitle(s);

			String[] menuItems = { "View", "Remove" };
			for (int i = 0; i < menuItems.length; i++) {
				menu.add(Menu.NONE, i, i, menuItems[i]);
			}
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		item
				.getMenuInfo();
		int menuItemIndex = item.getItemId();
		String[] menuItems = { "View", "Remove" };
		String menuItemName = menuItems[menuItemIndex];
		String listItemName = s;

		if (menuItemName.equals("View")) {
			Intent intent = new Intent(getApplicationContext(), ViewDoa.class);
			Bundle bundle = new Bundle();

			bundle.putString("doa", listItemName);
			bundle.putInt("pos", p);

			intent.putExtras(bundle);

			startActivity(intent);
		} else if (menuItemName.equals("Remove")) {
			DBHelper mydb = new DBHelper(getApplicationContext());
			mydb.deleteBookmark(p);
			doa = mydb.getAllBookmark();

			Toast.makeText(getApplicationContext(),
					listItemName + " Removed from Bookmark", Toast.LENGTH_SHORT)
					.show();

			list.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
					android.R.layout.simple_list_item_1, doa) {
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					View view = super.getView(position, convertView, parent);
					TextView text = (TextView) view.findViewById(android.R.id.text1);

					text.setTextColor(Color.BLACK);
					return view;
				}
			});

			if (doa.isEmpty()) {
				TV.setText("Doa Tidak Ditemukan");
				TV.setVisibility(0);
			}
		}
		return true;
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
		if (TextUtils.isEmpty(arg0)) {
			list.clearTextFilter();
		} else {
			list.setFilterText(arg0.toString());
		}

		return true;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {

		return false;
	}

}
