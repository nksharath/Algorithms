import java.io.BufferedInputStream;
import java.util.Scanner;


/*
 * Primes.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : Generate Prime Numbers : Sieve of Eratosthenes 
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4005 800-01 
*@RIT ID		: sxn9447@rit.edu
*@Version       : 1.0.1
*@LastModified  : 03/08/2013 3.25 PM
*
*/
public class Primes 
{
	public static void main(String args[])
	{
		Scanner read=new Scanner(System.in);
		int N=Integer.parseInt(read.nextLine());
		Boolean []primes=new Boolean[N+1];
		
		
		for(int i=2;i<=N;i++)
			primes[i]=true;

		for(int i=2;i<=Math.sqrt(N);i++)
		{
			if(primes[i]==true)
			{
				for(int j=i*i;j<=N;j=j+i)
				{
					primes[j]=false;
				}
					
			}
		}
		
		for(int i=2;i<=N;i++)
		{
			if(primes[i])
				System.out.println(i);
		}
			
	}

}
