
import java.util.Arrays;
import java.util.List;

public class MyMap <K, V> {
    private List<Node<K, V>> hashTable;
    private final int TABLE_SIZE = 50;

    public MyMap() {
        this.hashTable = Arrays.asList(new Node[TABLE_SIZE]);
    }

    public void addEntry(K key, V value) throws DuplicateKeyException {
        // Hash key and get the index
        int index = getIndex(key);

        // If nothing is mapped to that index, create a node and make it the head node
        if (hashTable.get(index) == null) {
            Node<K, V> node = new Node<>(key, value);
            hashTable.set(index, node);
        }

        // If somethings already mapped to that index
        else {
            // Iterate through nodes at index
            // Check each node to verify key does not already exist
            //      Throw exception if key already exists
            // Iterate until null node is found
            Node<K, V> currentNode = hashTable.get(index);
            while(true) {
                // check key
                if (currentNode.getKey().equals(key)) {
                    // Throw exception
                    // Key already exists
                    throw new DuplicateKeyException();
                }
                else {
                    // break out of loop if next node is null
                    if (currentNode.getNext() == null) {
                        break;
                    }
                    // set current node to next node
                    currentNode = currentNode.getNext();
                }
            }

            Node<K, V> node = new Node<>(key, value);
            currentNode.setNext(node);
        }
    }

    public void removeEntry(K key) throws KeyDoesNotExistException {
        int index = getIndex(key);

        if (hashTable.get(index) != null) {
            Node<K, V> currentNode = hashTable.get(index);
            Node<K, V> lastNode = currentNode;

            while(currentNode.getKey() != key) {
                lastNode = currentNode;
                currentNode = currentNode.getNext();

                if (currentNode == null) {
                    throw new KeyDoesNotExistException();
                }
            }

            if (lastNode.equals(currentNode)) {
                hashTable.set(index, currentNode.getNext());
            }
            else {
                // Set last node's next node to current node (Node with matching key)'s next node
                lastNode.setNext(currentNode.getNext());
            }
        }
    }

    public V get(K key) throws KeyDoesNotExistException {
        int index = getIndex(key);

        Node<K, V> currentNode = hashTable.get(index);

        // iterate through list at index to find key
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }

        // Throw exception does not exist
        throw new KeyDoesNotExistException();
    }

    public void updateEntry(K key, V value) throws KeyDoesNotExistException {
        int index = getIndex(key);

        Node<K, V> currentNode = hashTable.get(index);

        // iterate through the nodes for the matching key
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                currentNode.setValue(value);
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            throw new KeyDoesNotExistException();
        }

    }

    private int getIndex(K key) {
        return key.hashCode() % TABLE_SIZE;
    }
}