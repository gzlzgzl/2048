import java.io.*;
import java.util.*;
public class A2048
{
	private static int totalpoints=0;
	private static int[][] rotate(int[][] arr)
	{
		//rotate clockwise 90 degrees
		int len=arr.length;
		int[][] result=new int[len][len];
		for(int i=0;i<len;i++)
			for(int j=0;j<len;j++)
				result[j][len-1-i]=arr[i][j];
		return result;
	}
	private static int[] mergerow(int[] row)
	{
		//push numbers in a row to the left
		int len=row.length,k=0;
		int[] newrow=new int[len];
		for(int i=0;i<len;i++)
			if(row[i]>0)
			{
				newrow[k]=row[i];
				k++;
			}
		int[] result=new int[len];
		for(int i=0;i<len-1;i++)
			if(newrow[i]==newrow[i+1])
			{
				newrow[i]*=2;
				totalpoints+=newrow[i];
				newrow[i+1]=0;
			}
		k=0;
		for(int i=0;i<len;i++)
			if(newrow[i]>0)
			{
				result[k]=newrow[i];
				k++;
			}
		return result;
	}
	private static int[][] mergearr(int[][] arr)
	{
		//merge all rows on the board
		int len=arr.length;
		int[][] result=arr;
		for(int i=0;i<len;i++)
			result[i]=mergerow(arr[i]);
		return result;
	}
	public static int[][] merge(int[][] arr, int direction)
	{
		//direction: 0-left 1-down 2-right 3-up
		//returns the result after merging to a specfic direction
		int[][] result=arr;
		for(int i=0;i<direction;i++)
			result=rotate(result);
		result=mergearr(result);
		for(int i=0;i<4-direction;i++)
			result=rotate(result);
		return result;
	}	
	public static int point()
	{
		return totalpoints;
	}
	//This is an example of the Main class.
	/*
	public static void main(String args[])
	{
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Size:");
		int len=keyboard.nextInt();
		int[][] map=new int[len][len],map2=map;		
		while(GenerateNumbers.generate(map))
		{
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
			System.out.println("Direction:");
			int dir=keyboard.nextInt();
			map2=merge(map,dir);
			System.out.println("Total points: "+totalpoints);
			
			map=map2;
		}	
	}*/
	
}