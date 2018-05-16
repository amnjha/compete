package Challenge.Dell;

import java.io.*;
import java.util.StringTokenizer;

public class OneSwapPalin {

    private static FastReader reader = new FastReader();
    public static void main(String[] args) throws IOException {
        int T= reader.nextInt();
        while (T-->0){
            solve();
        }
    }

    private static void solve() throws IOException {
        String S= reader.nextLine();

        int N = S.length();
        char[] s= S.toCharArray();
        int k=0, l=0;
        for (int i=N/2; i>=0; i--){
            if(s[i]!=s[(N-1)-i]) {
                k=i;
                l=(N-1)-i;
            }
        }

        if(k!=0 || l!=0) {
            if (check(s,k)) {
                System.out.println("Yes");
                return;
            }
            else if(check(s,l))
            {
                System.out.println("Yes");
                return;
            }
            else
            {
                System.out.println("No");
                return;
            }
        }
        else if (checkPalin(s))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static boolean check(char[] s, int k){
        int N= s.length;

        int i;
        for (i = 0; i < (N+1)/2; i++) {
            if(i==k)
                continue;

            if(s[i]!=s[k] && s[(N-1)-k]==s[i]) {
                swapChars(s,i,k);
                if(checkPalin(s))
                    return true;
                else
                    swapChars(s,i,k);
            }
        }
        return false;
    }

    private static boolean checkPalin(char[] s){
        int N=s.length;
        for(int i=0;i<N/2; i++){
            if (s[i]!=s[(N-1)-i])
                return false;
        }
        return true;
    }

    private static void swapChars(char[] chars, int k, int l){
        char temp = chars[k];
        chars[k]= chars[l];
        chars[l]=temp;
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
