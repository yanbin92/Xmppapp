package com.itheima.xmpp_20150807;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;

import com.itheima.xmpp_20150807.activity.LoginActivity;
import com.itheima.xmpp_20150807.utils.ThreadUtils;

public class SplashActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// 停留3s,进入登录界面

		ThreadUtils.runInThread(new Runnable() {
			@Override
			public void run() {
				// 休眠3s
				SystemClock.sleep(3000);

				// 进入主界面
				Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
