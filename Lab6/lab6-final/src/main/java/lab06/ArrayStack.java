package lab06;

/**
 * A stack implemented with an ArrayList.
 *
 * @author Nat Tuck
 * @author Erica Guenther
 * @author Violet Lempke
 * @author Daniel Whitney
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
        data.append(item);
    }
    
    @Override
    public T pop() {
        var xx = data.get(data.length() - 1);
        data.set(data.length(), null);
        data.setLength(data.length() - 1);
        return xx; 
    }

    @Override
    public T peek() {
        return data.get(data.length() - 1);
    }

    @Override
    public boolean empty() {
        if (data.length() == 0) {
            return true;
        }
        else {
            return false;
        }        
    }

    /**
     * Get the item at index ii.
     *
     * @param  ii  the index
     * @return     the item
     */
    T get(int ii) {
        return data.get(ii);
    }
}
