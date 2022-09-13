import java.util.ArrayList;
import java.util.List;

class ArraySubstrings {

    private void generateSubstrings(int[] nums, int startInd, int size, List<List<Integer>> result, List<Integer> ds) {
        if (startInd == size) {
            result.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[startInd]);
        generateSubstrings(nums, startInd+1, size, result, ds);
        ds.remove(ds.size()-1);
        generateSubstrings(nums, startInd+1, size, result, ds);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<Integer>();
        generateSubstrings(nums, 0, nums.length, result, ds);
        return result;
    }
}