//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class - 
//Lab  -

import static java.lang.System.*;

public class ListFunHouse {
    //this method will print the entire list on the screen

    public static void print(ListNode list) {
        ListNode temp = list;
        while (temp != null) {
            out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    //this method will return the number of nodes present in list
    public static int nodeCount(ListNode list) {
        int count = 0;
        ListNode temp = list;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //this method will create a new node with the same value as the first node and add this
    //new node to the list.  Once finished, the first node will occur twice.
    public static void doubleFirst(ListNode list) {
        ListNode doubleF = new ListNode(list.getValue(), list.getNext());
        list.setNext(doubleF);
    }

    //this method will create a new node with the same value as the last node and add this
    //new node at the end.  Once finished, the last node will occur twice.
    public static void doubleLast(ListNode list) {
        while (list != null) {
            if (list.getNext() == null) {
                ListNode last = new ListNode(list.getValue(), null);
                list.setNext(last);
                break;
            }
            list = list.getNext();
        }
    }

    //method skipEveryOther will remove every other node
    public static void skipEveryOther(ListNode list) {
    }

    //this method will set the value of every xth node in the list
    public static void setXthNode(ListNode list, int x, Comparable value) {
        int count = 1;
        while (list != null) {
            if (count % x == 0) {
                list.setValue(value);
            }
            list = list.getNext();
        }
    }

    //this method will remove every xth node in the list
    public static void removeXthNode(ListNode list, int x) {
        int count = 1;
        ListNode prev = list;
        ListNode temp = list;
        while (temp != null) {
            if (count % x == 0) {
                prev.setNext(temp.getNext());
            }

        }
        list = temp;
    }
}
