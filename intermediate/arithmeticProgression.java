import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
Problem Description

Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Problem Constraints
2 <= N <= 105
-109 <= A[i] <= 109

Input Format
The first and only argument is an integer array A of size N.

Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.

Example Input
Input 1: A = [3, 5, 1]
Input 2: A = [2, 4, 1]

Example Output
Output 1: 1
Output 2: 0

Example Explanation

Explanation 1:
 We can reorder the elements as [1, 3, 5] or [5, 3, 1] with differences 2 and -2 respectively, between each consecutive elements.

Explanation 2:
 There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class arithmeticProgression {

    public  static  void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 5));

        int n = A.size();

        int res = isProgress(A, n);

        System.out.println("res : " + res);
    }

    public static int isProgress(ArrayList<Integer> A, int n){

        Collections.sort(A);

        if(n == 2) return 1;

        int commonDifference = A.get(1) - A.get(0);

        for(int i = 1; i < n - 1; i++){

            if(A.get(i + 1) - A.get(i) != commonDifference) return -1;

        }

        return 1;
    }
}
