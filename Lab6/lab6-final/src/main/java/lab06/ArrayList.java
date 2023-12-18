package lab06;

import java.util.function.Function;

/**
 * A dynamic array.
 *
 * @author Nat Tuck
 *
 * @param <T> Type of element
 */
class ArrayList<T> {
    T[] data;
    int length;

    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T> ArrayList<T> list(T... args) {
        ArrayList<T> ys = new ArrayList<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys.append(args[ii]);
        }
        return ys;
    }
    
    /**
     * Create an empty ArrayList.
     */
    @SuppressWarnings("unchecked")
    ArrayList() {
        // This appears to be the standard way to
        // get a new array of T.
        this.data = (T[]) new Object[2];
        this.length = 0;
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
     * Set length.
     *
     * @param  nn  New length
     */
    void setLength(int nn) {
        if (nn > capacity()) {
            setCapacity(2*length());
        }
        this.length = nn;
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
     * Resize the backing array. If new capacity
     * is less than current size, array is truncated.
     *
     * @param  nn  New capacity
     */
    @SuppressWarnings("unchecked")
    void setCapacity(int nn) {
        T[] data1 = (T[]) new Object[nn];
        int len1 = Math.min(nn, this.length);

        for (int ii = 0; ii < len1; ++ii) {
            data1[ii] = this.data[ii];
        }

        this.data = data1;
        this.length = len1;
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
     * Add an item to the end of the array.
     *
     * @param  vv  New item
     */
    void append(T vv) {
        if (capacity() < 1 + length()) {
            setCapacity(2 * length());
        }
        set(this.length, vv);
        this.length += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int ii = 0; ii < length(); ++ii) {
            sb.append(get(ii).toString());
            if (ii < length() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
