class Spreadsheet {
    private int[][] grid;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26]; // 26 columns (A-Z)
    }

    // Parse cell reference (e.g., "A1" -> [0,0])
    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // 1-indexed
        return new int[]{row, col};
    }

    // Set cell value
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    // Reset cell to 0
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    // Evaluate formula of form "=X+Y"
    public int getValue(String formula) {
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+"); // split by '+'
        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    // Helper to get operand value (either integer or cell reference)
    private int getOperandValue(String operand) {
        if (Character.isDigit(operand.charAt(0))) {
            return Integer.parseInt(operand);
        } else {
            int[] pos = parseCell(operand);
            return grid[pos[0]][pos[1]];
        }
    }
}
/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */