package leetcode;
import java.util.*;

public class FibSum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k =s.nextInt();
		System.out.println(findMinFibonacciNumbers(k));
	}
	public static int findMinFibonacciNumbers(int k) {
		ArrayList<Integer> fibTerms = new ArrayList<>();
		calculateFibTerms(fibTerms,k);

		int count = 0;
		int j = fibTerms.size() - 1;

		for(;k>0;j--){
			count += (k / fibTerms.get(j));
			k %= (fibTerms.get(j));
		}

		return count;
	}

	public static void calculateFibTerms(List<Integer> fibonacciTerms, int k) {
		int i = 3, nextTerm = 0;

		fibonacciTerms.add(0);
		fibonacciTerms.add(1);
		fibonacciTerms.add(1);

		while(true) {
			nextTerm = fibonacciTerms.get(i - 1) + fibonacciTerms.get(i - 2);
			if(nextTerm > k)
				return;

			fibonacciTerms.add(nextTerm);
			i++;
		}
	}
}