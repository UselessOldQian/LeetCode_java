package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qian
 * @create 2021-04-1410:06 下午
 */
public class LongestSubstringWORepeat3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdfsdf"));
    }
    static public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxlen = 0;
        int curlen = 0;
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            if (set.add(s.charAt(i))) {
                curlen++;
                maxlen = Math.max(curlen, maxlen);
                i++;
            } else {
                set.remove(s.charAt(j));
                j++;
                curlen--;
            }
        }
        return maxlen;
    }
}
