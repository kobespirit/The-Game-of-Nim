//package ProjeC;

import java.util.Scanner;

/* Player.java
 *This class is an abstract class defining the data a player should have and the moving methods in different games
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */

public abstract class Player {
	private String userName;
	private String surName;
	private String givenName;
	private int gamePlay=0;
	private int winGame=0;
	private String ID="Human";     //default ID is "Human"
	
	public Player(String userName, String surName, String givenName,
			int gamePlay, int winGame, String ID) {
		this.userName = userName;
		this.surName = surName;
		this.givenName = givenName;
		this.gamePlay=gamePlay;
		this.winGame=winGame;
		this.ID=ID;
	}
	public Player(){}
	public Player(String userName, String surName, String givenName,
			int gamePlay, int winGame) {
		this.userName = userName;
		this.surName = surName;
		this.givenName = givenName;
		this.gamePlay=gamePlay;
		this.winGame=winGame;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public int getGamePlay() {
		return gamePlay;
	}
	public void setGamePlay(int gamePlay) {
		this.gamePlay = gamePlay;
	}
	public int getWinGame() {
		return winGame;
	}
	public void setWinGame(int winGame) {
		this.winGame = winGame;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public int getPercent(){
		if(this.gamePlay==0)
			return 0;
		else
			return Math.round((float)winGame/gamePlay*100);
	}
	
	public String showPlayer(){     //display this player's information
		
		return this.userName+","+this.givenName+","+this.surName+","+this.gamePlay+" games,"+this.winGame+" wins";
	}
	
	public void showRanking(){     //get the winning percetage of this player
		System.out.format("%-5s",getPercent()+"%");
		System.out.format("| "+String.format("%02d",getGamePlay())+" games"+" | "+getGivenName()+" "+getSurName()+"\n");
	}
	
	public abstract int removeStone(NimGame nim,int currentStone,int upperBound)throws InvalidMoveException;    //abstract method move()
	
	public abstract String advancedMove(boolean[] available, String lastMove)throws InvalidMoveException;    //abstract method advancedMove()
}
