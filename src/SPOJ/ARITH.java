package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ARITH {
    public static void main(String[] args) throws IOException {
        BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(buff.readLine());

        while (T-->0){

        }
        dispSumOrDiff("1234+12346","+");
    }

    private static void dispSumOrDiff(String val, String op){
        String arr[]=val.split("[+][-]*");

        int n1=Integer.parseInt(arr[0]), n2=Integer.parseInt(arr[1]);
        int l1=arr[0].length();
        int l2=arr[1].length();
        int maxLength=l1;

        if(l1>l2){
            arr[1]=getNSpaces(l1-l2)+arr[1];
            maxLength=l1;
        }
        else if(l2>l1)
        {
            arr[0]=getNSpaces(l2-l1)+arr[0];
            maxLength=l2;
        }
        char[] dashes=new char[maxLength+1];
        Arrays.fill(dashes,'-');

        System.out.println(" "+arr[0]);
        System.out.println(op+arr[1]);
        System.out.println(String.copyValueOf(dashes));
        System.out.println(" "+(n1+n2));


    }

    private void dispDiff(String val){
        String arr[]=val.split("-");
    }

    private void dispProd(String val){
        String arr[]=val.split("[*]");
    }

    private static int getMaxLength(String... x){
        int mx=x[0].length();
        for(String y:x){
            int val=y.length();
            if (val>mx)
                mx=val;
        }
        return mx;
    }

    private static String getNSpaces(int n){
        char[] arr= new char[n];
        Arrays.fill(arr,' ');
        return String.copyValueOf(arr);
    }
}
