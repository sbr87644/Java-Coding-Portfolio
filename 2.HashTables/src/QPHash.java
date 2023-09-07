
public class QPHash {

    private int size, spot = -1;
    private Node[] elements;
    private Node curr;

    public QPHash() {
        //TODO Implement a default constructor for QPHash
        elements = new Node[16];
    }

    public QPHash(int startSize) {
        //TODO Implement a constructor that instantializes the hash array to startSize.
        elements = new Node[startSize];
    }

    /**
     * This function allows rudimentary iteration through the QPHash. The
     * ordering is not important so long as all added elements are returned only
     * once. It should return null once it has gone through all elements
     *
     * @return Returns the next element of the hash table. Returns null if it is
     * at its end.
     */
    public Object getNextKey() {
        //TODO returns the next key in the hash table.
        //You will need external tracking variables to account for this.
        if (curr == null || curr == elements[spot] && spot != size) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != null && i > spot) {
                    curr = elements[i];
                    spot = i;
                    return curr.data;
                }
            }
        }
        return null;
    }

    /**
     * Adds the key to the hash table. If there is a collision, a new location
     * should be found using quadratic probing. If the key is already in the
     * hash table, it increments that key's counter.
     *
     * @param keyToAdd : the key which will be added to the hash table
     */
    public void insert(Object keyToAdd) {
        //TODO Implement insert into the hash table.
        //If keyToAdd is already in the hash table, then increment its count.
        if (!contains(keyToAdd)) {
            size++;
            int h = Math.abs(keyToAdd.hashCode() % elements.length);
            if (elements[h] == null) {
                elements[h] = new Node(keyToAdd);
            } else {
                int i = 1;
                int quad = 1;
                while (elements[(h + quad) % elements.length] != null) {
                    quad = (int) Math.pow(++i, 2);
                }
                elements[(h + quad) % elements.length] = new Node(keyToAdd);
            }
        } else {
            findNode(keyToAdd).count++;
        }
        if (size / (double) elements.length >= .5) {
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

    public boolean contains(Object key) {
        for (Node n : elements) {
            if (n != null) {
                if (n.data.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Node findNode(Object key) {
        for (Node n : elements) {
            if (n != null) {
                if (n.data.equals(key)) {
                    return n;
                }
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
            if (n != null) {
                out += n.data + " " + n.count + " ";
            }
            out += "\n";
        }
        return out;
    }

    private class Node {

        public Object data;
        public int count;

        public Node(Object d) {
            data = d;
            count = 1;
        }
    }
}
