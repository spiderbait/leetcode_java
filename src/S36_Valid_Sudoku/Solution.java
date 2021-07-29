package S36_Valid_Sudoku;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        char[][] transposedBoard = transpose(board);
        char[][] flattenedBoard = flatten(board);
        for (int i=0; i<board.length; i++) {
            if (!isValidRowOrColumn(board[i]) || !isValidRowOrColumn(transposedBoard[i]) || !isValidRowOrColumn(flattenedBoard[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidRowOrColumn(char[] rowOrColumn) {
        List<Character> charList = new ArrayList<>();
        for (char c: rowOrColumn) {
            if (c == '.') {
                continue;
            } else {
                if (charList.contains(c)) {
                    return false;
                } else {
                    charList.add(c);
                }
            }
        }
        return true;
    }

    public char[][] transpose(char[][] board) {
        char[][] transposedBoard = new char[board[0].length][board.length];
        for (int i=0; i < board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                transposedBoard[i][j] = board[j][i];
            }
        }
        return transposedBoard;
    }

    public char[][] flatten(char[][] board) {
        char[][] flattenBoard = new char[board.length][board[0].length];
        int iMax = 3;
        int jMax = 3;
        int iMin = 0;
        int jMin = 0;
        int m = 0;
        int n;
        while(true) {
            n = 0;
            for (int i=iMin; i<iMax; i++) {
                for (int j=jMin; j<jMax; j++) {
                    flattenBoard[m][n] = board[i][j];
                    n ++;
                }
            }
            m ++;
            if (jMax == board[0].length && iMax == board.length) {
                break;
            }
            if (jMax < board[0].length) {
                jMax += 3;
                jMin += 3;
            } else if (jMax == board[0].length && iMax < board.length) {
                jMax = 3;
                jMin = 0;
                iMax += 3;
                iMin += 3;
            }
        }
        return flattenBoard;
    }

    public void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

       char[][] board1 =
               {{'5','3','.','.','7','.','.','.','.'}
               ,{'6','.','.','1','9','5','.','.','.'}
               ,{'.','9','8','.','.','.','.','6','.'}
               ,{'8','.','.','.','6','.','.','.','3'}
               ,{'4','.','.','8','.','3','.','.','1'}
               ,{'7','.','.','.','2','.','.','.','6'}
               ,{'.','6','.','.','.','.','2','8','.'}
               ,{'.','.','.','4','1','9','.','.','5'}
               ,{'.','.','.','.','8','.','.','7','9'}};

       char[][] board2 =
               {{'8','3','.','.','7','.','.','.','.'}
               ,{'6','.','.','1','9','5','.','.','.'}
               ,{'.','9','8','.','.','.','.','6','.'}
               ,{'8','.','.','.','6','.','.','.','3'}
               ,{'4','.','.','8','.','3','.','.','1'}
               ,{'7','.','.','.','2','.','.','.','6'}
               ,{'.','6','.','.','.','.','2','8','.'}
               ,{'.','.','.','4','1','9','.','.','5'}
               ,{'.','.','.','.','8','.','.','7','9'}};

       char[] row = {'.','9','8','.','.','6','.','6','.'};

        Solution s = new Solution();
//        System.out.println(s.isValidSudoku(board2));
//        System.out.println(s.isValidRowOrColumn(row));
//        char[][] transposedBoard1 = s.transpose(board1);
//        s.printBoard(board1);
//        s.printBoard(transposedBoard1);
        s.printBoard(s.flatten(board1));

    }
}
