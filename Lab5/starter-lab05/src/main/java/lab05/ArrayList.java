package lab05;

import java.util.function.Function;

/**
 * A dynamic array.
 *
 * @author Nat Tuck
 * @author [Your Name]
 *
 * @param <T> Type of element
 */
class ArrayList<T> {
    T[] data;
    int length;

    /**
     * Create an empty ArrayList with capacity nn.
     *
     * @param  nn  
     */
    @SuppressWarnings("unchecked")
    ArrayList(int nn) {
        // This appears to be the standard way to
        // get a new array of T.
        this.data = (T[]) new Object[nn];
        this.length = 0;
    }

    /**
     * Create an empty ArrayList with the default capacity.
     */
    ArrayList() {
        this(4);
    }

    /**
     * Create an array list from a provided array.
     *
     * @param  xs  The array
     */
    ArrayList(T[] xs) {
        this.data = xs;
        this.length = xs.length;
    }

    /**
     * Get length.
     *
     * @return current length
     */
    int length() {
        return this.length;
    }

    /**
     * Get capacity.
     *
     * @return current capacity
     */
    int capacity() {
        return this.data.length;
    }

    /**
     * Get item by index.
     *
     * @param  ii  Index
     * @return     The item
     */
    T get(int ii) {
        return this.data[ii];
    }

    /**
     * Set item at index.
     *
     * @param  ii  Index
     * @param  vv  Item to put
     */
    void set(int ii, T vv) {
        this.data[ii] = vv;
    }

    /**
     * Resize the backing array. If new capacity
     * is less than current size, array is truncated.
     *
     * @param  nn  New capacity
     */
    @SuppressWarnings("unchecked")
    void resize(int nn) {
        T[] data1 = (T[]) new Object[nn];
        int len1 = Math.min(nn, this.length);

        for (int ii = 0; ii < len1; ++ii) {
            data1[ii] = this.data[ii];
        }

        this.data = data1;
        this.length = len1;
    }

    /**
     * Increase the size of the backing array to make space
     * for at least one more item.
     */
    void grow() {
        int len1 = length() + 1;
        if (capacity() < len1) {
            resize(Math.max(len1, 2 * capacity()));
        }
    }

    /**
     * Decrease the size of the backing array to avoid
     * wasted space.
     */
    void shrink() {
        resize(Math.max(4, length()));
    }

    /**
     * Add an item to the end of the array.
     *
     * @param  vv  New itemmv
     */
    void append(T vv) {
        grow();
        set(this.length, vv);
        this.length += 1;
    }

    /**
     * Make a shallow copy of this ArrayList.
     *
     * @return  New copy
     */
    @Override
    public ArrayList<T> clone() {
        var ys = new ArrayList<T>(length());
        for (int ii = 0; ii < length(); ++ii) {
            ys.append(get(ii));
        }
        return ys;
    }

    /**
     * Generate a new ArrayList containing the results
     * of applying op to each element in this list.
     *
     * @param  op  The operation
     * @return     New list
     */
    ArrayList<T> map(Function<T, T> op) {
        // FIXME: Implement this
        
        var newList = new ArrayList<T>(this.length);
            
        for (int jj = 0; jj < this.length(); ++jj) {
   
            var v0 = op.apply(this.get(jj));

            newList.append(v0);
        }
        return newList;
    }
        
    

    /**
     * Generate a new ArrayList containing only those items
     * from this list that satisfy the predicate.
     *
     * @param  pred  The predicate
     * @return     New list
     */
    ArrayList<T> filter(Function<T, Boolean> pred) {
        // FIXME: Implement this
        
        var ys = new ArrayList<T>(length());
        var filteredList = new ArrayList<T>();
        for (int ii = 0; ii < length(); ++ii) {
            var x = this.data[ii];
            var result = pred.apply(x);
            if (result == true) {
                filteredList.append(x);
            }
            
        }
        return filteredList; 
    }

     
        

        

        


        
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int ii = 0; ii < length(); ++ii) {
            sb.append(get(ii).toString());
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
