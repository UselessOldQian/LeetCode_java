package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qian
 * @create 2021-04-2610:58 下午
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurrent(n,n,new StringBuilder(),res);
        return res;
    }

    public static void recurrent(int leftBracket, int rightBracket, StringBuilder sb, List<String> list){
        if(leftBracket == 0){
            for(int i =0;i<rightBracket;i++){
                sb = sb.append(")");
            }
            list.add(sb.toString());
            for(int i =0;i<rightBracket;i++){
                sb.deleteCharAt(sb.length() - 1);
            }
            return;
        }
        if(rightBracket>leftBracket){
            recurrent(leftBracket, --rightBracket, sb.append(")"), list);
            sb.deleteCharAt(sb.length() - 1);
            rightBracket++;
        }
        recurrent(--leftBracket, rightBracket, sb.append("("), list);
        sb.deleteCharAt(sb.length() - 1);
        leftBracket++;
    }
}
