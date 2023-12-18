package lab10;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A Set implemented using a hash table.
 *
 * @param  <T>  Type of value in set.
 */
public class HashSet<T extends Comparable<T>>
        implements Iterable<T>, Comparable<HashSet<T>> {
    // TODO: Declare data field
    // HashMap<?, ?> data;

    /**
     * Create a set from the provided args.
     *
     * @param  <U>  Item type
     * @param  args Items
     * @return      New set
     */
    @SafeVarargs
    public static <U extends Comparable<U>> HashSet<U> set(U... args) {
        var ys = new HashSet<U>();
        for (var item : args) {
            ys.add(item);
        }
        return ys;
    }

    /**
     * Initalize our set.
     */
    HashSet() {
        // TODO: intialize fields
    }

    /**
     * Determine if set contains item.
     *
     * @param  item  The item to check for
     * @return       True if item in set
     */
    boolean contains(T item) {
        // TODO: contains
        return false;
    }

    /**
     * Add item to set.
     *
     * @param  item  Item to add
     */
    void add(T item) {
        // TODO: Add item
    }

    /**
     * Remove item from set.
     *
     * @param  item  Item to remove
     */
    void remove(T item) {
        // TODO: Remove
    }

    /**
     * Calculate the union of two sets.
     *
     * @param  that  The other set
     * @return       Union of this and that
     */ 
    HashSet<T> union(HashSet<T> that) {
        // TODO: union
        return null;
    }

    /**
     * Calculate the intersection of two sets.
     *
     * @param  that  The other set
     * @return       Intersection of this and that
     */ 
    HashSet<T> intersection(HashSet<T> that) {
        // TODO: intersection
        return null;
    }

    /**
     * Determine if this set is a superset of another set.
     *
     * @param  that  The other set
     * @return       True if this is superset of that.
     */ 
    boolean isSuperset(HashSet<T> that) {
        // TODO: isSuperset
        return true;
    }

    /**
     * Determine if this set is a subset of another set.
     *
     * @param  that  The other set
     * @return       True if this is subset of that.
     */ 
    boolean isSubset(HashSet<T> that) {
        // TODO: subset
        return true;
    }

    /**
     * Number of items in set.
     *
     * @return How many items in set
     */ 
    int size() {
        // TODO: size
        return 4;
    }

    /**
     * Construct a list of the items in this set.
     *
     * @return List of items
     */
    ArrayList<T> toList() {
        //var ys = this.data.keys();
        //ys.sort(null);
        //return ys;
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return this.toList().iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof HashSet<?>)) {
            return false;
        }
        HashSet<?> that = (HashSet<?>) other;
        return this.toList().equals(that.toList());
    }

    @Override
    public int hashCode() {
        // TODO: hashCode
        return 5;
    }

    @Override
    public int compareTo(HashSet<T> that) {
        // TODO: compareTo
        return 5;
    }
} 
