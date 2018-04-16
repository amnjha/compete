package CODECHEF.LongChallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFWORK {
    public static void main(String[] args) {
        int N, C[], T[];
        FastReader reader = new FastReader();

        final int AUTHOR= 2;
        final int TRANSLATOR=1;
        final int AUTH_TRAN=3;

        N=reader.nextInt();
        C= new int[N];
        T= new int[N];

        int authorMin=100_001;
        int translatorMin=100_001;
        int autTranMin=100_001;

        for (int i = 0; i < N; i++) {
            C[i]=reader.nextInt();
        }
        for (int i = 0; i < N; i++) {
            T[i]=reader.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if(T[i]==AUTHOR && C[i]<authorMin)
                authorMin=C[i];
            else if(T[i]==TRANSLATOR && C[i]<translatorMin)
                translatorMin=C[i];
            else if(T[i]==AUTH_TRAN &&  C[i]<autTranMin)
                autTranMin=C[i];
        }

        int minPay;
        if(autTranMin < (authorMin+translatorMin)){
            minPay=autTranMin;
        }
        else
            minPay =authorMin+translatorMin;

        System.out.println(minPay);

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
