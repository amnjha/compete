package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextGreatestNumber {
    public static void main(String[] args) throws IOException {
        String number;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        number = reader.readLine();
        int[] arr= splitNumber(number);

        boolean isSorted=false;
        int prev=arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]>prev)
            {
                isSorted=false;
                break;
            }
        }

        if(isSorted){

        }
    }

    public static int[] splitNumber(String x) {
        int[] i = new int[x.length()];
        int k = 0;
        for (char c : x.toCharArray()) {
            i[k++] = Integer.parseInt(c + "");
        }
        return i;
    }
}
