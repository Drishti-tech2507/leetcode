import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Three 9x9 boolean arrays to mark seen digits:
        // rows[r][d] -> digit d seen in row r
        // cols[c][d] -> digit d seen in column c
        // boxes[b][d] -> digit d seen in 3x3 box b
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.' || ch == '0') continue; // treat '.' as empty (LeetCode uses '.')
                if (ch < '1' || ch > '9') return false; // invalid char guard

                int d = ch - '1'; // map '1'..'9' -> 0..8
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r][d]) return false;    // duplicate in row
                if (cols[c][d]) return false;    // duplicate in column
                if (boxes[boxIndex][d]) return false; // duplicate in 3x3 box

                rows[r][d] = true;
                cols[c][d] = true;
                boxes[boxIndex][d] = true;
            }
        }
        return true;
    }
}