package Challenge.MMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PoisonousGas {
    static FastReader reader= new FastReader();
    public static void main(String[] args) {
        int T= reader.nextInt();

        while (T-- >0){
            int N= reader.nextInt();
            solve(N);
        }
    }

    private static void solve(int N){
        int sum=0,k;
        for (int i = 0; i < N; i++) {
            k=reader.nextInt();
            if (k>0)
                sum+=k;
        }

        boolean res=false;
        int val=1;
        while (val<=sum)
        {
            if(sum==val)
            {
                res=true;
                break;
            }
            val=val*2;
        }
        if(res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static class FastReader {
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
