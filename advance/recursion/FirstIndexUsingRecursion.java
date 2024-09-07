package recursion;


import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given an array A of size N.
Write a recursive function that returns the first index at which an integer B is found in the array.
NOTE: If B is not found anywhere in the array then return -1.

Problem Constraints
1 <= N <= 100
-1000 <= A[i] <= 1000
-1000 <= B <= 1000

Input Format
The function contains two arguments.
The first argument is the array A.
The second argument is the element B that is to be searched.

Output Format
Return the Index of B from the list in integer format if B is present in the array, else return -1.

Example Input
Input 1 :
A = [-3, 5, 6, 2]
B = 6

Input 2 :
A = [0, 1, 0, 2]
B = 3

Example Output
Ouput 1 : 2
Ouput 2 : -1

Example Explanation
For Input 1 :
At index 0 we have -3
At index 1 we have 5
At index 2 we have 6 which is equal to B

For Input 2 :
The element B = 3 is nowhere to be found in the array so we print -1
 */
public class FirstIndexUsingRecursion {

    public static  void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-3, 5, 6, 2));
        int B = 3;

        int val = findFirstIndex(A, B, 0);
        System.out.println(val);
    }

    public  static  int findFirstIndex(ArrayList<Integer> A, int B, int i){

        if(i == A.size()){
            return -1;
        }

        if(A.get(i) == B){
            return i;
        }

        return findFirstIndex(A, B, i + 1);

    }
}
