package com.acm.ucf.quiz_game;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScoreFragment extends Fragment {
	   int count= 60;
	    TextView tv;
	    private TimerTask mTimerTask;
        private Timer timer = new Timer();  
        Handler timerHandler;

		public ScoreFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			
			View rootView = inflater.inflate(R.layout.fragment_score, container, false);
			timerHandler=new Handler();
			tv= (TextView)rootView.findViewById(R.id.textView3);

	        onTimerTick();
	        timer.schedule(mTimerTask, 10, 1000);
			return rootView;
	}
		
		  public void onTimerTick() {
	            
			  mTimerTask = new TimerTask() {
	                // this method is called every 1ms
	                public void run() {
	                     timerHandler.post(new Runnable() {
	                         public void run() {  
	                            // update textView
	                            // ERROR:textView2 cannot be resolved
	                        	 if(count!=0)
	                                tv.setText(Integer.toString(count--));
	                        	 else{
	                        		 tv.setText(Integer.toString(count));
	                        		 mTimerTask.cancel();
	                        	 }
	                            Log.d("tag", "Hello from timer fragment");
	                         }
	                     });
	                }};
	        }
}


