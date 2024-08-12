import java.math.BigInteger;

/*
Problem Description
Given two binary strings A and B. Return their sum (also a binary string).

Problem Constraints
1 <= length of A <= 10^5
1 <= length of B <= 10^5
A and B are binary strings

Input Format
The two argument A and B are binary strings.

Output Format
Return a binary string denoting the sum of A and B

Example Input
Input 1:
A = "100"
B = "11"

Input 2:
A = "110"
B = "10"

Example Output
Output 1: "111"
Output 2: "1000"

Example Explanation
For Input 1: The sum of 100 and 11 is 111.
For Input 2: The sum of 110 and 10 is 1000.

 */
public class addBinaryStrings {


    public static void main(String args[]) {

        /*
            String A = "110";
            String B = "10";

            long decimalA = binaryToDecimal(A, A.length());
            long decimalB = binaryToDecimal(B, B.length());

            long res = decimalA + decimalB;

            String sum = decimalToBinary(res);

            System.out.println("sum : " + sum);
        */
        // For very large numbers
        String A = "10001100010111000101100010100110001001101010000010011010";
        String B = "101111000100100100111110010010101110101001100100101001111010011000000110";

        BigInteger decimalA = new BigInteger(A, 2);
        BigInteger decimalB = new BigInteger(B, 2);

        BigInteger res = decimalA.add(decimalB);

        String binarySum = res.toString(2);

        System.out.println(binarySum);

    }

    public static long binaryToDecimal(String str, int n) {

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[n - i - 1] = Character.getNumericValue(str.charAt(i));
        }

        long decimalVal = 0;

        for (int i = 0; i < n; i++) {
            decimalVal += arr[i] * Math.pow(2, i);
        }

        return decimalVal;
    }

    public static String decimalToBinary(long a) {

        String str = "";

        for (long i = a; i > 0; i = i / 2) {
            str += i % 2;
        }

        String res = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }

        return res;
    }


}
