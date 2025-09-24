class MovieRentingSystem {
    
    // Map to store movie copies in each shop: movie -> TreeSet of (price, shop)
    private Map<Integer, TreeSet<int[]>> available;
    
    // TreeSet to store rented movies sorted by (price, shop, movie)
    private TreeSet<int[]> rented;
    
    // Map to quickly get price of a movie in a shop
    private Map<String, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; // sort by price
            if (a[0] != b[0]) return a[0] - b[0]; // then by shop
            return a[1] - b[1]; // then by movie
        });
        priceMap = new HashMap<>();
        
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            available.putIfAbsent(movie, new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // price
                return a[1] - b[1]; // shop
            }));
            available.get(movie).add(new int[]{price, shop});
            priceMap.put(shop + "-" + movie, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        
        int count = 0;
        for (int[] entry : available.get(movie)) {
            if (count == 5) break;
            res.add(entry[1]); // shop id
            count++;
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "-" + movie);
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{shop, movie, price});
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "-" + movie);
        rented.remove(new int[]{shop, movie, price});
        available.get(movie).add(new int[]{price, shop});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] entry : rented) {
            if (count == 5) break;
            res.add(Arrays.asList(entry[0], entry[1]));
            count++;
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */