package com.acm.ucf.quiz_game;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionFragment extends Fragment {
	
	public QuestionFragment(){
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_question, container, false);
		Button btn1 = (Button) rootView.findViewById(R.id.button1);
		Button btn2 = (Button) rootView.findViewById(R.id.button2);
		Button btn3 = (Button) rootView.findViewById(R.id.button3);
		Button btn4 = (Button) rootView.findViewById(R.id.button4);
		
		btn1.setBackgroundColor(Color.LTGRAY);
		btn2.setBackgroundColor(Color.LTGRAY);
		btn3.setBackgroundColor(Color.LTGRAY);
		btn4.setBackgroundColor(Color.LTGRAY);
		
		return rootView;
	}
	
	

		
}