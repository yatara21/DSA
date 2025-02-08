import java.util.LinkedList;
import java.util.Iterator;

public class MyHash<K, V> {
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75;
    
    // Inner class to store key-value pairs
    private class Node {
        K key;
        V value;
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int numOfElements;
    private double maxLoadFactor;
    private int tableSize;
    private LinkedList<Node>[] hashTable;
    
    @SuppressWarnings("unchecked")
    private void initializeHashTable() {
        hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<>();
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
    
    // Doubles the table size and rehashes all keys
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
    
    // Adds a key-value pair to the hash table.
    // If the key already exists, its value is updated.
    public boolean add(K key, V value) {
        if (loadFactor() > maxLoadFactor) {
            resize();
        }
        int index = Math.abs(key.hashCode()) % tableSize;
        LinkedList<Node> bucket = hashTable[index];
        
        // Update value if key already exists
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return false;
            }
        }
        
        // Add a new node
        bucket.add(new Node(key, value));
        numOfElements++;
        return true;
    }
    
    // Removes the node with the given key.
    public boolean remove(K key) {
        int index = Math.abs(key.hashCode()) % tableSize;
        LinkedList<Node> bucket = hashTable[index];
        Iterator<Node> iterator = bucket.iterator();
        
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove();
                numOfElements--;
                return true;
            }
        }
        return false; // Key not found
    }
    
    // Retrieves the value associated with the given key.
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
