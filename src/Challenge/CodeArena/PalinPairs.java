package Challenge.CodeArena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PalinPairs {
    static FastReader reader = new FastReader();
    public static void main(String[] args) {
        int N= reader.nextInt();

        Map<String, Long> stringCounts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String S= reader.nextLine();

            if(stringCounts.containsKey(S))
                stringCounts.put(S,stringCounts.get(S)+1);
            else
                stringCounts.put(S, 1L);
        }

        solve(stringCounts);
    }

    public static void solve(Map<String, Long> stringCounts){
        Set<String> processedString = new HashSet<>();

        long res=0;
        for(Map.Entry<String, Long> val: stringCounts.entrySet()){
            String  S= val.getKey();

            if(!processedString.add(S))
                continue;

            String rev= new StringBuffer(S).reverse().toString();
            if(S.equals(rev))
            {
                long N=stringCounts.get(S);
                if(N>1)
                    res+=(N*(N-1)/2);
                continue;
            }
            if (!processedString.add(rev))
                continue;

            if(stringCounts.containsKey(rev))
                res+=(stringCounts.get(S)* stringCounts.get(rev));
        }

        System.out.println(res);
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
    }}
