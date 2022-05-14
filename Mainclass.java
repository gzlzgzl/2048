import java.io.*;
import java.util.*;
public class Mainclass 
{

	public static void main(String[] args) throws IOException
	{	
		int mykey=0;
		Scanner keyboard = new Scanner(System.in);
		//create the game board
		int[][] board = new int[4][4];
		String direction="W";
		boolean abletomove=true;
		int move=-1;
		int point=0;
		// create the generator 
		GenerateNumbers generator=new GenerateNumbers();
		// create a calculator
		A2048 calculate = new A2048();
	
		System.out.println("2048");
		System.out.println("Press ENTER to continue.");
		mykey=(int)System.in.read(); 
		System.out.println("Please use   W    as direction keys.");
		System.out.println("          A  S  D   ");
		mykey=(int)System.in.read();
		
		while(abletomove)
		{
			move++;
			switch(direction)
			{
				case "W": board=calculate.merge(board, 3);break;
				case "A": board=calculate.merge(board, 0);break;
				case "S": board=calculate.merge(board, 1);break;
				case "D": board=calculate.merge(board, 2);break;
			} // calculate first
			abletomove=generator.generate(board); // then generate new numbers
			printboard(board); // print the board
			if(abletomove) // if there is empty space 
				{
					direction=keyboard.next(); // get the direction for next move
				}
		}
		
		System.out.println("Your moves: " + move);
		System.out.println("Your total point: "+ A2048.point());	
	}
	
	public static void printboard(int[][] arr)
	{
		for(int a=0; a<4; a++)
		{
			for(int b=0; b<4;b++)
			{
				System.out.print(arr[a][b]+" ");
			}
			System.out.println();
		}
	}

	/*public static boolean canmove(int[][] arr)
	{
		int emptyspace=0;
		for(int a=0; a<4; a++)
		{
			for(int b=0; b<4;b++)
			{
				if(arr[a][b]==0)
				{
					emptyspace++;
				}
			} // ending brace for forb
		} // ending brace for fora
		if(emptyspace==16)
		{
			return false;
		}	
		return true;
	} // ending brace for the method
	*/
}
