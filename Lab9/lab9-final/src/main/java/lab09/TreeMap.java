package lab09;

import java.util.function.Consumer;
import java.util.ArrayList;

/**
 * Binary Search Tree implementation with key-value pairs.
 *
 * @author Nat Tuck
 * @author Violet Lempke
 * @author Hunter Harris
 * @author Rider McCallum
 *
 * @param <K> Type of keys in the tree.
 * @param <V> Type of values associated with the keys.
 */
public class TreeMap<K extends Comparable<K>, V> {
    BinNode<K, V> root;
    int depth;
    int size;
    int maxSize;
    boolean needsRebalance;

    /**
     * Makes a new empty TreeMap.
     *
     * @author Nat Tuck
     *
     */
    public TreeMap() {
        this.root = new BinLeaf<K, V>();
        this.depth = 0;
        this.size = 0;
        this.maxSize = 0;
        this.needsRebalance = false; 
    }

    /**
     * Returns the size of the tree.
     *
     * @author Nat Tuck.
     *
     * @return The size of the tree.
     */
    int size() {
        return this.size;
    }
    
    /**
     * Checks if the tree contains the key.
     *
     * @author Nat Tuck.
     *
     * @param key The key to search for.
     * @return True if the key exists in the tree.
     */
    boolean hasKey(K key) {
        return root.hasKey(key);
    }

    /**
     * Retrieves the value associated with a given key in the tree.
     *
     * @author Nat Tuck.
     *
     * @param key The key to look up.
     * @return The value associated with the key.
     */
    V get(K key) {
        return root.get(key);
    }


    /**
     * Inserts a pair into the tree.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param key The key to insert.
     * @param val The value associated with the key.
     */
    void insert(K key, V val) {
        boolean addedItem = false;

        if (!this.hasKey(key)) {
            addedItem = true;
        }
        this.root = this.root.insert(key, val, 0);
        
        if (addedItem) {
            this.size += 1;
            this.maxSize = Math.max(this.size, this.maxSize);
        }
        /* 
        if (needsRebalance) {
            this.root = this.root.rebalance();
        }
        */
    }

    /**
     * Deletes a key from the tree.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param key The key to delete.
     */
    void delete(K key) {
        if (!this.root.hasKey(key)) {
            return;
        }

        this.root = this.root.delete(key);
        this.size -= 1;
    }

    /**
     * Returns a list of keys.
     *
     * @author Nat Tuck
     *
     * @return An ArrayList containing the keys.
     */
    ArrayList<K> keys() {
        var ys = new ArrayList<K>();
        for (var ee : this.toList()) {
            ys.add(ee.key());
        }
        return ys;
    } 
    /**
     * Returns height.
     *
     * @author Nat Tuck.
     *
     * @return Height.
     */
    int height() {
        return root.height();
    }

    /**
     * Iterator over tree.
     *
     * @author Nat Tuck.
     * @param op Operator to apply to each entry.
     */
    void eachEntry(Consumer<Entry<K, V>> op) {
        root.eachEntry(op);
    }

    /**
     * Creates a list from tree.
     *
     * @author Nat Tuck.
     * @return A list of tree data.
     */
    ArrayList<Entry<K, V>> toList() {
        return root.toList();
    }

    @Override
    public String toString() {
        return String.format("{size=%d maxSize=%d %s}",
                             this.size,
                             this.maxSize,
                             this.root.toString());
    }

    /**
     * Finds max depth of a tree.
     *
     * @author Nat Tuck
     * @return Max depth of tree.
     */
    int maxDepth() {
        return (int) (Math.ceil(2 * log2(this.size + 2)));
    }

    /**
     * Gets log of a number.
     *
     * @author Nat Tuck.
     * @param xx Number to get log of.
     * @return Log of xx.
     */
    static double log2(double xx) {
        return Math.log(xx) / Math.log(2.0);
    }
}

/**
 * Interface for a singular node.
 *
 * @author Nat Tuck
 * @author Violet Lempke
 * @author Hunter Harris
 * @author Rider McCallum
 *
 * @param <V> Type of data.
 * @param <K> Type of data.
 */
interface BinNode<K extends Comparable<K>, V> {
    /**
     * Tell whether or not current nod is a leaf.
     *
     * @author Nat tuck
     *
     * @return True if leaf, false if not.
     */
    boolean isLeaf();

    /**
     * Tell whether or not key already exists.
     *
     * @author Nat Tuck
     * @param key Key to look for.
     * @return True if key exists, false if it doesn't.
     */
    boolean hasKey(K key);

    /**
     * Inserts a key if key not already present, checks for rebalancing.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     * @param key Key to insert if not already present.
     * @param val Value associated with key.
     * @param depth Depth of tree.
     * @return Maybe a new tree if key isn't present.
     */
    BinNode<K, V> insert(K key, V val, int depth);

    /**
     * Gets key.
     *
     * @author Nat Tuck
     * @param key Key to look for.
     * @return Key.
     */
    V get(K key);

    /**
     * Deletes a key if it exists.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     * @param key Key to search for.
     * @return A tree without the provided key.
     */
    BinNode<K, V> delete(K key);

    /**
     * Merges two trees.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     * @param other Second tree.
     * @return A new tree incorporating both trees' nodes.
     */
    BinNode<K, V> merge(BinNode<K, V> other);

    /**
     * Data of an individual node.
     *
     * @author Nat Tuck.
     * @return Data of a node.
     */
    Entry<K, V> data();

    /**
     * Node left of current node.
     *
     * @author Nat Tuck
     * @return Node's left node.
     */
    BinNode<K, V> left();

    /**
     * Node right of current node.
     *
     * @author Nat Tuck
     * @return Node's left node.
     */
    BinNode<K, V> right();
    
    /**
     * Size of tree.
     *
     * @author Nat Tuck
     *
     * @return Amount of items/nodes in tree.
     */
    int size();

    /**
     * Gives height of the tree.
     *
     * @author Nat Tuck
     *
     * @return Height of tree.
     */
    int height();

    /**
     * Balances a tree.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     * @return A balanced binary tree.
     */
    BinNode<K, V> rebalance();

    /**
     * Iterator over every entry.
     *
     * @author Nat Tuck
     *
     * @param op Operation to peform on each entry.
     */
    void eachEntry(Consumer<Entry<K, V>> op);

    /**
     * Creates a list out of everything in the tree.
     *
     * @author Nat Tuck
     * @return List of data.
     */
    default ArrayList<Entry<K, V>> toList() {
        var ys = new ArrayList<Entry<K, V>>();
        this.eachEntry((xx) -> ys.add(xx));
        return ys;
    }

    /**
     * Returns a balanced tree.
     *
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param <K> Type of data.
     * @param <V> Type of data.
     * @param ents Entries.
     * @param i0 Index one.
     * @param i1 Index two.
     * @return A balanced tree.
     */
    static <K extends Comparable<K>, V> BinNode<K, V>
          fromList(ArrayList<Entry<K, V>> ents, int i0, int i1) {

        // Given a list, return a balanced tree.

        return new BinLeaf<K, V>();
    }
}

/**
 * Record for a Bin leaf.
 *
 * @author Nat Tuck
 * @author Violet lempke
 * @author Hunter Harris
 * @author Rider McCallum
 * @param <V> Type of data.
 * @param <K> Type of data.
 */
record BinLeaf<K extends Comparable<K>, V>() implements BinNode<K, V> {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean hasKey(K _key) {
        return false;
    }

    @Override
    public BinNode<K, V> insert(K key, V val, int depth) {
        // depth += 1;
        // addedItem = true;
        // if (depth > maxDepth) { needsRebalance = true; }
        return new BinBranch<K, V>(new Entry<K, V>(key, val), this, this);
    }

    @Override
    public V get(K key) {
        throw new RuntimeException("no such key");
    }

    @Override
    public BinNode<K, V> delete(K _key) {
        return this;
    }

    @Override
    public BinNode<K, V> merge(BinNode<K, V> that) {
        return that;
    }

    @Override
    public Entry<K, V> data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<K, V> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinNode<K, V> right() {
        throw new RuntimeException("leaf");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public BinNode<K, V> rebalance() {
        return this;
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void eachEntry(Consumer<Entry<K, V>> op) {
        // do nothing
    }
}

/**
 * Record for a BinBranch.
 *
 * @author Nat Tuck
 * @author Violet Lempke
 * @author Hunter Harris
 * @author Rider McCallum
 *
 * @param left Left node.
 * @param right Right node.
 * @param data Node data.
 * @param <V> Type of data.
 * @param <K> Type of data.
 */
record BinBranch<K extends Comparable<K>, V>(
            Entry<K, V> data, BinNode<K, V> left, BinNode<K, V> right)
        implements BinNode<K, V> {
    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean hasKey(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left.hasKey(key);
        }
        else {
            return this.right.hasKey(key);
        }
    }

    @Override
    public BinNode<K, V> insert(K key, V val, int depth) {
        depth += 1;
        
        
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            var ent = new Entry<K, V>(key, val);
            return new BinBranch<K, V>(ent, this.left, this.right);
        }

        BinNode<K, V> node;

        if (cmp < 0) {
            node = new BinBranch<K, V>(this.data,
                                       this.left.insert(key, val, depth),
                                       this.right);
        }
        else {
            node = new BinBranch<K, V>(this.data,
                                       this.left,
                                       this.right.insert(key, val, depth));
        }

        // if needsRebalance and size(largerChild) / size(here) > 0.7
        // then we need to return a rebalanced node.
        return node;
    }

    @Override
    public V get(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return this.data().val();
        }
        if (cmp < 0) {
            return this.left.get(key);
        }
        else {
            return this.right.get(key);
        }
    }

    @Override
    public BinNode<K, V> delete(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new BinBranch<K, V>(this.data,
                                    this.left.delete(key), this.right);
        }
        else {
            return new BinBranch<K, V>(this.data,
                                    this.left, this.right.delete(key));
        }
    }

    @Override
    public BinNode<K, V> merge(BinNode<K, V> that) {
        if (that.isLeaf()) {
            return this;
        }

        return this.insert(that.data().key(), that.data().val(), 0)
            .merge(that.left())
            .merge(that.right());
    }

    @Override
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    @Override
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    @Override
    public BinNode<K, V> rebalance() {
        // TODO: This should return a balanced subtree
        // containing the same entries as the current subtree.
        return this;
    }

    
    @Override
    public String toString() {
        var sb = new StringBuilder();
        if (this.left.isLeaf() && this.right.isLeaf()) {
            sb.append(" [");
            sb.append(this.data.key());
            sb.append(" => ");
            sb.append(this.data.val());
            sb.append("] ");
        }
        else {
            sb.append("(");
            sb.append(this.left.toString());
            sb.append(" [");
            sb.append(this.data.key());
            sb.append(" => ");
            sb.append(this.data.val());
            sb.append("] ");
            sb.append(this.right.toString());
            sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public void eachEntry(Consumer<Entry<K, V>> op) {
        this.left().eachEntry(op);
        op.accept(this.data());
        this.right().eachEntry(op); 
    }
}

