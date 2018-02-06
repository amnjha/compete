package CODECHEF.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Question : FRGTNLNG(https://www.codechef.com/problems/FRGTNLNG)
 */
public class FRGTNLNG {
    public static void main(String[] args) {
        int T,N,K;
        Scanner sc= new Scanner(System.in);

        T=sc.nextInt();
        String arr[];
        String cont[];
        while (T-- > 0){
            N=sc.nextInt();
            K=sc.nextInt();

            arr= new String[N];
            cont= new String[N];

            for (int i = 0; i < N; i++) {
                arr[i]=sc.next();
                cont[i]="NO";
            }

            String phrase[] =  new String[K];
            for (int i = 0; i < K; i++) {
                sc.nextInt();
                phrase[i]=sc.nextLine();
            }

            for (int i = 0; i < K; i++) {
                for (int j = 0; j < N; j++) {
                    if(phrase[i].contains(arr[j])){
                        cont[j]="YES";
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.print(cont[i]+" ");
            }
        }
    }
}
