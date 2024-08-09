import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
Problem Description

Given an integer array A, find if an integer p exists in the array such that,
the number of integers greater than p in the array equals p.

Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108

Input Format
First and only argument is an integer array A.

Output Format
Return 1 if any such integer p is present else, return -1.

Example Input

Input 1: A = [3, 2, 1, 3]
Input 2: A = [1, 1, 3, 3]

Example Output

Output 1: 1
Output 2: -1

Example Explanation

Explanation 1:
 For integer 2, there are 2 greater elements in the array.

Explanation 2:
 There exist no integer satisfying the required conditions.
 */
public class nobleInteger {

    public static void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 1, 3));

        int n = A.size();

        Collections.sort(A);

        int res = -1;

        if(A.get(n - 1) == 0) System.out.println(res);

        else {

            int i = 0;

            while (i < n - 1) {

                if ((A.get(i) != A.get(i + 1)) && ((n - 1 - i) == A.get(i))){
                    res = 1;
                    break;
                }

                i++;

            }

            System.out.println("count : " + res);

        }

    }
}
