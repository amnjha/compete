package CODECHEF.LongChallenge.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AVGPR
{
    public static void main(String[] args) throws IOException
    {
        FastReader br = new FastReader();
        int T=0;

        T=br.nextInt();
        int N;
        int A[];
        Map<Integer, Integer> numberMap;

        while (T-- >0){
            N=br.nextInt();
            A=new int[N];
            numberMap= new HashMap<>();

            for (int i = 0; i < N; i++)
            {
                A[i]= br.nextInt();
                if(numberMap.get(A[i])==null)
                    numberMap.put(A[i],1);
                else
                    numberMap.put(A[i], numberMap.get(A[i])+1);
            }

            Arrays.sort(A);

            int cnt=0;
            for (int i = 0; i <N; i++)
            {
                if(i!=0 && A[i]==A[i-1])
                    continue;

                for (int j = 0; j <= i; j++)
                {
                    if(j!=0 && A[j]==A[j-1])
                        continue;

                    int diff = (2*A[i])-A[j];
                    if (numberMap.containsKey(diff))
                    {
                        int numCount=numberMap.get(A[i]);
                        int otherNumCount= numberMap.get(A[j]);

                        int countVal=numberMap.get(diff);

                        if(A[i]==A[j])
                            otherNumCount=0;

                        if(diff==A[i]) {
                            numCount = 0;
                            countVal--;
                        }

                        numCount=numCount>1?numCount:0;
                        otherNumCount=otherNumCount>1?otherNumCount:0;
                        cnt += countVal + (numCount * otherNumCount);
                    }
                }
            }

            System.out.println(cnt);
        }
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
