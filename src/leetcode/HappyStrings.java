package leetcode;

import java.util.ArrayList;
import java.util.List;

public class HappyStrings {

	private List<String> strings = new ArrayList<>();

	public void getHappyStrings(char[] charSet, String prefix, int n, int k){
		if(strings.size() == k)
			return;

		if(n == 0) {
			strings.add(prefix);
			return;
		}

		for (int i = 0; i < charSet.length; i++) {
			char lastChar = '_';
			if(!prefix.isEmpty())
				lastChar = prefix.charAt(prefix.length()-1);

			if(lastChar == charSet[i])
				i++;

			if(i == charSet.length)
				break;

			getHappyStrings(charSet, prefix+charSet[i], n-1, k);
		}
	}


	public String getHappyString(int n, int k) {
		char[] charSet = {'a', 'b', 'c'};
		strings = new ArrayList<>();
		getHappyStrings(charSet, "", n, k);
		if(strings.size() >= k)
			return strings.get(k-1);
		return "";
	}

	public static void main(String[] args) {
		System.out.println(new HappyStrings().getHappyString(10,100));
	}
}
