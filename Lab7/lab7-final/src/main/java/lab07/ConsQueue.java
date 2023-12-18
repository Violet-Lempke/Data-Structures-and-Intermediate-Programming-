package lab07;
/**
 *A queue using conslist.
 *
 *@param <T> the Type of the item 
 *
 *@author Violet Lempke
 */
public class ConsQueue<T> implements Queue<T> {
    /**
     * Add an item to the end of the queue.
     *
     * @param  item  The item to add
     */ 

    private ConsList<T> front;
    private ConsList<T> back;
    /**
     *initializes a consQeueu.
     */
    public ConsQueue() {
        front = ConsList.list();
        back = ConsList.list();
        
    }
    /**
    * Add an item to the queue.
    *
    * @param  item  The item to add
    */ 
    public void push(T item) {
        
        back = new Cell<T>(item, back);
    }
    
    /**
     * Get the first item and remove it from queue.
     *
     * @return First item
     */
    public T shift() {
        if (front.empty() == false) {
            T xx = front.first();
            front = front.rest();
            return xx;
        }
        else {
            if (back.empty() == true) {
                throw new RuntimeException("empty queue");
            }
            front = back.reverse();
            back = ConsList.list();
            var temp = front.first();
            front = front.rest();
            return temp;
        }
            

    }
    
    /**
     * Get the first item.
     *
     * @return First item
     */
    public T first() {
        if (front.empty() == false) {
            return front.first();
        }
        else {
            if (back.empty() == true) {
                throw new RuntimeException("empty queue");
            }
            front = back.reverse();
            return front.first();
        }
    }
    
    /**
     * Determine if queue is empty.
     *
     * @return True if empty
     */
    public boolean empty() {
        if (back.empty() == true && front.empty() == true) {
            return true;
        }
        else {
            return false;
        }
        //  TODO: build this class

    }
}
