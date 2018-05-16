package Challenge.TataHealth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSubArray {
    public static void main(String[] args) throws IOException {
        int T;
        FastReader reader= new FastReader();

        T= reader.nextInt();
        MergeSort sorter= new MergeSort();
        while(T-- >0){
            int N=reader.nextInt();
            int A[] = new int[N];

            for (int i = 0; i < N; i++) {
                A[i]=reader.nextInt();
            }
            sorter.sort(A, N);
            System.out.println(solve(A,N));
        }
    }



    public static long solve(int A[], int N){
        long B[]= new long[N];

        long val=0;
        for (int i=0;i < N; i++){
            val+=A[i];
            B[i]=val;
        }

        long maxSum=B[0]*N;

        long sum;
        for (int i = 1; i < N; i++) {
            sum=((N-i)*(B[i]-B[i-1]))-B[i-1];
            if(A[i]!=(B[i]-B[i-1]))
                System.out.println(A[i]+","+(B[i]-B[i-1]));

            if (sum>maxSum)
                maxSum=sum;
        }

        return maxSum;
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

class MergeSort
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sortArr(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            sortArr(arr, l, m);
            sortArr(arr , m+1, r);

            merge(arr, l, m, r);
        }
    }

    void sort(int arr[],int N){
        sortArr(arr,0,N-1);
    }
}
