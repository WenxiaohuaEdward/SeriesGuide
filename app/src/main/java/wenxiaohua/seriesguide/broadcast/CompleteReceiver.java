package wenxiaohua.seriesguide.broadcast;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public  class CompleteReceiver extends BroadcastReceiver {

	private String TAG = "CompleteReceiver";
	public static final String COMPLETE ="android.intent.action.DOWNLOAD_COMPLETE";
	private  Context mContext;

	@Override
	public void onReceive(Context context, Intent intent) {
		// get complete download id
		long completeDownloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
		// to do here
		this.mContext = context;
		Log.d(TAG, "onReceive - " + intent.getAction());

		if (intent.getAction().equals(COMPLETE)) {
			Toast.makeText(mContext,"缓存成功",Toast.LENGTH_LONG);
		}
	}


}


