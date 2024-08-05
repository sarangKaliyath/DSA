import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given a 2D integer array A, return the transpose of A.
The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000

Input Format
First argument is a 2D matrix of integers.

Output Format
You have to return the Transpose of this 2D matrix.

Example Input
Input 1: A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2: A = [[1, 2],[1, 2],[1, 2]]

Example Output
Output 1: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2: [[1, 1, 1], [2, 2, 2]]

Example Explanation

Explanation 1:
Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].

Explanation 2:
After transposing the matrix, A becomes [[1, 1, 1], [2, 2, 2]]
 */

public class transposeOfAMatrix {

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(4, 5, 6)),
                new ArrayList<>(Arrays.asList(7, 8, 9))
        ));

        int n = A.size();
        int m = A.get(0).size();

//        ifMatrixIsNxN(A, n, m);
        ifMatrixNxM(A, n, m);

    }

    public static void ifMatrixIsNxN(ArrayList<ArrayList<Integer>> A, int n, int m) {

        for (int i = 0; i < n; i++) {

            for (int j = i; j < m; j++) {

                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i));
                A.get(j).set(i, temp);

            }

        }

        System.out.println(A);

        // Time O(N ^ M);
        // Space O(1);

    }

    public static void ifMatrixNxM(ArrayList<ArrayList<Integer>> A, int n, int m) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                res.get(j).add(A.get(i).get(j));
            }

        }

        System.out.println("res : " + res);

        // Time O(N ^ M);
        // Space O(N)

    }
}
