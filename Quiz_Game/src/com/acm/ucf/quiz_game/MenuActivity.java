package com.acm.ucf.quiz_game;

import com.acm.ucf.quiz_game.MainActivity.PlaceholderFragment;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	
        Button btnquiz = (Button) findViewById(R.id.btnQuiz);
    	btnquiz.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	        // Do something in response to button click
    	    }
    	});
        Button flash = (Button) findViewById(R.id.btnFlash);
    	flash.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	        // Do something in response to button click
    	    }
    	});
    	
    }
}
