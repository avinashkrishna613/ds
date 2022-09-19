import java.util.Arrays;
// leetcode link - https://leetcode.com/problems/h-index/
public class HIndex {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int result = 1;
            int arrLen = citations.length;

            if (citations[arrLen-1] == 0) return 0;
            for (int i=0; i<arrLen; i++) {
                if (arrLen-i <= citations[i]) {
                    result = result > arrLen-i ? result : arrLen-i;
                }
            }
            return result;
        }
}
