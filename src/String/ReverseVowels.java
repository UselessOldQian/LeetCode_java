package String;

/**
 * @author Qian
 * @create 2021-04-261:09 下午
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
    public static String reverseVowels(String s) {
        int l = 0;
        int r = s.length()-1;
        int n = r;
        char[] cArray = s.toCharArray();
        while(l<r){
            while(l<n){
                if(isVowel(cArray[l])){
                    break;
                }
                l++;
            }
            while(r>0){
                if(isVowel(cArray[r])){
                    break;
                }
                r--;
            }
            if(l<r){
                char temp = cArray[r];
                cArray[r] = cArray[l];
                cArray[l] = temp;
            }
            l++;
            r--;
        }
        return cArray.toString();

    }

    public static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
