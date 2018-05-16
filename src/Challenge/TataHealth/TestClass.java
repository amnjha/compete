package Challenge.TataHealth;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Write your code here
        String A= br.readLine();
        String B= br.readLine();

        int zeroCountA=0;
        int zeroCountB=0;
        int oneCountA=0;
        int oneCountB=0;

        int misMatchCount=0;

        char[] a= A.toCharArray();
        char[] b= B.toCharArray();
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
                zeroCountA++;
            else
                oneCountA++;

            if(b[i]==0)
                zeroCountB++;
            else
                oneCountB++;

            if (a[i]!=b[i])
                misMatchCount++;
        }

        if (zeroCountA!=zeroCountB || oneCountA!=oneCountB)
            System.out.println(-1);

        if(misMatchCount%2==0)
            misMatchCount/=2;
        else
            misMatchCount=(misMatchCount/2)+1;
        System.out.println(misMatchCount);
    }
}
