//package ProjeC;

import java.util.Scanner;

/* AdvancedNimGame.java
 * This class is to start the advanced nim game 
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */

public class AdvancedNimGame extends NimGame{
	
	boolean[] stones;
	public String[] inputStone;
	public AdvancedNimGame(){
		
	}
	public AdvancedNimGame(int CStone, Player p1, Player p2) {   //construct method to initialize this game object
		super(CStone,p1,p2);
		stones=new boolean[CStone];
		for(int i=0;i<CStone;i++)
			stones[i]=true;
		}
	
	public void startGame(Scanner keyboard,AdvancedNimGame nim) {
		System.out.println();
		System.out.println("Initial stone count: "+nim.currentStone);
		System.out.printf("Stones display:");
		for(int i=0;i<nim.stones.length;i++){   //initialize the stones and status
			if(nim.stones[i])
				System.out.printf(" <"+(i+1)+","+"*"+">");
		}
		System.out.println();
		System.out.println("Player 1: "+nim.getPlayer1().getGivenName()+" "+nim.getPlayer1().getSurName());
		System.out.println("Player 2: "+nim.getPlayer2().getGivenName()+" "+nim.getPlayer2().getSurName());
		System.out.println("");
		int player1=nim.getPlayer1().getGamePlay();   
		int player2=nim.getPlayer2().getGamePlay();   
		int getWin1=nim.getPlayer1().getWinGame();
	    int getWin2=nim.getPlayer2().getWinGame();
		nim.getPlayer1().setGamePlay(player1+1);
		nim.getPlayer2().setGamePlay(player2+1);
		String stoneInfo="";
		int player = 1;
		while (nim.currentStone >= 0){
			if(player>0){
				if(nim.currentStone==0){
					nim.getPlayer2().setWinGame(getWin2+1);
					System.out.println("Game Over");
					System.out.println(nim.getPlayer2().getGivenName()+" "+nim.getPlayer2().getSurName()+" wins!");
					break;
				}
				else{
					System.out.printf(nim.currentStone+" stones left:");
					for(int i=0;i<nim.stones.length;i++){     //illustrate the current status of the stones
						if(nim.stones[i])
							System.out.printf(" <"+(i+1)+","+"*"+">");
						else
							System.out.printf(" <"+(i+1)+","+"x"+">");
					}
					System.out.println();
					System.out.println(nim.getPlayer1().getGivenName() +"'s turn - which to remove?");
					
						try {
							stoneInfo=nim.getPlayer1().advancedMove(nim.stones,stoneInfo);
							nim.inputStone=stoneInfo.split(" ");
							if(nim.inputStone[1].equals("1")){    //minus how many stones the player moved
								nim.currentStone=nim.currentStone-1;
							}
							else{
								nim.currentStone=nim.currentStone-2;
								
							}
							player = player * -1;
						} catch (InvalidMoveException e){
							System.out.println();
							System.out.println(e.getMessage());
							System.out.println();
						}
				}
			}
			if(player<0){
				if(nim.currentStone==0){
					nim.getPlayer1().setWinGame(getWin1+1);
					System.out.println("Game Over");
					System.out.println(nim.getPlayer1().getGivenName()+" "+nim.getPlayer1().getSurName()+" wins!");
					break;
				}
				else{
					System.out.printf(nim.currentStone+" stones left:");
					for(int i=0;i<nim.stones.length;i++){         //illustrate the current status of the stones
						if(nim.stones[i])
							System.out.printf(" <"+(i+1)+","+"*"+">");
						else
							System.out.printf(" <"+(i+1)+","+"x"+">");
					}
					System.out.println();
					System.out.println(nim.getPlayer2().getGivenName() +"'s turn - which to remove?");
	
					try {
						stoneInfo=nim.getPlayer2().advancedMove(nim.stones,stoneInfo);
						nim.inputStone=stoneInfo.split(" ");
						if(nim.inputStone[1].equals("1")){       //minus how many stones the player moved 
							nim.currentStone=nim.currentStone-1;
						}
						else{
							nim.currentStone=nim.currentStone-2;
							
						}
						player = player * -1;
					} catch (InvalidMoveException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						}
				}
			}
		}
		System.out.println();
	}
}
