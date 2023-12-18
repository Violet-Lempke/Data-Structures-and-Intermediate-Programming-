package lab08;

import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 *Basic Interface for a BinTree.
 *
 *@param <T> The type of item
 *
 *@author Nat Tuck
 */
interface BinTree<T extends Comparable<T>> extends Iterable<T> {
    /**
     *Creates an empty tree.
     *
     *@author Nat Tuck
     *
     *@param <U> Creates an empty tree. 
     *
     *@return an empty tree
     */
    public static <U extends Comparable<U>> BinTree<U> makeEmpty() {
        return new BinLeaf<U>();
    }
    /**
     *Determines whether a node is a leaf.
     *
     *@return a boolean
     */
    boolean isLeaf();
    /**
     *Checks if a tree contains an item. 
     *
     * @param item an item
     *
     * @return a boolean
     */
    boolean contains(T item);
    /**
     *Inserts an item into a tree. 
     *
     * @param t an item
     *
     * @return a tree with the item removed. 
     */
    BinTree<T> insert(T t);
    /**
     *Removes an item from a tree. 
     *
     * @param item the item to be inserted. 
     *
     * @return a tree with the item inserted.
     */
    BinTree<T> remove(T item);
    /**
     *Creates a new tree containing the elements of 2 trees. 
     *
     * @param other a binTree
     *
     * @return a binTree. 
     */
    BinTree<T> merge(BinTree<T> other);
    /**
     * Returns the data in a node. 
     *
     * @return an item
     */
    T data();
    /**
     *Moves left a node in the tree.
     *
     * @return none
     */
    BinTree<T> left();
    /**
     *Moves right a node in the tree.
     *
     * @return none
     */
    BinTree<T> right();
    /**
     *Finds the number of items. 
     *
     *@return an integer
     */
    int length();
    /**
     *Our default iterator.
     *
     *@return the BinTreeIterator
     */
    default Iterator<T> iterator() {
        return new BinTreeIterator<T>(this);
    }
}
/**
 *Record representing a leaf of the binTree.
 *
 *@author Nat Tuck
 *
 *@param <T> I don't really know what this is for. 
 */
record BinLeaf<T extends Comparable<T>>() implements BinTree<T> {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean contains(T _item) {
        return false;
    }

    @Override
    public BinTree<T> insert(T item) {
        return new BinBranch<T>(item, this, this);
    }

    @Override
    public BinTree<T> remove(T item) {
        return this;
    }

    @Override
    public BinTree<T> merge(BinTree<T> that) {
        return that;
    }

    @Override
    public T data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinTree<T> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public BinTree<T> right() {
        throw new RuntimeException("leaf");
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public String toString() {
        return ".";
    }
}
/**
 *Record for a branch of a binTree.
 *
 *@author Nat Tuck. 
 *
 *@param <T> the type of item. 
 *
 *@param data the data in the branch. 
 *
 *@param left the node left of the branch.
 *
 *@param right the node right of the branch. 
 */
record BinBranch<T extends Comparable<T>>(T data, BinTree<T> left, BinTree<T> right)
        implements BinTree<T> {
    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left.contains(item);
        }
        else {
            return this.right.contains(item);
        }
    }

    @Override
    public BinTree<T> insert(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this;
        }
        if (cmp < 0) {
            return new BinBranch<T>(this.data, this.left.insert(item), this.right);
        }
        else {
            return new BinBranch<T>(this.data, this.left, this.right.insert(item));
        }
    }

    @Override
    public BinTree<T> remove(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new BinBranch<T>(this.data, this.left.remove(item), this.right);
        }
        else {
            return new BinBranch<T>(this.data, this.left, this.right.remove(item));
        }
    }

    @Override
    public BinTree<T> merge(BinTree<T> that) {
        if (that.isLeaf()) {
            return this;
        }

        return this.insert(that.data())
            .merge(that.left())
            .merge(that.right());
    }

    @Override
    public int length() {
        return 1 + this.left.length() + this.right.length();
    }

    @Override
    public String toString() {
        if (this.left.isLeaf() && this.right.isLeaf()) {
            return this.data.toString();
        }

        var sb = new StringBuilder();
        sb.append("(");
        sb.append(this.left.toString());
        sb.append(" ");
        sb.append(this.data.toString());
        sb.append(" ");
        sb.append(this.right.toString());
        sb.append(")");
        return sb.toString();
    }
}
/**
 *In order iterator for a binTree. 
 *
 *@param <T> the type of item. 
 *
 *@author Violet Lempke
 */
class BinTreeIterator<T extends Comparable<T>> implements Iterator<T> {
    Deque<BinTree<T>> path;
    BinTree<T> node;
    /**
     *Basic Iterator for a bintree.
     *
     *@param node a node. 
     *
     */
    BinTreeIterator(BinTree<T> node) {
        this.node = node;
        this.path = new ArrayDeque<BinTree<T>>();
    }

    @Override
    public boolean hasNext() {
        return !(this.node.isLeaf() && this.path.isEmpty());
    }

    @Override
    public T next() {
        // TODO: Complete this.
        
        if (this.node.isLeaf()) {
            this.node = path.pop();
            var zz = this.node.data();
            this.node = this.node.right();
            return zz;
            
        }
        
       
        while (!this.node.left().isLeaf()) {
            path.push(this.node);
            this.node = this.node.left();

            
        }
        if (!this.node.right().isLeaf()) {
            var yy = this.node.data();
            this.node = this.node.right();
            return (yy);
        }
        var zz = this.node.data();
        this.node = this.node.right();
        return zz;
            
            

    }
        
        
}
   

