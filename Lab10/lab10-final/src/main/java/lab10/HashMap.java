package lab10;

import java.util.ArrayList;
import java.lang.reflect.Array;
import static lab10.ConsList.cons;
import static lab10.ConsList.empty;

/**
 * A key-value map built with a hash table.
 *
 *@author Nat Tuck
 *
 * @param  <K>  Key type
 * @param  <V>  Value type
 */
public class HashMap<K, V> {
    ConsList<Entry<K, V>>[] data;
    int size;
    Entry<K, V> empty;

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
        var curSlot = slot(key);
        for (var entry : this.data[curSlot]) {
            if (key.equals(entry.key())) {
                return true; 
            }
        }
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
        
        if (!this.hasKey(ent.key())) {
            size += 1;
        }
        
        var slot = this.slot(ent.key());
        this.data[slot] = new Cell<> (ent, this.data[slot]);
        var prevData = this.data;
        
        if (loadFactor() > 1.5) {
            // grow
            
            this.data = newArray(2*prevData.length);
            for (int ii = 0; ii < this.data.length; ++ ii) {
                this.data[ii] = ConsList.empty();
            }
        
            for (int ii = 0; ii < prevData.length; ++ii) {
                for (var entry : prevData[ii]) {
                    var entrySlot = this.slot(entry.key());
                    this.data[entrySlot] = new Cell<> (entry, this.data[entrySlot]);
                }
            
            
            }   
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
        var slot = this.slot(key);
        
     
        for (var entry : this.data[slot]) {
            if (key.equals(entry.key())) {
                return entry.val();
            }
        }
            
        
        throw new RuntimeException("key not found");
    }

    /**
     * Delete entry in map.
     *
     * @param  key  The key to delete
     */
    void del(K key) {
        // TODO: del
        if (this.hasKey(key)) {
            size -= 1;
        }
        var slot = this.slot(key);
        var prevData = this.data[slot];
        this.data[slot] = ConsList.empty();
        
        for (var entry : this.data[slot]) {
            if (!key.equals(entry.key())) {
                this.data[slot] = new Cell<>(entry, this.data[slot]);
            }
        }
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

