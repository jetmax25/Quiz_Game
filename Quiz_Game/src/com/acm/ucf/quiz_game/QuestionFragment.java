package com.acm.ucf.quiz_game;

import java.util.Random;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionFragment extends Fragment {
	private Button[] buttons = new Button[4];
	
	
	public QuestionFragment(){
		

		
		
		
	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_question, container, false);
		buttons[0] = (Button) rootView.findViewById(R.id.button1);
		buttons[1] = (Button) rootView.findViewById(R.id.button2);
		buttons[2] = (Button) rootView.findViewById(R.id.button3);
		buttons[3] = (Button) rootView.findViewById(R.id.button4);
		
		buttons[0].setBackgroundColor(Color.LTGRAY);
		buttons[1].setBackgroundColor(Color.LTGRAY);
		buttons[2].setBackgroundColor(Color.LTGRAY);
		buttons[3].setBackgroundColor(Color.LTGRAY);
		
		
		//loads possible answers from array
				Resources res = getResources();
				String[] answers = res.getStringArray(R.array.questionBank);
				
				
				//creates a random number between 0 and 3 that button is correct and the others are incorrect
				Random rand = new Random();
				int correct = rand.nextInt(4); 
				
				
				buttons[correct].setText(answers[0]);
				buttons[(correct + 1) % 4].setText(answers[1]);
				buttons[(correct + 2) % 4].setText(answers[2]);
				buttons[(correct + 3) % 4].setText(answers[3]); 
		
		
		return rootView;
	}
	
	

		
}