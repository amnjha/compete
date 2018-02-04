package CODECHEF.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Question : SALARY(https://www.codechef.com/problems/SALARY)
 **/

public class SALARY {
    public static void main(String[] args) {
        int T,N, W;
        int min, sum;
        Scanner sc= new Scanner(System.in);
        T=sc.nextInt();
        while (T-- > 0)
        {
            System.out.println();
            sum=0;
            min=10001;
            N=sc.nextInt();
            int n=N;
            while (n-- > 0){
                W=sc.nextInt();
                sum+=W;
                if(W<min){
                    min=W;
                }
            }
            sum-=N*min;
            System.out.println(sum);
        }
    }
}
