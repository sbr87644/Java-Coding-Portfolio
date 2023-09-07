
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

/**
 * An trie data structure that implements the Dictionary and the AutoComplete
 * ADT
 *
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements Dictionary, AutoComplete {

    private TrieNode root;
    private int size;

    public AutoCompleteDictionaryTrie() {
        root = new TrieNode();
    }

    /**
     * Insert a word into the trie. You should ignore the word's case. That is,
     * you should convert the string to all lower case as you insert it.
     */
    public boolean addWord(String word) {
        //TODO: Implement this method.
        word = word.toLowerCase();
        if (!isWord(word)) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode insert = temp.insert(word.charAt(i));
                if (insert != null) {
                    temp = insert;
                } else {
                    temp = temp.getChild(word.charAt(i));
                }
                if (i == word.length() - 1) {
                    temp.setEndsWord(true);
                }
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * Return the number of words in the dictionary. This is NOT necessarily the
     * same as the number of TrieNodes in the trie.
     */
    public int size() {
        //TODO: Implement this method
        return size;
    }

    /**
     * Returns whether the string is a word in the trie
     */
    @Override
    public boolean isWord(String s) {
        // TODO: Implement this method
        s = s.toLowerCase();
        TrieNode temp = root;
        for (int i = 0; i < s.length(); i++) {
            temp = temp.getChild(s.charAt(i));
            if (temp == null) {
                return false;
            }
        }
        return temp.endsWord();
    }

    /**
     *  * Returns up to the n "best" predictions, including the word itself, in
     * terms of length If this string is not in the trie, it returns null.
     *
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */
    @Override
    public List<String> predictCompletions(String prefix, int numCompletions) {
        // TODO: Implement this method
        // This method should implement the following algorithm:
        // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
        //    empty list
        // 2. Once the stem is found, perform a breadth first search to generate completions
        //    using the following algorithm:
        //    Create a queue (LinkedList) and add the node that completes the stem to the back
        //       of the list.
        //    Create a list of completions to return (initially empty)
        //    While the queue is not empty and you don't have enough completions:
        //       remove the first Node from the queue
        //       If it is a word, add it to the completions list
        //       Add all of its child nodes to the back of the queue
        // Return the list of completions
        prefix = prefix.toLowerCase();
        TrieNode pre = root;
        for (int i = 0; i < prefix.length(); i++) {
            pre = pre.getChild(prefix.charAt(i));
            if (pre == null) {
                return new ArrayList<String>();
            }
        }

        Queue<TrieNode> words = new LinkedList<>();
        ArrayList<String> complete = new ArrayList<>();
        words.add(pre);
        while (!words.isEmpty() && complete.size() < numCompletions) {
            TrieNode temp = words.poll();
            if (temp.endsWord()) {
                complete.add(temp.getText());
            }
            for (char c : temp.getValidNextCharacters()) {
                words.add(temp.getChild(c));
            }
        }
        return complete;
    }

    // For debugging
    public void printTree() {
        printNode(root);
    }

    /**
     * Do a pre-order traversal from this node down
     */
    public void printNode(TrieNode curr) {
        if (curr == null) {
            return;
        }

        System.out.println(curr.getText());

        TrieNode next = null;
        for (Character c : curr.getValidNextCharacters()) {
            next = curr.getChild(c);
            printNode(next);
        }
    }
}
