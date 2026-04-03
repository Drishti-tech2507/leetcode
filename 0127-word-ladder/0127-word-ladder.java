class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet <>(wordList);
         if (!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int level = 1; 
        
        while (!queue.isEmpty()) {
            int s = queue.size();
            
            for (int i = 0; i < s; i++) {
                String word = queue.poll();
                
                if (word.equals(endWord)) return level;
                
                char[] arr = word.toCharArray();
                
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newW = new String(arr);
                        
                        if (set.contains(newW)) {
                            queue.add(newW);
                            set.remove(newW); 
                        }
                    }
                    
                    arr[j] = original; 
                }
            }
            
            level++;
        }
        
        return 0;
        
    }
}