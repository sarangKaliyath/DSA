import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

You have a set of non-overlapping intervals.
You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
0 <= |intervals| <= 10^5

Input Format
First argument is the vector of intervals
second argument is the new interval to be merged

Output Format
Return the vector of intervals after merging

Example Input

Input 1:
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

Input 2:
Given intervals [1, 3], [6, 9] insert and merge [2, 6] .

Example Output
Output 1: [ [1, 5], [6, 9] ]
Output 2: [ [1, 9] ]

Example Explanation

Explanation 1:
(2,5) does not completely merge the given intervals

Explanation 2:
(2,6) completely merges the given intervals

 */
public class MergeIntervals2 {

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList());

        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 1));

        ArrayList<ArrayList<Integer>> res = approach(A, B);
        System.out.println(res);

        // Time O(N);
        // Space O(N);

    }

    public static ArrayList<ArrayList<Integer>> approach(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (n == 0) {
            res.add(B);
        } else {

            int start = A.get(0).get(0);
            int end = A.get(0).get(1);

            int bStart = B.get(0);
            int bEnd = B.get(1);

            if (bEnd < start) {
                A.add(0, B);
            } else if (bStart > A.get(n - 1).get(1)) {
                A.add(n, B);
            } else if (bStart <= start && bEnd >= A.get(n - 1).get(1)) {
                A.clear();
                A.add(B);
            } else {
                for (int i = 0; i < n; i++) {
                    int aStart = A.get(i).get(0);
                    int aEnd = A.get(i).get(1);

                    if (i < n - 1 && bStart > aEnd && bEnd < A.get(i + 1).get(0)) {
                        A.add(i + 1, B);
                        break;
                    } else if (bStart <= aEnd) {
                        A.get(i).set(0, Math.min(aStart, bStart));
                        A.get(i).set(1, Math.max(aEnd, bEnd));
                        break;
                    }
                }
            }

            n = A.size();
            start = A.get(0).get(0);
            end = A.get(0).get(1);


            for (int i = 1; i < n; i++) {

                if (A.get(i).get(0) <= end) {
                    end = Math.max(A.get(i).get(1), end);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(end);
                    res.add(temp);
                    start = A.get(i).get(0);
                    end = A.get(i).get(1);
                }

            }

            res.add(new ArrayList<>(Arrays.asList(start, end)));

        }


        return res;

    }
}
