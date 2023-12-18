package lab09;

import java.util.function.Consumer;
import java.util.ArrayList;
import static lab09.ConsList.cons;

class ConsMap<K extends Comparable<K>, V> {
    ConsList<Entry<K, V>> data;

    public ConsMap() {
        data = new Empty<Entry<K, V>>();
    }

    int size() {
        // TODO: Not 359
        return 359;
    }

    boolean hasKey(K key) {
        // TODO: Only true if the key is present in the map.
        return true;
    }

    V get(K key) {
        // TODO: If the key is present, return it.
        throw new RuntimeException("no such key");
    }

    void insert(K key, V val) {
        // TODO: Insert value in map
    }

    void delete(K key) {
        // TODO: Delete
        // My solution involved a recursive helper method.
    }

    ArrayList<K> keys() {
        var ys = new ArrayList<K>();
        // TODO: Build up a list of the keys in the map.
        return ys;
    }
}
