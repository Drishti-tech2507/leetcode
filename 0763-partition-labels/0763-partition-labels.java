class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> n = new ArrayList<>();
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++)
        {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if(i == end)
            {
                n.add(end - start + 1);
                start = i + 1;
            }
        }
        return n;
    }
}