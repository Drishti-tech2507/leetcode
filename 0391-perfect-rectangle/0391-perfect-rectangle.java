class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        // Total area of small rectangles
        long area = 0;

        // Corner set
        Set<String> corners = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

            // Update bounding rectangle
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // Add area
            area += (long)(x2 - x1) * (y2 - y1);

            // Process 4 corners
            String[] points = {
                x1 + "," + y1, 
                x1 + "," + y2, 
                x2 + "," + y1, 
                x2 + "," + y2
            };

            for (String p : points) {
                if (!corners.add(p)) {
                    // If already exists, remove it
                    corners.remove(p);
                }
            }
        }

        // Final corners must match bounding rectangle
        if (corners.size() != 4 || 
            !corners.contains(minX + "," + minY) ||
            !corners.contains(minX + "," + maxY) ||
            !corners.contains(maxX + "," + minY) ||
            !corners.contains(maxX + "," + maxY)) {
            return false;
        }

        // Total area must match bounding rectangle area
        long boundingArea = (long)(maxX - minX) * (maxY - minY);
        return area == boundingArea;
    }
}