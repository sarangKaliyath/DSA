import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description
Given an array of size N, find the majority element.
The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.

Problem Constraints
1 <= N <= 5*10^5
1 <= num[i] <= 10^9

Input Format
Only argument is an integer array.

Output Format
Return an integer.

Example Input
Input 1: [2, 1, 2]
Input 2: [1, 1, 1]

Example Output
Input 1: 2
Input 2: 1

Example Explanation
For Input 1: 2 occurs 2 times which is greater than 3/2.
For Input 2: 1 is the only element in the array, so it is majority.
 */
public class majorityElement {

    public static  void main (String args []){

        List<Integer> A = new ArrayList<>(Arrays.asList(2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2));

        int n = A.size();

        bruteForce(A, n);

//        secondApproach(A, n);

        mooreVotingAlgorithm(A, n);
    }

    public static void bruteForce(List<Integer> A, int n){

        int maxVal = -1;
        int maxCount = 0;

        for(int i = 0; i < n; i++ ){

            int count = 0;

            for(int j = i; j < n; j++){
                if(A.get(i) == A.get(j)) count++;
            }

            if(count > maxCount && count > n/2){
                maxCount = count;
                maxVal = A.get(i);
            }

        }

        System.out.println("maxVal : " + maxVal + " maxCount : " + maxCount);

        // Time O(N^2);
        // Space O(1);
    }

    public static  void secondApproach (List<Integer> A, int n){

        Collections.sort(A);

        if(n == 1) {
            System.out.println("maxVal : " + A.get(0) + " maxCount : " + 1);
        }
        else {


            int maxVal = -1;
            int maxCount = 0;
            int count = 1;

            for (int i = 0; i < n - 1; i++) {

                if (A.get(i) != A.get(i + 1)) {
                    count = 1;
                } else {
                    count++;
                    if (count > maxCount && count > n / 2) {
                        maxCount = count;
                        maxVal = A.get(i);
                    }
                }

            }

            System.out.println("maxVal : " + maxVal + " maxCount : " + maxCount);
        }

        // Time O(NlogN);
        // Space O(N);
    }

    public static void mooreVotingAlgorithm (List<Integer> A, int n){

        int maxVal = A.get(0);
        int frequency = 1;

        for(int i = 1; i < n; i++){

            if(frequency == 0){
                maxVal = A.get(i);
                frequency = 1;
            }

            else if(maxVal == A.get(i)) frequency++;

            else frequency--;


        }

        int count = 0;

        for(int i = 0; i < n; i++){
          if(maxVal == A.get(i)) count++;
        }

        if(count > n/2) {
            System.out.println("maxVal : " + maxVal + " maxCount : " + count);
        }
        else {
            System.out.println("maxVal : " + -1 + " maxCount : " + 0);
        }

        // Time O(N);
        // Space O(1);

    }
}
