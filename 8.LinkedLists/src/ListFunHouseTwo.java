//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -  

import static java.lang.System.*;

public class ListFunHouseTwo {

    private ListNode theList;

    public ListFunHouseTwo() {
        theList = null;
    }

    public void add(Comparable data) {
        theList = new ListNode(data, theList);
    }

    //this method will return the number of nodes present in list
    public int nodeCount() {
        int count = 0;
        ListNode temp = theList;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //this method will create a new node with the same value as the first node and add this
    //new node at the front of the list.  Once finished, the first node will occur twice.
    public void doubleFirst() {
        ListNode doubleF = new ListNode(theList.getValue(), theList.getNext());
        theList.setNext(doubleF);

    }

    //this method will create a new node with the same value as the last node and add this
    //new node at the end.  Once finished, the last node will occur twice.
    public void doubleLast() {
        ListNode temp = theList;
        while (temp != null) {
            if (temp.getNext() == null) {
                ListNode last = new ListNode(temp.getValue(), null);
                temp.setNext(last);
                break;
            }
            temp = temp.getNext();
        }
    }

    //method skipEveryOther will remove every other node
    public void skipEveryOther() {
        ListNode head = theList;
        while (theList != null) {
            if (theList.getNext() == null) {
                theList.setNext(null);
            } else {
                theList.setNext(theList.getNext().getNext());
            }
            theList = theList.getNext();
        }
        theList = head;
    }

    //this method will set the value of every xth node in the list
    public void setXthNode(int x, Comparable value) {
        int count = 1;
        ListNode head = theList;
        while (theList != null) {
            if (count % x == 0) {
                theList.setValue(value);
            }
            count++;
            theList = theList.getNext();
        }
        theList = head;
    }

    //this method will remove every xth node in the list
    public void removeXthNode(int x) {
        int count = 1;
        ListNode head = theList;
        while (theList != null) {
            if (count + 1 % x == 0) {
                if (theList.getNext() == null) {
                    theList.setNext(null);
                } else {
                    theList.setNext(theList.getNext().getNext());
                }
                count++;
            }
            count++;
            theList = theList.getNext();
        }
        theList = head;
    }
    //this method will return a String containing the entire list

    public String toString() {
        String output = "";
        ListNode temp = theList;
        while (temp != null) {
            output += temp.getValue() + " ";
            temp = temp.getNext();
        }
        return output;
    }

}
