
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        FileInput.init();

        //TODO Initialize the hash tables 
        //TODO Use the FileInput functions to read the two files.
        // Input the elements of those two files into two hash tables,
        // one file into a ChainingHash object and the other into a QPHash object.
        //TODO Initialize necessary variables for calculating the square error
        // and most distant word.
        //TODO Iterate through the first hash table and add sum the squared error
        // for these words.
        //TODO Find  words in the second hash table that are not in the first and add their squared error
        // to the total
        //TODO Print the total calculated squared error for the two tables and also the word with the highest distance.
        ChainingHash bacon = new ChainingHash();
        QPHash shakes = new QPHash();
        String[] baconEssay = FileInput.readBacon();
        String[] hamlet = FileInput.readShakespeare();
        for (String s : baconEssay) {
            bacon.insert(s);
        }
        for (String s : hamlet) {
            shakes.insert(s);
        }
        double mostDiff = Double.MIN_VALUE;
        String diff = "";
        double totalError = 0, freqB = 0, freqS = 0;
        String s = (String) bacon.getNextKey();
        while (s != null) {
            freqB = bacon.findCount(s) / (double) baconEssay.length;
            if (shakes.contains(s)) {
                freqS = shakes.findCount(s) / (double) hamlet.length;
                totalError += Math.pow(freqS - freqB, 2);
                if (Math.abs(freqS - freqB) > mostDiff) {
                    mostDiff = Math.abs(freqS - freqB);
                    diff = s;
                }
            } else {
                totalError += Math.pow(freqB, 2);
            }
            s = (String) bacon.getNextKey();
        }
        s = (String) shakes.getNextKey();
        while (s != null) {
            if (!bacon.contains(s)) {
                freqS = shakes.findCount(s) / (double) hamlet.length;
                totalError += Math.pow(freqS, 2);
            }
            s = (String) shakes.getNextKey();
        }
        out.println("Total Square Error: " + totalError);
        out.println("Most different word: " + diff);
        /*
        HashMap<String, Integer> b = new HashMap<>();
        HashMap<String, Integer> s = new HashMap<>();
        String[] baconEssay = FileInput.readBacon();
        String[] hamlet = FileInput.readShakespeare();
        for (String st : baconEssay) {
            if (!b.containsKey(st)) {
                b.put(st, 1);
            } else {
                b.put(st, b.get(st) + 1);
            }
        }
        for (String st : hamlet) {
            if (!s.containsKey(st)) {
                s.put(st, 1);
            } else {
                s.put(st, s.get(st) + 1);
            }
        }
        double mostDiff = Double.MIN_VALUE;
        String diff = "";
        double totalError = 0;
        double freqB = 0;
        double freqS = 0;
        for (String st : b.keySet()) {
            freqB = b.get(st) / (double) baconEssay.length;
            if (s.containsKey(st)) {
                freqS = s.get(st) / (double) hamlet.length;
                totalError += Math.pow(freqS - freqB, 2);
                if (Math.abs(freqS - freqB) > mostDiff) {
                    mostDiff = Math.abs(freqS - freqB);
                    diff = st;
                }
            } else {
                totalError += Math.pow(freqB, 2);
            }
        }
        for (String st : s.keySet()) {
            if (!b.containsKey(st)) {
                freqS = s.get(st) / (double) hamlet.length;
                totalError += Math.pow(freqS, 2);
            }
        }
        out.println("Total Square Error: " + totalError);
        out.println("Most different word: " + diff);
         */
    }

}
