package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= N+2

The elements of array A are distinct

Input Format
Only argument A is an array of integers

Output Format
Return a sorted array of size 2 denoting the missing elements.

Example Input
Input 1: A = [3, 2, 4]
Input 2: A = [5, 1, 3, 6]

Example Output
Output 1: [1, 5]
Output 2: [2, 4]

Example Explanation
For Input 1:
The missing numbers are 1 and 5.

For Input 2:
The missing numbers are 2 and 4.

 */
public class FindTwoMissingNumbers {

    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 1, 3, 6));

        int n = A.size();

        bruteForce(A, n);

        optimized(A, n);
    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i <= n + 2; i++) {

            boolean isPresent = false;

            for (int j = 0; j < n; j++) {

                if (i == A.get(j)) {
                    isPresent = true;
                    break;
                }

            }

            if (!isPresent) res.add(i);

        }

        System.out.println(res);

        // Time O(N^2);
        // Space O(1);

    }

    public static void optimized(ArrayList<Integer> A, int n) {

        int xor = 0;

        for (int i = 1; i <= n + 2; i++) {
            xor ^= i;
        }

        for (int i = 0; i < n; i++) {
            xor ^= A.get(i);
        }

        int index = -1;

        for (int i = 0; i < 32; i++) {

            if ((xor & (1 << i)) > 0) {
                index = i;
                break;
            }

        }

        int ansOne = 0;
        int ansTwo = 0;

        for (int i = 1; i <= n + 2; i++) {

            if ((i & (1 << index)) > 0) ansOne ^= i;

            else ansTwo ^= i;

        }

        for (int i = 0; i < n; i++) {

            if ((A.get(i) & (1 << index)) > 0) ansOne ^= A.get(i);

            else ansTwo ^= A.get(i);

        }

        ArrayList<Integer> res = new ArrayList<>();

        if (ansOne < ansTwo) {
            res.add(ansOne);
            res.add(ansTwo);
        } else {
            res.add(ansTwo);
            res.add(ansOne);
        }

        System.out.println(res);

        // Time O(N);
        // Space O(1);

    }

}
