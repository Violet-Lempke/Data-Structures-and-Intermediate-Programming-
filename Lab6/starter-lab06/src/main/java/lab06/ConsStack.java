package lab06;

/**
 * A stack implemented using a ConsList.
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
        // incorrectly do nothing
    }
    
    @Override
    public T pop() {
        return get(10);
    }

    @Override
    public T peek() {
        return get(10);
    }

    @Override
    public boolean empty() {
        return false;
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
