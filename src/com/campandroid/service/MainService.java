package com.campandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.campandroid.*;
import com.campandroid.alltest.DonwloadTest;

public class MainService extends Service {

	int nCount = 0;
	@Override
    public void onCreate() {
        super.onCreate();
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
    	if(intent != null){
    		LogCountInfo();
    	}
        return super.onStartCommand(intent, flags, startId);
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    // 3초간격으로 handleMessage()를 호출한다. 
    Handler handler;
    private void  LogCountInfo(){
    	handler = new Handler() {
            public void handleMessage(Message msg) {
            	Log.d("ALLTEST", String.format("service count-->%d", nCount++) );
            	if(nCount == 20){
            		// 다운로드를 테스트한다.
            		String sURL = "http://postfiles1.naver.net/20140601_48/adsloader_1401555211884l4tOi_PNG/%BB%E7%C1%F8_14._5._26._%BF%C0%C0%FC_12_54_53.png?type=w2";
            		new DonwloadTest(getApplicationContext()).StartDownload(sURL);
            	}
            	
            	if(nCount < 100){
            	    handler.sendEmptyMessageDelayed(0,3000);
            	}
                
            }
        };
        handler.sendEmptyMessage(0);
    }

}
