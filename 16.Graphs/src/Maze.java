//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class Maze {

    private int[][] maze;

    public Maze() {
        maze = new int[10][10];
    }

    public Maze(int[][] m) {
        maze = m;
    }

    public boolean checkForExitPath(int r, int c) {
        if(r >= 0 && r < maze.length && c >= 0 && c < maze.length && maze[r][c] == 1){
            maze[r][c] = 2;
            if(c == maze.length - 1){
                return true;   
            } else {
                return checkForExitPath(r + 1, c) || checkForExitPath(r - 1, c) || checkForExitPath(r, c + 1)
                        || checkForExitPath(r, c - 1);
            }
        }
        return false;
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < maze.length; i++){
           for(int j = 0; j < maze[i].length; j++){   
              output+= maze[i][j] + " ";   
           }
           output+= "\n";
        }
        return output;
    }
}
