package com.aayush.yash.activities;

import com.aayush.yash.controllers.TicTacToeController;
import com.aayush.yash.models.TicTacToeModel;

import com.aayush.yash.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener {

	private static TicTacToeModel model = TicTacToeModel.getInstance();
	private static TicTacToeController controller = TicTacToeController
			.getInstance();

	private Button[] buttons;
	
	private void initListeners() {
		buttons = new Button[9];
		buttons[0] = (Button) findViewById(R.id.button_11);
		buttons[1] = (Button) findViewById(R.id.button_12);
		buttons[2] = (Button) findViewById(R.id.button_13);
		buttons[3] = (Button) findViewById(R.id.button_21);
		buttons[4] = (Button) findViewById(R.id.button_22);
		buttons[5] = (Button) findViewById(R.id.button_23);
		buttons[6] = (Button) findViewById(R.id.button_31);
		buttons[7] = (Button) findViewById(R.id.button_32);
		buttons[8] = (Button) findViewById(R.id.button_33);

		for (Button btn : buttons) {
			btn.setOnClickListener(this);
		}

		TextView reset=(TextView)findViewById(R.id.reset);
		reset.setOnClickListener(this);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Kinderg.ttf");
		reset.setTypeface(typeFace);
		
	}
	

	private void injectionController() {
		TextView humanScore=(TextView)findViewById(R.id.human_score);
		TextView droidScore=(TextView)findViewById(R.id.droid_score);
		Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Kinderg.ttf");
		humanScore.setTypeface(typeFace);
		droidScore.setTypeface(typeFace);
		controller.setButtons(buttons);
		controller.setScores((TextView) findViewById(R.id.human_score),
			(TextView) findViewById(R.id.droid_score));
	}

	private void doMove(Button btn) {
		MediaPlayer xPlayer = MediaPlayer.create(Game.this, R.raw.soundx);
		MediaPlayer oPlayer = MediaPlayer.create(Game.this, R.raw.soundo);
        
        
		switch (btn.getId()) {
		case R.id.button_11:
			model.doMove(0, 0);
			xPlayer.start();
			break;
		case R.id.button_12:
			model.doMove(0, 1);
			xPlayer.start();
			break;
		case R.id.button_13:
			model.doMove(0, 2);
			xPlayer.start();
			break;
		case R.id.button_21:
			model.doMove(1, 0);
			xPlayer.start();
			break;
		case R.id.button_22:
			model.doMove(1, 1);
			xPlayer.start();
			break;
		case R.id.button_23:
			model.doMove(1, 2);
			xPlayer.start();
			break;
		case R.id.button_31:
			model.doMove(2, 0);
			xPlayer.start();
			break;
		case R.id.button_32:
			model.doMove(2, 1);
			xPlayer.start();
			break;
		case R.id.button_33:
			model.doMove(2, 2);
			xPlayer.start();
			break;
		}
	}

	private void newRound() {
		model.newRound();
		controller.refreshGame();
	}
	
	private  void restart(){
		showRestartDialog();
	}

	private void newGame() { 
		model.newGame();
		controller.refreshGame();
	}

	private void showAlertDialog(int status) {
		
		new AlertDialog.Builder(this).setTitle(R.string.message_title)
				.setMessage(status).setNeutralButton("Ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dlg, int sumthin) {
								newRound();
							}
						}).show();
		
	}



	

	private void showRestartDialog() {
		
		new AlertDialog.Builder(this).setTitle(R.string.question_title)
				.setMessage(R.string.restart_game).setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dlg, int sumthin) {
								newGame();
							}
						}).setNegativeButton("No", null).show();
		/*final Context context = this;
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.reset);
		dialog.setTitle("Reset");
		
		TextView text = (TextView) dialog.findViewById(R.id.about_content);
		text.setText("Do you want to reset? ");
		ImageView image = (ImageView) dialog.findViewById(R.id.ImageView01);
		image.setImageResource(R.drawable.ic_launcher);

		Button dialogButton = (Button) dialog.findViewById(R.id.dialogbutton);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				newRound();
			}
		});

		dialog.show();*/
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		initListeners();
		injectionController();
		controller.refreshGame();
	} 
	
	public void onClick(View v) {
		if (v instanceof Button) {
			doMove((Button) v);
			controller.refreshGame();
			if (model.getState() == TicTacToeModel.STATE_DRAW)
				showAlertDialog(R.string.draw_game);
			else if (model.getState() == TicTacToeModel.STATE_WIN) {
				if (model.getWinner() == TicTacToeModel.NOUGHT)
					showAlertDialog(R.string.nought_win_game);
				else if (model.getWinner() == TicTacToeModel.CROSS)
					showAlertDialog(R.string.cross_win_game);
			}

		} else if (v instanceof TextView) {
			showRestartDialog();
		}
	}

}
