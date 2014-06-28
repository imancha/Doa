package com.imancha.doa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Help extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.setTitle("Help");

		TextView TV = (TextView) findViewById(R.id.textView1);
		TV.setText("Untuk membaca atau menghafal Doa Sehari Hari, pilih Menu Doa pada Menu Utama kemudian pilih Doa yang diinginkan.\n\n"
				+ "Untuk mempermudah dalam mencari Doa, gunakan fasilitas filter/cari dengan mengklik icon cari pada pojok kanan atas dari Daftar Doa.\n\n"
				+ "Tambahkan Doa pada Menu Bookmark untuk mempercepat dalam memilih Doa yang ingin dibaca atau dihafal dengan mengklik icon bintang pada pojok kanan atas dari Doa yang sedang dibaca.\n\n"
				+ "Untuk menghapus Doa pada Daftar Bookmark, klik dan tahan Doa yang diinginkan sampai muncul pop up menu dan pilih Remove.");
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
