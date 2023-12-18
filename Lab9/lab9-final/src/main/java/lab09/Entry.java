package lab09;

/**
 * A record for key-value pair entries.
 *
 * @author Nat Tuck
 * 
 * @param <K> Type of the key.
 * @param <V> Type of the value.
 * @param key The key.
 * @param val The value.
 */
public record Entry<K extends Comparable<K>, V>(K key, V val) {
    // empty
    
}

