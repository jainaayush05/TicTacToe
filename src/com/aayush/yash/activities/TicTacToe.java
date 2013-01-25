package com.aayush.yash.activities;

import com.aayush.yash.models.TicTacToeModel;

import com.aayush.yash.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TicTacToe extends Activity implements OnClickListener {
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		MediaPlayer IntroPlayer = MediaPlayer.create(TicTacToe.this, R.raw.intro);
		IntroPlayer.start();
		
      
		
		View continueGameButton = findViewById(R.id.continue_button);
		continueGameButton.setOnClickListener(this);
		View newGameButton = findViewById(R.id.new_game_button);
		newGameButton.setOnClickListener(this);
		View optionsButton = findViewById(R.id.options_button);
		optionsButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
	}
	
	
	
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.continue_button: 
			//music(2);
			startActivity(new Intent(this, Game.class));
			break;
		case R.id.new_game_button: 
			//music(2);
			TicTacToeModel.getInstance().newGame();
			startActivity(new Intent(this, Game.class));
			break;
		case R.id.options_button: 
			//music(2);
			startActivity(new Intent(this, Options.class));
			break;
		case R.id.about_button: 
			//music(2);
			startActivity(new Intent(this, About.class));
			break;
		default:
			break;
		}
	}
	

}