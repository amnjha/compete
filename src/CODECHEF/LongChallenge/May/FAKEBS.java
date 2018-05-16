package CODECHEF.LongChallenge.May;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FAKEBS {

    private static Reader reader = new Reader();
    public static void main(String[] args) throws IOException {

        int T = reader.nextInt();
        while (T-->0){
            solve();
        }

    }

    public static void solve() throws IOException {
        int N=reader.nextInt();
        int Q= reader.nextInt();
        Map<Long, Integer> positionMap = new HashMap<>();
        long[] A = new long[N];
        long[] B = new long[N];
        long[] posArray= new long[N];

        for (int i = 0; i < N; i++) {
            A[i]=reader.nextLong();
            B[i]=A[i];
            positionMap.put(A[i],i);
            posArray[i]=i;
        }
        Arrays.sort(B);
        Map<Long, Integer> sortedPosition = new HashMap<>();
        Map<Long, Long> swapCountArray= new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            sortedPosition.put(B[i],i);
        }


        long X;
        for (int i = 0; i < Q; i++) {
            X= reader.nextLong();
            long positionInSortedArray=sortedPosition.get(X);
            long swaps=swapCountArray.get(X)==null?calculateSwapCount(A,X,N,positionInSortedArray,posArray,positionMap):swapCountArray.get(X);
            swapCountArray.put(X,swaps);
            System.out.println(swaps);
        }
    }

    private static long calculateSwapCount(long A[], long X, int N, long positionInSortedArray, long[] positionArray, Map<Long, Integer> positionMap){
        long originalPosition= positionMap.get(X);

        long smallCount= positionInSortedArray;
        long largeCount= (N-1)-positionInSortedArray;

        long swapCountLeft=0;
        long swapCountRight=0;

        int l=0,h=N-1,m;
        while(l<=h){
            m=(l+h)/2;
            if (positionArray[m]==originalPosition){
                if(swapCountLeft==swapCountRight)
                    return swapCountLeft;
                else
                    return Math.max(swapCountLeft,swapCountRight);
            }
            else if(positionArray[m]<originalPosition){
                if(A[m]>X)
                    swapCountRight++;
                if(smallCount--==0)
                    return -1;
                l=m+1;
            }
            else if (positionArray[m]>originalPosition){
                if (A[m]<X)
                    swapCountLeft++;
                if(largeCount--==0)
                    return -1;
                h=m-1;
            }
        }
        return -1;
    }

    private static class Reader
    {

        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
