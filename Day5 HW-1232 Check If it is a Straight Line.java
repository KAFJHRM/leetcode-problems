class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // A line always contains at least 2 points (guaranteed by constraints)
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        // Calculate the initial delta values
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        // Check if every subsequent point has the same slope ratio
        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];
            
            // Cross-multiplication check
            if (dy * (xi - x0) != (yi - y0) * dx) {
                return false;
            }
        }
        
        return true;
    }
}
