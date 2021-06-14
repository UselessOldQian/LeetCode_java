package String;

import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-04-124:21 下午
 */
public class Strstr {
    public static void main(String[] args) {
        String Text = "abcsddfabcdab";
        String pattern = "abcdab";
        System.out.println("ok");
        int[] prefixTable = getPrefixTable(pattern);
        int ind = KMPsearch(Text, pattern, prefixTable);
        if (ind < 0) {
            System.out.println("none");
        } else {

            System.out.println(Text.substring(ind-1, ind-1 + pattern.length()));
        }
    }

    /**
     * Construct the prefix table
     * @param pattern
     * @return
     */
    public static int[] getPrefixTable(String pattern){
        int len = pattern.length();
        int[] prefixTable = new int[len];
        prefixTable[0] = 0;
        int i = 1;
        int j = 0;
        while (i < len) {
            // if the new added item is equal to the old one
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefixTable[i++] = ++j;
            } else {
                if (j > 0) {
                    j = prefixTable[j - 1];
                } else {
                    prefixTable[i++] = j;
                }
            }
        }

        // move the prefix table to make the KMP search more convenient
        for (int k = len - 1; k > 0; k--) {
            prefixTable[k] = prefixTable[k - 1];
        }
        prefixTable[0] = -1;
        return prefixTable;
    }

    public static int KMPsearch(String Text, String Pattern, int[] prefixTable){
        int n = Text.length();
        int m = Pattern.length();
        // the index of Text
        int i = 0;
        // the index of Pattern
        int j = 0;
        while (i <= n) {
            if (j == m) {
                return i - m + 1;
            }
            if(i == n){
                return -1;
            }

            if (Text.charAt(i) == Pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = prefixTable[j];
                if (j < 0) {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }



    public int strStr(String haystack, String needle) {
        // solution 1
//        int hashcode = 0;
//        for(int i =0;i<needle.length();i++){
//            hashcode += (int) needle.charAt(i) * 26;
        return 0;
    }

}
