package lab07;

/**
 * Double ended queue.
 *
 * @param  <T>  Type of item.
 * @author Nat Tuck
 */
interface Deque<T> {
    /**
     * Add an item to the end of the deque.
     *
     * @param  item  The item to add
     */ 
    void push(T item);
    
    /**
     * Get the last item and remove from deque.
     *
     * @return Next item
     */
    T pop();

    /**
     * Add an item to the start of the deque.
     *
     * @param  item  The item to add
     */
    void unshift(T item);

    /**
     * Get the first item and remove from deque.
     *
     * @return Next item
     */
    T shift();
    
    /**
     * Get the first item.
     *
     * @return Item
     */
    T first();

    /**
     * Get the last item.
     *
     * @return Item
     */
    T last();
    
    /**
     * Determine if queue is empty.
     *
     * @return True if empty
     */
    boolean empty();
}
