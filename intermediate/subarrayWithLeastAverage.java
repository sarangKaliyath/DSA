import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array A of size N, find the subarray of size B with the least average.

Problem Constraints
1 <= B <= N <= 10^5
-105 <= A[i] <= 10^5

Input Format
First argument contains an array A of integers of size N.
Second argument contains integer B.

Output Format
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.

Example Input

Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3

Input 2:
A = [3, 7, 5, 20, -10, 0, 12]
B = 2

Example Output
Output 1: 3
Output 2: 4

Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.

Explanation 2:
Subarray between [4, 5] has minimum average

 */
public class subarrayWithLeastAverage {

    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 7, 90, 20, 10, 50, 40));
        int B = 3;

        int n = A.size();

        bruteForce(A, B, n);
        slidingWindow(A, B, n);

    }

    public static void bruteForce(ArrayList<Integer> A, int B, int n) {

        int minAverage = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += A.get(j);

                int len = j - i + 1;

                if (len == B && sum < minAverage) {
                    minAverage = sum;
                    res = i;
                }
            }
        }

        System.out.println("res : " + res);

        // Time O(N^2);
        // Space O(1);

    }

    public static void slidingWindow(ArrayList<Integer> A, int B, int n) {

        int sum = 0;

        for (int i = 0; i < B; i++) {
            sum += A.get(i);
        }

        int index = 0;
        double minAverage = (double) sum / B;

        int left = 1;
        int right = B;

        while (right < n) {

            sum = sum - A.get(left - 1) + A.get(right);
            double avg = (double) sum / B;

            if (avg < minAverage) {
                minAverage = avg;
                index = left;
            }

            left++;
            right++;
        }

        System.out.println("index : " + index);

        // Time O(N);
        // Space O(1);
    }
}
