package com.joydeep.algo.chess;

import java.util.ArrayList;
import java.util.List;

public class KnightMovesNew {

	static int[][] board;

	private int noOfSolutions=0;

	private int noOfNoSolutions=0;
	
	private int hor=5;
	
	private int vert=5;

	/**
	 * @param args
	 */
	

	// Create a new chess board.
	public void initializeChessBoard() {
		board = new int[hor][];
		for (int i = 0; i < this.hor; i++) {			
				board[i] = new int[this.vert];			
		}
	}

	// Set all board entries to 0.
	void cleanUpStartPositions() {
		for (int i = 0; i < this.hor; i++) {
			for (int j = 0; j < this.vert; j++) {
				board[i][j] = 0;
			}
		}
	}

	public static int[][] getBoard() {
		return board;
	}

	public static void setBoard(int[][] board) {
		KnightMovesNew.board = board;
	}

	public int getNoOfSolutions() {
		return noOfSolutions;
	}

	public void setNoOfSolutions(int noOfSolutions) {
		this.noOfSolutions = noOfSolutions;
	}

	public int getNoOfNoSolutions() {
		return noOfNoSolutions;
	}

	public void setNoOfNoSolutions(int noOfNoSolutions) {
		this.noOfNoSolutions = noOfNoSolutions;
	}

	public int getHor() {
		return hor;
	}

	public void setHor(int hor) {
		this.hor = hor;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public void makeSolution() {
		for (int i = 0; i < this.hor; i++) {
			for (int j = 0; j < this.vert; j++) {
				makeMove(j, i, 1);
				board[i][j] = 0;
			}
			System.out.println();
		}
	}

	private void makeMove(int x, int y, int moveCount) {

		board[y][x] = moveCount;
		if (moveCount == (this.hor*this.vert)) {
			noOfSolutions++;
			printChessBoard();
			return;
		} else {
			for (Positions pos : getAllPossibleLocations(x, y)) {

				if (board[pos.getY()][pos.getX()] == 0) {
					//printChessBoard();
					makeMove(pos.getX(), pos.getY(), moveCount + 1);
					board[pos.getY()][pos.getX()] = 0; // reset the square
				}
			}
			noOfNoSolutions++;

		}

	}

	// print chess board.
	private void printChessBoard() {
		System.out.println("-------------------------------");
		for (int i = 0; i < this.hor; i++) {
			for (int j = 0; j < this.vert; j++) {
				System.out.print(board[i][j] + "\t    ");
			}
			System.out.println();
		}
	}
	
	
	private boolean validLocation(int x, int y) {
		// Check if any of the position is out of range .
		if ((x < 0) || (x > this.hor-1))
			return false;
		if ((y < 0) || (y > this.vert-1))
			return false;
		
		// Otherwise, it is in range.
		return true;
	}
	
	
	
		// Create possible locations and return the list of such locations.
		// The input location is x,y represent the current location.
		private List<Positions> getAllPossibleLocations(int x, int y) {
				List<Positions> possiablePositionList = new ArrayList<Positions>();
			
			// Check the 1st location
			if (validLocation(x + 2, y + 1)) {
				Positions pos = new Positions( x + 2,y+1);
				possiablePositionList.add(pos);
			}
			// Check the 2nd location
			if (validLocation(x + 2, y - 1)) {
				Positions pos = new Positions( x + 2,y-1);
				possiablePositionList.add(pos);
			}
			// Check the 3rd location
			if (validLocation(x - 2, y + 1)) {
				Positions pos = new Positions( x - 2,y+1);
				possiablePositionList.add(pos);
			}
			if (validLocation(x - 2, y - 1)) { // Check the 4th location
				Positions pos = new Positions( x - 2,y-1);
				possiablePositionList.add(pos);
			}
			if (validLocation(x + 1, y + 2)) { // Check the 5th location
				Positions pos = new Positions( x + 1,y+2);
				possiablePositionList.add(pos);
			}
			if (validLocation(x + 1, y - 2)) { // Check the 6th location
				Positions pos = new Positions( x + 1,y-2);
				possiablePositionList.add(pos);
			}
			if (validLocation(x - 1, y + 2)) { // Check the 7th location
				Positions pos = new Positions( x - 1,y+2);
				possiablePositionList.add(pos);
			}
			if (validLocation(x - 1, y - 2)) { // Check the 8th location
				Positions pos = new Positions( x - 1,y-2);
				possiablePositionList.add(pos);
			}

			return possiablePositionList;
		}

}
