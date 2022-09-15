// leetcode - https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOnes {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = Integer.MIN_VALUE, curr = 0;
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                if (nums[i] == 1) {
                    curr += 1;
                } else {
                    max = max > curr ? max : curr;
                    curr = 0;
                }
            }
            max = max > curr ? max : curr;
            return max;
        }
}
