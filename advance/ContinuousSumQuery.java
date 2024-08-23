import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
There are A beggars sitting in a row outside a temple.
Each beggar initially has an empty pot. When the devotees come to the temple,
they donate some amount of coins to these beggars.
Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
Given the amount P donated by each devotee to the beggars ranging from L to R index,
where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B

Problem Constraints
1 <= A <= 2 * 105
1 <= L <= R <= A
1 <= P <= 103
0 <= len(B) <= 105

Input Format
The first argument is a single integer A.
The second argument is a 2D integer array B.

Output Format
Return an array(0 based indexing) that stores the total number of coins in each beggars pot.

Example Input

Input 1:-
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

Example Output

Output 1:-
10 55 45 25 25

Example Explanation

Explanation 1:-
First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]

 */
public class ContinuousSumQuery {

    public static void main (String args []){

        int A = 5;
        ArrayList<ArrayList<Integer>> Q = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 10)),
                        new ArrayList<>(Arrays.asList(2, 3, 20)),
                        new ArrayList<>(Arrays.asList(2, 5, 25))
                )
        );
        int n = Q.size();

        bruteForce(A, Q, n);

        optimized(A, Q);

    }

    public static void bruteForce(int A, ArrayList<ArrayList<Integer>> Q, int n){

        ArrayList<Integer> a = new ArrayList<>(A);

        for(int i = 0; i < A; i++){
            a.add(0);
        }

        for(int i = 0; i < n; i++){

            int left = Q.get(i).get(0) - 1;
            int right = Q.get(i).get(1);
            int val = Q.get(i).get(2);


            for(int j = left; j < right; j++){
                a.set(j, a.get(j) + val);
            }

        }

        System.out.println(a);

        // Time O(Q * N);
        // Space O(N);
    }
    public static void optimized(int A, ArrayList<ArrayList<Integer>> B){

        ArrayList<Integer> a = new ArrayList<>(A);

        for(int i = 0; i < A; i++){
            a.add(0);
        }

        for(int i = 0; i < B.size(); i++){

            int start = B.get(i).get(0) - 1;
            int end = B.get(i).get(1);
            int val = B.get(i).get(2);

            a.set(start, a.get(start) + val);

            if(end < a.size()){
                a.set(end, a.get(end) - val);
            }

        }

        for(int i = 1; i < a.size(); i++){
            a.set(i, a.get(i - 1) + a.get(i));
        }

        System.out.println(a);

        // Time O(Q + N);
        // Space O(N);
    }
}
