package UVA.AdHoc.Games_harder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Q114_SimulationWizardry {

  private int M;
  private int N;

  public static void main(String[] st) {
    Q114_SimulationWizardry p = new Q114_SimulationWizardry();
    p.solve();
  }

  private void solve() {
    Scanner sc = new Scanner(System.in);
    M = sc.nextInt();
    N = sc.nextInt();
    sc.nextLine();
    int wallCost = sc.nextInt();
    sc.nextLine();
    int bumpersNum = sc.nextInt();
    sc.nextLine();
    int[][] bumpersPoints = new int[M + 2][N + 2];
    int[][] bumpersCost = new int[M + 2][N + 2];
    boolean[][] hasBumper = new boolean[M + 2][N + 2];
    while (bumpersNum-- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      bumpersPoints[x][y] = sc.nextInt();
      bumpersCost[x][y] = sc.nextInt();
      hasBumper[x][y] = true;
      sc.nextLine();
    }
    List<Ball> balls = new ArrayList<>();
    while (sc.hasNextLine()) {
      String[] input = sc.nextLine().split("\\s+");
      int[] line = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
      Ball b = new Ball(line[0], line[1], line[2], line[3]);
      balls.add(b);
    }
    List<Integer> ans = solve(balls, wallCost, bumpersPoints, bumpersCost, hasBumper);
    int sum = 0;
    for (Integer an : ans) {
      sum += an;
      System.out.println(an);
    }
    System.out.println(sum);
  }

  private List<Integer> solve(List<Ball> balls, int wallCost, int[][] bumpersPoints,
                              int[][] bumpersCost, boolean[][] hasBumper) {
    return balls.stream()
            .map(ball -> simulate(ball, wallCost, bumpersPoints, bumpersCost, hasBumper))
            .collect(Collectors.toList());
  }

  int[] xChange = {1, 0, -1, 0};
  int[] yChange = {0, 1, 0, -1};

  private int simulate(Ball ball, int wallCost, int[][] bumpersPoints, int[][] bumpersCost,
                       boolean[][] hasBumper) {
    int points = 0;
    while (ball.lifeTime > 0) {
      ball.lifeTime--;
      int newX = ball.x + xChange[ball.direction];
      int newY = ball.y + yChange[ball.direction];
      if (newX < 2 || newY < 2 || newX > M - 1 || newY > N - 1) {
        ball.lifeTime -= wallCost;
        ball.direction = (4 + ball.direction - 1) % 4;
      } else if (hasBumper[newX][newY]) {
        if (ball.lifeTime > 0) {
          ball.lifeTime -= bumpersCost[newX][newY];
          points += bumpersPoints[newX][newY];
        }
        ball.direction = (4 + ball.direction - 1) % 4;
      } else {
        ball.x = newX;
        ball.y = newY;
      }
    }
    return points;
  }


  private class Ball {

    private int x;
    private int y;
    private int lifeTime;
    private int direction;

    public Ball(int x, int y, int direction, int lifeTime) {
      this.x = x;
      this.y = y;
      this.lifeTime = lifeTime;
      this.direction = direction;
    }

    @Override
    public String toString() {
      return "Ball{" +
              "x=" + x +
              ", y=" + y +
              ", lifeTime=" + lifeTime +
              ", direction=" + direction +
              '}';
    }
  }
}
