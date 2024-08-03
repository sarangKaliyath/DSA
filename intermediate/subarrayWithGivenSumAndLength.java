import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

Given an array A of length N. Also given are integers B and C.
Return 1 if there exists a subarray with length B having sum C and 0 otherwise.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 104
1 <= B <= N
1 <= C <= 109

Input Format
First argument A is an array of integers.
The remaining arguments B and C are integers

Output Format
Return 1 if such a subarray exist and 0 otherwise

Example Input
Input 1:
A = [4, 3, 2, 6, 1]
B = 3
C = 11

Input 2:
A = [4, 2, 2, 5, 1]
B = 4
C = 6



Example Output
Output 1: 1
Output 2: 0

Example Explanation
Explanation 1: The subarray [3, 2, 6] is of length 3 and sum 11.
Explanation 2: There are no such subarray.

 */
public class subarrayWithGivenSumAndLength {

    public static void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 3, 2, 6, 1));
        int B = 3;
        int C = 11;

        int n = A.size();

        bruteForce(A, B, C, n);
        slidingWindowWithWhileLoop(A, B, C, n);
        slidingWindow(A, B, C, n);
    }

    public static void bruteForce(ArrayList<Integer> A, int B, int C, int n){

        int res = 0;

        for(int i = 0; i < n; i++){

            int sum = 0;

            for(int j = i; j < n; j++){

                sum+= A.get(j);

                if(j - i + 1 == B &&  sum == C) {
                    res = 1;
                    break;
                }

            }

        }

        System.out.println("res : " + res);

        // Time O(n^2);
        // Space O(1);
    }

    public  static  void slidingWindowWithWhileLoop(ArrayList<Integer> A, int B, int C, int n){

        int res = 0;
        int sum = 0;

        for(int i = 0; i < B; i++){
            sum+= A.get(i);
        }

        if(sum == C) {
            res = 1;
        }
        else {

            int left = 1;
            int right = B;

            while (right < n) {

                sum = sum - A.get(left - 1) + A.get(right);

                if (sum == C) {
                    res = 1;
                    break;
                }

                left++;
                right++;
            }
        }

        System.out.println("res : " + res);

        // Time O(N);
        // Space O(1);
    }

    public  static  void  slidingWindow(ArrayList<Integer> A, int B, int C, int n){

        int sum = 0;
        int res = 0;

        for(int i = 0; i < B; i++){
            sum+= A.get(i);
        }

        if(sum == C) res = 1;

        for(int i = 1; i < n - B + 1; i++){

            sum = sum - A.get(i - 1) + A.get(B + i - 1);

            if(sum == C){
                res = 1;
                break;
            }
        }

        System.out.println("res : " + res);

        // Time O(N);
        // Space O(1);
    }
}
