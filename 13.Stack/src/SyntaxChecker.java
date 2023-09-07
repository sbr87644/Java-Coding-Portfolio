//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Stack;
import static java.lang.System.*;

public class SyntaxChecker {

    private String exp;
    private Stack<Character> symbols;

    public SyntaxChecker() {
        exp = "";
        symbols = new Stack<>();
    }

    public SyntaxChecker(String s) {
        setExpression(s);
    }

    public void setExpression(String s) {
        symbols = new Stack();
        exp = s;
    }

    public boolean checkExpression() {
        for (char c : exp.toCharArray()) {
            if (c == '{' || c == '(' || c == '<' || c == '[') {
                symbols.push(c);
            } else if (c == '}' || c == ')' || c == '>' || c == ']') {
                if (!symbols.isEmpty()) {
                    char pos= symbols.pop();
                    if (pos == '{' && c == '}') {
                    } else if (pos == '(' && c == ')') {
                    } else if (pos == '<' && c == '>') {
                    } else if (pos == '[' && c == ']') {
                    } else
                        return false;
                } else {
                    return false;
                }
            }
        }
        return symbols.isEmpty();
    }

    //write a toString
    public String toString() {
        String out = exp;
        System.out.println(checkExpression());
        if (checkExpression()) {
            out += " is correct.";
        } else {
            out += " is incorrect.";
        }
        return out;
    }
}
