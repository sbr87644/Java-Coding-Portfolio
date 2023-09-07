
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.*;

public class IteratorRemoverRunner {

    public static void main(String[] args) {
        //add test cases
        IteratorRemover test = new IteratorRemover("a b c a b c a", "a");
        out.println(test);
        test.remove();
        out.println(test);
        test.setTest("a b c d e f g h i j x x x x", "x");
        out.println(test);
        test.remove();
        out.println(test);
        test.setTest("1 2 3 4 5 6 a b c a b c", "b");
        out.println(test);
        test.remove();
        out.println(test);
    }
}
