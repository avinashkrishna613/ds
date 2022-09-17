import java.util.ArrayList;
import java.util.List;
// leetcode link - https://leetcode.com/problems/decompress-run-length-encoded-list/
public class DecompressArray {

        public int[] decompressRLElist(int[] nums) {
            int size = nums.length;
            List<Integer> result = new ArrayList<Integer>();
            int j = Integer.MIN_VALUE;
            for (int i = 0; i<=size-2; i+=2) {
                for (j=0 ;j<nums[i]; j++) {
                    result.add(nums[i+1]);
                }
            }
            return result.stream().mapToInt(value -> value.intValue()).toArray();
        }
}
