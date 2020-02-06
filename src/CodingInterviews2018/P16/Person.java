package CodingInterviews2018.P16;

public class Person {
    public int birth;
    public int death;
    public Person(int birthYear, int deathYear) {
        birth = birthYear;
        death = deathYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birth=" + birth +
                ", death=" + death +
                '}';
    }
}
