package arithmaticsandGcD;

/*

Problem Description

Implement pow(a, b) % c.
In other words, given a, b and c, Find (ab % c).
Note= The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.

Problem constraints
-10^9 <= a <= 10^9
0 <= b <= 10^9
1 <= c <= 10^9

Input Format
Given three integers a, b, c.

Output Format
Return an integer.

Example Input
Input 1=
a = 2
b = 3
c = 3

Input 2=
a = 3
b = 3
c = 1

Example Output
Output 1= 2
Output 2= 0

Example Explanation
Explanation 1= 23 % 3 = 8 % 3 = 2
Explanation 2= 33 % 1 = 27 % 1 = 0

 */
public class ImplementPowerFunction {

    public  static void main (String [] args){

        int A = 71045970;
        int B = 41535484;
        int C = 64735492;

        int val = (int) recursion((A + C) % C, B, C);
        System.out.print(val);
    }

    public static long recursion (long A, long B, long C){

        if(A == 0) return 0;
        if(B == 0) return 1;

        long val = recursion(A, B/2, C);

        if((B & 1) == 0) return (val * val) % C;

        else return ((val * val) % C * A) % C;
    }
}
