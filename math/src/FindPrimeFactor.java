/* @author: Yujing Chen */

import java.util.List;
import java.util.Arrays;

public class FindPrimeFactor {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(12,18,15,6);
        List<Integer> b = Arrays.asList(4,2,6,3);
        System.out.println(findPrimeFactor(a,b));
    }

    /**
     * Returns the least index at which b[i] is a prime factor of a[i].
     *
     * @param  a   an integer list
     * @param  b   an integer list
     * @return     the least index at which b[i] is a prime factor of a[i],
     *             if not found, return -1
     * @throws    NullPointerException if a or b is null
     *                                 if a or b contains null element
     * @throws    IllegalArgumentException if a or b is empty
     */

    public static int findPrimeFactor (List<Integer> a, List<Integer> b){
        try {
            if (a.size() == 0 || b.size() == 0) {
                throw new IllegalArgumentException("Empty list!");
            }
            int max_size = a.size() > b.size() ? b.size() : a.size();
            for (int i = 0; i < max_size; i++) {
                if (isPrime(b.get(i)) && (a.get(i) % b.get(i) == 0)) {
                    return i;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch(NullPointerException e){
            System.out.println("NullPointerException Caught");
        }
        return -1;
    }

    /**
     * Returns true if n is a prime factor, false if n is not a prime factor.
     *
     * @param  n   an integer
     * @return     true, if n is a prime factor
     *             false, if n is not a prime factor.
     */

    public static boolean isPrime(int n) {
        if (n%2==0 && n != 2)
            return false;
        for(int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
