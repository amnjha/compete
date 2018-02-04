package CODECHEF.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Question : RAINBOWA(https://www.codechef.com/problems/RAINBOWA)
 */
public class RAINBOWA {
    public static void main(String[] args) {
        int T,N,A[];
        Scanner sc= new Scanner(System.in);
        T=sc.nextInt();

        while (T-- > 0){
            N=sc.nextInt();
            A=new int[N];
            for (int i = 0; i < N; i++) {
                A[i]=sc.nextInt();
            }

            boolean found=true;
            if(A[N/2]>7 || A[(N+1)/2]>7 || A[N/2]<1 || A[(N+1)/2]<1)
                found=false;
            if(found)
            for (int i = 0,k=N-1 ;i<k; i++,k--) {
                if(A[i]!=A[k] || A[i]>A[i+1] || A[i]>7 || A[i]<1) {
                    found=false;
                    break;
                }
            }
            System.out.println(found?"yes":"no");

        }
    }
}
