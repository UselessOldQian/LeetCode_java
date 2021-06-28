package BackTracking;

/**
 * @author Qian
 * @create 2021-06-223:20 下午
 */
public class WordSearching {
    public static void main(String[] args) {
        System.out.println(
                exist(new char[][]{{'A','B','C','D'}},"ABCE")
        );
    }

    public static boolean[][] isVisited;
    public static char[][] globalBoard;
    static public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        globalBoard = board;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                isVisited = new boolean[n][m];
                if(dfs(word,0,i,j))
                    return true;
            }
        }
        return false;
    }

    static public boolean dfs(String word,int ind,int i,int j){
        if(i<0 || j<0 || i>=globalBoard.length || j>=globalBoard[0].length || isVisited[i][j])
            return false;
        if(word.length()==ind){
            return true;
        }
        if(word.charAt(ind)==globalBoard[i][j]){
            isVisited[i][j] = true;
            boolean isValid =  dfs(word,ind+1,i+1,j)||dfs(word,ind+1,i,j+1)||
                    dfs(word,ind+1,i-1,j) || dfs(word,ind+1,i,j-1);
            isVisited[i][j] = false;
            return isValid;
        }
        return false;
    }
}
