
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class MyLinkedListGrader {

    PrintWriter out;

    public String printListForwards(MyLinkedList<Integer> lst) {
        LLNode<Integer> curr;
        String ret = "";
        if (lst.head.data == null) {
            curr = lst.head.next;
        } else {
            curr = lst.head;
        }

        while (curr != null && curr.data != null) {
            ret += curr.data;
            curr = curr.next;
        }
        return ret;
    }

    public static String printListBackwards(MyLinkedList<Integer> lst) {
        LLNode<Integer> curr;
        String ret = "";
        if (lst.tail.data == null) {
            curr = lst.tail.prev;
        } else {
            curr = lst.tail;
        }
        while (curr != null && curr.data != null) {
            ret += curr.data;
            curr = curr.prev;
        }
        return ret;
    }

    public void doTest() {
        int incorrect = 0;
        int tests = 0;
        String feedback = "";
        try {
            out = new PrintWriter("grader.out");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        MyLinkedList<Integer> lst = new MyLinkedList<Integer>();
        int nums[] = {1, 2, 3, 4, 5};

        feedback += "** Test #1: Adding to end of list...";
        for (int i : nums) {
            lst.add(i);
        }
        feedback += "Got " + printListForwards(lst) + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test #2: Getting from the middle...";
        feedback += "Fourth element was " + lst.get(3) + ". ";

        lst.add(2, 6);
        out.println(feedback);
        feedback = "";
        feedback += "** Test #3: Adding to the middle...";
        feedback += "Got " + printListForwards(lst) + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test #4: Testing 'prev' pointers by going through the list backwards...";
        feedback += "Got " + printListBackwards(lst) + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test #5: Testing list size...";
        feedback += "Got " + lst.size() + ". ";

        lst.remove(2);
        out.println(feedback);
        feedback = "";
        feedback += "** Test #6: Removing from the middle...";
        feedback += "Got " + printListForwards(lst) + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test #7: Testing 'prev' pointers on remove by going through the list backwards...";
        feedback += "Got " + printListBackwards(lst) + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test #8: Testing size after remove...";
        feedback += "Got " + lst.size() + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test #9: Testing add, remove, and add on new list...";
        lst = new MyLinkedList<Integer>();
        lst.add(0, 1);
        lst.remove(0);
        lst.add(0, 1);
        feedback += "Got " + printListForwards(lst) + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Test 10: Checking size after previous test...";
        feedback += "List size is " + lst.size() + ". ";
        out.println(feedback);
        feedback = "";
        feedback += "** Tests 11-20: Testing method bounds...";
//
//        MyLinkedList<String> list = new MyLinkedList<>();
//        list.add("" + 1);
//        list.add("" + 2);
//        list.add("" + 3);
//        list.add("" + 0);
//        list.remove(2);
//        System.out.println(list);
//        list.remove(2);
//        System.out.println(list);
//        list.remove(1);
//        System.out.println(list);
//        list.remove(0);
//        System.out.println(list);
        out.println(feedback + "Tests complete. Check that everything is as expected.");
        out.close();

    }

    public static void main(String args[]) {
        MyLinkedListGrader grader = new MyLinkedListGrader();
        grader.doTest();
//        MyLinkedList<String> list = new MyLinkedList<>();
//        LinkedList<String> ll = new LinkedList();
//        for (int i = 0; i < 4; i++) {
//            int spot = (int) (Math.random() * i);
//            //System.out.println(spot + " " + i + " " + list.size);
//            list.add(spot, "" + i);
//            ll.add(spot, "" + i);
//        }
//        System.out.println(list);
//        System.out.println(ll);
//        while (!ll.isEmpty()) {
//            int spot = (int) (Math.random() * ll.size());
//            System.out.println("Spot: " + spot);
//            list.remove(spot);
//            ll.remove(spot);
//            System.out.println(list);
//            System.out.println(ll);
//        }
    }

}
