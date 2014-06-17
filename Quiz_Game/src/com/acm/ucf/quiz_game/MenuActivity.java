package com.acm.ucf.quiz_game;

import com.acm.ucf.quiz_game.MainActivity.PlaceholderFragment;
<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
=======
import android.content.Intent;
import android.app.Activity;
>>>>>>> c851342babbf15569369cdfd4b1340f6ca7f13bc
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
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
=======
        setContentView(R.layout.activity_menu);
    	
    }
    
    public void startQuiz(View view)
    {
    	Intent intent = new Intent(this, QuizActivity.class);
    	startActivity(intent);
    }
>>>>>>> c851342babbf15569369cdfd4b1340f6ca7f13bc
}
