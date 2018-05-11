//package ProjeC;

import java.text.DecimalFormat;
import java.util.*;

import org.w3c.dom.events.EventException;

/* NimGame.java
 * This class is to start the game and terminal the game
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */

public class NimGame {

	  /*When the command is "startgame", the program begin to execute this method, you pass the player
     * information into this method to make sure the game will proceed successfully
     * */
	
	
	public int currentStone;
	public int upperBound;
	private Player player1;
	private Player player2;

	public void NimGame(int CStone, int UBound, Player p1, Player p2) {
	currentStone = CStone;
	upperBound = UBound;
	player1 = p1;
	player2 = p2;
	}

	public NimGame(int CStone, Player p1, Player p2){    //this constructor is for AdvancedNimGame,which inherits this class
	currentStone = CStone;
	player1 = p1;
	player2 = p2;
	}
	
	public NimGame(){}
	
	public Player getPlayer1() {
		return player1;
	}


	public void setPlayer1(NimPlayer player1) {
		this.player1 = player1;
	}


	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(NimPlayer player2) {
		this.player2 = player2;
	}
	
	public void startGame(Scanner scanner,NimGame nim){    //start to play the game, players could be AI or human
	int player1=nim.getPlayer1().getGamePlay();
	int player2=nim.getPlayer2().getGamePlay();
	int getWin1=nim.getPlayer1().getWinGame();
    int getWin2=nim.getPlayer2().getWinGame();
    System.out.println("");
	System.out.println("Initial stone count: "+nim.currentStone );
	System.out.println("Maximum stone removal: "+ nim.upperBound);
	System.out.println("Player 1: "+nim.getPlayer1().getGivenName()+" "+nim.getPlayer1().getSurName());
	System.out.println("Player 2: "+nim.getPlayer2().getGivenName()+" "+nim.getPlayer2().getSurName());
	System.out.println("");
    nim.getPlayer1().setGamePlay(player1+1);
	nim.getPlayer2().setGamePlay(player2+1);
	int player = 1;
	while (nim.currentStone >= 0){
	if(nim.currentStone!=0){
		System.out.print(nim.currentStone + " stones left:");
		for (int i = 1; i <= nim.currentStone; i++){
			System.out.print(" *");
		}
		System.out.println();
	}
	
	if (player > 0) {
		if(nim.currentStone==0){     //if the number of stone is 0,then game over
			nim.getPlayer1().setWinGame(getWin1+1);
			System.out.println("Game Over");
			System.out.println(nim.getPlayer1().getGivenName()+" "+nim.getPlayer1().getSurName()+" wins!");
			break;
		}
			
		else{
			System.out.println(nim.getPlayer1().getGivenName() +"'s turn - remove how many?");
			try{
				nim.currentStone = nim.getPlayer1().removeStone(nim,nim.currentStone, nim.upperBound);
				System.out.println();
				player = player * -1;    // change the turn to another player
			}catch(InvalidMoveException e){
				System.out.println(e.getMessage());
				System.out.println();
			}
			
		}
		
	} else if (player < 0) {
		if(nim.currentStone==0){
			nim.getPlayer2().setWinGame(getWin2+1);
			System.out.println("Game Over");
			System.out.println(nim.getPlayer2().getGivenName()+" "+nim.getPlayer2().getSurName()+" wins!");
			break;
		}
			
		else{
			System.out.println(nim.getPlayer2().getGivenName()+"'s turn - remove how many?");
			try{
				nim.currentStone = nim.getPlayer2().removeStone(nim,nim.currentStone, nim.upperBound);
				System.out.println();
				player = player * -1;
			}catch(InvalidMoveException e){   //catch the invalid exception from the move method
				System.out.println(e.getMessage());
				System.out.println();
				}
			
			}
		
		}
	
	  }
	
	}
	public void terminal(){    //this method is to terminal the game
		System.out.println("");
		System.exit(0);
	}
}
