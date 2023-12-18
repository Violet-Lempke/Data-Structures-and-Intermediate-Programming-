package lab09;

import java.util.ArrayList;

/**
 * A key-value map using a linked list.
 *
 * @author Nat Tuck
 * @author Violet Lempke
 * @author Hunter Harris
 * @author Rider McCallum
 * 
 * @param <K> Keys in the map.
 * @param <V> Values associated with the keys.
 */
class ConsMap<K extends Comparable<K>, V> {
    ConsList<Entry<K, V>> data;

    /**
     * Constructs a new ConsMap with an empty data list.
     *
     * @author Nat Tuck
     *
     */
    public ConsMap() {
        data = new Empty<Entry<K, V>>();
    }

    /**
     * Returns the number of key-value pairs in the map.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @return The size of the map.
     */
    int size() {
        return this.data.length();
    }

    /**
     * Checks if the map contains the key.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param key The key to search for.
     * @return True if the key exists in the map.
     */
    boolean hasKey(K key) {
        for (var xx : this.data) {
            if (key == xx.key()) {
                return true;
            }
        }
        return false;
    }
        
    /**
     * Retrieves value associated with key in the map.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param key The key to look up.
     * @return The value associated with the key.
     */
    V get(K key) {
        if (!this.hasKey(key)) {
            throw new RuntimeException("no such key");
        }

        for (var xx : this.data) {
            if (xx.key() == key) {
                return xx.val();
            }
        }
        return null;
    }

    /**
     * Inserts a key-value pair into the map.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param key The key to insert.
     * @param val The value associated with the key.
     */
    void insert(K key, V val) {
        this.data =  new Cell<>(new Entry<K, V>(key, val), this.data); 
    }

    /**
     * Deletes a key from the map.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @param key The key to delete.
     */
    void delete(K key) {
        var xx = this.data;
        ConsMap<K, V> newMap = new ConsMap<K, V>();
        for (var yy : xx) {
            if (yy.key() == key) {
                continue;
            }
            newMap.insert(yy.key(), this.get(yy.key()));
            
        }
        this.data = newMap.data;
    }

    /**
     * Makes a list of all keys in the map.
     *
     * @author Nat Tuck
     * @author Violet Lempke
     * @author Hunter Harris
     * @author Rider McCallum
     *
     * @return An ArrayList containing all the keys in the map.
     */
    ArrayList<K> keys() {
        var ys = new ArrayList<K>();
        for (var xx : this.data) {
            ys.add(xx.key());
        }
        return ys;
    }
}
