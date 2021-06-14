package String;

/**
 * @author Qian
 * @create 2021-04-1612:05 下午
 */
public class reverseWord  {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    static public String reverseWords(String s) {
        s = s.trim();
        StringBuilder word = new StringBuilder();
        StringBuilder reverseW = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c != ' '){
                word.append(c);
            }
            else if(word.length()!=0){
                word.reverse();
                word.append(' ');
                reverseW.append(word);
                word.setLength(0);
            }
        }
        if(! word.equals("")){
            word.reverse();
            reverseW.append(word);
            word.setLength(0);
        }
        return reverseW.toString().trim();
    }
}
