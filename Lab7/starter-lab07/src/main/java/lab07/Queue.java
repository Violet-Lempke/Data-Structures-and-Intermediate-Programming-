package lab07;

/**
 * A queue.
 *
 * @param  <T>  Type of item.
 * @author Nat Tuck
 */
interface Queue<T> {
    /**
     * Add an item to the queue.
     *
     * @param  item  The item to add
     */ 
    void push(T item);
    
    /**
     * Get the first item and remove it from queue.
     *
     * @return First item
     */
    T shift();
    
    /**
     * Get the first item.
     *
     * @return First item
     */
    T first();
    
    /**
     * Determine if queue is empty.
     *
     * @return True if empty
     */
    boolean empty();
}
