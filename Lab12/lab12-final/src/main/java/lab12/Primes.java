package lab12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Primes {
    static List<Integer> findPrimes(long nn, int tt) {
        final int P = tt;
        long npp = nn / P;

        var workers = new Worker[P];
        for (int ii = 0; ii < P; ++ii) {
            long i0 = Math.max(2, ii*npp);
            long i1 = ii == (P - 1) ? nn : (ii + 1) * npp;
            workers[ii] = new Worker(i0, i1);
            workers[ii].start();
        }

        var ys = new ArrayList<Integer>();
        ys.add(2);
        for (int ii = 0; ii < P; ++ii) {
            try {
                workers[ii].join();
                ys.addAll(workers[ii].primes);
            }
            catch (InterruptedException ee) {
                throw new Error("interrupted");
            }
        }

        return ys;
    }

    static ArrayList<Integer> findPrimesRange(long i0, long i1) {
        var ys = new ArrayList<Integer>();
        if (i0 % 2 == 0) {
            i0 += 1;
        }
        for (int ii = (int) i0; ii < i1; ii += 2) {
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


class Worker extends Thread {
    long i0;
    long i1;
    ArrayList<Integer> primes;

    Worker(long i0, long i1) {
        this.i0 = i0;
        this.i1 = i1;
        this.primes = new ArrayList<Integer>();
    }

    @Override
    public void run() {
        this.primes = Primes.findPrimesRange(i0, i1);
    }
    
}
