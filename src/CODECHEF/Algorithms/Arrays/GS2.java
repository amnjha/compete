package CODECHEF.Algorithms.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GS2 {
    public static void main(String[] args) throws IOException {
        System.out.println(getPosition("(I want (to write a language parser), would (you) help me)",2));
        System.out.println(getPosition("((()()))",4));
    }

    private static int getPosition(String inputString, int N){
        Stack<Integer> stack = new Stack<>();

        int out =-1;

        char[] arr = inputString.toCharArray();
        int ctr= 0;
        int openingPos=-1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c=='('){
                ctr++;
                if(ctr==N){
                    openingPos=i;
                }
                stack.push(i);
            }
            else if( c == ')')
            {
                if(!stack.isEmpty()) {
                    int x=stack.pop();
                    if(x==openingPos)
                        out=i+1;
                }
                else {
                    out= -1;
                    break;
                }
            }
            else
                continue;
        }

        if (stack.size()!=0)
            out=-1;

        return out;
    }
}
