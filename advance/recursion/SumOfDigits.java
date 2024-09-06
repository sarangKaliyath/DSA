package recursion;

/*
Problem Description
Given a number A, we need to find the sum of its digits using recursion.

Problem Constraints
1 <= A <= 10^9

Input Format
The first and only argument is an integer A.

Output Format
Return an integer denoting the sum of digits of the number A.

Example Input
Input 1: A = 46
Input 2: A = 11

Example Output
Output 1: 10
Output 2: 2

Example Explanation
Explanation 1:
 Sum of digits of 46 = 4 + 6 = 10

Explanation 2:
 Sum of digits of 11 = 1 + 1 = 2
 */
public class SumOfDigits {

    public static void main(String args[]) {

        int A = 123;
        int ans = 0;

        int val = recursion(A, ans);

        System.out.println(val);

        int res = betterApproach(A);
        System.out.println(res);
    }

    public static int betterApproach(int A) {
        if (A == 0) return 0;
        return (A % 10 + betterApproach(A / 10));
    }

    public static int recursion(int A, int ans) {
        if (A == 0) return ans;

        ans += (int) (A % 10);
        return recursion((int) A / 10, ans);
    }

}
