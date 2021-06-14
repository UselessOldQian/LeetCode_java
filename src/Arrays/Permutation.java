package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Qian
 * @create 2021-04-2611:27 下午
 */
public class Permutation {
    public static void main(String[] args) {

        permute(new int[]{1,2,3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> last = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> array = new ArrayList<>();
        recur(res,last,array);
        return res;
    }

    public static void recur(List<List<Integer>> res, List<Integer> last, List<Integer> array){
        if(last.size()==1){
            array.add(last.get(0));
            res.add(new ArrayList<>(array));
            array.remove(last.get(0));
            return;
        }
        for(int i =0;i<last.size();i++){
            Integer num = last.remove(i);
            array.add(num);
            recur(res,last,array);
            last.add(i,num);
            array.remove(num);
        }
        return;
    }
}
