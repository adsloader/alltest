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
	
	// ���� ��ũ�� ������ Download �Ŵ����� �̿��� Ư������(download)�� �����Ѵ�.
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
