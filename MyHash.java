import java.util.LinkedList;
import java.util.Iterator;
public class MyHash<K extends Comparable<K>, V> {
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75;

    private class Node implements Comparable<Node> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node that) {
            return this.key.compareTo(that.key);
        }
    }
    @SuppressWarnings("unused")
    private class IteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int position;
        @SuppressWarnings("unchecked")
        public IteratorHelper() {
            keys = (T[]) new Object[numOfElements];
            int p = 0;
            for (int i = 0; i < tableSize; i++) {
                LinkedList<Node> list = hashTable[i];
                for (Node node : list) {
                    keys[p++] = (T) node.key;
                }
            }
        position = 0;
        }
        @Override
        public boolean hasNext() {
            return position < numOfElements;
        }
        @Override
        public T next() {
            return keys[position++];
        }
    }
   
    private int numOfElements;
    private double maxLoadFactor;
    private int tableSize;
    private LinkedList<Node>[] hashTable;

    @SuppressWarnings("unchecked")
    private void initializeHashTable() {
        this.hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            this.hashTable[i] = new LinkedList<>();
        }
    }

    public MyHash(int tableSize) {
        this.numOfElements = 0;
        this.maxLoadFactor = DEFAULT_MAX_LOAD_FACTOR;
        this.tableSize = tableSize;
        initializeHashTable();
    }

    public boolean isEmpty() {
        return numOfElements == 0;
    }

    public int size() {
        return numOfElements;
    }

    public double loadFactor() {
        return (double) numOfElements / tableSize;
    }

    private void resize() {
        int newTableSize = tableSize * 2;
        MyHash<K, V> newHash = new MyHash<>(newTableSize);

        for (LinkedList<Node> bucket : hashTable) {
            for (Node node : bucket) {
                newHash.add(node.key, node.value);
            }
        }

        this.hashTable = newHash.hashTable;
        this.tableSize = newTableSize;
    }

    public boolean add(K key, V value) {
        if (loadFactor() > maxLoadFactor) {
            resize();
        }

        int index = Math.abs(key.hashCode()) % tableSize;
        LinkedList<Node> bucket = hashTable[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;  // Update value if key already exists
                return false;
            }
        }

        Node newNode = new Node(key, value);
        bucket.addLast(newNode);
        numOfElements++;
        return true;
    }

    public boolean remove(K key) {
        int index = Math.abs(key.hashCode()) % tableSize;
        LinkedList<Node> bucket = hashTable[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                numOfElements--;
                return true;
            }
        }
        return false; // Key not found
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % tableSize;
        LinkedList<Node> bucket = hashTable[index];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null; // Key not found
    }
}
