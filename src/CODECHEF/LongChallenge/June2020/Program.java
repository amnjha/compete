package CODECHEF.LongChallenge.June2020;

import java.util.HashMap;
import java.util.Map;

class Program {

	static Map<Integer, Integer> fib = new HashMap<>();

	static {
		fib.put(0, 0);
		fib.put(1, 1);
	}

	public static int getNthFib(int n) {
		return _fib(n-1);
	}

	public static int _fib(int n){
		if (fib.containsKey(n))
			return fib.get(n);

		int fibn = _fib(n - 1) + _fib(n - 2);
		fib.put(n, fibn);
		return fibn;
	}

	public static void main(String[] args) {
		System.out.println(getNthFib(6));
	}
}
