
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author egg
 */
public class HangmanManagerTest {

    @Test
    public void testConstructor() {
        try {
            HangmanManager hangman = new HangmanManager(new ArrayList<>(), -5, 5);
            fail("length < 1 should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructor2() {
        try {
            HangmanManager hangman = new HangmanManager(new ArrayList<>(), 5, -1);
            fail("max guesses < 0 should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test of words method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testWords() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary-tiny.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 4, 5);
        System.out.println("words");

        Set<String> expResult = new TreeSet<>();
        expResult.add("ally");
        expResult.add("beta");
        expResult.add("cool");
        expResult.add("deal");
        expResult.add("else");
        expResult.add("flew");
        expResult.add("good");
        expResult.add("hope");
        expResult.add("ibex");
        Set<String> result = hangman.words();
        assertEquals(expResult, result);
    }

    /**
     * Test of guessesLeft method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGuessesLeft() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary-tiny.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 4, 5);
        hangman.record('e');

        System.out.println("guessesLeft");

        int expResult = 4;
        int result = hangman.guessesLeft();
        assertEquals(expResult, result);

    }

    /**
     * Test of pattern method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testPattern() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary-tiny.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 4, 5);
        hangman.record('e');

        System.out.println("pattern");

        String expResult = "----";
        String result = hangman.pattern();
        assertEquals(expResult, result);

    }

    /**
     * Test of guesses method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGuesses() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary-tiny.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        Scanner console = new Scanner(System.in);

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 4, 5);
        hangman.record('e');
        System.out.println("guesses");
        Set<Character> s = new TreeSet<>();
        s.add('e');
        Set<Character> expResult = s;
        Set<Character> result = hangman.guesses();
        assertEquals(expResult, result);

    }

    /**
     * Test of record method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testRecord() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary-tiny.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 4, 5);
        System.out.println("record");
        char guess = 'e';

        int expResult = 0;
        int result = hangman.record(guess);
        assertEquals(expResult, result);

    }

    @Test
    public void testRecordForExceptions() {
        try {
            HangmanManager hangman = new HangmanManager(new ArrayList<>(), 5, 5);
            hangman.record('a');
            fail("empty list should throw exception");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testRecordForExceptions3() {
        try {
            ArrayList<String> list = new ArrayList<>();
            list.add("dog");
            HangmanManager hangman = new HangmanManager(list, 3, 3);
            hangman.record('a');
            hangman.record('a');
            fail("call to record w/ prev guess should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testWords2() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 8, 8);
        int count = hangman.record('y');
        assertEquals(0, count);
        assertEquals(23297, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        count = hangman.record('b');
        assertEquals(0, count);
        assertEquals(19682, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        count = hangman.record('u');
        assertEquals(0, count);
        assertEquals(14504, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        count = hangman.record('t');
        assertEquals(0, count);
        assertEquals(8108, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        count = hangman.record('l');
        assertEquals(0, count);
        assertEquals(4757, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        count = hangman.record('a');
        assertEquals(0, count);
        assertEquals(2309, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        count = hangman.record('e');
        assertEquals(0, count);
        assertEquals(442, hangman.words().size());
        assertEquals("--------", hangman.pattern());

        hangman.record('o');
        assertEquals("chinking", hangman.words().iterator().next());
    }

    @Test
    public void testWords4() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 7, 13);
        assertEquals(21729, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        int count = hangman.record('q');
        assertEquals(0, count);
        assertEquals(21440, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('w');
        assertEquals(0, count);
        assertEquals(19721, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('e');
        assertEquals(0, count);
        assertEquals(6639, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('r');
        assertEquals(0, count);
        assertEquals(4217, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('t');
        assertEquals(0, count);
        assertEquals(2731, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('y');
        assertEquals(0, count);
        assertEquals(2240, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('u');
        assertEquals(0, count);
        assertEquals(1537, hangman.words().size());
        assertEquals("-------", hangman.pattern());

        count = hangman.record('i');
        assertEquals(1, count);
        assertEquals(433, hangman.words().size());
        assertEquals("----i--", hangman.pattern());

        count = hangman.record('o');
        assertEquals(0, count);
        assertEquals(210, hangman.words().size());
        assertEquals("----i--", hangman.pattern());

        count = hangman.record('p');
        assertEquals(0, count);
        assertEquals(163, hangman.words().size());
        assertEquals("----i--", hangman.pattern());

        count = hangman.record('a');
        assertEquals(1, count);
        assertEquals(113, hangman.words().size());
        assertEquals("-a--i--", hangman.pattern());

        count = hangman.record('s');
        assertEquals(0, count);
        assertEquals(69, hangman.words().size());
        assertEquals("-a--i--", hangman.pattern());

        count = hangman.record('d');
        assertEquals(0, count);
        assertEquals(52, hangman.words().size());
        assertEquals("-a--i--", hangman.pattern());

        count = hangman.record('f');
        assertEquals(0, count);
        assertEquals(45, hangman.words().size());
        assertEquals("-a--i--", hangman.pattern());

        count = hangman.record('g');
        assertEquals(1, count);
        assertEquals(31, hangman.words().size());
        assertEquals("-a--i-g", hangman.pattern());

        hangman.record('c');
        assertEquals("balking", hangman.words().iterator().next());
    }

    @Test
    public void testWords5() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 9, 15);
        assertEquals(18844, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        int count = hangman.record('z');
        assertEquals(0, count);
        assertEquals(18199, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('x');
        assertEquals(0, count);
        assertEquals(17735, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('c');
        assertEquals(0, count);
        assertEquals(12267, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('v');
        assertEquals(0, count);
        assertEquals(11063, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('a');
        assertEquals(0, count);
        assertEquals(5172, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('s');
        assertEquals(0, count);
        assertEquals(1301, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('d');
        assertEquals(0, count);
        assertEquals(695, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('f');
        assertEquals(0, count);
        assertEquals(535, hangman.words().size());
        assertEquals("---------", hangman.pattern());

        count = hangman.record('g');
        assertEquals(1, count);
        assertEquals(231, hangman.words().size());
        assertEquals("--------g", hangman.pattern());

        count = hangman.record('h');
        assertEquals(0, count);
        assertEquals(199, hangman.words().size());
        assertEquals("--------g", hangman.pattern());

        count = hangman.record('t');
        assertEquals(0, count);
        assertEquals(90, hangman.words().size());
        assertEquals("--------g", hangman.pattern());

        count = hangman.record('o');
        assertEquals(0, count);
        assertEquals(43, hangman.words().size());
        assertEquals("--------g", hangman.pattern());

        count = hangman.record('u');
        assertEquals(0, count);
        assertEquals(21, hangman.words().size());
        assertEquals("--------g", hangman.pattern());

        count = hangman.record('i');
        assertEquals(1, count);
        assertEquals(10, hangman.words().size());
        assertEquals("------i-g", hangman.pattern());

        count = hangman.record('e');
        assertEquals(2, count);
        assertEquals(4, hangman.words().size());
        assertEquals("-e-e--i-g", hangman.pattern());

        count = hangman.record('l');
        assertEquals(2, count);
        assertEquals(3, hangman.words().size());
        assertEquals("-e-elli-g", hangman.pattern());

        count = hangman.record('r');
        assertEquals(1, count);
        assertEquals(2, hangman.words().size());
        assertEquals("re-elli-g", hangman.pattern());

        count = hangman.record('n');
        assertEquals(1, count);
        assertEquals(2, hangman.words().size());
        assertEquals("re-elling", hangman.pattern());

        count = hangman.record('p');
        assertEquals(0, count);
        assertEquals(1, hangman.words().size());
        assertEquals("re-elling", hangman.pattern());

        hangman.record('b');
        assertEquals("rebelling", hangman.words().iterator().next());
    }

    /**
     * Test of guessesLeft method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGuessesLeft2() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        Scanner console = new Scanner(System.in);

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');

        System.out.println("guessesLeft2");

        int expResult = 2;
        int result = hangman.guessesLeft();
        assertEquals(expResult, result);

    }

    /**
     * Test of pattern method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testPattern2() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        Scanner console = new Scanner(System.in);

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        hangman.record('i');
        System.out.println("pattern2");

        String expResult = "---------i--";
        String result = hangman.pattern();
        assertEquals(expResult, result);

    }

    /**
     * Test of guesses method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGuesses2() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        // set basic parameters
        Scanner console = new Scanner(System.in);

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        System.out.println("guesses2");

        Set<Character> expResult = new TreeSet<Character>();
        expResult.add('e');
        expResult.add('a');
        expResult.add('t');
        Set<Character> result = hangman.guesses();
        assertEquals(expResult, result);

    }

    /**
     * Test of record method, of class HangmanManager.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testRecord2() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        System.out.println("record2");

        char guess = 'i';

        int expResult = 1;
        int result = hangman.record(guess);
        assertEquals(expResult, result);

    }

    public void testRecord3() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<String>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        hangman.record('i');
        hangman.record('o');

        System.out.println("record3");

        char guess = 'u';

        int expResult = 2;
        int result = hangman.record(guess);
        assertEquals(expResult, result);

    }

    public void testPattern3() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<String>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        hangman.record('i');
        hangman.record('o');
        hangman.record('u');
        System.out.println("pattern3");

        String expResult = "-u---ou-i--";
        String result = hangman.pattern();
        assertEquals(expResult, result);

    }

    @Test
    public void testGuessesLeft3() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<String>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        hangman.record('i');
        hangman.record('o');
        hangman.record('u');
        System.out.println("guessesLeft3");

        int expResult = 2;
        int result = hangman.guessesLeft();
        assertEquals(expResult, result);

    }

    public void testPattern4() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<String>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        hangman.record('i');
        hangman.record('o');
        hangman.record('u');
        hangman.record('f');
        hangman.record('d');
        hangman.record('m');
        hangman.record('b');
        hangman.record('n');

        System.out.println("pattern4");

        String expResult = "dumbfoundin-";
        String result = hangman.pattern();
        assertEquals(expResult, result);

    }

    @Test
    public void testWords3() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        List<String> dictionary = new ArrayList<>();

        while (input.hasNext()) {
            dictionary.add(input.next().toLowerCase());
        }

        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        HangmanManager hangman = new HangmanManager(dictionary2, 12, 5);
        System.out.println("words3");
        hangman.record('e');
        hangman.record('a');
        hangman.record('t');
        hangman.record('i');
        hangman.record('g');
        hangman.record('u');

        Set<String> expResult = new TreeSet<>();
        expResult.add("cosponsoring");
        Set<String> result = hangman.words();
        assertEquals(expResult, result);

    }

}
