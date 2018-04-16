package CodingInterviews.P8;

import CodingInterviews.utils.Matrix;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by max on 12/26/2016.
 */
public class q8_2 {
    public static ArrayList<Point> getPath(boolean[][] maze) {
        if(maze == null || maze.length == 0){
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> visited = new HashSet<Point>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path,visited)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> visited) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);
        if (!visited.add(p)) {
            return false;
        }

        boolean isStartingPoint = (col == 0) && (row == 0);
        if (isStartingPoint || getPath(maze, row, col - 1, path, visited) || getPath(maze, row - 1, col, path, visited)) {
            path.add(p);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int size = 4;
        boolean[][] maze = Matrix.randomBooleanMatrix(size);
        maze[0][0] = maze[size-1][size-1] = true;

        Matrix.printMatrix(maze);

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            System.out.println(path.toString());
        } else {
            System.out.println("No path found.");
        }
    }
}
