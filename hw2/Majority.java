// Sharath Navalpakkam Krishnan sxn9447@rit.edu
// Rahul Nuggehalli Gopinathan rnn4511@rit.edu
import java.util.Scanner;

public class Majority 
{
	public static void main(String args[])
	{
		int count=0,current=0,majority=0,flag=0;
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []array=new int[n];
		for(int i=0;i<n;i++)
		{
			array[i]=input.nextInt();			
		}
		
		for(int i=0;i<array.length;i++)
		{
			if(count==0)
			current=array[i];
			
			if(current==array[i])
				count++;
			else
				count--;
		}
		
		for(int i=0;i<array.length;i++)
		{
			if(current==array[i])
				majority++;
			
			if(majority>(array.length/2)){
				System.out.println("YES");
				flag=1;
				break;
				}
		}
		if(flag==0)
		System.out.println("NO");
	}
}

