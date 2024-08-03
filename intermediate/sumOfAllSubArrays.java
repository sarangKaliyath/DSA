import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array,
which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.
Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.

Problem Constraints
1 <= N <= 105
1 <= Ai <= 10 4

Input Format
The first argument is the integer array A.



Output Format
Return a single integer denoting the sum of all subarray sums of the given array.

Example Input
Input 1: A = [1, 2, 3]
Input 2: A = [2, 1, 3]

Example Output
Output 1: 20
Output 2: 19

Example Explanation

Explanation 1:
The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20

Explanation 2:
The different subarrays for the given array are: [2], [1], [3], [2, 1], [1, 3], [2, 1, 3].
Their sums are: 2 + 1 + 3 + 3 + 4 + 6 = 19

 */
public class sumOfAllSubArrays {

    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3));

        int n = A.size();

        bruteForce(A, n);
        usingPrefixSum(A, n);
        carryForward(A, n);
        contributionTechnique(A, n);
    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        long res = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                long sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += A.get(k);
                }

                res += sum;

            }

        }

        System.out.println("res : " + res);

        // Time O(N^3);
        // Space O(1);
    }

    public  static void usingPrefixSum(ArrayList<Integer> A, int n){

        ArrayList<Integer> prefixSum = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            prefixSum.add(null);
        }

        prefixSum.set(0, A.get(0));

        for(int i = 1; i < n; i++){
            prefixSum.set(i, prefixSum.get(i - 1) + A.get(i));
        }

        long res = 0;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                long sum = prefixSum.get(j);

                if(i != 0) {
                    sum = sum - prefixSum.get(i - 1);
                }

                res+= sum;

            }

        }

        System.out.println("res : " + res);

        // Time O(N^2);
        // Space O(N);
    }

    public  static  void carryForward (ArrayList<Integer> A, int n){

        long res = 0;

        for(int i = 0; i < n; i++){

            long sum = 0;

            for(int j = i; j < n; j++){

                sum+= A.get(j);

                res+= sum;

            }

        }

        System.out.println("res : " + res);

        // Time O(N^2);
        // Space O(1);
    }

    public  static  void contributionTechnique(ArrayList<Integer> A,int n){

        long res = 0;

        for(int i = 0; i < n; i++){

            long frequency = ( i + 1) * ( n - i);

            res += frequency * A.get(i);

        }

        System.out.println("res : " + res);

        // Time O(N);
        // Space O(1);
    }
}
