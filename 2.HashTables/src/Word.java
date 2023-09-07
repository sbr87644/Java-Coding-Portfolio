//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class - 
//Lab  -

public class Word {

    private String theValue;

    //write a constructor method
    public Word(String s) {
        theValue = s;
    }

    //write the getValue method
    public String getValue() {
        return theValue;
    }

    //write the equals method
    public boolean equals(Object obj) {
        return hashCode() == new Word((String) obj).hashCode();
    }

    //write the hashCode method
    public int hashCode() {
        return countVowels() * theValue.length() % 10;
    }

    private int countVowels() {
        int count = 0;
        for (int i = 0; i < theValue.length(); i++) {
            if (theValue.charAt(i) == 'a' || theValue.charAt(i) == 'e' || theValue.charAt(i) == 'i' || theValue.charAt(i) == 'o' || theValue.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    //write the toString method
    public String toString() {
        return theValue;
    }
}
