class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
        {
            return false;
        }
        String doub = s + s;
        return doub.contains(goal);
    }
}