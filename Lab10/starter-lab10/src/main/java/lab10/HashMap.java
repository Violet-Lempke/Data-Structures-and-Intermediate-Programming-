package lab10;

import java.util.ArrayList;
import java.lang.reflect.Array;
import static lab10.ConsList.cons;
import static lab10.ConsList.empty;

/**
 * A key-value map built with a hash table.
 *
 * @param  <K>  Key type
 * @param  <V>  Value type
 */
public class HashMap<K, V> {
    ConsList<Entry<K, V>>[] data;
    int size;

    /**
     * Initialize our object.
     */
    public HashMap() {
        this.data = newArray(4);
        this.size = 0;
        for (int ii = 0; ii < this.data.length; ++ii) {
            this.data[ii] = empty();
        }
    }

    /**
     * Allocate new data array.
     *
     * @param  size  New size for data array
     * @return       New data array
     */
    @SuppressWarnings("unchecked")
    ConsList<Entry<K, V>>[] newArray(int size) {
        return (ConsList<Entry<K, V>>[]) Array.newInstance(ConsList.class, size);
    }

    /**
     * Check for key in map.
     *
     * @param  key  The key to check for
     * @return      True if key is in map
     */
    boolean hasKey(K key) {
        // TODO: hasKey
        return false;
    }

    /**
     * Put key value pair in map. 
     *
     * @param  key  The key to insert
     * @param  val  The value to insert
     */
    void put(K key, V val) {
        put(new Entry<K, V>(key, val));
    }

    /**
     * Put Entry in map.
     *
     * @param  ent  The key-value pair to insert
     */
    void put(Entry<K, V> ent) {
        // TODO: put

        if (loadFactor() > 1.5) {
            // grow
        }
    }

    /**
     * Get value associated with key in map.
     *
     * @param  key  The key to get value for
     * @return      Value
     */
    V get(K key) {
        // TODO: get
        throw new RuntimeException("key not found");
    }

    /**
     * Delete entry in map.
     *
     * @param  key  The key to delete
     */
    void del(K key) {
        // TODO: del
    }

    /**
     * Get table slot to look for key in map.
     *
     * @param  key  Key to find slot for
     * @return      An integer between 0 and arraySize()
     */ 
    int slot(K key) {
        return Math.floorMod(key.hashCode(), arraySize());
    }

    /**
     * Get number of entries in table.
     *
     * @return Number of entries in table.
     */
    int size() {
        return size;
    }

    /**
     * Get size of backing array.
     *
     * @return Size of array.
     */
    int arraySize() {
        return this.data.length;
    }

    /**
     * Determine load factor of table.
     *
     * @return Ratio of number of entries in table to backing array size.
     */ 
    double loadFactor() {
        return ((double) size()) / ((double) arraySize());
    }

    /**
     * List keys in table.
     *
     * @return List of keys
     */
    ArrayList<K> keys() {
        // TODO: keys
        return new ArrayList<K>();
    }
}

/**
 * A key-value pair in for hash table.
 *
 * @param  <K>  Key type
 * @param  <V>  Value type
 * @param  key  Key for entry
 * @param  val  Value for entry
 *
 * @author Nat Tuck
 */
record Entry<K, V>(K key, V val) {
    // defaults
}

