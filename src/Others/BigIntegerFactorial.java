package Others;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerFactorial
{
    public static void main(String[] args)
    {
        int n;
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();

        BigInteger fact= getFactorial(n);
        int length=fact.toString().length();
        long sumOfDigits=0;
        do{
            sumOfDigits=getSumOfDigits(fact);
            fact=BigInteger.valueOf(sumOfDigits);
        }while(sumOfDigits>0);
        System.out.println(sumOfDigits+length);
    }

    private static BigInteger getFactorial(int number){
        BigInteger num= BigInteger.valueOf(number);
        if(num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }
        else
            return getFactorial(number).multiply(getFactorial(number-1));
    }

    private static long getSumOfDigits(BigInteger number){
        long sum=0;
        char[] digits= number.toString().toCharArray();
        for (int i = 0; i < digits.length; i++) {
            sum+=Integer.parseInt(digits[i]+"");
        }
        return sum;
    }
}