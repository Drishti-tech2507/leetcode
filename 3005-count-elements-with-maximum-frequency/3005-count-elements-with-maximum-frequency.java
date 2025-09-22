import java.util.HashMap;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 1: Count frequency of each element
        int maxFreq = 0;
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        
        // Step 2: Count total elements with max frequency
        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                count += freq;
            }
        }
        
        return count;
    }
}