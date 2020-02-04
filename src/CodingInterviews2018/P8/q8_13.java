package CodingInterviews2018.P8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q8_13 {

    private static class Box implements Comparable<Box> {

        double height;
        double width;
        double depth;

        public Box(double h, double w, double d) {
            this.height = h;
            this.width = w;
            this.depth = d;
        }

        @Override
        public int compareTo(Box other) {
            return Double.compare(height, other.height);
        }

        public boolean canPlaceOnTop(Box b) {
            return height < b.height && width < b.width && depth < b.depth;
        }
    }


    private static double stackOfBoxes(List<Box> boxes) {
        if (boxes == null || boxes.isEmpty())
            return 0;
        boxes.sort(Collections.reverseOrder());
        return stackOfBoxes(boxes, 0, 0, new Box(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
    }

    private static double stackOfBoxes(List<Box> boxes, int currInd, double maxHeight, Box topBox) {
        if (currInd == boxes.size()) {
            return maxHeight;
        }
        Box currBox = boxes.get(currInd);
        double withBoxOnTop = 0;
        if (currBox.canPlaceOnTop(topBox)) {
            withBoxOnTop = stackOfBoxes(boxes, currInd + 1, maxHeight + currBox.height, currBox);
        }
        double withoutBoxOnTop = stackOfBoxes(boxes, currInd + 1, maxHeight, topBox);
        return Math.max(withBoxOnTop, withoutBoxOnTop);
    }


    public static void main(String[] st) {
        Box b3 = new Box(4, 6, 1);
        Box b1 = new Box(1, 2, 3);
        Box b2 = new Box(2, 3, 4);

        Box[] boxList = {new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};

        double height = stackOfBoxes(Arrays.asList(boxList));
        System.out.println(height);
    }
}
