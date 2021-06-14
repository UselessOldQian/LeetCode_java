package Design;

/**
 * @author Qian
 * @create 2021-04-255:52 下午
 */
public class LRUTest {
    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1,1);
        test.put(2,2);
        test.get(1);
        test.put(3,3);
        test.get(2);
        test.put(4, 4);
        test.get(1);
        test.get(3);
        test.get(4);
    }
}
