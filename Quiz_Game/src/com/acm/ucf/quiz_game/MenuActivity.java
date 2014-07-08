package com.acm.ucf.quiz_game;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    	
    }
    
    public void startQuiz(View view)
    {
    	Intent intent = new Intent(this, QuizActivity.class);
    	startActivity(intent);
    }
}
