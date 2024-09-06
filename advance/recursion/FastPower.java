package recursion;

/*
Problem Description
Given two positive integers A and B. Implement Fast Power function to compute AB
Note : Please use the approach taught in the class.

Problem Constraints
AB would fit in 64-bit type integer.

Input Format
Two integers A and B

Output Format
Single integer denoting the answer to AB

Example Input
Input 1 :
A = 2 , B = 10

Input 2 :
A = 1 , B = 100000000

Example Output
Output 1 : 1024
Output 2 : 1

Example Explanation
For Input 1 :
2^10 = 2^5 * 2^5
2^5 = 32, so 32 * 32 = 1024

For Input 2 :
1 raised to power anything is 1
 */
public class FastPower {

    public  static void main (String args []){

        int A = 2;
        int B = 10;

        long res = powFirstApproach(A, B);
        System.out.println(res);
        // Time O(N);
        // Space O(N);

        long powSecond = powSecondApproach(A, B);
        System.out.println(powSecond);
        // Time O(N);
        // Space O(log N);

        long powOptimized = powOptimizedApproach(A, B);
        System.out.println(powOptimized);
        // Time O(log N);
        // Space O(log N);

    }

    public static long powFirstApproach (int A, int B){

        if(B == 0){
            return 1;
        }

        return powFirstApproach(A, B - 1) * A;
    }

    public static long powSecondApproach (int A, int B){

        if (B == 0) return 1;

        if((B & 1) == 0)
            return powSecondApproach(A, B/2) * powSecondApproach(A, B/2);
        else
            return powSecondApproach(A, B/2) * powSecondApproach(A, B/2) * A;
    }

    public  static long powOptimizedApproach (int A, int B){

        if(B == 0) return 1;

        long pow = powOptimizedApproach(A, B/2);

        if((B & 1) == 0){
            return pow * pow;
        }
        else {
            return pow * pow * A;
        }

    }
}
