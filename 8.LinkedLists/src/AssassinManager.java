
import static java.lang.System.out;
import java.util.List;

public class AssassinManager {
    // YOUR CODE GOES HERE

    //////// DO NOT MODIFY AssassinNode.  You will lose points if you do. ////////
    /**
     * Each AssassinNode object represents a single node in a linked list for a
     * game of Assassin.
     */
    AssassinNode killRing, graveyard;

    public AssassinManager(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        //graveyard = new AssassinNode(null);
        killRing = new AssassinNode(names.get(0));
        AssassinNode temp = killRing;
        for (int i = 1; i < names.size(); i++) {
            temp.next = new AssassinNode(names.get(i));
            temp = temp.next;
        }
    }

    public String killRing() {
        String out = "";
        AssassinNode temp = killRing;
        if (isGameOver()) {
            out += killRing.name + " won the game!";
        } else {
            while (temp != null) {
                if (temp.next != null) {
                    out += "  " + temp.name + " is stalking " + temp.next.name + "\n";
                } else {
                    out += "  " + temp.name + " is stalking " + killRing.name + "\n";
                }
                temp = temp.next;
            }
        }
        return out;
    }

    public String graveyard() {
        String out = "";
        AssassinNode temp = graveyard;
        while (temp != null) {
            out += "  " + temp.name + " was killed by " + temp.killer + "\n";
            temp = temp.next;
        }
        return out;
    }

    public boolean killRingContains(String name) {
        AssassinNode temp = killRing;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean graveyardContains(String name) {
        AssassinNode temp = graveyard;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean isGameOver() {
        return killRing.next == null;
    }

    public String winner() {
        if (isGameOver()) {
            return killRing.name;
        }
        return null;
    }

    public void kill(String name) {
        if (isGameOver()) {
            throw new IllegalStateException();
        }
        if (!killRingContains(name)) {
            throw new IllegalArgumentException();
        }
        AssassinNode curr = killRing;
        AssassinNode prev = null;
        while (!curr.name.equalsIgnoreCase(name)) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            AssassinNode temp = curr;
            while (temp.next != null) {
                temp = temp.next;
            }
            curr.killer = temp.name;
            killRing = curr.next;

        } else {
            curr.killer = prev.name;
            if (curr.next == null) {
                prev.next = null;
            } else {
                prev.next = curr.next;
            }
        }
        addGrave(curr);
    }

    private void addGrave(AssassinNode dead) {
        if (graveyard == null) {
            graveyard = new AssassinNode(dead.name);
        } else {
            graveyard = new AssassinNode(dead.name, graveyard);
        }
        graveyard.killer = dead.killer;
    }

    private static class AssassinNode {

        public final String name;  // this person's name
        public String killer;      // name of who killed this person (null if alive)
        public AssassinNode next;  // next node in the list (null if none)

        /**
         * Constructs a new node to store the given name and no next node.
         */
        public AssassinNode(String name) {
            this(name, null);
        }

        /**
         * Constructs a new node to store the given name and a reference to the
         * given next node.
         */
        public AssassinNode(String name, AssassinNode next) {
            this.name = name;
            this.killer = null;
            this.next = next;
        }
    }
}
