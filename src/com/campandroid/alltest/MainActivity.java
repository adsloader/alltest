package com.campandroid.alltest;

import com.campandroid.service.MainService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	int nLineNumber = 0;
	// Activity�� ������ ��
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ���񽺸� �����ŵ�ϴ�.
		Intent Service = new Intent(this, MainService.class);
		startService(Service);
		
		Log.d("ALLTEST", String.format("\n%d: onCreate", nLineNumber++) );
	}
	
	// �� activity �Ǿ����� ���� ��
	@Override
	public void onResume(){
		super.onResume();
		Log.d("ALLTEST", String.format("%d: onResume", nLineNumber++) );
	}
	
	// �� activity �Ǿտ� ������ ���� ��
	@Override
	public void onStop(){
		super.onStop();
		Log.d("ALLTEST", String.format("%d: onStop", nLineNumber++) );
	}
	
	// Activity�� ���ʽ���� ��
	@Override
	public void onStart(){
		super.onStart();
		Log.d("ALLTEST", String.format("%d: onStart", nLineNumber++) );
	}
	
	// Activity�� ������ ����� ��
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.d("ALLTEST", String.format("%d: onDestroy", nLineNumber++) );
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
