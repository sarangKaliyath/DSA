import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given an array A of N elements.
Find the number of triplets i,j and k such that,
i<j<k and A[i]<A[j]<A[k].

Problem Constraints
1 <= N <= 103
1 <= A[i] <= 109

Input Format
First argument A is an array of integers.

Output Format
Return an integer.

Example Input
Input 1:
A = [1, 2, 4, 3]

Input 2:
A = [2, 1, 2, 3]

Example Output
Output 1: 2
Output 2: 1

Example Explanation
For Input 1:
The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].

For Input 2:
The triplet that satisfy the conditions is [1, 2, 3].

 */
public class countingIncreasingTriplets {

    public static  void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(18,26,17,30,13,30,20,13,10,19));

        int n = A.size();

        bruteForce(A, n);

        optimized(A, n);
    }

    public static void bruteForce(ArrayList<Integer> A, int n){

        int count = 0;

        for(int i = 0; i < n - 2; i++){

            for(int j = i + 1; j < n - 1; j++){

                if(A.get(i) < A.get(j)){

                    for(int k = j + 1; k < n; k++){
                        if(A.get(j) < A.get(k)) count++;
                    }
                }
            }

        }

        System.out.println("count : " + count );

        // Time O(N^3);
        // Space O(1);

    }

    public static void optimized(ArrayList<Integer> A, int n){

        if(n < 3) {
            System.out.println("n : " + 0);
        }
        else {

            int res = 0;

            for(int center = 1; center < n - 1; center++){

                int smallerCount = 0;
                for(int left = center - 1; left >= 0; left --){
                    if(A.get(left) < A.get(center)) smallerCount++;
                }

                int largerCount = 0;

                for(int right = center + 1; right < n; right++){
                    if(A.get(right) > A.get(center)) largerCount++;
                }

                res += smallerCount * largerCount;

            }

            System.out.println("res : " + res);

        }

        // Time O(N^2);
        // Space O(1);

    }
}
