package CODECHEF.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Question :CNOTE (https://www.codechef.com/problems/CNOTE)
 **/
public class CNOTE {
    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();

        int P, C, K, N, X, Y, diff;

        while (T--  > 0){
            X=sc.nextInt();
            Y=sc.nextInt();
            K=sc.nextInt();
            N=sc.nextInt();

            diff=X-Y;
            boolean found=false;
            for(int i=0; i<N; i++){
                P=sc.nextInt();
                C=sc.nextInt();

                if(P >= diff && C <= K) {
                    found=true;
                }
            }
            if(found)
                System.out.println("LuckyChef");
            else
                System.out.println("UnluckyChef");
        }
    }
}
