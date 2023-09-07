//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Stack;
import java.util.Scanner;
import static java.lang.System.*;

public class PostFix {

    private Stack<Double> stack;
    private String exp;

    public PostFix() {
        setExpression("");
    }

    public PostFix(String exp) {
        setExpression(exp);
    }

    public void setExpression(String exp) {
        stack = new Stack<>();
        this.exp = exp;
    }

    public double calc(double one, double two, char op) {
        if (op == '-') {
            return two - one;
        } else if (op == '+') {
            return one + two;
        } else if (op == '*') {
            return one * two;
        } else {
            return two / one;
        }
    }

    public void solve() {
        for (char c : exp.toCharArray()) {
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                stack.push(calc(stack.pop(), stack.pop(), c));
            } else if (c != ' ') {
                stack.push((double) (c - '0'));
            }
        }
    }

    //add a toString
    public String toString() {
        String out = "";
        for (char c : exp.toCharArray()) {
            out += c;
        }
        out += " = " + stack.peek();
        return out;
    }
}
