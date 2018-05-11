//package ProjeC;

import java.text.DecimalFormat;
import java.util.Scanner;

/* NimPlayer.java
 * This class inherits the Player class, representing the move made by human
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */


public class NimPlayer extends Player{
	
	public NimPlayer(String userName,String surName,String givenName,int gamePlay,int winGame,String ID){
		super(userName,surName,givenName,gamePlay,winGame,ID);
		
	}
	
	public NimPlayer(){
		
	}
	
	/*This method is used to control the moving process made by human in the simple Nim game
	 * if the player moves the illeage movement,then throw an InvalidMoveException*/
	public int removeStone(NimGame nim,int currentStone,int upperBound) throws InvalidMoveException {
		int removeNumber = Nimsys.keyboard.nextInt();
		Nimsys.keyboard.nextLine();
		if (removeNumber > upperBound || removeNumber > currentStone){
			throw new InvalidMoveException(String.valueOf(Math.min(nim.currentStone, nim.upperBound)));
		} 
		else {
			return currentStone - removeNumber;
			}
		}
	
	/*This method is used to control the moving process made by human in the advanced Nim game
	 * if the player moves the illeage movement,then throw an InvalidMoveException*/
	public String advancedMove(boolean[] avaliable,String moveStone) throws InvalidMoveException{
		System.out.println();
		String getMove=Nimsys.keyboard.nextLine();
		String[] inputStone=null;
		inputStone=getMove.split(" ");
		int index=Integer.valueOf(inputStone[0]);
		int number=Integer.valueOf(inputStone[1]);
		if(avaliable[index-1]&&number==1){
			avaliable[index-1]=false;
			return (index)+" "+"1";
		}
		else if(avaliable[index-1]&&avaliable[index]&&number==2){
				avaliable[index-1]=false;
				avaliable[index]=false;
				return (index)+" "+"2";
			
		}
		else
			throw new InvalidMoveException();
	}
}


