package com.acm.ucf.quiz_game;

import android.view.View;
import android.widget.Button;

public class Question{
	
		private boolean correct;
		private String answer;
		private static int score;
		
		
		Question(String answer){
			this.answer = answer; 
		}
		
		public boolean checkAnswer(Button check){
			if(check.getText().toString().contentEquals(answer)){
			
				return true;
			}
			
			
			return false;
		}
		
	
}
