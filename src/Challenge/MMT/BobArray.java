package Challenge.MMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BobArray {
    public static void main(String[] args) {
        FastReader reader= new FastReader();
        int N= reader.nextInt();
        int Q= reader.nextInt();

        long A[]= new long[N];

        int type;
        int X;
        for (int i = 0; i < Q; i++) {
            type=reader.nextInt();
            X= reader.nextInt()-1;
            if(type ==1)
                    A[X]= (A[X]*2)+1;
            else if(type==2)
                    A[X]=A[X]/2;
            else if (type==3) {
                int Y = reader.nextInt();
                System.out.println(countSetBits(A, X, Y));
            }
        }
    }

    private static Map<Long, Integer> setBitMap = new HashMap<>();

    private static long countSetBits(long[] A, int K,int L){
        long res=0;
        for (int i = K; i < L; i++) {
            res+=countSetBits(A[i]);
        }
        return res;
    }

    private static int countSetBits(long n)
    {
        Integer res=setBitMap.get(n);
        if(res!=null)
            return res;

        long k=n;
        int count = 0;
        while (n > 0)
        {
            n &= (n - 1) ;
            count++;
        }
        setBitMap.put(k,count);
        return count;
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
