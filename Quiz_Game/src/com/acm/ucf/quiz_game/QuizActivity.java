package com.acm.ucf.quiz_game;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);

		if (savedInstanceState == null) {
			
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			
			fragmentTransaction.add(R.id.scoreFragment, new ScoreFragment());
			fragmentTransaction.add(R.id.questionFragment, new QuestionFragment());
			fragmentTransaction.add(R.id.navigationFragment, new NavigationFragment());
			
			fragmentTransaction.commit();
		}
		
		//Button nextQuestionButton = (Button) findViewById(R.id.next);
		//nextQuestionButton.setEnabled(false);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Method will be called when a button is clicked to answer a question.
	// It will grey out all the answers except the correct one, which will be in green
	// if the user selected the wrong answer, it will be shown in red.
	public void checkAnswer1(View v){
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		
		btn1.setBackgroundColor(Color.GREEN);
		btn2.setBackgroundColor(Color.DKGRAY);
		btn3.setBackgroundColor(Color.DKGRAY);
		btn4.setBackgroundColor(Color.DKGRAY);
		
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		
		//enableNext();
		
	}
	public void checkAnswer2(View v){
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		
		btn1.setBackgroundColor(Color.GREEN);
		btn2.setBackgroundColor(Color.RED);
		btn3.setBackgroundColor(Color.DKGRAY);
		btn4.setBackgroundColor(Color.DKGRAY);
		
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		
		//enableNext();

	}
	public void checkAnswer3(View v){
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		
		btn1.setBackgroundColor(Color.GREEN);
		btn2.setBackgroundColor(Color.DKGRAY);
		btn3.setBackgroundColor(Color.RED);
		btn4.setBackgroundColor(Color.DKGRAY);
		
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		
		//enableNext();

	}
	public void checkAnswer4(View v){
		
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		
		btn1.setBackgroundColor(Color.GREEN);
		btn2.setBackgroundColor(Color.DKGRAY);
		btn3.setBackgroundColor(Color.DKGRAY);
		btn4.setBackgroundColor(Color.RED);
		
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		
		//enableNext();

	}
	
	public void enableNext(){
		
	}
	
}
