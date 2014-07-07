package com.acm.ucf.quiz_game;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

	// Splash screen timer
		private static int SPLASH_TIME_OUT = 2000;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_splash);

			Thread startTimer = new Thread(){ 
				public void run() {
					try {
						sleep(SPLASH_TIME_OUT);
						Intent i = new Intent(SplashScreen.this, MenuActivity.class);
						startActivity(i);
						finish();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			};
			startTimer.start();

		}

}