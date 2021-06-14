package String;

import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-06-1012:50 上午
 */
public class PermutationInString {
    public static void main(String[] args) {
        checkInclusion("hello" ,"ooolleoooleh");
    }

    static public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] curCount = new int[26];
        int needToFill = 0;
        for(int i = 0;i<s1.length();i++){
            if(s1Count[s1.charAt(i)-'a']++==0)
                needToFill++;
        }
        int start = 0;
        int end = 0;
        int charIdx = 0;
        int currFill = 0;
        while(end<s2.length()){
            charIdx = s2.charAt(end)-'a';
            if(s1Count[charIdx]==0){
                Arrays.fill(curCount,0);
                start = ++end;
                currFill = 0;
                continue;
            }
            if(++curCount[charIdx]>s1Count[charIdx]){
                while(start<end && s2.charAt(start++)!=s2.charAt(end)){
                    int startIdx = s2.charAt(start)-'a';
                    if(curCount[startIdx]-- == s1Count[charIdx])
                        currFill--;
                }
            }else if(curCount[charIdx] == s1Count[charIdx]){
                currFill++;
            }
            end++;
            if(currFill==needToFill){
                return true;
            }
        }
        return false;
    }
}
