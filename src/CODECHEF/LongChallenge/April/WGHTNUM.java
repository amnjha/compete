package CODECHEF.LongChallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class WGHTNUM {
    public static void main(String[] args) {
        FastReader reader =  new FastReader();
        int T = reader.nextInt();
        int W;
        long N;

        while (T--  >0 ){
            N= reader.nextInt();
            W= reader.nextInt();

            if (W>9) {
                System.out.println(0);
                continue;
            }

            System.out.print(9-W);

            if(N>2) {
                long val = ((Double) Math.pow(10, N - 2)).longValue();
                for (long i = 0; i < val; i++)
                    System.out.print('0');
            }
        }
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
                catch (IOException e)
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
