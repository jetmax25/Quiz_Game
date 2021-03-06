package com.acm.ucf.quiz_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity  {
	
	
	//counts the question number currently answering
	private static int questionNum = 0;
	//holds the questions
	private static ArrayList<Question> questions;
	private static Button[] buttons = new Button[4];
	private static Question currentQuestion;
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	private int score = 0;
	
	private static final String KEY_SCORE = "scorekey";
	
	
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
			
			//creates the questions
			questions = new ArrayList<Question>();
			currentQuestion = new Question("correct");
			questions.add(currentQuestion);
			fragmentTransaction.commit();		
			
		}
		//Button nextQuestionButton = (Button) findViewById(R.id.next);
		//nextQuestionButton.setEnabled(false);
			
		// Check the bundle for instance
		if(savedInstanceState != null) {
			score = savedInstanceState.getInt(KEY_SCORE, 0);
			
		}
		
		
			
		
	}
	
	
	/* TALK ABOUT THIS, WHY DOESNT IT WORK? */
//	private void initialize(QuestionFragment q){
//		
//		View v=q.getView();
//		
//		buttons[0] = (Button) v.findViewById(R.id.button1);
//		buttons[1] = (Button) v.findViewById(R.id.button2);
//		buttons[2] = (Button) v.findViewById(R.id.button3);
//		buttons[3] = (Button) v.findViewById(R.id.button4);
//		
//		
//		//loads possible answers from array
//		Resources res = getResources();
//		String[] answers = res.getStringArray(R.array.questionBank);
//		
//		
//		//creates a random number between 0 and 3 that button is correct and the others are incorrect
//		Random rand = new Random();
//		int correct = rand.nextInt(4); 
//		
//		
//		buttons[correct].setText(answers[0]);
//		buttons[(correct + 1) % 4].setText(answers[1]);
//		buttons[(correct + 2) % 4].setText(answers[2]);
//		buttons[(correct + 3) % 4].setText(answers[3]); 
//		}

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
		
		//savedInstanceState.putInt(KEY_SCORE, score);
		
	}
	
	public void findCorrect(Button btnSkip){
		
		
		//finds the correct answer and makes it green all others are gray
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
	
	public void onSavedInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt(KEY_SCORE, score);
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
				  
				File file = new File("Questions.txt");  
				PrintWriter out = null;
				try {
					out = new PrintWriter(new FileWriter(file));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				  
				// Write each string in the array on a separate line  
				for (int i = 0; i < questions.size(); i++) {  
				    out.println(questions.get(i));
				}  
				  
				out.close();  
		super.onStop();
	}
	
	
	
	
}
