package Challenge.Monocept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SPCLSUBS {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[] )throws Exception{
        int n,q,i;
        FastReader fr= new FastReader();
        n=fr.nextInt();
        int a[]=new int[n];
        q=fr.nextInt();
        int sum=0;
        for(i=0;i<n;i++)
        {
            a[i]=sum+fr.nextInt();
            sum=a[i];
        }
        int x,y;
        while(q-- > 0){
            x=fr.nextInt();
            y=fr.nextInt();

            if(x!=1)
                System.out.println(a[y-1]-a[x-2]/(y-x));
            else
                System.out.println(a[y-1]/y-(x-1));
        }

    }

    public static String[] readInput() throws Exception{
        return br.readLine().split(" ");
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
