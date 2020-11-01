import java.util.Scanner;
import java.util.ArrayList;
public class MODPOWER {
	
	static ArrayList<Integer> bit = new ArrayList<Integer>();
	static long a;
	
	public static void computePower(int n, int m, int k)
	{
		int i;
		
		a = 1;
		
		for(i = bit.size() - 1; i >= 0; i--)
		{
			a = (a*a) % n ;
			
			if(bit.get(i) == 1)
			{
				a = (a * m) % n;
			}
		}
	}
	
	public static void makebit(int k)
	{
		if(k == 0) return;
		
		int n = k % 2;
		
		bit.add(n);
		
		makebit(k/2);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		makebit(k);
		
		computePower(n, m, k);
		
		System.out.println(a);
		
		sc.close();
	}

}
