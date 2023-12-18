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
        if (back.empty() == false) {
            var temp = back.first();
            back = back.rest();
            return temp;
    
        }
        if (front.empty() == true) {
            throw new RuntimeException ("empty deque");
        }
        var tempFront = front.reverse();
        var temp = tempFront.first();
        tempFront = tempFront.rest();
        front = tempFront.reverse();
        return temp;


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
        if (front.empty() == false) {
            T xx = front.first();
            front = front.rest();
            return xx;
        }
        else {
            if (back.empty() == true) {
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
        if (front.empty() == false) {
            return front.first(); 
        }
        else {
            if (back.empty() == true) {
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
        if (back.empty() == false) {
            return back.first();
        }
        if (front.empty() == true) {
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
        if (front.empty() == true && back.empty() == true) {
            return true;
        }
        return false;
    }


}
