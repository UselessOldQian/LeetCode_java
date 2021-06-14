package String;

import java.util.HashMap;

/**
 * @author Qian
 * @create 2021-04-146:37 下午
 */
public class firstUniqueChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("asdf"));
    }

    static public int firstUniqChar(String s) {
        int[] hashArray = new int[26];
        System.out.println(hashArray[0]);
        for (int i = 0; i < s.length(); i++) {
            hashArray[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashArray[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;


    }
}
