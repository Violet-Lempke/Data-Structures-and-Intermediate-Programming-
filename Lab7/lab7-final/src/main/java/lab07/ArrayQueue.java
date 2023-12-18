package lab07;
/**
 *The things for our queue.
 *
 *@param <T> the type of our item. 
 *
 *@author Violet Lempke
 */
public class ArrayQueue<T> implements Queue<T> {
    T[] data;
    int length;
    int frontIndex;
    int backIndex;
    /**
     *sets up our Queue.
     */
    ArrayQueue() {
        // This appears to be the standard way to
        // get a new array of T.
        this.data = (T[]) new Object[2];
        this.length = 0;
        this.frontIndex = 0;
        this.backIndex = 0;
    }   
    /**
     * returns the number of items in the list. 
     *
     * @return an int
     */
    int capacity() {
        return this.data.length;
    }

    /**
    * Add an item to the end of the queue.
    *
    * @param  item  The item to add
    */
    
    public void push(T item) {
        
        if (this.length == this.capacity()) {
            var newArray = (T[]) new Object[(this.capacity()*2)];
            for (int ii = 0; ii < length; ++ii) {
                newArray[ii] = this.data[ii];
            }
            this.data = newArray;
        }
            
        this.data[backIndex] = item;
        this.backIndex += 1;
        this.length += 1;

        
    }
    
    /** 
     * Get the first item and remove it from queue.
     *
     * @return First item
     */
    public T shift() {
        if (this.empty() == true) {
            throw new RuntimeException("empty queue");
        }
        length -= 1;
        this.frontIndex += 1;
        return this.data[this.frontIndex - 1];
        
    }
    
    /**
     * Get the first item.
     *
     * @return First item
     */
    public T first() {
        if (this.empty() == true) {
            throw new RuntimeException("empty queue");
        }
        return this.data[frontIndex];
    }
    
    /**
     * Determine if queue is empty.
     *
     * @return True if empty
     */
    public boolean empty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

}
