/*

Problem Description
You have given a string A having Uppercase English letters.
You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.

Problem Constraints 1 <= length(A) <= 105

Input Format
First and only argument is a string A.

Output Format
Return an long integer denoting the answer.

Example Input
Input 1: A = "ABCGAG"
Input 2: A = "GAB"

Example Output
Output 1: 3
Output 2: 0

Example Explanation
Explanation 1:
 Subsequence "AG" is 3 times in given string, the pairs are (0, 3), (0, 5) and (4, 5).
Explanation 2:
 There is no subsequence "AG" in the given string.

 */
public class specialSubsequenceAG {

    public static void main (String args []){

        String str = "ABCGAG";
        int n = str.length();

        bruteForce(str, n);
        optimized(str, n);

    }

    public static void bruteForce(String str, int n){
        int count = 0;

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'A'){
                for(int j = i + 1; j < n; j++){
                    if(str.charAt(j) == 'G') count++;
                }
            }
        }
        System.out.println("count : " + count);

        // Time O(N^2);
        // Space O(1);
    }
    public static void optimized(String str, int n){

        int gCount = 0;
        int resCount = 0;

        for(int i = n - 1; i >= 0; i--){

            if(str.charAt(i) == 'G') gCount++;

            if(str.charAt(i) == 'A') resCount+= gCount;
        }

        System.out.println("resCount : " + resCount);

        // Time O(N);
        // Space O(1);

    }

}
