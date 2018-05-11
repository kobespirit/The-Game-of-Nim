//package practice;
import java.util.Scanner;
public class Nimsys {
	//main method
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);//create Scanner object called scanner
		
		System.out.println("Welcome to Nim");//print out welcome info
		System.out.println("");
		
		System.out.println("please enter player 1's name:");
		NimPlayer player1=new NimPlayer();//create NimPlayer object called player1
		//scanner.nextLine();
		player1.setName(scanner.nextLine());//call setName method,give the input value using scanner object
		System.out.println("");
		
		System.out.println("please enter player 2's name:");
		NimPlayer player2=new NimPlayer();//create another NimPlayer object called player2
		player2.setName(scanner.nextLine());//call setName method,give the input value using scanner object
		System.out.println("");
		
		System.out.println("please enter upper bound of stone removal:");
		int upperbound=scanner.nextInt();//define variable upperbound by using scanner object
		System.out.println("");
		
		System.out.println("please enter initial number of stones:");
		int initialnub=scanner.nextInt();//define initial stone numbers
		System.out.println("");
		
		System.out.print(initialnub+" stones left:");
		for (int i=1;i<=initialnub;i++)
			System.out.print(" *");//print out number of stones by using for loop
		System.out.println("");
		
		int winflag=0;//define a flag to identify who is winner
		for(int j=0;j<=initialnub;j++){
			System.out.println(player1.getName() +"'s turn - remove how many?");
			int remove=scanner.nextInt();//define a variable remove to record the stone removed
			initialnub=initialnub-remove;//show the stone numbers after removing
			System.out.println("");
			winflag=0;//player1's turn, give value 0 to the flag
			System.out.print(initialnub+" stones left");
			for(int k=1;k<=initialnub;k++)
				System.out.print(" *");//print out stone numbers
			System.out.println("");
			//check whether the number of stone is equals to 1
			if(initialnub==1){
				System.out.println(player2.getName()+"'s turn - remove how many?");
			    remove=player2.removeStone(scanner.nextInt());//player2 should remove the last one
				break;//jump out the for loop because player1 wins
			}
			
			System.out.println(player2.getName()+"'s turn - remove how many?");
			remove=player2.removeStone(scanner.nextInt());//give the input value to remove using removeStone method
			initialnub=initialnub-remove;//show the number of left stones
			System.out.println("");
			winflag=1;//player2's turn,give value 1 to the flag
			System.out.print(initialnub+" stones left");
			for(int n=1;n<=initialnub;n++)
				System.out.print(" *");
			System.out.println("");
			//check again whether the number of stone is equals to 1
			if(initialnub==1){
				System.out.println(player1.getName()+"'s turn - remove how many?");
			    remove=player1.removeStone(scanner.nextInt());//player1 should remove the last stone
				break;//jump out because player2 wins
			}	
		}
		System.out.println("");
		System.out.println("Game Over");
		
		if(winflag==1)
			System.out.println(player2.getName()+" wins!");//if winflag is 1, that means player1 removed the last stone,player2 wins
		
		else
		    System.out.println(player1.getName()+" wins!");//the other case
			
   }
}
