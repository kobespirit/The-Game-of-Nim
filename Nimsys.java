//package ProjeC;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;

import org.w3c.dom.events.EventException;
/* Nimsys.java
 * This class is to be used to control the commands that you enter and to store the detailed 
 * information of the player by using ArrayList. When you enter or exit the game, you should store
 * the data of players in a file called "players.dat"
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */

public class Nimsys {
	
	public String[] commands;
	public static Scanner keyboard;
	
	public static void main(String[] arg) {
		ArrayList<Player> list = new ArrayList<Player>();
		NimGame nim = new NimGame();
		Nimsys nimSys=new Nimsys();
		keyboard = new Scanner(System.in);
		Scanner putFileIn=null;
		File fileInput=null;
		try {
			fileInput=new File("players.dat");
			if(fileInput.exists()){
				putFileIn = new Scanner(fileInput);
				nimSys.inPutFile(putFileIn, nimSys, list);
			} else
				try {
					fileInput.createNewFile();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("Welcome to Nim");
		System.out.println("");
		String state;
		while(true){
			boolean judge=false;
			System.out.print(">");
			state = keyboard.nextLine();
			nimSys.commands=state.split(" ");
			if(nimSys.commands[0].equals("addplayer")){    //different commands below
					judge=true;
					try {
						nimSys.commands=nimSys.commands[1].split(",");
						if(nimSys.commands.length!=3)
							throw new CommandException();
						else{
							nimSys.addUser(list,nimSys.commands[0],nimSys.commands[1],nimSys.commands[2]);
						}	
					} catch (CommandException e) {
						System.out.println(e.getMessage());
						System.out.println();
						
					}
			  }
			else if(nimSys.commands[0].equals("addaiplayer")){
				judge=true;
					try {
						nimSys.commands=nimSys.commands[1].split(",");
						if(nimSys.commands.length<=1)
							throw new CommandException();
						else{
							nimSys.addAI(list,nimSys.commands[0],nimSys.commands[1],nimSys.commands[2]);
						}	
					} catch (CommandException e) {
						System.out.println(e.getMessage());
						System.out.println();
					}
				}
			else if(nimSys.commands[0].equals("startgame")){
				judge=true;
				nimSys.commands = nimSys.commands[1].split(",");
				int a=Integer.parseInt(nimSys.commands[0]);
				int b=Integer.parseInt(nimSys.commands[1]);
				String name1=nimSys.commands[2];
				String name2 = nimSys.commands[3];
				nim.NimGame(a, b, nimSys.getPlayer(name1, list), nimSys.getPlayer(name2, list));
				
				nim.startGame(keyboard,nim);
				
				System.out.println();
			}
			else if(nimSys.commands[0].equals("startadvancedgame")){
				judge=true;
				nimSys.commands = nimSys.commands[1].split(",");
				int a=Integer.parseInt(nimSys.commands[0]);
				String name1=nimSys.commands[1];
				String name2 = nimSys.commands[2];
				AdvancedNimGame advanced= new AdvancedNimGame(a,nimSys.getPlayer(name1, list),nimSys.getPlayer(name2, list));
				advanced.startGame(keyboard, advanced);
			}
			else if(nimSys.commands[0].equals("removeplayer")){
				judge=true;
				nimSys.removePlayer(nimSys,list,keyboard);
				System.out.println();
			}
			else if(nimSys.commands[0].equals("editplayer")){
				judge=true;
				nimSys.commands=nimSys.commands[1].split(",");
				nimSys.editPlayer(nimSys,list,keyboard);
				System.out.println();
			}
				
			else if(nimSys.commands[0].equals("resetstats")){
				judge=true;
				nimSys.commands=nimSys.commands[1].split(",");
				nimSys.resetPlayer(nimSys,list,keyboard);
				System.out.println();
			}
				
			else if(nimSys.commands[0].equals("displayplayer")){
				judge=true;
				nimSys.displayPlayer(nimSys,keyboard,list);
				System.out.println();
			}
				
			else if(nimSys.commands[0].equals("rankings")){
				judge=true;
				nimSys.ranking(list);
				System.out.println();
			}
				
			else if(state.equals("exit")){
				judge=true;
				try {
					nimSys.FileWrite(nimSys,list);
				} catch (IOException e) {
					System.out.println("Don't find this file");
				}
				nim.terminal();
				}
				
			
			if(judge==false){
					try{
						throw new CommandException(nimSys.commands[0]);
					}catch(CommandException e){
						System.out.println(e.getMessage());
						System.out.println();
					}
			}
		}
	}
	
	/*This method is used to add players, you are only allowed to add players when this player' username does not
	 * exist in, in other word, when the username has already existed, the flag is set to false
	 * */
	public void addUser(ArrayList<Player> list,String U,String F,String G) {
		boolean flag = true;
		Iterator<Player> aa = list.iterator();
		while (aa.hasNext()) {
			Player in =  aa.next();
			if(in.getUserName().equals(U)){
				System.out.println("The player already exists.");
				flag =false;
				return;
			}	
		}
		
		if(flag)
			list.add(new NimPlayer(U,F,G,0,0,"Human"));
		System.out.println("");
	}
	
	/*This method is used to add AIplayers, same like the add() method above
	 * */
	public void addAI(ArrayList<Player> list,String U,String F,String G) {
		boolean flag = true;
		Iterator<Player> aa = list.iterator();
		while (aa.hasNext()) {
			Player in =  aa.next();
			if(in.getUserName().equals(U)){
				System.out.println("The player already exists.");
				flag =false;
				return;
			}	
		}
		if(flag)
			list.add(new NimAIPlayer(U,F,G,0,0,"AI"));
		System.out.println("");
	}
	
	
	/*This method is used to remove players' information in the ArrayList, also use flag to ensure the
	 * player you want to remove is in the ArrayList. 
	 * */
	public void removePlayer(Nimsys nimSys,ArrayList<Player> list,Scanner keyboard) {
		boolean flag = false;
		Iterator<Player> aa = list.iterator();
		
		if(nimSys.commands.length==1){
			System.out.println("Are you sure you want to remove all players? (y/n)");
			String next = keyboard.next();
			keyboard.nextLine();
			if(next.equals("y"))
				list.clear();	
		}
			
		else{
			while (aa.hasNext()) {
				Player in =  aa.next();
				if(in.getUserName().equals(nimSys.commands[1])){
					list.remove(in);
					flag = true;
					break;
				}
			}
			if(flag == false)
				System.out.println("The player does not exist.");
		}
		
	}

	/*This method is used to edit players' information, the username cannot be changed * */
	public void editPlayer(Nimsys nimSys,ArrayList<Player> list,Scanner keyboard) {
		boolean flag=false;
		Iterator<Player> aa = list.iterator();
		while (aa.hasNext()) {
			Player in =  aa.next();
			if(in.getUserName().equals(nimSys.commands[0])){
				in.setSurName(nimSys.commands[1]);
				in.setGivenName(nimSys.commands[2]);
				flag = true;
				break;
			}
		}
		if(flag == false)
			System.out.println("The player does not exist.");
		
	}

	/*This method is to reset the statistics of players,if you reset a player's statistics, its
	 * record should be set to zero
	 * */
	public void resetPlayer(Nimsys nimSys,ArrayList<Player> list,Scanner keyboard) {
		boolean flag = false;
		Iterator<Player> aa = list.iterator();
		
		if(nimSys.commands.length==1){
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			String next = keyboard.next();
			keyboard.nextLine();
			if(next.equals("y")){
				while (aa.hasNext()) {
					Player in =  aa.next();
					in.setWinGame(0);
					in.setGamePlay(0);
					
					}
				}
			}
			
		else{
			while (aa.hasNext()) {
				Player in =  aa.next();
				if(in.getUserName().equals(nimSys.commands[0])){
					in.setWinGame(0);
					in.setGamePlay(0);
					flag = true;
					break;
				}
			}
			if(flag == false)
				System.out.println("The player does not exist.");
		}
	}

	/*This method is to display all player's some played information,it should be displayed by ordered username
	 * */
	public void displayPlayer(Nimsys nimSys, Scanner keyboard,ArrayList<Player> list)throws EventException {
		boolean flag = false;
		Iterator<Player> aa = list.iterator();
		Collections.sort(list, new Comparator<Player>(){    //using collection sort to sort the ArrayList by Username
			public int compare(Player a1, Player a2) {
				return a1.getUserName().compareTo(a2.getUserName());
			}
		});
		
		if(nimSys.commands.length==1){
			while(aa.hasNext()){
				Player in =  aa.next();
				String information=in.showPlayer();
				System.out.println(information);
			}
		}
		else{
			while (aa.hasNext()) {
				Player in =  aa.next();
				if(in.getUserName().equals(nimSys.commands[1])){
					System.out.println(in.showPlayer());
					flag = true;
					break;
				}
				
			}
			if(flag=false)
				System.out.println("This player don't exist");
		}
	}

	/*This method is to display all player's some played information,it should be displayed by ordered percentage
	 * if the percentages are same among players, then displayed by ordered username
	 * */
	public void ranking(ArrayList<Player> list) {
		Collections.sort(list, new Comparator<Player>(){
			public int compare(Player a1, Player a2) {
				int a = a2.getPercent()-a1.getPercent(); 
				return a==0?a1.getUserName().compareTo(a2.getUserName()):a;
			}
		});
		Iterator<Player> aa = list.iterator();
		while(aa.hasNext()){
			Player in =  aa.next();
			in.showRanking();
		}
	}
	
	/*This method is to get the reference of the player object in the array list*/
	public Player getPlayer(String userName,ArrayList<Player> list) {
		Iterator<Player> aa = list.iterator();
		while (aa.hasNext()) {
			Player in =  aa.next();
			if(in.getUserName().equals(userName)){
				if(in.getID().equals("AI"))
					return (NimAIPlayer)in;
				else
					return (NimPlayer)in;
				}
			}
		return null;
		}
	
	/*This method is to input the players' information from the file to the ArrayList*/
	public void inPutFile(Scanner PutFileIn,Nimsys nimSys,ArrayList<Player> list){
		String st=null;
		while(PutFileIn.hasNext()){
			st=PutFileIn.nextLine();
			nimSys.commands=st.split(" ");
			if(nimSys.commands[5].equals("Human"))
				list.add(new NimPlayer(nimSys.commands[0],nimSys.commands[1],nimSys.commands[2],
						Integer.parseInt(nimSys.commands[3]),Integer.parseInt(nimSys.commands[4]),nimSys.commands[5]));
			else
				list.add(new NimAIPlayer(nimSys.commands[0],nimSys.commands[1],nimSys.commands[2],
						Integer.parseInt(nimSys.commands[3]),Integer.parseInt(nimSys.commands[4]),nimSys.commands[5]));
						
		}
	}
	
	/*This method is to write players' information to the file named "players.dat"*/
	public void FileWrite(Nimsys nimSys,ArrayList<Player> list)throws IOException{
		OutputStream out = new FileOutputStream("players.dat");
		Iterator<Player> aa = list.iterator();
		while(aa.hasNext()){  //each line includes the information below related to the players
			Player in =  aa.next();
			out.write(in.getUserName().getBytes());
			out.write(' ');
			out.write(in.getSurName().getBytes());
			out.write(' ');
			out.write(in.getGivenName().getBytes());
			out.write(' ');
			out.write(String.valueOf(in.getGamePlay()).getBytes());
			out.write(' ');
			out.write(String.valueOf(in.getWinGame()).getBytes());
			out.write(' ');
			out.write(String.valueOf(in.getID()).getBytes());
			out.write('\r');
		}
	}
}