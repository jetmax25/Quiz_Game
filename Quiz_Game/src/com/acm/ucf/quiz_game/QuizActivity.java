package com.acm.ucf.quiz_game;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity  {
	
	// Counts the question number currently answering
	// private int questionNum = 0;
	// Holds the questions
	private ArrayList<Question> questions;
	private Button[] buttons = new Button[4];
	private Question currentQuestion;
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	int score = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		if (savedInstanceState == null) {
			
			fragmentManager = getFragmentManager();
			fragmentTransaction = fragmentManager.beginTransaction();
			
			fragmentTransaction.add(R.id.scoreFragment, new ScoreFragment());
			fragmentTransaction.add(R.id.questionFragment, new QuestionFragment());
			fragmentTransaction.add(R.id.navigationFragment, new NavigationFragment());
			
			// Creates the questions
			questions = new ArrayList<Question>();
			currentQuestion = new Question("correct");
			questions.add(currentQuestion);
			fragmentTransaction.commit();
		}
		// Button nextQuestionButton = (Button) findViewById(R.id.next);
		// nextQuestionButton.setEnabled(false);
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
	public void checkAnswer(View v){
		
		buttons[0] = (Button) findViewById(R.id.button1);
		buttons[1] = (Button) findViewById(R.id.button2);
		buttons[2] = (Button) findViewById(R.id.button3);
		buttons[3] = (Button) findViewById(R.id.button4);
		
		Button btnChosen = (Button) findViewById(v.getId());
		TextView scoreView = (TextView) findViewById(R.id.evScore);
		
		/* can change getText to getKey and set a key in the xml*/
		
		//checks the buttons text against the Question 
		boolean correct = currentQuestion.checkAnswer(btnChosen);
		
		if(correct){
			btnChosen.setBackgroundColor(Color.GREEN);
			score++;
			scoreView.setText(Integer.toString(score));
			btnChosen.setEnabled(false);
		}
		
		else btnChosen.setBackgroundColor(Color.RED);
			
		for(int i = 0; i < 4; i++){
			if(btnChosen.equals(buttons[i])) continue;
			
			if(currentQuestion.checkAnswer(buttons[i])) buttons[i].setBackgroundColor(Color.GREEN);
			else buttons[i].setBackgroundColor(Color.GRAY);
			buttons[i].setEnabled(false);
		}
	}
	
	public void findCorrect(Button btnSkip){
		
		// Finds the correct answer and makes it green all others are gray
		for(int i = 0; i < 4; i++){
			if(btnSkip.equals(buttons[i])) continue;
			
		if(currentQuestion.checkAnswer(buttons[i])) buttons[i].setBackgroundColor(Color.GREEN);
			else buttons[i].setBackgroundColor(Color.GRAY);
		}
	}
	
	public void next(View V){
		
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		transaction.replace(R.id.questionFragment, new QuestionFragment());
		transaction.commit(); 
	
		currentQuestion = new Question("correct");
		questions.add(currentQuestion);	
	}
}
