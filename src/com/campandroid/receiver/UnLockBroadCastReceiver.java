package com.campandroid.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UnLockBroadCastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "Unlock~~", Toast.LENGTH_LONG).show();

	}

}
