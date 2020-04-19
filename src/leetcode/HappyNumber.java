package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int val = n;
		do {
			val = getSqSum(val);
		} while(val>1 && set.add(val));

		if(val == 1)
			return true;
		else
			return false;
	}

	public int getSqSum(int n){
		int sum = 0;
		while(n!=0){
			int d = n%10;
			sum+= d*d;
			n = n/10;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(1111111));
	}
}
