package Arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qian
 * @create 2021-07-1011:17 下午
 */
public class FindWay {
    public static void main(String[] args) {
        char[][] maze = new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] pos = new int[]{1,2};
        nearestExit(maze, pos);
    }
    static public int nearestExit(char[][] maze, int[] entrance) {
        if(maze.length==0)
            return -1;
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int[] cur = queue.poll();
                if(cur[0] < 0 || cur[0] >= maze.length || cur[1] < 0 || cur[1] >= maze[0].length){
                    continue;
                }
                if(isVisited[cur[0]][cur[1]] || maze[cur[0]][cur[1]]=='+')
                    continue;
                if(cur[0] == 0 || cur[0] == maze.length-1 || cur[1] == 0 || cur[1] == maze[0].length-1){
                    if(step != 0)
                        return step;
                }
                queue.offer(new int[]{cur[0],cur[1]-1});
                queue.offer(new int[]{cur[0],cur[1]+1});
                queue.offer(new int[]{cur[0]-1,cur[1]});
                queue.offer(new int[]{cur[0]+1,cur[1]});
                isVisited[cur[0]][cur[1]] = true;
            }
            step++;
        }
        return -1;
    }
}
