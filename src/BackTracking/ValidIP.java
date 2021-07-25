package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian
 * @create 2021-07-101:01 下午
 */
public class ValidIP {
    public static void main(String[] args) {
        System.out.println('a'-'A');
        restoreIpAddresses("25525511135");
    }
    static List<String> ret = new ArrayList();
    static StringBuilder ans = new StringBuilder();
    static public List<String> restoreIpAddresses(String s) {
        backtrack(s,0,4);
        return ret;
    }

    static void backtrack(String s, int start, int last){
        if(last>s.length()-start || last == 0)
            return;
        if(last*3<s.length()-start)
            return;
        if(start == s.length()){
            ret.add(new String(ans));
            return;
        }
        for(int i = 1;i<=3;++i){
            if(start+i>s.length())
                return;
            String sub = s.substring(start,start+i);
            if(Integer.parseInt(sub)<=255){
                if(start+i==s.length())
                    ans.append(sub);
                else{
                    ans.append(sub+".");
                }
                backtrack(s,start+i,last-1);
                if(start+i==s.length())
                    ans.delete(ans.length() - sub.length(), ans.length());
                else{
                    ans.delete(ans.length() - 1 - sub.length(), ans.length());
                }
            }
            if(s.charAt(start)=='0')
                return;
        }
    }
}
