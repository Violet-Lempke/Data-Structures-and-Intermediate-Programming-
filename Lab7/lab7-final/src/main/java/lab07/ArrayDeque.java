package lab07;
/**
 *things for our Queue.
 *
 *@param <T> type of item
 *
 *@author Violet Lempke
 */
public class ArrayDeque<T> implements Deque<T> {
    T[] data;
    int length; 
    int frontIndex;
    int backIndex;
    
    /**
     *constructs empty Deque.
     *
     *@author Violet Lempke
     */
    ArrayDeque() {
        // This appears to be the standard way to
        // get a new array of T.
        this.data = (T[]) new Object[2];
        this.length = 0;
        this.frontIndex = 0;
        this.backIndex = -1;
    }
    /**
     *returns the number of items in the list. 
     *
     *@return an int
     */
    int capacity() {
        return this.data.length;
    }
    /**
    * Add an item to the end of the deque.
    *
    * @param  item  The item to add
    */ 
    public void push(T item) {
        if (backIndex + 1 >= this.capacity()) {
            
            var newArray = (T[]) new Object[(this.capacity()*2)];
            for (int ii = 0; ii < this.capacity(); ++ii) {
                newArray[ii] = this.data[ii];
                
            }
        
            this.data = newArray;
        }
        this.backIndex += 1;
        this.data[backIndex] = item;
        
        this.length += 1;

        
    }
    
    
    
    /**
     * Get the last item and remove from deque.
     *
     * @return Next item
     */
    public T pop() {
        if (this.empty() == true) {
            throw new RuntimeException("empty deque");
        }
        var temp = this.data[this.backIndex];
        this.backIndex -= 1; 
        this.length -= 1;
        return temp; 
    }

    /**
     * Add an item to the start of the deque.
     *
     * @param  item  The item to add
     */
    public void unshift(T item) {
        if (frontIndex - 1 < 0) {
            
            var newArray = (T[]) new Object[(this.capacity()*2)];
            for (int ii = 0; ii < this.capacity(); ++ii) {
                newArray[ii + this.capacity()] = this.data[ii];
                
            }
        
            frontIndex += this.capacity();
            backIndex += this.capacity();
            this.data = newArray;
        
        }
        this.length += 1;
        this.frontIndex -= 1;
        this.data[frontIndex] = item;
    }

    /**
     * Get the first item and remove from deque.
     *
     * @return Next item
     */
    public T shift() {
        if (this.empty() == true) {
            throw new RuntimeException("empty deque");
        }
        this.length -= 1;
        this.frontIndex += 1;
        return this.data[frontIndex - 1];
    }
    
    /**
     * Get the first item.
     *
     * @return Item
     */
    public T first() {
 
        if (this.empty() == true) {
            throw new RuntimeException("empty deque");
        }
        return this.data[frontIndex];
    }
    

    /**
     * Get the last item.
     *
     * @return Item
     */
    public T last() {
        if (this.empty() == true) {
            throw new RuntimeException("empty deque");
        }
        return this.data[backIndex];
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


