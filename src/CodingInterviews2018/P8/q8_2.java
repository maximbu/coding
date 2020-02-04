package CodingInterviews2018.P8;

import CodingInterviews.utils.Matrix;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class q8_2 {

    public static void main(String[] args) {
        int size = 4;
        boolean[][] maze = Matrix.randomBooleanMatrix(size);
        maze[0][0] = maze[size - 1][size - 1] = true;

        Matrix.printMatrix(maze);

        var path = getPath(maze);
        System.out.println(path.map(q8_2::printPath).orElse("No path found."));
    }

    private static String printPath(ArrayList<Point> list) {
        return list.stream().map(p -> "(" + p.x + "," + p.y + ")").collect(Collectors.joining("->"));
    }

    private static Optional<ArrayList<Point>> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return Optional.empty();
        }

        var startingPoint = new Point(0, 0);
        var path = new ArrayList<Point>();
        var visited = new HashSet<Point>();
        if (getPath(maze, startingPoint, path, visited)) {
            Collections.reverse(path);
            return Optional.of(path);
        }
        return Optional.empty();

    }

    private static boolean getPath(boolean[][] maze, Point curr, ArrayList<Point> path, HashSet<Point> visited) {
        if (curr.x >= 0 && curr.y >= 0 && curr.x < maze.length && curr.y < maze[0].length && maze[curr.x][curr.y] && visited.add(curr)) {
            boolean endPoint = (curr.x == maze.length - 1 && curr.y == maze[0].length - 1);
            if (endPoint || getPath(maze, new Point(curr.x + 1, curr.y), path, visited) || getPath(maze, new Point(curr.x, curr.y + 1), path, visited)) {
                path.add(curr);
                return true;
            }
        }
        return false;
    }

}
