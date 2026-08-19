class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
       HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int seatNumber = seat[1];
            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(seatNumber);
        }
        int answer = (n - map.size()) * 2;
        for (HashSet<Integer> seats : map.values()) {

            boolean l = true;   

            boolean m = true; 

            boolean r = true;  
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    l = false;
                    break;

                }
            }
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    m = false;
                    break;

                }
            }
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    r = false;
                    break;
                }
            }
            if (l && r) {
                answer += 2;
            }
            else if (l || m || r) {
                answer += 1;
            }
        }
        return answer;
    }
}