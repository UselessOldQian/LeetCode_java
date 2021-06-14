package String;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Qian
 * @create 2021-04-261:43 下午
 */
public class ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("[asdf{}()]"));
    }

    public static boolean isValid(String s){
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i  = 0;i<s.length();i++) {
            if(hashMap.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }
            if(hashMap.containsKey(s.charAt(i))){
                if(hashMap.get(s.charAt(i))!=stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
