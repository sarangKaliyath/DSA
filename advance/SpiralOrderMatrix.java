import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A

Output Format
Return a 2-D matrix which consists of the elements added in spiral order.

Example Input
Input 1: 1
Input 2: 2
Input 3: 5

Example Output

Output 1:
[ [1] ]

Output 2:
[ [1, 2],
  [4, 3] ]

Output 3:
[ [1,   2,  3,  4, 5],
  [16, 17, 18, 19, 6],
  [15, 24, 25, 20, 7],
  [14, 23, 22, 21, 8],
  [13, 12, 11, 10, 9] ]



Example Explanation

Explanation 1:
Only 1 is to be arranged.

Explanation 2:
1 --> 2
      |
      |
4<--- 3

 */
public class SpiralOrderMatrix {

    public static void main (String args []){


        int A = 5;


        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < A; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < A; i++){
            for(int j = 0; j < A; j++){
                arr.get(i).add(0);
            }
        }

        int r = 0; int c = 0;
        int val = 1; int n = A;

        while(n > 1){

            int i = r; int j = c;

            for(int k = 0; k < n - 1; k++){
                arr.get(i).set(j, val);
                j++; val++;
            }

            for(int k = 0; k < n - 1; k++){
                arr.get(i).set(j, val);
                i++; val++;
            }

            for(int k = 0; k < n - 1; k++){
                arr.get(i).set(j, val);
                j--; val++;
            }

            for(int k = 0; k < n - 1; k++){
                arr.get(i).set(j, val);
                i--; val++;
            }

            r++; c++; n -= 2;

        }

        if(n == 1){
            arr.get(r).set(c, val);
        }

        System.out.println(arr);

        // Time O(N^2);
        // Space O(N^2);
    }
}
