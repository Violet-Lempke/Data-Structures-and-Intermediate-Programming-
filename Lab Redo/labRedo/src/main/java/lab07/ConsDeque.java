package lab07;
/**
 *Things for a ConsDeque.
 *
 *@param <T> type of the item
 *
 *@author Violet Lempke
 */
public class ConsDeque<T> implements Deque<T> {

    private ConsList<T> front;
    private ConsList<T> back;
    /**
     * initializes a ConsDeque.
     */
    public ConsDeque() {
        front = ConsList.list();
        back = ConsList.list();
    }
    /**
     * Add an item to the end of the deque.
     *
     * @param  item  The item to add
     */ 
    public void push(T item) {
        back = new Cell<T>(item, back);
    }
    
    /**
     * Get the last item and remove from deque.
     *
     * @return Next item
     */
    public T pop() {
        if (!back.empty()) {
            var temp = back.first();
            back = back.rest();
            return temp;
    
        }
        if (front.empty()) {
            throw new RuntimeException ("empty deque");
        }
        back = front.reverse();
        front = ConsList.list();
        return this.pop();


    }

    /**
     * Add an item to the start of the deque.
     *
     * @param  item  The item to add
     */
    public void unshift(T item) {
        front = new Cell<T>(item, front);

    }

    /**
     * Get the first item and remove from deque.
     *
     * @return Next item
     */
    public T shift() {
        if (!front.empty()) {
            T xx = front.first();
            front = front.rest();
            return xx;
        }
        else {
            if (back.empty()) {
                throw new RuntimeException("empty deque");
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
     * @return Item
     */
    public T first() {
        if (!front.empty()) {
            return front.first(); 
        }
        else {
            if (back.empty()) {
                throw new RuntimeException("empty deque");
            }
            front = back.reverse();
            return front.first();
        }
    }

    /**
     * Get the last item.
     *
     * @return Item
     */
    public T last() {
        if (!back.empty()) {
            return back.first();
        }
        if (front.empty()) {
            throw new RuntimeException("empty deque");
        }
        var temp = front.reverse();
        return temp.first();
        
    }
    
    /**
     * Determine if queue is empty.
     *
     * @return True if empty
     */
    public boolean empty() {
        return front.empty() && back.empty();
    }


}
