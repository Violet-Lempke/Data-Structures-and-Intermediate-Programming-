package lab12;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var limit = new TimeLimit(20);
        limit.start();

        int tt = procs();
        System.out.println("We have " + tt + " hardware threads.");

        long t0 = System.nanoTime();
        var xs = NewPrimes.findPrimes(10 * 1000 * 1000, tt);
        //var xs = SievePrimes.findPrimes(10 * 10000 * 100000);
        long count = xs.size();
        long t1 = System.nanoTime();
        long ms = ((t1 - t0) / 1000000);
        
        System.out.printf("found %d primes in %d ms\n", count, ms);
       
         
    }

    static int procs() {
        return Runtime.getRuntime().availableProcessors();
    }
}

class TimeLimit extends Thread {
    long seconds;

    TimeLimit(long seconds) {
        this.seconds = seconds;
        setDaemon(true);
    }

    @Override
    public void run() {
        boolean timeout = true;
        try {
            Thread.sleep(1000 * seconds);
        }
        catch (InterruptedException _ee) {
            timeout = false;
        }
        if (timeout) {
            System.out.printf("Hit time limit of %d seconds.\n",
                              seconds);
            System.exit(1);
        }
    }
}
