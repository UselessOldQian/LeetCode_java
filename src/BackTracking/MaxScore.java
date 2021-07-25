package BackTracking;

import java.util.HashMap;

/**
 * @author Qian
 * @create 2021-07-2511:18 上午
 */
public class MaxScore {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.computeIfAbsent();

        int[][] stu = new int[][]{{1,1,0},{1,0,1},{0,0,1}};
        int[][] men = new int[][]{{1,0,0},{0,0,1},{1,1,0}};
        System.out.println(maxCompatibilitySum(stu,men));
    }
    static public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return helper(students,mentors,0,new boolean[mentors.length],0);
    }

    static int helper(int[][] students, int[][] mentors,
                      int curStu, boolean[] unavailTeacher,
                      int score){
        for(int i = 0;i<mentors.length;++i){
            if(unavailTeacher[i]){
                continue;
            }
            unavailTeacher[i] = true;
            int curscore = score+calScore(students[curStu], mentors[i]);
            score = Math.max(helper(students,mentors,curStu+1,unavailTeacher,curscore),score);
            unavailTeacher[i] = false;
        }
        return score;
    }

    static int calScore(int[] stu, int[] tea){
        int score = 0;
        for(int i = 0;i<stu.length;++i){
            if(stu[i]==tea[i]){
                score++;
            }
        }
        return score;
    }
}
