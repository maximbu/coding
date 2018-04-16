package CodingInterviews.utils;

/**
 * Created by max on 1/1/2017.
 */
public class WeightedGraphNodeNeighbor implements Comparable<WeightedGraphNodeNeighbor>{
    private String name;
    private double weight;

    public WeightedGraphNodeNeighbor(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightedGraphNodeNeighbor{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(WeightedGraphNodeNeighbor o) {
        if(weight<o.weight) return -1;
        if(weight>o.weight) return 1;
        return 0;
    }
}


