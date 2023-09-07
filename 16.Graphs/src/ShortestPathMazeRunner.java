//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathMazeRunner {

    public static void main(String args[]) throws IOException {
        //add test cases
        Scanner file = new Scanner(new File("maze2.dat"));
        int len;
        int[][] maze;
        ShortestPathMaze m;
        while (file.hasNextInt()) {
            len = file.nextInt();
            maze = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    maze[i][j] = file.nextInt();
                }
            }
            m = new ShortestPathMaze(maze);
            out.println(m);
            m.checkForExitPath(0, 0, 0);
            if (m.checkExit()) {
                out.println("shortest path of " + m.getShortestPath());
            } else {
                out.println("no path");
            }
            out.println();
        }
    }
}
