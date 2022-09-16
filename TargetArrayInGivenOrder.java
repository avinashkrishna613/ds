import java.util.LinkedList;
import java.util.List;
// leetcode url - https://leetcode.com/problems/create-target-array-in-the-given-order/
public class TargetArrayInGivenOrder {
        public int[] createTargetArray(int[] nums, int[] index) {
            int numsSize = nums.length, indexSize = index.length;

            if (numsSize != indexSize) {
                return new int[1];
            }

            List<Integer> result = new LinkedList<>();
            for (int i=0 ;i<indexSize; i++) {
                int ind = index[i], val = nums[i];
                result.add(ind, val);
            }

            return result.stream().mapToInt(value -> value.intValue()).toArray();
        }
}
