package lab11;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.Iterator;

/**
 *A Minimum Value Tree. 
 *
 *@param <T> the type of data to be put into the heap
 * @author Nat Tuck
 * @author Data Structures Students, Fall 2023
 */
public class MinHeap<T> implements Iterable<T> {
    ArrayList<T> data;
    BiFunction<T, T, Integer> compare;
    /**
     *Compares values within the minHeap.
     *
     * @param compare a compare function
     */
    MinHeap(BiFunction<T, T, Integer> compare) {
        this.data = new ArrayList<T>();
        this.compare = compare;
    }
    /**
     *Adds a piece of data to the minHeap.
     *
     * @param xx a piece of data
     */
    void add(T xx) {
        this.data.add(xx);
        int ii = this.data.size() - 1;
        while (ii != 0) {
            int pidx = parent(ii);
            var aa = this.data.get(ii);
            var bb = this.data.get(pidx);
            int cmp = this.compare.apply(aa, bb);
            if (cmp < 0) {
                swap(ii, pidx);
            }
            else {
                break;
            }
            ii = pidx;
        }
    }
    /**
     *Swaps the position of two pieces of data in the minHeap.
     *
     * @param ii Position of the first piece of data 
     *
     * @param jj Position of the second piece of data
     */
    void swap(int ii, int jj) {
        T temp = this.data.get(ii);
        this.data.set(ii, this.data.get(jj));
        this.data.set(jj, temp);
    }
    /**
     *Returns the top of the heap without removing it. 
     *
     * @return piece of data at the top of the heap
     */
    T peek() {
        if (this.data.size() > 0) {
            return this.data.get(0);
        }
        else {
            return null;
        }
    }
    /**
     *Returns the piece of data at the top of the heap and removes it. 
     *
     * @return the piece of data at the top of the heap
     */
    T poll() {
        if (this.data.size() == 0) {
            return null;
        }
        T yy = this.data.get(0);
        if (this.data.size() > 1) {
            this.swap(0, this.data.size() - 1);
            this.data.remove(this.data.size() - 1);
            if (this.data.size() > 2) {
                if ((this.compare.apply(this.data.get(0), this.data.get(minChild(0)))) > 0) {
                    
                    
                    
                    var curIndex = 0;
                    while (true) {
                        if ((this.compare.apply(this.data.get(curIndex),
                            this.data.get(rightChild(curIndex))) < 0) && 
                            (this.compare.apply(this.data.get(curIndex), 
                                this.data.get(leftChild(curIndex))) < 0)) {
                            break;
                        }
                        var soonNew = minChild(curIndex);
                        this.swap(curIndex, soonNew);
                        curIndex = soonNew;
                        if (rightChild(curIndex) > this.data.size() - 1) {
                            if (leftChild(curIndex) < this.data.size() - 1) {
                                if (this.compare.apply(this.data.get(curIndex), 
                                    this.data.get(rightChild(curIndex))) < 0) {
                                    this.swap(curIndex, leftChild(curIndex));
                                }
                                
                                    
                                
                                    
                            }
                            break;
                        }
                    }
                }
            
            }
            else {
                if (this.data.size() == 2) {
                    if (this.compare.apply(this.data.get(0), this.data.get(1)) > 0) {
                        this.swap(0, 1);
                    }
                }
            }
        }
        
        else {
            this.data.remove(0);
        }
        
        return yy;
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    private int minChild(int ii) {
        int li = leftChild(ii);
        int ri = rightChild(ii);
        if (ri >= this.data.size()) {
            return li;
        }
        T lc = this.data.get(li);
        T rc = this.data.get(ri);
        if (this.compare.apply(lc, rc) < 0) {
            return li;
        }
        else {
            return ri;
        }
    }

    private int parent(int ii) {
        return (ii - 1) / 2;
    }

    private int leftChild(int ii) {
        return 2 * ii + 1;
    }

    private int rightChild(int ii) {
        return 2 * ii + 2;
    }
}
