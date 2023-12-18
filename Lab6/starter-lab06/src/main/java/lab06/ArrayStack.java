package lab06;

/**
 * A stack implemented with an ArrayList.
 *
 * @param  <T>  Type of items in the stack
 */
public class ArrayStack<T> implements Stack<T> {
    // Use this ArrayList to store the stack data.
    private ArrayList<T> data;

    /**
     * Initialize an empty stack.
     */
    public ArrayStack() {
        this.data = new ArrayList<T>();
    }
    
    @Override
    public void push(T item) {
        data.set(10, item);
    }
    
    @Override
    public T pop() {
        return data.get(10);
    }

    @Override
    public T peek() {
        return data.get(10);
    }

    @Override
    public boolean empty() {
        return true;
    }

    /**
     * Get the item at index ii
     *
     * @param  ii  the index
     * @return     the item
     */
    T get(int ii) {
        return data.get(10);
    }
}
