package lab10;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A Set implemented using a hash table.
 *
 *@author Violet Lempke
 *
 * @param  <T>  Type of value in set.
 */
public class HashSet<T extends Comparable<T>>
    implements Iterable<T>, Comparable<HashSet<T>> {
    // TODO: Declare data field
    HashMap<T, T> data;
    int size = 0;
    /**
     * Create a set from the provided args.
     *
     *@author Violet Lempke
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
        this.data = new HashMap<T, T>();

        
    }

    /**
     * Determine if set contains item.
     *
     * @param  item  The item to check for
     * @return       True if item in set
     */
    boolean contains(T item) {
        // TODO: contains
        if (item instanceof HashSet<?>) {
            for (var xx : this) {
                if (xx.equals(item)) {
                    return true;
                }
                
            }
            return false;
        }
        return this.data.hasKey(item);
    }

    /**
     * Add item to set.
     *
     * @param  item  Item to add
     */
    void add(T item) {
        // TODO: Add item
        this.data.put(item, item);
    }

    /**
     * Remove item from set.
     *
     * @param  item  Item to remove
     */
    void remove(T item) {
        // TODO: Remove
        this.data.del(item);
    }

    /**
     * Calculate the union of two sets.
     *
     * @param  that  The other set
     * @return       Union of this and that
     */ 
    HashSet<T> union(HashSet<T> that) {
        // TODO: union
        var unionSet = new HashSet<T>();
        for (var xx : this) {
            unionSet.add(xx);
        }
        for (var yy : that) {
            unionSet.add(yy);
        }
        return unionSet;
    }

    /**
     * Calculate the intersection of two sets.
     *
     * @param  that  The other set
     * @return       Intersection of this and that
     */ 
    HashSet<T> intersection(HashSet<T> that) {
        // TODO: intersection
        var intersecting = new HashSet<T>();
        for (var xx : this) {
            for (var yy : that) {
                if (xx.equals(yy)) {
                    intersecting.add(xx);
                }
            }
        }
        return intersecting;
    }

    /**
     * Determine if this set is a superset of another set.
     *
     * @param  that  The other set
     * @return       True if this is superset of that.
     */ 
    boolean isSuperset(HashSet<T> that) {
        // TODO: isSuperset

        return that.isSubset(this);
    }

    /**
     * Determine if this set is a subset of another set.
     *
     * @param  that  The other set
     * @return       True if this is subset of that.
     */ 
    boolean isSubset(HashSet<T> that) {
        boolean flag = false;
        for (var xx : this) {
            if (that.contains(xx)) {
                continue;
            }
            else {
                return false;
            }
        
            
        }
        
        return true;

    }
            
       
    

    /**
     * Number of items in set.
     *
     * @return How many items in set
     */ 
    int size() {
        // TODO: size
        return this.size;
    }

    /**
     * Construct a list of the items in this set.
     *
     * @return List of items
     */
    ArrayList<T> toList() {
        var ys = this.data.keys();
        ys.sort(null);
        return ys;
        
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
        return 75 + Math.floorMod(this.data.hashCode(), 4);
    }

    @Override
    public int compareTo(HashSet<T> that) {
        // TODO: compareTo
        return (this.hashCode() - that.hashCode());
    }
}

