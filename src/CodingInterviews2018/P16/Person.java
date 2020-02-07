package CodingInterviews2018.P16;

public class Person {
    private int birth;
    private int death;

    public Person(int birthYear, int deathYear) {
        birth = birthYear;
        death = deathYear;
    }

    public int getBirth() {
        return birth;
    }

    public int getDeath() {
        return death;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birth=" + birth +
                ", death=" + death +
                '}';
    }
}
