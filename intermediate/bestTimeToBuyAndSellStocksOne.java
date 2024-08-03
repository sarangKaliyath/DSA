import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.

Problem Constraints
0 <= A.size() <= 700000
1 <= A[i] <= 107

Input Format
The first and the only argument is an array of integers, A.

Output Format
Return an integer, representing the maximum possible profit.

Example Input
Input 1: A = [1, 2]
Input 2: A = [1, 4, 5, 2, 4]

Example Output
Output 1: 1
Output 2: 4

Example Explanation
Explanation 1: Buy the stock on day 0, and sell it on day 1.
Explanation 2: Buy the stock on day 0, and sell it on day 2.

 */
public class bestTimeToBuyAndSellStocksOne {

    public static  void main (String args[]){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 4));

        int n = A.size();

        if(n == 1 || n == 0){
            System.out.println("profit : " + 0);
        }
        else{
            bruteForce(A, n);
            optimized(A, n);
        }


    }

    public static  void bruteForce(ArrayList<Integer> A, int n){

        int maxProfit = 0;

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){
                int diff = A.get(j) - A.get(i);
                if(diff  > maxProfit) maxProfit = diff;
            }

        }

        System.out.println("profit : " + maxProfit);

    }

    public static void optimized(ArrayList<Integer> A, int n){

        int maxProfit = 0;
        int max = A.get(n - 1);

        for(int i = n - 2; i >= 0; i--){

            int currVal = A.get(i);

            int diff = max - currVal;

            if(diff > maxProfit){
                maxProfit = diff;
            }

            if(currVal > max) {
                max = currVal;
            }

        }

        System.out.println("profit : " + maxProfit);

    }

}
