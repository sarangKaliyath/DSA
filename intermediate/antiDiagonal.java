import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9

Input Format
Only argument is a 2D array A of size N * N.

Output Format
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.

Example Input

Input 1:
1 2 3
4 5 6
7 8 9

Input 2:
1 2
3 4

Example Output

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0

Output 2:
1 0
2 3
4 0

Example Explanation

For input 1:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].

For input 2:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].

 */
public class antiDiagonal {

    public static void main (String args []){

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 2, 3)),
            new ArrayList<>(Arrays.asList(4, 5, 6)),
            new ArrayList<>(Arrays.asList(7, 8, 9))
        ));

        int n = A.size();
        int m = A.get(0).size();

        antiDiagonalArray(A, n, m);
        antiDiagonalString(A, n, m);

    }

    public static  void antiDiagonalString(ArrayList<ArrayList<Integer>> A, int n, int m){

        for(int j = 0; j < m; j++){

            String str = "";

            int r = 0; int c = j;

            while( r < n && c >= 0 ){

                str+= A.get(r).get(c) + " ";

                r++; c--;

            }

            System.out.println(str);

        }

        for(int i = 1; i < n; i++){

            int r = i;
            int c = m - 1;
            String str = "";

            while ( r < n && c >= 0){

                str += A.get(r).get(c) + " ";

                r++;
                c--;

            }

            System.out.println(str);

        }

    }

    public static void antiDiagonalArray(ArrayList<ArrayList<Integer>> A, int n, int m){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        for(int j = 0; j < m; j++){

            ArrayList<Integer> temp = new ArrayList<>();

            int r = 0; int c = j;

            while( r < n && c >= 0 ){

                 temp.add(A.get(r).get(c));

                r++; c--;

            }

            res.add(temp);

        }

        for(int i = 1; i < n; i++){

            ArrayList<Integer> temp = new ArrayList<>();

            int r = i; int c = m - 1;

            while(r < n && c >=0){
                temp.add(A.get(r).get(c));
                r++; c--;
            }
            res.add(temp);
        }

        for(int i = 0; i < res.size(); i++){
            while (res.get(i).size() != n) res.get(i).add(0);
        }


        System.out.println("res : " + res);
    }

}
