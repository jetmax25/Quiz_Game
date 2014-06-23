package com.acm.ucf.quiz_game;

import com.acm.ucf.quiz_game.MainActivity.PlaceholderFragment;
import android.content.Intent;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


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
