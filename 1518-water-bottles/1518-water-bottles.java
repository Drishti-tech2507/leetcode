class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int td = 0;
        int e = 0;
        td += numBottles;
        e = numBottles;
        while(e >= numExchange)
        {
            int newBottles = e/numExchange;
            td += newBottles;
            e = e%numExchange + newBottles;
        }
        return td;
    }
}