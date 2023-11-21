package map;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> implements MyMapInterface<K, V> {

    private List<Entry<K, V>> entries;

    public MyMap() {
        entries = new ArrayList<>();
    }

    @Override
    public V put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        entries.add(new Entry<>(key, value));
        return null;
    }

    @Override
    public V get(Object key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public V remove(Object key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                V removedValue = entry.value;
                entries.remove(entry);
                return removedValue;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : entries) {
            if (entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<K, V> entry : entries) {
            sb.append(entry.key).append("=").append(entry.value).append(", ");
        }
        // Remove the trailing comma and space if there are entries
        if (!entries.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

