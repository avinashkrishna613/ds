import java.util.HashMap;
import java.util.Map;

// leetcode - https://leetcode.com/problems/number-of-good-pairs/
public class GoodPairs {

        // private int func (int n) {
        //     if (n == 1) return 0;
        //     else if (n==2) return 1;
        //     else return func(n-1) + n - 1;
        // }

        public int numIdenticalPairs(int[] nums) {
            Map<Integer, Integer> valToCount = new HashMap<Integer, Integer>();
            int size=nums.length;
            for (int i=0; i<size; i++) {
                int prevCount = valToCount.getOrDefault(nums[i], 0);
                valToCount.put(nums[i], prevCount+1);
            }

            int goodPairs = 0;
            for (Map.Entry<Integer, Integer> entry : valToCount.entrySet()) {
                goodPairs += entry.getValue()*(entry.getValue()-1)/2;
            }

            return goodPairs;
        }
}
