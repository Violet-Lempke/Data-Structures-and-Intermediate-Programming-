package lab12;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SievePrimes {
    static long nn;
    static BitSet marks;

    static long countPrimes(long nn) {
        var xs = findPrimes(nn);
        return xs.size();
    }
    
    static List<Integer> findPrimes(long nn0) {
        nn = nn0;

        marks = new BitSet((int) nn);

        for (int ii = 4; ii < nn; ii += 2) {
            mark(ii);
        }

        for (int ii = 3; ii < nn; ii += 2) {
            if (isPrime(ii)) {
                for (int jj = ii + ii; jj < nn; jj += ii) {
                    mark(jj);
                }
            }
        }

        long count = 0;
        var ys = new ArrayList<Integer>();
        ys.add(2);
        for (int ii = 3; ii < nn; ii += 2) {
            if (isPrime(ii)) {
                ys.add(ii);
            }
        }
        return ys;
    }

    static void mark(int ii) {
        marks.set(ii);
    }

    static boolean isPrime(int xx) {
        return !marks.get(xx);
    }
}
