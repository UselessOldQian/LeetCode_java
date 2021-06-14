package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qian
 * @create 2021-04-1811:26 下午
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(30));
    }

    public static int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
