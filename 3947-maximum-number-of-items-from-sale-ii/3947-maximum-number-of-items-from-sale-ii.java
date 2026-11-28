import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int[] freq = new int[n + 1];

        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count factors divisible by each factor
        int[] count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                count[i] += freq[j];
            }
        }

        // Store available bonus purchases by price
        TreeMap<Long, Long> map = new TreeMap<>();

        for (int[] item : items) {

            int factor = item[0];
            long price = item[1];

            long free = count[factor] - 1;

            if (price < 2 * minPrice && free > 0) {
                map.merge(price, free, Long::sum);
            }
        }

        long remaining = budget;
        long purchased = 0;

        // Buy cheapest bonus opportunities first
        for (Map.Entry<Long, Long> entry : map.entrySet()) {

            long price = entry.getKey();
            long available = entry.getValue();

            long take = Math.min(available, remaining / price);

            purchased += take;
            remaining -= take * price;

            if (take < available) {
                break;
            }
        }

        // Each bonus purchase gives 2 copies.
        // Remaining budget buys cheapest items.
        long answer = 2 * purchased + remaining / minPrice;

        return (int) answer;
    }
}