class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        // Create an array of sets for each user's languages
        Set<Integer>[] langSet = new Set[m+1];
        for (int i = 0; i < m; i++) {
            langSet[i+1] = new HashSet<>();
            for (int lang : languages[i]) {
                langSet[i+1].add(lang);
            }
        }
        
        Set<Integer> conflictUsers = new HashSet<>();
        // Check each friendship
        for (int[] fr : friendships) {
            int u = fr[0], v = fr[1];
            if (!hasCommonLanguage(langSet[u], langSet[v])) {
                conflictUsers.add(u);
                conflictUsers.add(v);
            }
        }
        
        int minTeach = Integer.MAX_VALUE;
        // For each language from 1 to n
        for (int L = 1; L <= n; L++) {
            int count = 0;
            for (int u : conflictUsers) {
                if (!langSet[u].contains(L)) {
                    count++;
                }
            }
            if (count < minTeach) {
                minTeach = count;
            }
        }
        
        return minTeach;
    }
    
    private boolean hasCommonLanguage(Set<Integer> set1, Set<Integer> set2) {
        for (int lang : set1) {
            if (set2.contains(lang)) {
                return true;
            }
        }
        return false;
    }
}