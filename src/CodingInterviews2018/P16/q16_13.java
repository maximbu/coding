package CodingInterviews2018.P16;

public class q16_13 {

    private static Segment cutSquares(Square s1 , Square s2) {
        Point cent1 = new Point((s1.getTopLeft().getX()+s1.getBottomRight().getX())/2,(s1.getTopLeft().getY()+s1.getBottomRight().getY())/2);
        Point cent2 = new Point((s2.getTopLeft().getX()+s2.getBottomRight().getX())/2,(s2.getTopLeft().getY()+s2.getBottomRight().getY())/2);
        return new Segment(cent1,cent2);
    }


    public static void main(String[] args) {
        //Square s1
       // System.out.println(cutSquares));
    }
}
