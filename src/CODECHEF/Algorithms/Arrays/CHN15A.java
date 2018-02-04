package CODECHEF.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Question CHN15A(https://www.codechef.com/problems/CHN15A)
 */
public class CHN15A {
    public static void main(String[] args) {
        int T, N, K, C, ctr;
        Scanner sc= new Scanner(System.in);
        T=sc.nextInt();

        while (T-- > 0){
            N=sc.nextInt();
            K=sc.nextInt();

            ctr=0;
            while (N-- > 0){
                C=sc.nextInt()+K;
                if(C%7==0)
                    ctr++;
            }
            System.out.println(ctr);
        }
    }
}
