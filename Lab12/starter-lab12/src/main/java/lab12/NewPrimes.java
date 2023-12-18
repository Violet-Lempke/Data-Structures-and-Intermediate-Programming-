package lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.BitSet;

public class NewPrimes {
    static BitSet marks;
    static ArrayList<Integer> findPrimes(long range, int threadMax) {
        long npp;
        marks = new BitSet((int) range);
        var radRange = (long) Math.sqrt(range) + 1;
        var NeededPrimes = SievePrimes.findPrimes(radRange);
        var NeededPrimesSize = NeededPrimes.size();
        final int P = threadMax;
       
            
        npp = NeededPrimes.size() / P;
            
        
        
        var prevLimit = 1;
        var workers = new NewWorker[P];
        var workerCount = 0;
       
        boolean endingFlag = false;
        boolean tailFlag = false;
        var temp = 0;
        boolean lastWorker = false;
        for (int ii = 0; ii < P; ++ii) {
            if (ii + 1 == P) {
                lastWorker = true;
            }
            temp += npp;
           
            var remainder = 0;
            if (!endingFlag) {
                if (ii >= NeededPrimesSize) {
                
                    while (temp >= NeededPrimesSize) {
                        temp -= 1;
                    }
                    if (temp <= prevLimit) {
                        endingFlag = true;
                    
                        if (temp == prevLimit) {
                            tailFlag = true;
                            remainder = NeededPrimesSize - prevLimit;
                        }
                    }
                }
                if (lastWorker) {
                    endingFlag = true;
                    tailFlag = true;
                    remainder = NeededPrimesSize - prevLimit;
                }
                if (!endingFlag) {
                    var primesToWork = new ArrayList<Integer>();
                    for (int xx = prevLimit; xx < temp; ++xx) {
                        primesToWork.add(NeededPrimes.get(xx));
                    }
           
                    workers[workerCount] = new NewWorker(primesToWork, range);
                    workers[workerCount].start();
                    workerCount += 1;
                    prevLimit = temp;
                }
                if (tailFlag) {
                    var primesToWork = new ArrayList<Integer>();
            
                    for (int yy = prevLimit; yy < (prevLimit + remainder); ++yy) {
                        primesToWork.add(NeededPrimes.get(yy));
                    }
                
                    workers[workerCount] = new NewWorker(primesToWork, range);
                    workers[workerCount].start();
                    endingFlag = true;
                    tailFlag = false;
                    workerCount += 1;
            
                }
            }
        }
   
        var ys = new ArrayList<Integer>();
        for (var prime : NeededPrimes) {
            ys.add(prime);
        }
        for (int ii = 0; ii < workerCount; ++ii) {
            try {
                workers[ii].join();
                marks.or(workers[ii].bits);
                
            }
            catch (InterruptedException ee) {
                throw new Error("interrupted");
            }
        }
        for (int ii = 3; ii <= range; ii += 2) {
            if (isPrime(ii)) {
                ys.add(ii);
                
            }
            
        }
        

        return ys;
    
    }
    static boolean isPrime(int xx) {
        return !marks.get(xx);
    }
  
}

class NewWorker extends Thread {
    long limit;
        
    List<Integer> workLoad;
    ArrayList<Integer> composites;
    BitSet bits;
    NewWorker(List<Integer> workLoad, long limit) {
        this.limit = limit;
        this.workLoad = workLoad;
        this.composites = new ArrayList<Integer>();
        this.bits = new BitSet((int) limit);
    }

    @Override
    public void run() {
            
        for (var prime : workLoad) {
            
            for (int ii = prime; ii <= this.limit; ii += prime) {
                    
                this.bits.set(ii);
            }
                    

        }
    }
            
}


