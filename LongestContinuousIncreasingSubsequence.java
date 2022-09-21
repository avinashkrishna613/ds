// leetcode link - https://leetcode.com/problems/longest-continuous-increasing-subsequence/
public class LongestContinuousIncreasingSubsequence {

        public int findLengthOfLCIS(int[] nums) {
            int size = nums.length;
            int maxIncreasing = 1;
            int currInc = 1;
            for (int i=0; i<size-1; i++) {
                if (nums[i] < nums[i+1]) {
                    currInc += 1;
                }else {
                    maxIncreasing = maxIncreasing > currInc ? maxIncreasing : currInc;
                    currInc = 1;
                }
            }
            maxIncreasing = maxIncreasing > currInc ? maxIncreasing : currInc;
            return maxIncreasing;
        }

}
