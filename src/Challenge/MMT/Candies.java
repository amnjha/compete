package Challenge.MMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Candies {
    public static void main(String[] args) {
        FastReader reader= new FastReader();
        String S= reader.nextLine();
        int T=reader.nextInt();

        while (T-- > 0){
            int K= reader.nextInt();
            System.out.println(solve(S,K));
        }
    }

    public static int solve(String S, int K) {

        if (K==1)
            return 1;
        while(K<S.length()){
            for (int i=0; (i+K)<=S.length(); i++){
                if (checkPalin(S.substring(i,i+K)))
                    return K;
            }
            K++;
        }
        return -1;
    }

    private static boolean checkPalin(String S){
        Map<Character, Integer> countVal= new HashMap<>();
        for (char c : S.toCharArray()){
            if (countVal.get(c)==null)
                countVal.put(c,1);
            else
                countVal.put(c,countVal.get(c)+1);
        }

        int allowedOdds= S.length()%2;
        for(Map.Entry<Character, Integer> entry : countVal.entrySet()){
            if(entry.getValue()%2!=0)
                allowedOdds--;

            if (allowedOdds<0)
                return false;
        }
        return true;
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
