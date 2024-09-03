package BitManipulation;

/*

Problem Description

Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Problem Constraints
    1 <= |A| <= 2000000
    0 <= A[i] <= INTMAX

Input Format
The first and only argument of input contains an integer array A.

Output Format
Return a single integer denoting the single element.

Example Input
Input 1: A = [1, 2, 2, 3, 1]
Input 2: A = [1, 2, 2]

Example Output
Output 1: 3
Output 2: 1

Example Explanation
Explanation 1: 3 occurs once.
Explanation 2: 1 occurs once.

 */

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber {

    public static void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1));

        int n = A.size();

        int xor = A.get(0);

        for(int i = 1; i < n; i++){

            xor ^= A.get(i);

        }

        System.out.println(xor);

    }
}
