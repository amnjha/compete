package Challenge.DESHAW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ANDSUM {

    static final long MOD_VAL=1000000007;

    public static void main(String[] args) throws IOException {
        int T;
        FastReader reader= new FastReader();

        T=reader.nextInt();
        while (T-- >0){
            int N=reader.nextInt();
            int A[] = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = reader.nextInt();
            }

            System.out.println(solve(A));
        }
    }

    static long solve(int set[]) {

        long total = 0;

        for (int bit=1; bit!=0; bit<<=1) {

            int numbersWithBitSet = 0;
            for (int i : set) {
                if ((i&bit)!=0) numbersWithBitSet++;
            }

            long subsets = (1L<<numbersWithBitSet)-1;
            total += bit * subsets;
        }

        return total % MOD_VAL;
    }


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
