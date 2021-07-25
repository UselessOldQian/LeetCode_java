package BackTracking;

/**
 * @author Qian
 * @create 2021-07-1011:45 下午
 */
public class Winner {
    public static void main(String[] args) {
        sumGame("?3295???");
    }
    static public boolean sumGame(String num) {
        int prev = 0,last = 0;
        int prevQ = 0,lastQ = 0;
        for(int i = 0;i<num.length()/2;i++){
            if(num.charAt(i)!='?')
                prev += num.charAt(i)-'0';
            else
                prevQ++;
        }
        for(int i = num.length()/2;i<num.length();i++){
            if(num.charAt(i)!='?')
                last += num.charAt(i)-'0';
            else
                lastQ++;
        }
        return AliceHelper(prev,last,prevQ,lastQ);
    }

    static boolean AliceHelper(int prev, int last, int prevQ, int lastQ){
        if(((prevQ + lastQ)&1)==1)
            return true;
        int diff = prev - last;
        int diffQ = prevQ - lastQ;
        if(diff>0 && diff>diffQ/2*9)
            return true;
        if(diff<0 && diff<diffQ/2*9)
            return true;

        if(prevQ == 0 && lastQ == 0)
            return prev != last;
        if(prevQ > 0){
            for(int i = 0;i<10;i++){
                if(!BobHelper(prev+i, last, prevQ-1, lastQ))
                    return true;
            }
        }
        if(lastQ > 0){
            for(int i = 0;i<10;i++){
                if(!BobHelper(prev, last+i, prevQ, lastQ-1))
                    return true;
            }
        }
        return false;
    }

    static boolean BobHelper(int prev, int last, int prevQ, int lastQ){
        if(prevQ == 0 && lastQ == 0)
            return prev == last;
        if(prevQ > 0){
            for(int i = 0;i<10;i++){
                if(!AliceHelper(prev+i, last, prevQ-1, lastQ))
                    return true;
            }
        }
        if(lastQ > 0){
            for(int i = 0;i<10;i++){
                if(!AliceHelper(prev, last+i, prevQ, lastQ-1))
                    return true;
            }
        }
        return false;
    }
}
