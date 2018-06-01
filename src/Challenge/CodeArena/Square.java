package Challenge.CodeArena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square {
    static FastReader reader = new FastReader();
    public static void main(String[] args) {
        int T= reader.nextInt();
        long[] A= new long[T];

        long s=0;
        for (int i = 0; i <T ; i++) {
            s+=reader.nextInt();
            A[i]=s;
        }

        int Q= reader.nextInt();
        while (Q-->0){
            long X=reader.nextLong();
            System.out.println(solve(A, X));
        }

    }

    private static int solve(long[] A, long val){
        int l=0, h=A.length-1;

        if (val>A[h])
            return -1;

        int mid=-1;
        while (l<=h){
            mid=(h+l)/2;
            if(A[mid]==val)
                break;
            if (A[mid]<val)
                l=mid+1;
            else if (A[mid]>val)
                h=mid-1;
        }
        if(A[mid]<val && mid<A.length-1 && A[mid+1]>=val )
            mid+=1;

        return mid+1;
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
