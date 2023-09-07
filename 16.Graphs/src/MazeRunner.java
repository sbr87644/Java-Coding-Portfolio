//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MazeRunner {

    public static void main(String args[]) throws IOException {
        //add test cases
        Scanner file = new Scanner(new File("maze.dat"));
        int len;
        int[][] maze;
        Maze m;
        while (file.hasNextInt()) {
            len = file.nextInt();
            maze = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    maze[i][j] = file.nextInt();
                }
            }
            m = new Maze(maze);
            out.println(m);
            if (m.checkForExitPath(0, 0)) {
                out.println("exit found");
            } else {
                out.println("exit not found");
            }
            out.println();
        }
    }
}
