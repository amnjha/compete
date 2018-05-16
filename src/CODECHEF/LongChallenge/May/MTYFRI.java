package CODECHEF.LongChallenge.May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MTYFRI {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int T= reader.nextInt();

        while (T-->0){
            int N= reader.nextInt();
            int K= reader.nextInt();
            List<Long> f= new ArrayList<>();
            List<Long> s= new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(i%2==0)
                    f.add(reader.nextLong());
                else
                    s.add(reader.nextLong());

            }
            System.out.println(solve(f,s, K));
        }

    }

    private static String solve(List<Long> f, List<Long> s, int K){
        Collections.sort(f, Collections.reverseOrder());
        Collections.sort(s);

        long fSum= f.stream().reduce(Long::sum).get();
        long sSum= s.stream().reduce(Long::sum).get();


        if(fSum<sSum)
            return "YES";

        K=Integer.min(K,Integer.min(f.size(),s.size()));

        long fsSum=0;
        long ssSum=0;

        for (int i = 0; i < K; i++) {
            if(f.get(i)<s.get(i))
                break;

            fsSum += f.get(i);
            ssSum += s.get(i);


            long s1= (ssSum+fSum)-fsSum;
            long s2= (fsSum+sSum)-ssSum;

            if(s2>s1)
                return "YES";
        }

        return "NO";
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
