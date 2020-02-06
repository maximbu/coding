package CodingInterviews2018.P16;

public class q16_13 {

    private static Segment cutSquares(Square s1 , Square s2) {
        Point cent1 = new Point((s1.topLeft.x+s1.bottomRight.x)/2,(s1.topLeft.y+s1.bottomRight.y)/2);
        Point cent2 = new Point((s2.topLeft.x+s2.bottomRight.x)/2,(s2.topLeft.y+s2.bottomRight.y)/2);
        return new Segment(cent1,cent2);
    }


    public static void main(String[] args) {
        //Square s1
       // System.out.println(cutSquares));
    }
}
