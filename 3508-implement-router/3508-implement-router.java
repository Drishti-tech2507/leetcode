import java.util.*;
public class Router {
    private int memoryLimit;
    // Queue to store packets in FIFO order.
    private Deque<int[]> packetQueue;
    // Set for duplicate detection.
    private Set<String> packetSet;
    // Map from destination to list of timestamps.
    private Map<Integer, List<Integer>> destMap;
    
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packetQueue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destMap = new HashMap<>();
    }
    
    // Helper method to create a unique key for a packet.
    private String createKey(int source, int destination, int timestamp) {
        return source + "-" + destination + "-" + timestamp;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String key = createKey(source, destination, timestamp);
        // Check for duplicate.
        if(packetSet.contains(key)) {
            return false;
        }
        // If memory limit is reached, remove oldest packet.
        if(packetQueue.size() >= memoryLimit) {
            removeOldestPacket();
        }
        int[] packet = new int[]{source, destination, timestamp};
        packetQueue.offer(packet);
        packetSet.add(key);
        // Add to destination map; since packets are added in order, we can append.
        destMap.putIfAbsent(destination, new ArrayList<>());
        destMap.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(packetQueue.isEmpty()) {
            return new int[0];
        }
        int[] packet = packetQueue.poll();
        int source = packet[0], destination = packet[1], timestamp = packet[2];
        String key = createKey(source, destination, timestamp);
        packetSet.remove(key);
        // Remove the timestamp from the destination map.
        List<Integer> list = destMap.get(destination);
        if(list != null && !list.isEmpty()){
            if(list.get(0) == timestamp){
                list.remove(0);
            } else {
                list.remove((Integer)timestamp);
            }
        }
        return packet;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!destMap.containsKey(destination)) {
            return 0;
        }
        List<Integer> list = destMap.get(destination);
        // Use binary search since list is sorted.
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }
    
    // Helper to remove the oldest packet when memory limit is reached.
    private void removeOldestPacket() {
        if(!packetQueue.isEmpty()){
            int[] packet = packetQueue.poll();
            int source = packet[0], destination = packet[1], timestamp = packet[2];
            String key = createKey(source, destination, timestamp);
            packetSet.remove(key);
            List<Integer> list = destMap.get(destination);
            if(list != null && !list.isEmpty()){
                if(list.get(0) == timestamp){
                    list.remove(0);
                } else {
                    list.remove((Integer)timestamp);
                }
            }
        }
    }
    
    // Helper method: lower bound binary search for first index with value >= target.
    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(list.get(mid) < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
    
    // Helper method: upper bound binary search for first index with value > target.
    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(list.get(mid) <= target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */