/*
Problem Description
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.

Problem Constraints
1 <= |A| <= 1000

Input Format
The first and only argument contains the string A, consisting of lowercase English alphabets.

Output Format
Return an integer containing the answer.

Example Input
Input 1: "abobc"
Input 2: "bobob"

Example Output
Output 1: 1
Output 2: 2

Example Explanation
Explanation 1: The only occurrence is at second position.
Explanation 2: Bob occures at first and third position.

 */
public class countStringOccurrences {

    public static void main (String args []){

        String A = "bobob";
        int n = A.length();
        int count = 0;

        for(int i = 0; i < n - 2; i++){

            if(A.charAt(i) == 'b' && A.charAt(i + 1) == 'o' && A.charAt(i + 2) == 'b') count++;

        }

        System.out.println("Count : " + count);
    }
}
