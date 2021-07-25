package Arrays;

/**
 * @author Qian
 * @create 2021-07-109:21 下午
 */
public class MiniWindowSubstring {
    public static void main(String[] args) {
        minWindow("cabwefgewcwaefgcf",
                "cae");
    }
    static public String minWindow(String s, String t) {
        int[] submap = new int[64];
        int[] tmap = new int[64];
        int needed = 0;
        for(int i = 0;i<t.length();++i){
            if(tmap[t.charAt(i)-'A']++==0)
                needed++;
        }
        int l = 0, r = 0;
        while(needed != 0){
            if(r>=s.length())
                return "";
            if(++submap[s.charAt(r)-'A']==tmap[s.charAt(r)-'A']){
                needed--;
            }
            r++;
        }
        String retStr = s.substring(0,r);
        while(needed == 0){
            if(submap[s.charAt(l)-'A']--==tmap[s.charAt(l)-'A']){
                needed++;
            }
            else{
                retStr = s.substring(l+1,r);
            }
            l++;
        }

        while(r<s.length()){
            if(submap[s.charAt(l)-'A']--==tmap[s.charAt(l)-'A']){
                needed++;
            }
            if(++submap[s.charAt(r)-'A']==tmap[s.charAt(r)-'A']){
                needed--;
            }
            r++;l++;
            if(needed==0)
                retStr = s.substring(l,r);
            while(needed == 0){
                if(submap[s.charAt(l)-'A']--==tmap[s.charAt(l)-'A']){
                    needed++;
                }
                else{
                    retStr = s.substring(l+1,r);
                }
                l++;
            }
        }
        return retStr;
    }
}
