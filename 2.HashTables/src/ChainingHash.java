
public class ChainingHash {

    private int size, spot = -1;
    private Node[] elements;
    private Node curr;

    public ChainingHash() {
        //TODO Implement a default constructor for ChainingHash
        elements = new Node[16];
    }

    public ChainingHash(int startSize) {
        //TODO Implement a constructor that instantializes the hash array to startSize.
        elements = new Node[startSize];
    }

    /**
     * This function allows rudimentary iteration through the ChainingHash. The
     * ordering is not important so long as all added elements are returned only
     * once. It should return null once it has gone through all elements
     *
     * @return Returns the next element of the hash table. Returns null if it is
     * at its end.
     */
    public Object getNextKey() {
        //TODO returns the next key in the hash table.
        //You will need external tracking variables to account for this.
        if (curr == null || curr.next == null && spot != size) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null && i > spot) {
                    curr = elements[i];
                    spot = i;
                    return curr.data;
                }
            }
        }
        if (curr.next == null) {
            return null;
        }
        curr = curr.next;
        return curr.data;
    }

    /**
     * Adds the key to the hash table. If there is a collision, it should be
     * dealt with by chaining the keys together. If the key is already in the
     * hash table, it increments that key's counter.
     *
     * @param keyToAdd : the key which will be added to the hash table
     */
    public void insert(String keyToAdd) {
        //TODO Implement insert into the hash table.
        //If keyToAdd is already in the hash table, then increment its count.
        if (!contains(keyToAdd)) {
            size++;
            int h = Math.abs(keyToAdd.hashCode()) % elements.length;
            if (elements[h] == null) {
                elements[h] = new Node(keyToAdd);
            } else {
                Node temp = elements[h];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new Node(keyToAdd);
            }
        } else {
            findNode(keyToAdd).count++;
        }
        if (size / (double) elements.length >= .75) {
            increaseSize();
        }
    }

    private void increaseSize() {
        Node[] temp = new Node[nextPrime(elements.length * 2)];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }

    private int nextPrime(int num) {
        num++;
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    private boolean isPrime(int num) {
        if (num > 3) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean contains(String key) {
        for (Node n : elements) {
            while (n != null) {
                if (n.data.equals(key)) {
                    return true;
                }
                n = n.next;
            }
        }
        return false;
    }

    private Node findNode(Object key) {
        for (Node n : elements) {
            while (n != null) {
                if (n.data.equals(key)) {
                    return n;
                }
                n = n.next;
            }
        }
        return null;
    }

    /**
     * Returns the number of times a key has been added to the hash table.
     *
     * @param keyToFind : The key being searched for
     * @return returns the number of times that key has been added.
     */
    public int findCount(Object keyToFind) {
        //TODO Implement findCount such that it returns the number of times keyToFind
        // has been added to the data structure.
        return findNode(keyToFind).count;
    }

    /**
     * Returns the number of keys in the hash table.
     *
     * @return return keys
     */
    public int getSize() {
        //TODO
        return size;
    }

    public String toString() {
        String out = "";
        for (Node n : elements) {
            while (n != null) {
                out += n.data + " " + n.count + " ";
                n = n.next;
            }
            out += "\n";
        }
        return out;
    }

    private class Node {

        public Object data;
        public int count;
        public Node next;

        public Node(Object d) {
            data = d;
            count = 1;
        }
    }
}
