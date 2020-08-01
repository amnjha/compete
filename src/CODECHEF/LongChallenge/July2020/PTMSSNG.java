package CODECHEF.LongChallenge.July2020;

import java.util.*;
import java.io.*;

class PTMSSNG {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int T =s.nextInt();
        while (T-->0){
            int n =s.nextInt();

            long resX=0;
            long resY=0;

            for (int i = 0; i <4*n-1 ; i++) {
                long x=s.nextLong();
                long y =s.nextLong();
                resX ^=x;
                resY^=y;
            }

            System.out.println(resX+" "+resY);
        }
    }
}