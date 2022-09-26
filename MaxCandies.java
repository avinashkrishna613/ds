import java.util.LinkedList;
import java.util.List;

//leetcode link -     https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class MaxCandies {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int size = candies.length;
            int i = 0;
            int max = Integer.MIN_VALUE;
            for (; i<size; i++) {
                max = max > candies[i] ? max : candies[i];
            }

            i =0;
            List<Boolean> result = new LinkedList<Boolean>();
            for (; i<size; i++) {
                if (candies[i]+extraCandies >= max) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }

            return result;
        }
}
