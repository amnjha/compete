package Challenge.Dell;

import java.io.*;
import java.util.StringTokenizer;

public class EqualArray {

    private static FastReader reader = new FastReader();

    public static void main(String[] args) throws IOException {
        int T= reader.nextInt();
        while (T-->0){
            solve();
        }
    }

    private static void solve() throws IOException {
        int N = reader.nextInt();
        long A[] = new long[N];

        A[0]= reader.nextInt();
        for (int i = 1; i < N; i++) {
            A[i]=A[i-1]+reader.nextLong();
        }

        long X=Long.MAX_VALUE;
        boolean changed=false;
        for (int i = 0; i < N-1; i++) {
            long rightSum = A[N-1]-A[i];
            long leftSum = A[i];

            long diff =rightSum-leftSum;
            if (diff<X) {
                X = diff;
                changed=true;
            }
        }

        if (!changed)
            X=-1;
        System.out.println(X);
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
