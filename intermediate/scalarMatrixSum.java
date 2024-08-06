import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given a matrix A and and an integer B,
you have to perform scalar multiplication of matrix A with an integer B.

Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000
1 <= B <= 1000

Input Format
First argument is 2D array of integers A representing matrix.
Second argument is an integer B.

Output Format
You have to return a 2D array of integers after doing required operations.

Example Input
Input 1:
A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
B = 2

Input 2:
A = [[1]]
B = 5

Example Output
Output 1:
[[2, 4, 6],
[8, 10, 12],
[14, 16, 18]]

Output 2:
[[5]]

Example Explanation
Explanation 1:

==> ( [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ) * 2
==> [[2*1, 2*2, 2*3],
     [2*4, 2*5, 2*6],
     [2*7, 2*8, 2*9]]
==> [[2,   4,  6],
     [8,  10, 12],
     [14, 16, 18]]

Explanation 2:

==> ( [[1]] ) * 5
==> [[5*1]]
==> [[5]]

 */
public class scalarMatrixSum {

    public static void main (String args []){

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(4, 5, 6)),
                new ArrayList<>(Arrays.asList(7, 8, 9))
        ));

        int B = 2;

        int n = A.size();
        int m = A.get(0).size();

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                int val = A.get(i).get(j);

                A.get(i).set(j, val * B);

            }

        }

        System.out.println("A : " + A);

        // Time O(N * M); Space O(1);

    }

}
