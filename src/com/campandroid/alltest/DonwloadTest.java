package com.campandroid.alltest;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

public class DonwloadTest {
	DownloadManager downloadManager;
	Context ctx = null;
	public DonwloadTest(Context c){
		 ctx = c; 
		 downloadManager = (DownloadManager)ctx.getSystemService(Context.DOWNLOAD_SERVICE);
	}
	
	// 웹에 링크된 파일을 Download 매니저를 이용해 특정폴더(download)에 저장한다.
	@SuppressLint("NewApi")
	public void StartDownload(String sURL){
		Uri urlToDownload = Uri.parse(sURL);
		DownloadManager.Request request;
		
		List<String> pathSegments = urlToDownload.getPathSegments();
        request = new DownloadManager.Request(urlToDownload);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, pathSegments.get(pathSegments.size()-1));
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();
        downloadManager.enqueue(request);
	}
	
}
