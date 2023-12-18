package lab04;

/**
 * A pair of items.
 *
 * @author Nat Tuck
 *
 * @param  <T>    The type of the first item
 * @param  <U>    The type of the second item
 * @param  left   The first item
 * @param  right  The second item
 */
public record Pair<T, U>(T left, U right) {
    /**
     *Swaps the items in a pair.
     *
     *@author Violet Lempke
     *
     *@return a pair
     *
     */
    
    Pair<U, T> swap() {
       
        var newLeft = right;
        var newRight = left;
        
        return new Pair<U, T> (newLeft, newRight);
    }
}
