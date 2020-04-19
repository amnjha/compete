package CODECHEF.LongChallenge.April2020;

import java.util.*;

public class PPDIV {
	private static Scanner scanner = new Scanner(System.in);
	private static long MAX = (long) 1e18;
	private static long MOD = (long) (1e9 + 7);
	private static long N = 1000005;

	private static Set<Long> squareSet = new HashSet<>();
	private static Set<Long> otherPowers = new HashSet<>();
	private static Map<Long, Long> map = new HashMap<>();
	private static List<Long> powerList = new ArrayList<>();

	public static void main(String[] args) {
		int T = scanner.nextInt();
		calculatePowers();
		while (T-- > 0){
			solveTestCase();
		}
	}

	private static void calculatePowers(){
		for(long i = 1; i<= N; i++){
			long sq = i*i;
			if(sq < MAX){
				squareSet.add(sq);
			}

			if(squareSet.contains(i))
				continue;

			long t = i;
			while (sq <= MAX/t){
				t*=sq;
				if(t<=MAX)
					otherPowers.add(t);
			}
		}

		powerList.addAll(squareSet);
		powerList.addAll(otherPowers);
	}

	private static long divSum(long number){
		long s = 0;
		for(long k : powerList){
			s+= ((number/k)*k) % MOD;
		}
		return s;
	}

	private static void solveTestCase(){
		long num  = scanner.nextLong();
		if(!map.containsKey(num)){
			long result = divSum(num);
			map.put(num, result);
		}

		System.out.println(map.get(num));
	}


}
