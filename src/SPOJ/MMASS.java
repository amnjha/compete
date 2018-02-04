package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MMASS {

    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            if (c == ')')
                stack.push(calculateBracketValue() + "S");
            else
                stack.push(c + "");
        }
        calculateFinalVal();
        System.out.println(stack.pop());
    }

    private static String calculateBracketValue() {
        int val = 0;
        String x = stack.pop();
        while (!x.equals("(")) {
            int y = getAtomMass(x);
            if (y == 0) {
                if (x.endsWith("S"))
                    y = Integer.parseInt(x.substring(0, x.length() - 1));
                else {
                    y=evaluateFactor(x);
                }
            }
            val = val + y;
            x = stack.pop();
        }
        return String.valueOf(val);
    }

    private static int getAtomMass(String atomVal) {
        switch (atomVal) {
            case "C":
                return 12;
            case "H":
                return 1;
            case "O":
                return 16;
            default:
                return 0;
        }
    }

    private static void calculateFinalVal() {
        String x;
        int val;
        int sum=0;
        while (stack.size() != 0) {
            x=stack.pop();
            val = getAtomMass(x);
            if(val==0) {
                if (x.endsWith("S")) {
                    x = x.substring(0, x.length() - 1);
                    val=Integer.parseInt(x);
                }else{
                    val=evaluateFactor(x);
                }
            }
            sum=sum+val;
        }
        stack.push(sum+"");
    }

    private static int evaluateFactor(String x){
        int factor=Integer.parseInt(x);
        String s=stack.pop();
        s=s.endsWith("S")?s.substring(0,s.length()-1):s;
        int next=getAtomMass(s);
        if(next==0)
            next=Integer.parseInt(s);
        return next*factor;
    }
}
