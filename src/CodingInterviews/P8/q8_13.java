package CodingInterviews.P8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by max on 12/28/2016.
 */
public class q8_13 {
    public static class Box implements Comparable<Box> {
        double height;
        double len;
        double width;

        public Box(double height, double len, double width) {
            this.height = height;
            this.len = len;
            this.width = width;
        }


        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getLen() {
            return len;
        }

        public void setLen(double len) {
            this.len = len;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        @Override
        public int compareTo(Box o) {
            if (Math.abs(height - o.height) < 0.00001) return 0;
            return height < o.height ? -1 : 1;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "height=" + height +
                    ", len=" + len +
                    ", width=" + width +
                    '}';
        }

        public boolean canBeAbove(Box b) {
            return height < b.height && width < b.width && len < b.len;
        }
    }

    public static double stackOfBoxes(List<Box> boxes) {
        Collections.sort(boxes);
        double[] best = new double[boxes.size()];
        return stackOfBoxes(boxes, null, 0);
    }

    private static double stackOfBoxes(List<Box> boxes, Box bottom, int i) {
        if (i >= boxes.size()) return 0;
        Box newBottom = boxes.get(i);
        double heightWithI = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            heightWithI = newBottom.getHeight() + stackOfBoxes(boxes, newBottom, i + 1);
        }
        double heightWithoutI = stackOfBoxes(boxes, bottom, i + 1);

        return Math.max(heightWithI, heightWithoutI);
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
