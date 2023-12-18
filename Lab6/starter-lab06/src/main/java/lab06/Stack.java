package lab06;

/**
 * Interface for stack.
 *
 * @param  <T>  Type of item in stack.
 *
 * @author Nat Tuck
 */
public interface Stack<T> {
    /**
     * Add an item to the top of the stack.
     *
     * @param  item  The item to add
     */
    void push(T item);
    
    /**
     * Remove an item from the top of the stack and return it.
     *
     * @return The item
     */
    T pop();
    
    /**
     * Get the item from the top of the stack without removing it.
     *
     * @return The item
     */
    T peek();
    
    /**
     * Determine if stack is empty.
     *
     * @return True if empty
     */
    boolean empty();
}
