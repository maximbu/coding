package CodingInterviews.P8;

/**
 * Created by max on 12/28/2016.
 */
public class q8_10 {
    public enum Color {None("-"), Red("R"), Green("G");

        private final String repString;

        Color(String r) {
            repString = r;
        }

        @Override
        public String toString() {
            return repString;
        }
    }

    public static void fill(Color[][] area, int r, int c, Color newColor) {
        if (checkBounds(area, r, c) && area[r][c] != newColor) {
            fillRec(area, r, c, newColor, area[r][c]);
        }
    }

    private static boolean checkBounds(Color[][] area, int r, int c) {
        return !(r < 0 || r >= area.length || c < 0 || area[r].length <= c);
    }

    private static void fillRec(Color[][] area, int r, int c, Color newColor, Color origColor) {
        if (!checkBounds(area, r, c) || area[r][c] != origColor) {
            return;
        }
        area[r][c] = newColor;
        fillRec(area, r + 1, c, newColor, origColor);
        fillRec(area, r - 1, c, newColor, origColor);
        fillRec(area, r, c + 1, newColor, origColor);
        fillRec(area, r, c - 1, newColor, origColor);
    }

    public static void PrintScreen(Color[][] screen) {
        for (int r = 0; r < screen.length; r++) {
            for (int c = 0; c < screen[0].length; c++) {
                System.out.print(screen[r][c]);
            }
            System.out.println();
        }
    }
    public static void main(String[] st){
        int N = 10;
        Color[][] screen = new Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Color.None;
            }
        }
        for (int i = 0; i <40; i++) {
            screen[(int)(Math.random()*N)][(int)(Math.random()*N)] = Color.Green;
        }
        PrintScreen(screen);
        fill(screen, 2, 2, Color.Red);
        System.out.println();
        PrintScreen(screen);
    }
}
