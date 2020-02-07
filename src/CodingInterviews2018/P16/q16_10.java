package CodingInterviews2018.P16;

import java.util.Arrays;

public class q16_10 {

    private static int mostAlivePeople(Person[] a) {
        int from = Arrays.stream(a).map(Person::getBirth).min(Integer::compareTo).get();
        int to = Arrays.stream(a).map(Person::getDeath).max(Integer::compareTo).get();

        int[] years = new int[to - from + 1];
        for (Person p : a) {
            years[p.getBirth() - from]++;
            years[p.getDeath() - from]--;
        }
        int max = years[0];
        int bestYear = from;
        int alive = years[0];
        for (int i = 1; i < years.length; i++) {
            alive += years[i];
            if (alive > max) {
                max = alive;
                bestYear = i + from;
                System.out.println("In year " + bestYear + " there were " + max + " people alive");
            }
        }
        return bestYear;
    }


    public static void main(String[] args) {
        Person[] persons = new Person[10];
        persons[0] = new Person(1865, 1911);
        persons[1] = new Person(1920, 1961);
        persons[2] = new Person(1895, 1910);
        persons[3] = new Person(1900, 1911);
        persons[4] = new Person(1765, 1881);
        persons[5] = new Person(1811, 1888);
        persons[6] = new Person(1868, 1977);
        persons[7] = new Person(1895, 1911);
        persons[8] = new Person(1914, 1956);
        persons[9] = new Person(1933, 1977);
        System.out.println(mostAlivePeople(persons));
    }
}
