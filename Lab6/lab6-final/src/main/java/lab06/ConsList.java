package lab06;

import java.util.function.Function;

/**
 * Implements a generic linked list.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public interface ConsList<T> {
    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T> ConsList<T> list(T... args) {
        ConsList<T> ys = new Empty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = new Cell<T>(args[ii], ys);
        }
        return ys;
    }

    /**
     * Add item at start of list.
     *
     * @param  <T>   Item type
     * @param  item  Item to add
     * @param  list  List to add item to
     * @return       New list with item added
     */
    public static <T> ConsList<T> cons(T item, ConsList<T> list) {
        return new Cell<T>(item, list);
    }

    /**
     * Get the first item in the list.
     *
     * @return  The first item
     */ 
    T first();

    /**
     * Get a list of all items except the first.
     *
     * @return  The rest of the list
     */
    ConsList<T> rest();

    /**
     * Determine if the list is empty.
     *
     * @return  True for empty list, else false.
     */
    boolean empty();

    /**
     * Determine the length of the list.
     *
     * @return  ConsList length
     */
    int length();

    /**
     * Get an item in list by index.
     *
     * @param  ii  The index
     * @return     Value at index
     */
    T get(int ii);
}

/**
 * An empty list.
 *
 * @param  <T>   ConsList item type
 *
 * @author Nat Tuck
 */
record Empty<T>() implements ConsList<T> {
    @Override
    public T first() {
        throw new Error("empty list");
    }

    @Override
    public ConsList<T> rest() {
        throw new Error("empty list");
    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T get(int ii) {
        throw new Error("empty list");
    }

    @Override
    public String toString() {
        return "()";
    }

}

/**
 * A non-empty list.
 *
 * @param  <T>    Type of item in list
 * @param  first  First item in the list
 * @param  rest   The rest of the list
 *
 * @author Nat Tuck
 */
record Cell<T>(T first, ConsList<T> rest) implements ConsList<T> {
    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public T get(int ii) {
        if (ii == 0) {
            return this.first;
        }
        else {
            return this.rest.get(ii - 1);
        }
    }

    @Override
    public String toString() {
        var tmp = rest.toString();
        return "(" + first + " " + tmp.substring(1, tmp.length() - 1) + ")";
    }
}
