
import static java.lang.System.out;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

public class MonsterPQRunner {

    public static void main(String[] args) {
        //add test cases	
        MonsterPQ test = new MonsterPQ();
        test.add(new Monster(1,1,1));
        test.add(new Monster(2,2,2));
        test.add(new Monster(1,2,3));
        test.add(new Monster(3,2,1));
        test.add(new Monster(2,1,3));
        test.add(new Monster(2,3,1));
        test.add(new Monster(3,1,2));
        test.add(new Monster(3,3,3));
        out.println(test);
        out.println("getMin() - " + test.getMin());
        out.println("removeMin() - " + test.removeMin());
    }
}
