package hackerearth;

import java.util.*;

public class KthHCF {
	static long gcd(long a, long b)
	{
		// Everything divides 0
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd(a-b, b);
		return gcd(a, b-a);
	}

	static long findKHCF(long x, long y, int k){
		long max = Math.max(x,y);
		long hcf = gcd(x,y);
		int c =1;
		while (hcf != 0 ){
			if(c==k)
				return hcf;
			hcf = hcf/max;
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int D = scanner.nextInt();
		for (int i = 0; i < D; i++) {
			long X = scanner.nextLong();
			long Y = scanner.nextLong();
			int K = scanner.nextInt();

			long hcf = findKHCF(X, Y, K);
			if (hcf == -1)
				System.out.println("No crymeth today");
			else
				System.out.println(hcf);
		}
	}
}
