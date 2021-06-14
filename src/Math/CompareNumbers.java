package Math;

/**
 * @author Qian
 * @create 2021-04-162:23 下午
 */
public class CompareNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.2.3.4","1.0.0"));
    }

    static public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length1 = v1.length;
        int length2 = v2.length;
        int i = 0;
        while( i < v1.length && i < v2.length){
            if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                return -1;
            }else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                return 1;
            }
            i++;
        }
        if(length1 > length2){
            while(i<length1){
                if(Integer.parseInt(v1[i])>0) return 1;
                i++;
            }
        }
        else{
            while(i<length2){
                if(Integer.parseInt(v2[i])>0) return -1;
                i++;
            }
        }
        return 0;
    }
}
