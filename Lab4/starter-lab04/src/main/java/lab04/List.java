package lab04;

import java.util.function.Function;

/**
 * Implements a generic linked list.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public interface List<T> {
    /**
     * Creates a list of the given items.
     *
     * @param  <T>   List item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T> List<T> list(T... args) {
        List<T> ys = new Empty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = new Cell<T>(args[ii], ys);
        }
        return ys;
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
    List<T> rest();

    /**
     * Determine if the list is empty.
     *
     * @return  True for empty list, else false.
     */
    boolean empty();

    /**
     * Determine the length of the list.
     *
     * @return  List length
     */
    int length();

    /**
     * Reverse the list.
     *
     * @return  New list with content in reverse order
     */
    List<T> reverse();

    /**
     * Reverse this list and concatenate with other list.
     *
     * @param  ys  End of resulting list.
     * @return     New list
     */
    List<T> reverseConcat(List<T> ys);

    /**
     * Produce a new list by applying op to each item
     * in this list.
     *
     * @param  <U>  Type of items in result list.
     * @param  op   The operation to perform on each item.
     * @return      New list
     */
    <U> List<U> map(Function<T, U> op);
}

/**
 * An empty list.
 *
 * @param  <T>   List item type
 *
 * @author Nat Tuck
 */
record Empty<T>() implements List<T> {
    @Override
    public T first() {
        throw new Error("empty list");
    }

    @Override
    public List<T> rest() {
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
    public String toString() {
        return "Empty";
    }

    @Override
    public List<T> reverse() {
        return new Empty<T>();
    }

    @Override
    public List<T> reverseConcat(List<T> ys) {
        return ys;
    }

    @Override
    public <U> List<U> map(Function<T, U> op) {
        return new Empty<U>();
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
record Cell<T>(T first, List<T> rest) implements List<T> {
    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public String toString() {
        return "(" + first + " " + rest + ")";
    }

    @Override
    public List<T> reverse() {
        var ys = new Empty<T>();
        return reverseConcat(ys);
    }

    @Override
    public List<T> reverseConcat(List<T> ys) {
        return this.rest.reverseConcat(new Cell<T>(this.first, ys));
    }

    @Override
    public <U> List<U> map(Function<T, U> op) {
        return new Cell<U>(op.apply(this.first()), this.rest.map(op));
    }
}
