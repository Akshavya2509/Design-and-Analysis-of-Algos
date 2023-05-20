/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		// your code goes here
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t != 0)
		{
		    long n = sc.nextLong(), h = sc.nextLong(), w = sc.nextLong();
		    
		    long max = 0, min = 0;
		    
		    if(h > w)
		        max = h*n;
		    else
		        max = w*n;
		        
		    while(min < max)
		    {
		        long half = min + ((max - min) / 2);
		        if(((half/h) * (half/w)) >= n)
		        {
		            max = half;
		        }
		        
		        else
		        {
		            min = half + 1;
		        }
		    }
		    
		    System.out.println(max);
		    t--;
		}
	}
}