package CodingInterviews2018.P16;

public class q16_22 {

    private static void langtonsAnt(int k) {
        var board = new LangtonsAntBoard();
        Ant ant = new Ant();
        for (int i = 0; i < k; i++) {
            Location newLocation = board.makeMove(ant.getLocation());
            ant.setLocation(newLocation);
        }
        board.print();
    }


    public static void main(String[] args) {
        langtonsAnt(52);
    }
}
