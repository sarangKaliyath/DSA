/*

Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
Find and return the length of the longest consecutive 1’s that can be achieved.

Input Format
The only argument given is string A.

Output Format
Return the length of the longest consecutive 1’s that can be achieved.

Constraints
1 <= length of string <= 1000000
A contains only characters 0 and 1.

For Example

Input 1: A = "111000"
Output 1: 3

Input 2: A = "111011101"
Output 2: 7

 */
public class lengthOfLongestConsecutiveOnes {

    public static void main (String args []){

        String A = "111011101";

        int n = A.length();

        int count = 0;

        for(int i = 0; i < n; i++){
            count += Character.getNumericValue(A.charAt(i));
        }

        if(count == n) {
            System.out.println("n : " + n);
        }
        else {

            int res = 0;

            for (int i = 0; i < n; i++) {

                if (A.charAt(i) == '0') {

                    int left = 0;
                    int right = 0;

                    for (int j = i - 1; j >= 0; j--) {
                        if (A.charAt(j) == '1') left++;
                        else break;
                    }

                    for (int j = i + 1; j < n; j++) {
                        if (A.charAt(j) == '1') right++;
                        else break;
                    }

                    if (left + right == count) {
                        res = Math.max(res, left + right);
                    } else {
                        res = Math.max(res, left + right + 1);
                    }

                }
            }

            System.out.println("res : " + res);
        }
    }
}
