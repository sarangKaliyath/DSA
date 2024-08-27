import java.util.ArrayList;
import java.util.Arrays;

/*

Problem Description
Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

NOTE:
    If two rows have the maximum number of 1 then return the row which has a lower index.
    Rows are numbered from top to bottom and columns are numbered from left to right.
    Assume 0-based indexing.
    Assume each row to be sorted by values.
    Expected time complexity is O(rows + columns).

Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 1

Input Format
The only argument given is the integer matrix A.

Output Format
Return the row with the maximum number of 1.

Example Input
Input 1:
 A = [   [0, 1, 1]
         [0, 0, 1]
         [0, 1, 1]   ]
Input 2:
 A = [   [0, 0, 0, 0]
         [0, 0, 0, 1]
         [0, 0, 1, 1]
         [0, 1, 1, 1]    ]

Example Output
Output 1: 0
Output 2: 3

Example Explanation

Explanation 1:
 Row 0 has maximum number of 1s.
Explanation 2:
 Row 3 has maximum number of 1s.

 */
public class RowWithMaximumNumberOfOnes {

    public static void main (String args []){

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(0, 0, 0, 1)),
                new ArrayList<>(Arrays.asList(0, 0, 1, 1)),
                new ArrayList<>(Arrays.asList(0, 1, 1, 1))
        ));

        int n = A.size();
        int m = A.get(0).size();

        int i = 0;
        int j = m - 1;

        int maxCount = 0;
        int count = 0;
        int maxCountIndex = 0;

        while (i < n && j >= 0){

            if(A.get(i).get(j) == 1){
                count++;
                if(count > maxCount){
                    maxCount = count;
                    maxCountIndex = i;
                }
                j--;
            }
            else i++;

        }

        System.out.println("MaxCount : " + maxCount + " Index : " + maxCountIndex);


    }
}
