package CODECHEF.LongChallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class WGHTNUM {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int T = reader.nextInt();
        int W;
        long N;

        while (T -- > 0) {
            N = reader.nextInt();
            W = reader.nextInt();

            if (W >9 || W <-9)
            {
                System.out.println(0);
                continue;
            }

            int x;
            if (W< 0)
                x=10+W;
            else
                x=9-W;

            String val="1";
            if(x >0)
                val = x +"";
            if (N > 2) {
                String f = "%-" + (N - 2) + "s";
                val = String.format(f, val).replace(' ', '0');
                if (val.length() > 9)
                    val = new BigInteger(val).mod(BigInteger.valueOf(1000000007)).toString();
            }

            System.out.println(val);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
