package CodingInterviews2018.P17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q17_8 {

    private static class Performer implements Comparable<Performer> {
        private final int height;
        private final int weight;

        public Performer(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "{" +
                    "h:" + height +
                    ", w:" + weight +
                    '}';
        }

        public boolean canBeOnTopOf(Performer performer) {
            return height < performer.height && weight < performer.weight;
        }

        @Override
        public int compareTo(Performer o) {
            return this.height != o.height ? Integer.compare(this.height, o.height) : Integer.compare(this.weight, o.weight);
        }
    }

    private static class MaxPerformerTower{
        private int height;
        private List<Performer> performers = new ArrayList<>();

        public MaxPerformerTower(Performer p) {
            tryToAddPerformer(p);
        }

        public MaxPerformerTower(MaxPerformerTower prev , Performer p) {
            performers = new ArrayList<>(prev.performers);
            height=prev.height;
            tryToAddPerformer(p);
        }

        public int getHeight() {
            return height;
        }

        public boolean canAddPerformer(Performer p){
            return performers.size() == 0 || performers.get(0).canBeOnTopOf(p);
        }

        private void tryToAddPerformer(Performer p) {
            if(canAddPerformer(p)) {
                performers.add(p);
                height += p.height;
            }
        }

        @Override
        public String toString() {
            return "MaxPerformerTower{" +
                    "height=" + height +
                    ", performers=" + performers +
                    '}';
        }
    }

    private static MaxPerformerTower findHighestTower(List<Performer> performers) {
        performers.sort(Performer::compareTo);
        MaxPerformerTower[] highest = new MaxPerformerTower[performers.size()];
        for (int indexOfPerformer = 0; indexOfPerformer < performers.size(); indexOfPerformer++) {
            highest[indexOfPerformer] = findHighestTower(performers.get(indexOfPerformer), highest, indexOfPerformer);
        }
        int max = highest[0].height;
        int ind = 0;
        for (int performerOnTop = 1; performerOnTop < performers.size(); performerOnTop++) {
            if (max < highest[performerOnTop].height) {
                max = highest[performerOnTop].height;
                ind = performerOnTop;
            }
        }
        return highest[ind];
    }

    private static MaxPerformerTower findHighestTower(Performer performer, MaxPerformerTower[] highest, int indexOfPerformer) {
        MaxPerformerTower bestTower = new MaxPerformerTower(performer);

        for (int performerOnTop = 0; performerOnTop < indexOfPerformer; performerOnTop++) {
            int newHeight = highest[performerOnTop].getHeight();
            if(highest[performerOnTop].canAddPerformer(performer)) {
                newHeight += performer.getHeight();
            }
            if (bestTower.getHeight() < newHeight) {
                bestTower = new MaxPerformerTower(highest[performerOnTop], performer);
            }
        }
        return bestTower;

    }


    public static void main(String[] args) {
        List<Performer> performers = Arrays.asList(
                new Performer(65, 60), new Performer(70, 150), new Performer(56, 90),
                new Performer(75, 190), new Performer(60, 95), new Performer(68, 110),
                new Performer(35, 65), new Performer(40, 60), new Performer(45, 63));

        System.out.printf("Longest sequence for those people: %s is: %n%s%n", performers, findHighestTower(performers));
    }




}
