//package ProjeC;

/* InvalidMoveException.java
 * This Exception class is to control invalid moves during the game time
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */
public class InvalidMoveException extends Exception{

	public InvalidMoveException(){
		super("Invalid move.");
	}
	
	public InvalidMoveException(String message){
		super("Invalid move. You must remove between 1 and "+message+" stones.");
	}
}
