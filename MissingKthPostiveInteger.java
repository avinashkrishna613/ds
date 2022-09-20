import java.util.HashSet;
import java.util.Set;

// leetcode link - https://leetcode.com/problems/kth-missing-positive-number/
public class MissingKthPostiveInteger {
        public int findKthPositive(int[] arr, int k) {
            int size = arr.length;
            int maxValue = arr[size-1];
            Set<Integer> hashSet = new HashSet<Integer>();
            for (int i=0; i<size; i++) {
                hashSet.add(arr[i]);
            }

            if (maxValue == size) {
                return maxValue+k;
            } else {
                for (int i=1; i<=maxValue; i++) {
                    if (!hashSet.contains(i)) {
                        k--;
                    }
                    if (k==0) return i;
                }
                return maxValue+k;
            }
        }
}
