//Time Complexity: O(1)     for variable length : O(n²)
//Space Complexity: O(1)    for variable length : O(n²)

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValid(board) ? "Yes! it's a valid sudoku" : "No! it's not a valid sudoku");
    }

    public static boolean isValid(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] column = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                if (num == '.') continue;

                int boardIndex = (r/3)*3 + (c/3);
                if (row[r].contains(num) || column[c].contains(num) || box[boardIndex].contains(num)) {
                    return false;
                }

                row[r].add(num);
                column[c].add(num);
                box[boardIndex].add(num);
            }
        }
        return true;
    }
}
