package Challenge.DESHAW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravellingAnt {

    static final long MOD_VAL=((Double)(Math.pow(10,9)+7)).longValue();

    public static void main(String[] args) {
        FastReader reader= new FastReader();
        int T= reader.nextInt();

        while (T-- > 0){
            long N=reader.nextLong();
            System.out.println(solve(N));
        }
    }

    static long solve(long N){
        int sol[] = {1,0,2,0,6,0};
        long ans=0;
        if(N==0)
            return 1;

        if (N%2==0){
            long mod=N%5;
            N/=5;

            if(N!=0)
                ans =N*sol[((Long)mod).intValue()];
            else
                ans=sol[((Long)mod).intValue()];
        }

        return ans%MOD_VAL;
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
