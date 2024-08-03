import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given an integer array A of size N.
You have to perform B operations. In one operation,
you can remove either the leftmost or the rightmost element of the array A.
Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
        Remove 3 elements from front and 0 elements from the back, OR
        Remove 2 elements from front and 1 element from the back, OR
        Remove 1 element from front and 2 elements from the back, OR
        Remove 0 elements from front and 3 elements from the back.

Problem Constraints
1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you removed.

Example Input
Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3

Input 2:
 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4

Example Output
Output 1: 8
Output 2: 9

Example Explanation
Explanation 1: Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2: Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9

 */
public class PickFromBothSides {

    public static  void main (String args[]){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 3, -1, 4, 2, 1));
        int B = 4;

        int n = A.size();

        ArrayList<Integer> prefixSum = new ArrayList<>(n);
        ArrayList<Integer> suffixSum = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            prefixSum.add(null);
            suffixSum.add(null);
        }

        prefixSum.set(0, A.get(0));
        suffixSum.set(n - 1, A.get(n - 1));

        for(int i = 1; i < n; i++){
            prefixSum.set(i, prefixSum.get(i - 1) + A.get(i));
        }

        for(int i = n - 2; i >=0; i--){
            suffixSum.set(i, suffixSum.get(i + 1) + A.get(i));
        }

        /*
            res is handling the edge cases where,
            we are comparing the sum of the first B elements sum with,
            last B elements and storing the max value in res;

            i.e if A = [5, -2, 3, 1, 2] & B = 3
                the prefixSum at index 2 i.e ( B - 1 ), will be:
                    5 - 2 + 3 = 6;
                the suffixSum at index 3 i.e ( n - B ), will be:
                    2 + 1 + 3 = 6;
                thus,
                    res = 6;
         */
        int res = Math.max(prefixSum.get(B - 1), suffixSum.get(n - B));

        for(int i = 1; i < B; i++){
            int sum = prefixSum.get(i - 1) + suffixSum.get(n - B + i);
            res = Math.max(res, sum);
        }

        System.out.println(res);

    }
}
