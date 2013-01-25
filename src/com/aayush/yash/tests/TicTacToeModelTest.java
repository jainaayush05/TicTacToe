/**
 * Tests for the model
 * You need add JUnit 4 library to the build path 
 */

package com.aayush.yash.tests;
import org.junit.Assert;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aayush.yash.models.TicTacToeModel;



public class TicTacToeModelTest {
	private TicTacToeModel model = TicTacToeModel.getInstance();
	
	@Test
	public void test_NewGame() { 
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		assertTrue(TicTacToeModel.EMPTY == model.getWinner());
		assertTrue(TicTacToeModel.STATE_NONE == model.getState());
	}

	@Test
	public void test_HardDraw1() {
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		model.doMove(0, 0);
		model.doMove(0, 2);
		model.doMove(2, 1);
		model.doMove(1, 2);
		model.doMove(1, 0);
		assertTrue(model.getState() == TicTacToeModel.STATE_DRAW);
	}

	@Test
	public void test_HardDraw2() {
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		model.doMove(2, 1);
		model.doMove(2, 0);
		model.doMove(0, 0);
		model.doMove(1, 2);
		model.doMove(0, 1);
		assertTrue(model.getState() == TicTacToeModel.STATE_DRAW);
	}

	@Test
	public void test_HardDraw3() {
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		model.doMove(2, 1);
		model.doMove(2, 2);
		model.doMove(0, 2);
		model.doMove(1, 0);
		model.doMove(0, 1);
		assertTrue(model.getState() == TicTacToeModel.STATE_DRAW);
	}

	@Test
	public void test_HardLose1() {
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		model.doMove(0, 0);
		model.doMove(0, 1);
		model.doMove(1, 0);
		assertTrue(model.getState() == TicTacToeModel.STATE_WIN);
		assertTrue(model.getWinner() == TicTacToeModel.NOUGHT);
	}

	@Test
	public void test_HardLose2() {
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		model.doMove(2, 2);
		model.doMove(0, 0);
		model.doMove(2, 1);
		assertTrue(model.getState() == TicTacToeModel.STATE_WIN);
		assertTrue(model.getWinner() == TicTacToeModel.NOUGHT);
	}

	@Test
	public void test_HardLose3() {
		model.setDifficulty(TicTacToeModel.HARD_DIF);
		model.newRound();
		model.doMove(0, 2);
		model.doMove(1, 2);
		model.doMove(0, 0);
		model.doMove(1, 0);
		assertTrue(model.getState() == TicTacToeModel.STATE_WIN);
		assertTrue(model.getWinner() == TicTacToeModel.NOUGHT);
	}

}
