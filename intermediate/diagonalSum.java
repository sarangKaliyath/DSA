import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).

Problem Constraints
1 <= N <= 103
-1000 <= A[i][j] <= 1000

Input Format
First and only argument is a 2D integer matrix A.

Output Format
Return an integer denoting the sum of minor diagonal elements.

Example Input

Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]

Input 2:
 A = [[3, 2],
      [2, 3]]

Example Output

Output 1: -5
Output 2: 4

Example Explanation

Explanation 1:
 A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5

Explanation 2:
 A[1][2] + A[2][1] = 2 + 2 = 4
 */
public class diagonalSum {

    public static void main (String args []){

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, -2, -3)),
                new ArrayList<>(Arrays.asList(-4, 5, -6)),
                new ArrayList<>(Arrays.asList(-7, -8, 9))
        ));

        int n = A.size();
        int m = A.get(0).size();
        int sum = 0;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(i + j == m - 1) sum+= A.get(i).get(j);

            }

        }

        System.out.println("sum : " + sum);


        // Time O(N^2); Space O(1);
    }

}
