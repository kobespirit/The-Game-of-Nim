//package ProjeC;

/* CommandException.java
 * This Exception class is to control invalid commands
 * Author: Tiehua Zhang
 * Created on 29th May, 2014
 */
public class CommandException extends Exception{

	public CommandException(){
		super("Incorrect number of arguments supplied to command.");
	}
	
	public CommandException(String message){
		super("'"+message+"'"+" is not a valid command.");
	}
}
