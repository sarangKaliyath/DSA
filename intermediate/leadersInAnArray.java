import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A containing N distinct integers,
you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^8

Input Format
There is a single input argument which a integer array A

Output Format
Return an integer array denoting all the leader elements of the array.

Example Input
Input 1: A = [16, 17, 4, 3, 5, 2]
Input 2: A = [5, 4]

Example Output
Output 1: [17, 2, 5]
Output 2: [5, 4]

Example Explanation
Explanation 1:
 Element 17 is strictly greater than all the elements on the right side to it.
 Element 2 is strictly greater than all the elements on the right side to it.
 Element 5 is strictly greater than all the elements on the right side to it.
 So we will return these three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.

Explanation 2:
 Element 5 is strictly greater than all the elements on the right side to it.
 Element 4 is strictly greater than all the elements on the right side to it.
 So we will return these two elements i.e [5, 4], we can also any other ordering.
 */
public class leadersInAnArray {

    public static void  main (String args[]){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 12,3 , 3, 4, 5, 56, 6, 1, 1));

        int n = A.size();

        bruteforce(A, n);
        optimized(A, n);

    }

    public static void bruteforce(ArrayList<Integer> A, int n){

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            boolean isLeader = true;

            for(int j = i + 1; j < n; j++){

                if(A.get(j) >= A.get(i)) isLeader = false;

            }
            if(isLeader) res.add(A.get(i));
        }
        System.out.println("res : " + res);
    }

    public  static  void optimized(ArrayList<Integer> A, int n){

        ArrayList<Integer> res = new ArrayList<>();
        int max = -1;


        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1){
                max = A.get(i);
                res.add(A.get(i));
            }
            else {
                if(max < A.get(i)){
                    max = A.get(i);
                    res.add(max);
                }
            }
        }

        System.out.println("res : " + res);

    }

}
