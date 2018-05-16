/*
package Challenge.MMT;

class ShortestPalSubStr
{
    static int shortestPalSubstr(String str, int K) {
        int start = 0;
        int len = str.length();
        int minLength=len;

        int low, high;

        for (int i = 1; i < len; ++i)
        {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 < minLength && high - low + 1> K) {
                    start = low;
                    minLength = high - low + 1;
                }
                --low;
                ++high;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 < minLength && high - low + 1> K) {
                    start = low;
                    minLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.print("Longest palindrome substring is: ");

        if (minLength==len && !(new StringBuilder(str).reverse().toString().equals(str)))
            minLength=-1;
        return minLength;
    }

    // Driver program to test above function
    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.println("Length is: " +
                shortestPalSubstr(str, 4));
    }

}
*/
