package recursion;

/*

Problem Description
You are given an array A. Print the elements of the array using recursion.

NOTE :
    You are required to not use any loops, You can create new functions.
    Don't change the signature of the function PrintArray.
    Print a new empty line after printing the output.

Problem Constraints
1 <= | A | <= 100
-1000 <= A[i] <= 1000

Input Format
One line containing the array A

Output Format
Print the elements of the array in the sequential order.

Example Input
Input 1 : A = [6, -2, 5, 3]
Input 2 : A = [1]

Example Output
Output 1 : 6 -2 5 3
Output 2 : 1

 */

import java.util.ArrayList;
import java.util.Arrays;

public class PrintArrayUsingRecursion {

    public  static void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1));

        recursion(A, 0, A.size());

    }

    public  static void recursion (ArrayList<Integer> A, int i, int n){

        if(i == n) return;

        System.out.print(A.get(i) + " ");

        recursion(A, i + 1, n);
    }
}
