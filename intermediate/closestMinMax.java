import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array A, find the size of the smallest subarray
such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.

Problem Constraints
1 <= |A| <= 2000

Input Format
First and only argument is vector A

Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array

Example Input
Input 1: A = [1, 3, 2]
Input 2: A = [2, 6, 1, 6, 9]

Example Output
Output 1: 2
Output 2: 3

Example Explanation
Explanation 1:Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2: Take the last 3 elements of the array.

 */
public class closestMinMax {
    public static void main(String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 1));

        int n = A.size();

        int[] minMax = findMinMax(A, n);

        int min = minMax[0];
        int max = minMax[1];

        bruteForce(A, n, min, max);
        optimized(A, n, min, max);
        bestApproach(A, n, min, max);

    }

    public static  int[] findMinMax(ArrayList<Integer> A, int n){

        int min = A.get(0);
        int max = A.get(0);

        for(int i = 1; i < n; i++){
            int value = A.get(i);
            if(value < min) min = value;
            if(value > max) max = value;
        }

        return new int[]{min, max};

        // Time O(N);
        // Space O(1);
    }



    public static void bruteForce(ArrayList<Integer> A, int n, int min, int max){

        int res = n;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                boolean minFlag = false;
                boolean maxFlag  = false;

                for(int k = i; k <= j; k++){
                    if(A.get(k) == min){
                        minFlag = true;
                    }
                    if(A.get(k) == max) {
                        maxFlag = true;
                    }
                }

                if(minFlag && maxFlag){
                    res = Math.min(res, j - i + 1);
                }

            }

        }

        System.out.println("bruteForce : " +res);

        // Time O(N^3);
        // Space O(1);
    }

    public  static  void optimized(ArrayList<Integer> A, int n, int min , int max){

        int res = n;

        for(int i = 0; i < n; i++){

            boolean minFlag = false;
            boolean maxFlag = false;

            for(int j = i; j < n; j++){

                if(A.get(j) == min) minFlag = true;
                if(A.get(j) == max) maxFlag = true;

                if(minFlag && maxFlag) res = Math.min(res, j - i + 1);

            }

        }

        System.out.println("optimized : " + res);

        // Time O(N^2);
        // Space O(1);
    }

    public static void bestApproach (ArrayList<Integer> A, int n, int min , int max){

        int res = n;
        int maxIndex = -1;
        int minIndex = -1;

        for(int i = 0; i < n; i++){
            if(A.get(i) == min){
                minIndex = i;

                if(maxIndex != -1) res = Math.min(res, (minIndex - maxIndex + 1));
            }
            if(A.get(i) == max){
                maxIndex = i;

                if(minIndex != -1) res = Math.min(res, (maxIndex - minIndex + 1));
            }
        }

        System.out.println("best Approach : " + res);

        // Time O(N);
        // Space O(1);
    }
}
