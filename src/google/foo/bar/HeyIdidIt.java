package google.foo.bar;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class HeyIdidIt {
	public static void main(String[] args) {
		System.out.println(solution("210022", 3));
	}

	public static int solution(String n, int b) {
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		int k = 0;
		while(set.add(n) || n=="0"){
			list.add(n);
			n = getDiff(n, b);
			k++;
		}
		if(n != "0"){
			return k - list.indexOf(n);
		}

		return 1;
	}

	public static String getDiff(String num, int base){
		char[] chars = num.toCharArray();
		Arrays.sort(chars);
		String asc = new String(chars);
		String desc = new StringBuilder(asc).reverse().toString();

		long desc_base_10 = Long.parseLong(desc, base);
		long asc_base_10 = Long.parseLong(asc, base);

		return Long.toString((desc_base_10 -  asc_base_10), base);
	}
}
