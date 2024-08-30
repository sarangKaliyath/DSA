import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000
-109 <= A[i] <= 10^9

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the first missing positive integer.

Example Input
Input 1: [1, 2, 0]
Input 2: [3, 4, -1, 1]
Input 3: [-8, -7, -6]

Example Output
Output 1: 3
Output 2: 2
Output 3: 1

Example Explanation

Explanation 1:
A = [1, 2, 0]
First positive integer missing from the array is 3.

Explanation 2:
A = [3, 4, -1, 1]
First positive integer missing from the array is 2.

Explanation 3:
A = [-8, -7, -6]
First positive integer missing from the array is 1.
 */
public class FirstMissingInteger {

    public static void main(String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3, 1, 2));

        int n = A.size();

        int index =  optimized(A, n);
        System.out.println(index);
    }

    public static int optimized(ArrayList<Integer> A, int n){

        for(int i  = 0; i < n; i++){
            if(A.get(i) < 1){
                A.set(i, n + 2);
            }
        }

        for(int i = 0; i < n; i++){

            int val = Math.abs(A.get(i));

            if(val >= 1 && val <= n ){

                int index = val - 1;

                if(A.get(index) > 0){
                    A.set(index, A.get(index) * -1);
                }

            }

        }

        for(int i = 0; i < n; i++){
            if(A.get(i) > 0){
                return i + 1;
            }
        }

        return n + 1;

    }
}
