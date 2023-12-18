package lab08;

import java.util.Iterator;

/**
 * Implements a generic set with a cons list structure.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public interface ConsSet<T extends Comparable<T>>
    extends Iterable<T>, Comparable<ConsSet<T>> {

    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T extends Comparable<T>> ConsSet<T> set(T... args) {
        ConsSet<T> ys = new ConsEmpty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = ys.add(args[ii]);
        }
        return ys;
    }
    /**
     *Checks whether or not a set is empty. 
     *
     * @return a boolean 
     */
    boolean isEmpty();

    /**
     * Get the first item in the set.
     *
     * @return  The first item
     */ 
    T first();

    /**
     * Get the set of all items except the first.
     *
     * @return  The rest of the list
     */
    ConsSet<T> rest();

    /**
     * Add an item to the set.
     *
     *@param item an item. 
     *
     *@return the list excluding the first item
     */
    ConsSet<T> add(T item);
    /**
     *Remove an item from the set. 
     *
     * @param item an item 
     *
     * @return a new set with item added.
     */
    ConsSet<T> remove(T item);
    /**
     *Determines whether or not a set contains an item.
     *
     *@param item an item
     * 
     *@return a boolean
     */
    boolean contains(T item);
    /**
     *Returns all values contained within two sets in a new set. 
     *
     * @param other a ConsSet
     *
     * @return a ConsSet
     */
    ConsSet<T> union(ConsSet<T> other);
    /**
     *Returns a set containing items common to both ConsSets.
     *
     * @param other a ConsSet
     *
     * @return a ConsSet
     */
    ConsSet<T> intersection(ConsSet<T> other);
    /**
     *Determines if all item from a set are in another.
     *
     * @param other a ConsSet
     *
     * @return a boolean
     */
    boolean isSubset(ConsSet<T> other);
    /**
     *Determines whether or not other is a subset of the set. 
     *
     * @param other a ConsSet
     *
     * @return a boolean
     */
    boolean isSuperset(ConsSet<T> other);
    
    /**
     * Determine the size of the set.
     *
     * @return  Size of set.
     */
    int size();
    /**
     *Returns the default iterator for ConsSet.
     *
     *@return an iterator 
     */
    default Iterator<T> iterator() {
        return new ConsSetIterator<T>(this);
    }
}

/**
 * An empty set.
 *
 * @param  <T>   Type of item in set.
 *
 * @author Nat Tuck
 */
record ConsEmpty<T extends Comparable<T>>() implements ConsSet<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T first() {
        throw new RuntimeException("empty set");
    }

    @Override
    public ConsSet<T> rest() {
        throw new RuntimeException("empty set");
    }

    @Override
    public ConsSet<T> add(T item) {
        return new ConsCell<T>(item, this);
    }

    @Override
    public ConsSet<T> remove(T item) {
        return this;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public ConsSet<T> union(ConsSet<T> other) {
        return other;
    }

    @Override
    public ConsSet<T> intersection(ConsSet<T> other) {
        return this;
    }
    
    @Override
    public boolean isSubset(ConsSet<T> other) {
        return true;
    }

    @Override
    public boolean isSuperset(ConsSet<T> other) {
        return other.isSubset(this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "{ }";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ConsEmpty<?>;
    }

    @Override
    public int compareTo(ConsSet<T> that) {
        if (that.isEmpty()) {
            return 0;
        }
        return -1;
    }
}

/**
 * A non-empty set.
 *
 * @param  <T>   Type of item in set
 * @param  first  First item in the set
 * @param  rest   The rest of the set
 *
 * @author Nat Tuck
 */
record ConsCell<T extends Comparable<T>>(T first, ConsSet<T> rest) implements ConsSet<T> {
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public int size() {
        return 1 + rest.size();
    }

    @Override
    public ConsSet<T> add(T item) {
        int cmp = this.first.compareTo(item);
        // TODO: Add item to list, keeping items in sorted order.
       
        ConsSet<T> xx = this;
        var pointer = 0;
        var zz = true;
        while (zz == true) {
            if (xx.isEmpty()) {
                return new ConsCell<T>(item, this);
            }
            cmp = xx.first().compareTo(item);
            if (cmp == 0) {
                return this;
            }
            
            if (cmp > 0) {
                
                var newGuy = new ConsEmpty<T>();
                ConsSet<T> newestGuy = newGuy.add(item);
                
                newestGuy = new ConsCell<T>(item, xx);
                xx = this;
                for (int ii = 0; ii < pointer; ii++) {
                    newestGuy = newestGuy.add(xx.first());
                    xx = xx.rest();
                    
                }
                return newestGuy;
            }
            pointer += 1;
                
            xx = xx.rest();
            if (xx.isEmpty()) {
                zz = false;
            }
        }
        xx = this;
            
        var newGuy = new ConsEmpty<T>();
        ConsSet<T> newestGuy = newGuy.add(item);
        while (!xx.isEmpty()) {
            newestGuy = newestGuy.add(xx.first());
            xx = xx.rest();
        }
                
        
            
            
        
        return newestGuy;
    }

    @Override
    public ConsSet<T> remove(T item) {
        if (this.first() == item) {
            return this.rest();
        }
        var xx = this.rest();
        var pointer = 1;
        while (!xx.isEmpty()) {
            
            if (xx.first() == item) {
                var temp = new ConsEmpty<T>();
                ConsSet<T> newList = temp.add(first());
                xx = this;
                for (int ii = 0; ii < pointer; ii++) {
                    newList = newList.add(xx.first());
                    xx = xx.rest();
                        
                }
                
                xx = xx.rest();
                    
                while (!xx.isEmpty()) {
                    newList = newList.add(xx.first());
                    xx = xx.rest();
                }
                    
                return newList;
            }
            pointer += 1;
            xx = xx.rest();
        }
        return this;
    }

    @Override
    public boolean contains(T item) {
        if (this.first.equals(item)) {
            return true;
        }
        else {
            return this.rest.contains(item);
        }
    }

    @Override
    public ConsSet<T> union(ConsSet<T> other) {
        // TODO: Calculate Union
        var temp = new ConsEmpty<T>();
        ConsSet<T> newList = temp.add(this.first);
        var xx = this.rest();
        while (!xx.isEmpty()) {
            newList = newList.add(xx.first());
            xx = xx.rest();
        }
        newList = newList.add(other.first());
        xx = other;
        
        while (!xx.isEmpty()) {
            newList = newList.add(xx.first());
            xx = xx.rest();
        }
        return newList;
    }

    @Override
    public ConsSet<T> intersection(ConsSet<T> other) {
        // TODO: Calculate Intersection
        var temp = new ConsEmpty<T>();
        ConsSet<T> intersection = temp;
        ConsSet<T> xx = this;
        while (!xx.isEmpty()) {
            var yy = other;
            while (!yy.isEmpty()) { 
                int cmp = xx.first().compareTo(yy.first());
                if (cmp == 0) {
                    intersection = intersection.add(xx.first());
                }
                yy = yy.rest();
            }
            xx = xx.rest();
        }
        return intersection;
    }
    
    @Override
    public boolean isSubset(ConsSet<T> other) {
        // TODO: Calculate isSubset
        // (Is this a subset of other?)
        ConsSet<T> xx = this;
        while (!xx.isEmpty()) {
            ConsSet<T> yy = other;
            var match = false;
            while (!yy.isEmpty())  {
                int cmp = xx.first().compareTo(yy.first());
                if (cmp == 0) {
                    match = true;
                }
                yy = yy.rest();
            }
            if (!match) {
                return false;
            }
            xx = xx.rest();
        }
        return true;

    }

    @Override
    public boolean isSuperset(ConsSet<T> other) {
        // TODO: Calculate isSuperset
        // (Is this a superset of other?)
        return (other.isSubset(this));

    }

    @Override
    public String toString() {
        var tmp = rest.toString();
        return "{ " + first + " " + tmp.substring(2, tmp.length() - 1) + "}";
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ConsSet<?>)) {
            return false;
        }

        ConsSet<?> that = (ConsSet<?>) other;
        return this.first().equals(that.first()) && this.rest().equals(that.rest());
    }

    @Override
    public int compareTo(ConsSet<T> that) {
        if (that.isEmpty()) {
            return 1;
        }

        int dx = this.first().compareTo(that.first());
        if (dx != 0) {
            return dx;
        }
        else {
            return this.rest().compareTo(that.rest());
        }
    }
}
/**
 *The code for our Iterator.
 *
 *@param <T> expands our iterator. 
 *
 *@author Nat Tuck
 *
 */
class ConsSetIterator<T extends Comparable<T>> implements Iterator<T> {
    ConsSet<T> curr;
    /**
     * returns the current item.
     *
     *@param xs current item
     *
     */
    ConsSetIterator(ConsSet<T> xs) {
        this.curr = xs;
    }

    @Override
    public boolean hasNext() {
        return !this.curr.isEmpty();
    }

    @Override
    public T next() {
        T item = this.curr.first();
        this.curr = this.curr.rest();
        return item;
    }
}
