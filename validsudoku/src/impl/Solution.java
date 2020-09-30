package impl;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int []rows = new int[9];
        int []cols = new int[9];
        int [][]boards = new int[3][3];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];

                if (cur != '.') {
                    int num = Character.getNumericValue(cur);
                    // check if the row contains cur already
                    int curRow = rows[row];
                    if (((curRow >> num) & 0x1) == 1) {
                        return false;
                    } else {
                        rows[row] |= (0x1 << num);
                    }

                    int curCol = cols[col];
                    if (((curCol >> num) & 0x1) == 1) {
                        return false;
                    } else {
                        cols[col] |= (0x1 << num);
                    }

                    int curBoard = boards[row/3][col/3];
                    if (((curBoard >> num) & 0x1) == 1) {
                        return false;
                    } else {
                        boards[row/3][col/3] |= (0x1 << num);
                    }
                }

            }
        }
        return true;
    }
}