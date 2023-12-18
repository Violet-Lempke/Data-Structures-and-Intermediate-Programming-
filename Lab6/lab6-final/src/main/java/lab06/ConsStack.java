package lab06;

/**
 * A stack implemented using a ConsList.
 *
 * @author Nat Tuck
 * @author Erica Guenther
 * @author Violet Lempke
 * @author Daniel Whitney
 *
 * @param  <T>  Type of item in stack
 */
public class ConsStack<T> implements Stack<T> {
    // Use this ConsList to store the stack data.
    private ConsList<T> data;

    /**
     * Initialize empty stack.
     */
    public ConsStack() {
        data = ConsList.list();
    }

    @Override
    public void push(T item) {
        // COMPLETED

        data = new Cell<T>(item, data);
    }
    
    @Override
    public T pop() {
        // COMPLETED

        var yy = data.first();
        data = data.rest();
        return yy;
    }

    @Override
    public T peek() {
        // COMPLETED

        return data.first();
    }

    @Override
    public boolean empty() {
        // COMPLETED
        
        if (data.empty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Get the item at index ii.
     *
     * @param  ii  index
     * @return     The item
     */
    T get(int ii) {
        return data.get(ii);
    }
}
