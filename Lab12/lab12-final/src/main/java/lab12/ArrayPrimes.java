package lab12;

import java.util.ArrayList;
import java.util.List;

public class ArrayPrimes {
    static List<Long> findPrimes(long nn) {
        var ys = new ArrayList<Long>();
        ys.add(2L);
        for (long ii = 3; ii < nn; ii += 2) {
            if (isPrime(ii)) {
                ys.add(ii);
            }
        }
        return ys;
    }

    static boolean isPrime(long xx) {
        long top = 1 + (long) Math.ceil(Math.sqrt(xx));
        for (long ii = 3; ii < top; ii += 2) {
            if (xx % ii == 0) {
                return false;
            }
        }
        return true;
    }
}
