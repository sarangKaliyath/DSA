package recursion;

import java.util.ArrayList;
import java.util.Arrays;

/*

Problem Description
Given an array of integers A with N elements and a target integer B,
the task is to find all the indices at which B occurs in the array.

Note: The problem encourages recursive logic for learning purposes.
Although the online judge doesn't enforce recursion,
it's recommended to use recursive solutions to align with the question's spirit.

Problem Constraints
1 <= N <= 10^3
1 <= A[i] <= 10^3
1 <= B <= 10^3
It is guaranteed that the target B, exist atleast once in the Array A.

Input Format
First Argument in an Array of Integers, A.
Second Argument is the Target, B.

Output Format
Return the sorted array of indices.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 1

Input 2:
A = [8, 9, 5, 6, 5, 5]
B = 5

Example Output
Output 1: [0]
Output 2: [2, 4, 5]

Example Explanation
Explanation 1:
The Target, 1 occurs on Index = 0.  So returning [0]

Explanation 2:
Here, the target 5 occurs at indexes [2, 4, 5].

 */
public class AllIndicesOfArray {

    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 9, 5, 6, 5, 5));
        int B = 5;

        int[] ans = recursion(A, B, 0, 0);

        int n = ans.length;

        ArrayList<Integer> res= new ArrayList<>(n);

        for(int value : ans){
            res.add(value);
        }

        System.out.print(res);
    }

    public static int[] recursion(ArrayList<Integer> A, int B, int index, int count) {
        if (index == A.size()) return new int[count];

        if (A.get(index) == B) {
            int ans[] = recursion(A, B, index + 1, count + 1);
            ans[count] = index;
            return ans;
        } else {
            return recursion(A, B, index + 1, count);
        }
    }

}
