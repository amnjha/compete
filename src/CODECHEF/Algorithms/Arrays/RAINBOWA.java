package CODECHEF.Algorithms.Arrays;

import java.util.Arrays;
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
            int k=0,l=N-1;
            int ctr;
            for(int i=0;i<6; i++) {
                ctr=0;
                while (A[k] == (i+1) && k<=(N+1)/2) {
                    ctr++;
                    k++;
                }
                if(ctr==0)
                {
                    found=false;
                    break;
                }
                while (A[l]==(i+1) && l>=(N+1)/2)
                {
                    ctr--;
                    l--;
                }
                if (ctr!=0 || A[i] > 7 || A[i] < 1) {
                    found = false;
                    break;
                }
            }

            if(A[k]!=7 || A[l]!=7)
                found=false;

            System.out.println(found?"yes":"no");

        }
    }
}
