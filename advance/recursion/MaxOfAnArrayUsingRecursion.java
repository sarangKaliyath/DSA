package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/*

Problem Description
Given an array A of size N, write a recursive function that returns the maximum element of the array.

Problem Constraints
1 <= N <= 100
1 <= A[i] <= 1000

Input Format
The first line contains the array A.

Output Format
A single integer is the maximum value of the array.

Example Input
Input 1: A = [12, 10, 3, 4, 5]
Input 2: A = [1, 5, 80, 40]

 */
public class MaxOfAnArrayUsingRecursion {

    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 80, 40));

        int maxVal = findMax(A, 1, A.size(), A.get(0));

        System.out.println(maxVal);

        int max = betterApproach(A, 0);

        System.out.println(max);
    }

    public static int betterApproach(ArrayList<Integer> A, int i) {

        if (i == A.size() - 1) return A.get(i);

        return Math.max(A.get(i), betterApproach(A, i + 1));
    }

    public static int findMax(ArrayList<Integer> A, int i, int n, int max) {

        if (i == n) {
            return max;
        }

        max = Math.max(max, A.get(i));

        return findMax(A, i + 1, n, max);
    }
}
