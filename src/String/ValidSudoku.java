package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Qian
 * @create 2021-04-2810:56 下午
 */
public class ValidSudoku {
    public static void main(String[] args) {
        isValidSudoku(new char[][]{{'3','3','.','.','.','.','.','.','.'},{'3','3','.','.','.','.','.','.','.'},
                {'3','3','.','.','.','.','.','.','.'},{'3','3','.','.','.','.','.','.','.'},
                {'3','3','.','.','.','.','.','.','.'},{'3','3','.','.','.','.','.','.','.'},
                {'3','3','.','.','.','.','.','.','.'},{'3','3','.','.','.','.','.','.','.'},
                {'3','3','.','.','.','.','.','.','.'}});
    }
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<Integer,Set<Character>> rows = new HashMap<> ();
        HashMap<Integer,Set<Character>> grids = new HashMap<> ();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                cols.put(j,cols.getOrDefault(j,new HashSet<Character>()));
                if(!cols.get(j).add(board[i][j])){
                    return false;
                }
                rows.put(i,rows.getOrDefault(i,new HashSet<Character>()));
                if(!rows.getOrDefault(i,new HashSet<Character>()).add(board[i][j])){
                    return false;
                }
                int grid = i/3*3+j/3;
                rows.put(grid,rows.getOrDefault(grid,new HashSet<Character>()));
                if(!grids.getOrDefault(grid,new HashSet<Character>()).add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

}
