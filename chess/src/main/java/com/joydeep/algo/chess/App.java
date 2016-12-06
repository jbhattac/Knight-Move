package com.joydeep.algo.chess;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		KnightMovesNew kt = new KnightMovesNew();
		System.out.println("Starting the Knight Move");
		if(args.length>1){
			kt.setHor(Integer.parseInt(args[0])); 
			kt.setVert(Integer.parseInt(args[1]));
			System.out.println("Setting board size to "+kt.getHor()+" * "+kt.getVert());
		}
		
		kt.initializeChessBoard();
		kt.cleanUpStartPositions();
		kt.makeSolution();
		
		System.out.println("No of Solution "+ kt.getNoOfSolutions());
		System.out.println("No of No Solution "+ kt.getNoOfNoSolutions());
		Runtime runtime = Runtime.getRuntime();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is MB: " +memory/(1024L*1024L));

	}
}
