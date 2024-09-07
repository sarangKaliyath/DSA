package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem Description

Given an integer array A of N integers,
find the pair of integers in the array which have minimum XOR value.
Report the minimum XOR value.

Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 10^9

Input Format
First and only argument of input contains an integer array A.

Output Format
Return a single integer denoting minimum xor value.

Example Input

Input 1: A = [0, 2, 5, 7]
Input 2: A = [0, 4, 7, 9]

Example Output

Output 1: 2
Output 2: 3

Example Explanation

Explanation 1:
 0 xor 2 = 2

 */

public class MinXorValue {

    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 2, 5, 7));
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 4, 7, 9));

        int n = A.size();

        bruteForce(A, n);

        optimized(A, n);

    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        long min = A.get(0) ^ A.get(1);

        for (int i = 0; i < n - 1; i++) {

            int X = A.get(i);

            for (int j = i + 1; j < n; j++) {

                int Y = A.get(j);

                if ((X ^ Y) < min) {
                    min = X ^ Y;
                }

            }

        }

        System.out.println(min);

        // Time O(N^2);
        // Space O(1);

    }

    public static void optimized(ArrayList<Integer> A, int n) {

        Collections.sort(A);

        int min = A.get(0) ^ A.get(1);

        for (int i = 1; i < n - 1; i++) {

            long val = A.get(i) ^ A.get(i + 1);

            if (val < min) {
                min = (int) val;
            }

        }

        System.out.println(min);

        // Time O(NlogN);
        // Space O(1);

    }
}
