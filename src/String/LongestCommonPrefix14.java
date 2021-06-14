package String;

/**
 * @author Qian
 * @create 2021-04-145:40 下午
 */
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        " sdfa ".trim();
        System.out.println(longestCommonPrefix(new String[]{"asdfsf","asdgg","asdddd","asddddf"}));
    }

    static public String longestCommonPrefix(String[] strs) {
//        int miniLen = 201;
//        for (int i = 0; i < strs.length; i++) {
//            if (miniLen > strs[i].length()) {
//                miniLen = strs.length;
//            }
//        }
//        if (miniLen == 201 || miniLen == 0) {
//            return "";
//        }

        String longestprefix = "" ;
        int j = 0;
        while(true){
            if (strs[0].length() - 1 < j) {
                return strs[0].substring(0, j);
            }
            char currentChar = strs[0].charAt(j);
            for(int i =0;i<=strs.length-1;i++){
                if (j > strs[i].length()-1 || strs[i].charAt(j)!=currentChar) {
                    return strs[i].substring(0,j);
                }
            }
            j++;
        }
    }
}
