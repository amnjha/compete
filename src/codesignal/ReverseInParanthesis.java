package codesignal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseInParanthesis {

	static String reverseInParentheses(String inputString) {
		Stack<Character> characters = new Stack<>();

		for(char c: inputString.toCharArray()){
			if(c != ')'){
				characters.push(c);
			} else{
				char s;
				List<Character> popped = new ArrayList<>();
				while((s = characters.pop())!='('){
					popped.add(s);
				}
				for(char v : popped){
					characters.push(v);
				}
			}
		}

		StringBuilder s = new StringBuilder();
		while (!characters.isEmpty()){
			s.append(characters.pop());
		}

		return s.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseInParentheses("foo(bar(baz))blim"));
	}
}
