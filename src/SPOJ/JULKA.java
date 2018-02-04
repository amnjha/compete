package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JULKA {
    public static void main(String[] args) throws IOException {
        BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
        int T=10;
        BigInteger total,extra;
        while (T-->0){
            total=new BigInteger(buff.readLine());
            extra=new BigInteger(buff.readLine());

            System.out.println(total.subtract(extra).divide(BigInteger.valueOf(2)).add(extra));
            System.out.println(total.subtract(extra).divide(BigInteger.valueOf(2)));
        }
    }
}