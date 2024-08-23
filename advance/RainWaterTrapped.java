import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description

Imagine a histogram where the bars' heights are given by the array A.
Each bar is of uniform width, which is 1 unit. When it rains,
water will accumulate in the valleys between the bars.
Your task is to calculate the total amount of water that can be trapped in these valleys.

Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 105

Input Format
First and only argument is the Integer Array, A.

Output Format
Return an Integer, denoting the total amount of water that can be trapped in these valleys

Example Input

Input 1: A = [0, 1, 0, 2]
Input 2: A = [1, 2]



Example Output

Output 1: 1
Output 2: 0

Example Explanation

Explanation 1:
1 unit is trapped on top of the 3rd element.

Explanation 2:
No water is trapped.Problem Description

Imagine a histogram where the bars' heights are given by the array A.
Each bar is of uniform width, which is 1 unit. When it rains,
water will accumulate in the valleys between the bars.
Your task is to calculate the total amount of water that can be trapped in these valleys.

Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 105

Input Format
First and only argument is the Integer Array, A.

Output Format
Return an Integer, denoting the total amount of water that can be trapped in these valleys

Example Input

Input 1: A = [0, 1, 0, 2]
Input 2: A = [1, 2]



Example Output

Output 1: 1
Output 2: 0

Example Explanation

Explanation 1:
1 unit is trapped on top of the 3rd element.

Explanation 2:
No water is trapped.

 */
public class RainWaterTrapped {

    public static void main (String args []){

        List<Integer> A = new ArrayList<>(Arrays.asList(56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77));

        int n = A.size();

        bruteForce(A , n);

        int totalTrappedWatter = optimized(A, n);
        System.out.println("totalTrappedWatter : " + totalTrappedWatter);
    }

    public static void bruteForce (List<Integer> A, int n){

        int totalWatterTrapped = 0;

        for(int i = 1; i < n - 1; i++){

            int maxLeftHeight = A.get(0);

            for(int left = i - 1; left >= 0; left--){
                if(A.get(left) > maxLeftHeight) maxLeftHeight = A.get(left);
            }

            int maxRightHeight = 0;

            for(int right = i + 1; right < n; right++){
                if(A.get(right) > maxRightHeight) maxRightHeight = A.get(right);
            }

            int val = Math.min(maxLeftHeight, maxRightHeight) - A.get(i);

            if(val > 0) totalWatterTrapped += val;
        }

        System.out.println("totalWatterTrapped : " + totalWatterTrapped);

        // Time O(N^2);
        // Space O(1);
    }

    public static int optimized (List<Integer> A, int n){

        int totalWaterTrapped = 0;

        int [] leftMax = new int[n];
        leftMax[0] = A.get(0);

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], A.get(i));
        }

        int [] rightMax = new int [n];
        rightMax[n - 1] = A.get(n - 1);

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
        }

        for(int i = 1; i < n - 1; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - A.get(i);

            if(water > 0) totalWaterTrapped += water;
        }

        return totalWaterTrapped;
    }

}
