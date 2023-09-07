//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class ShortestPathMaze {

    private int[][] maze;
    private int shortest;
    private boolean exit;

    public ShortestPathMaze() {
        maze = new int[10][10];
        shortest = Integer.MAX_VALUE;
    }

    public ShortestPathMaze(int[][] m) {
        maze = m;
        shortest = Integer.MAX_VALUE;
    }

    public void checkForExitPath(int r, int c, int path) {
        if (r >= 0 && r < maze.length && c >= 0 && c < maze.length && maze[r][c] == 1) {
            maze[r][c] = 2;
            if (c == maze.length - 1 && path + 1 < shortest) {
                exit = true;
                shortest = path + 1;
            } else {
                checkForExitPath(r, c + 1, path + 1);
                checkForExitPath(r, c - 1, path + 1);
                checkForExitPath(r + 1, c, path + 1);
                checkForExitPath(r - 1, c, path + 1);
            }
        }
    }

    public int getShortestPath() {
        return shortest;
    }

    public boolean checkExit() {
        return exit;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                output += maze[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }
}
