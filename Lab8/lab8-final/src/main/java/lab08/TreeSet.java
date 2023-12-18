package lab08;

import java.util.Iterator;
import java.util.ArrayList;
/**
 *The code for a treeset.
 *
 *@author Nat Tuck
 *
 *@author Violet Lempke
 *
 *@param <T> the type of data
 *
 *@param data data in tree
 */
public record TreeSet<T extends Comparable<T>>(BinTree<T> data)
    implements Iterable<T>, Comparable<TreeSet<T>> {
    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <U extends Comparable<U>> TreeSet<U> set(U... args) {
        
        BinTree<U> xs = BinTree.<U>makeEmpty();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            xs = xs.insert(args[ii]);
        }
        return new TreeSet<U>(xs);
    }
    /**
     *Adds an item to a TreeSet.
     *
     *@author Violet Lempke
     *
     * @param item an item
     *
     * @return a TreeSet
     */
    TreeSet<T> add(T item) {
        return new TreeSet<T> (this.data.insert(item));
    }
    /**
     *Removes an item from a TreeSet.
     *
     *@author Violet Lempke
     *
     * @param item an item
     *
     * @return a TreeSet
     */
    TreeSet<T> remove(T item) {
        return new TreeSet<T> (this.data.remove(item));
        
    }
    /**
     *Determines if a TreeSet contains an item.
     *
     * @author Violet Lempke
     *
     * @param item an item.
     *
     * @return a TreeSet.
     */
    boolean contains(T item) {
        
        for (var xx : this) {
            if (xx.equals(item)) {
                return true;
            }
        }
        return false;
    
    }   
    /**
     *Creates a tree set containing all items from two TreeSets. 
     *
     * @param that a TreeSet
     *
     * @return a TreeSet
     */
    TreeSet<T> union(TreeSet<T> that) {
        // TODO
        return new TreeSet<T> (this.data.merge(that.data()));
        
    }
    /**
     *returns a TreeSet of the shared Items in two TreeSets. 
     *
     * @param that a TreeSet
     * 
     * @return a TreeSet
     */
    TreeSet<T> intersection(TreeSet<T> that) {
        var tempTree = this.data();
        var newTree = BinTree.<T>makeEmpty();
        for (var xx : tempTree) {
            if (that.data.contains(xx)) {
                newTree = newTree.insert(xx);
                
            }
        }
        return new TreeSet<T> (newTree);
    }
        
    /**
     *Determines whether all the items in a TreeSet are in another.
     *
     * @param that
     * @return
     */
    boolean isSubset(TreeSet<T> that) {
        var tempTree = this.data();
        for (var xx : tempTree) {
            if (!that.contains(xx)) {
                return false;
            }
        }
        return true;
    }
    /**
     *Determines whether the parameter TreeSet is a subset of the other.
     *
     * @param that a TreeSet
     *
     * @return a TreeSet
     */
    boolean isSuperset(TreeSet<T> that) {
        return that.isSubset(this);
    }
    /**
     *Returns the number of items in a TreeSet.
     *
     * @return an integer
     */
    int size() {
        return this.data.length();
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    @Override
    public int compareTo(TreeSet<T> that) {
        var xi = this.iterator();
        var yi = that.iterator();

        while (xi.hasNext() && yi.hasNext()) {
            var xx = xi.next();
            var yy = xi.next();
            var cc = xx.compareTo(yy);
            if (cc != 0) {
                return cc;
            }
        }

        if (xi.hasNext()) {
            return 1;
        }

        if (yi.hasNext()) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TreeSet<?>)) {
            return false;
        }

        TreeSet<?> that = (TreeSet<?>) other;
        var xi = this.iterator();
        var yi = that.iterator();

        var xs = new ArrayList<Object>();
        xi.forEachRemaining(xs::add);

        var ys = new ArrayList<Object>();
        yi.forEachRemaining(ys::add);

        return xs.equals(ys);
    }
}
