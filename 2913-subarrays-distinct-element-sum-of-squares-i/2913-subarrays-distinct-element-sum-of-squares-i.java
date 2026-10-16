import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;

        // Iterate over all possible starting indices i
        for (int i = 0; i < n; i++) {
            Set<Integer> distinct = new HashSet<>();
            
            // Expand the subarray from i to j
            for (int j = i; j < n; j++) {
                distinct.add(nums.get(j));
                int count = distinct.size();
                totalSum += count * count;
            }
        }

        return totalSum;
    }
}