package CODECHEF.LongChallenge.May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RD19 {

    public static void main(String[] args) {

        FastReader reader = new FastReader();

        int T= reader.nextInt();
        while (T-- >0){
            int N= reader.nextInt();
            List<Integer> A= new ArrayList<>();
            for (int i=0; i<N; i++){
                A.add(reader.nextInt());
            }
            solve(A,N);
        }
    }

    public static void solve(List<Integer> A,int N){
        Collections.sort(A);
        List<Integer> fin = new ArrayList<>();

        for (int i = 2; i < A.get(A.size()-1); i++) {
            int j=0;
            for (; j < A.size(); j++) {
                if(A.get(j)%i!=0)
                    break;
                else
                    fin.add(A.get(j));
            }
            if(j==A.size())
                A=fin;
            fin.clear();
            if(A.size()==0)
                break;
        }

        int res= N-A.size();
        if (res==N)
            res=-1;

        System.out.println(res);
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
