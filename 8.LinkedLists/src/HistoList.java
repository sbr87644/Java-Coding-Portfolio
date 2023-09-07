//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.*;
import static java.lang.System.*;

public class HistoList {

    private HistoNode front;

    public HistoList() {
        front = null;
    }

    //addLetter will add a new node to the front for let if let does not exist
    //addLetter will bump up the count if let already exists
    public void addLetter(char let) {
         if(indexOf(let) > -1){
             HistoNode temp = front;
             while(temp != null){
                 if(temp.getLetter() == let){
                     temp.setLetterCount(temp.getLetterCount() + 1);
                     break;
                 }
                 temp = temp.getNext();
             }
         }
         else
             front = new HistoNode(let, 1, front);
    }

    //returns the index pos of let in the list if let exists
    public int indexOf(char let) {
       int pos = 0;
       HistoNode temp = front;
       while(temp != null){
           if(temp.getLetter() == let)
               return pos;
           pos++;
           temp = temp.getNext();
       }
        return -1;
    }

    //returns a reference to the node at spot
    private HistoNode nodeAt(int spot) {
        HistoNode current = null;
        HistoNode temp = front;
        int pos = 0;
        while(temp != null){
            if(pos == spot){
                current = temp;
                break;
            }
            temp = temp.getNext();
        }
        return current;
    }

    //returns a string will all values from list
    public String toString() {
        String output = "";
        HistoNode temp = front;
        while(temp != null){
            output+= temp.getLetter() + " - " + temp.getLetterCount() + " ";
            temp = temp.getNext();
        }
        return output;
    }
}
