import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection2Arrays {
        public int[] intersection(int[] nums1, int[] nums2) {
            int firstLen = nums1.length;
            int secondLen = nums2.length;

            List<Integer> result = new ArrayList<>();

            Map<Integer, Integer> map = new HashMap<>();
            if (firstLen < secondLen) {
                for (Integer num : nums1) {
                    int count = map.getOrDefault(num, 0);
                    map.put(num, count + 1);
                }

                for (Integer num : nums2) {
                    if (map.containsKey(num) && map.get(num) != 0) {
                        result.add(num);
                        map.remove(num);
                    }
                }

            } else {
                for (Integer num : nums2) {
                    int count = map.getOrDefault(num, 0);
                    map.put(num, count + 1);
                }

                for (Integer num : nums1) {
                    if (map.containsKey(num)) {
                        result.add(num);
                        map.remove(num);
                    }
                }

            }

            return result.stream().mapToInt(val -> val.intValue()).toArray();
        }
}
