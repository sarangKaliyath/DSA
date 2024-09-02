package BitManipulation;

import java.util.*;

/*
Problem Description
Given an array of integers, every element appears thrice except for one, which occurs once.
Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Problem Constraints
    2 <= A <= 5*10^6
    0 <= A <= INTMAX

Input Format
First and only argument of input contains an integer array A.

Output Format
Return a single integer.

Example Input
Input 1: A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2: A = [0, 0, 0, 1]

Example Output

Output 1:4
Output 2: 1

Example Explanation
Explanation 1:
 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 */
public class SingleNumberTwo {

    public static void main (String args []){

        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));

        int n = A.size();

        bruteForce(A, n);
        optimized(A, n);
    }

    public static void bruteForce (List<Integer> A , int n){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int key = A.get(i);

            if(map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }

        int res = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            if(entry.getValue() == 1){
                res = entry.getKey();
            }

        }

        System.out.println(res);

        // Time O(N);
        // Space O(N);
    }

    public static void optimized (List<Integer> A, int n){

        int res = 0;

        for(int i = 0; i < 32; i++){

            int count = 0;

            for(int j = 0; j < n; j++){
                if((A.get(j) & (1 << i)) > 0) count++;
            }

            if(count % 3 == 1){
                res  |= (1<<i);
            }

        }

        System.out.println(res);

        // Time O(N);
        // Space O(1);

    }

}
