package BitManipulation;

/*

Problem Description

Given an integer A.
Two numbers, X and Y, are defined as follows:
    X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
    Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
NOTE 2: Your code will be run against a maximum of 100000 Test Cases.

Problem Constraints
1 <= A <= 10^9

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the XOR of X and Y.

Example Input A = 5

Example Output 10

Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.

 */
public class StrangeEquality {

    public static void main (String args []){

        int A = 12;

        bruteForce(A);

        optimized(A);
    }

    public static void optimized (int A){

        /*
            To calculate binary length of a decimal number
                 Length = [Log (n)] + 1;
                 where, log has base 2;
            The Math.log computes natural log (base "e").
         */

        int len = (int) (Math.log(A) / Math.log(2) );

        int y = 2 * (1 << len);

        int ans = 0;

        for(int i = 0; i < len; i++){
            ans = A ^ (1 << i);
        }

        System.out.println(len + " y:" + y + " a" + ans);
    }

    public static  void bruteForce(int A){

        int X = 0;

        for(int i = 4; i >= 0; i--){
            int xor = i ^ A;
            int sum = i + A;

            if(xor == sum){
                X = i;
                break;
            }
        }

        int Y = 0;

        for(int i = A+1; i < Math.pow(10, 10); i++){
            int xor = i ^ A;
            int sum = i + A;

            if(xor == sum){
                Y = i;
                break;
            }
        }

        System.out.println(X + " " + Y);

    }
}