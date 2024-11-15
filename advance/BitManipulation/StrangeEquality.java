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

    public static void main(String args[]) {

        int A = 21;

        bruteForce(A);

        optimized(A);

        mySolution(A);
    }

    public static void optimized(int A) {

        int bits = 0;
        int x = 0;
        int y = 0;

        while (A != 0) {
            if ((A & 1) == 0) {  // checking if A is even or odd;
                x |= (1 << bits);
            }
            A >>= 1; // which also means A = A/2;
            bits++;
        }

        y = (1 << bits);

        System.out.println("x : " + x + " y : " + y + " sum : " + (x + y));

    }

    public static void mySolution(int A) {

        int pos = 0;

        for(int i = 0; i < 32; i++){
            if((A & (1 << i)) > 0) {
              pos = i;
            };
        }
  
        int x = 0;
        int bits = 0;
  
        for(int i = 0; i <= pos; i ++){
          if((A & (1 << i)) == 0) x |= 1 << bits;
          bits++;
        }
  
        int y = 1 << (pos + 1);

        System.out.println("x : " + x + " y : " + y + " sum : " + (x + y));

    }

    public static void bruteForce(int A) {

        int X = 0;

        for (int i = A - 1; i >= 0; i--) {
            int xor = i ^ A;
            int sum = i + A;

            if (xor == sum) {
                X = i;
                break;
            }
        }

        int Y = 0;

        for (int i = A + 1; i < Math.pow(10, 10); i++) {
            int xor = i ^ A;
            int sum = i + A;

            if (xor == sum) {
                Y = i;
                break;
            }
        }

        System.out.println(X + " " + Y);

    }
}
