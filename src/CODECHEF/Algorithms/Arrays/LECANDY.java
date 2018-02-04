package CODECHEF.Algorithms.Arrays;

import java.util.Scanner;

/**
 * Question: LECANDY (https://www.codechef.com/problems/LECANDY)
 **/

public class LECANDY {
    public static void main(String[] args) {
        long C, sum;
        long A;
        int T, N;

        Scanner in = new Scanner(System.in);
        T = in.nextInt();

        while (T-- > 0) {
            N = in.nextInt();
            C = in.nextLong();

            sum = 0;
            for (int i = 0; i < N; i++) {
                A = in.nextLong();
                sum += A;
            }

            if (sum > C)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
}
