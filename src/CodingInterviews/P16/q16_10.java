package CodingInterviews.P16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 1/22/2017.
 */
public class q16_10 {
    private static class Person {
        private int birthYear;
        private int deathYear;

        public Person(int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
        }

        public int getDeathYear() {
            return deathYear;
        }

        public void setDeathYear(int deathYear) {
            this.deathYear = deathYear;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "birthYear=" + birthYear +
                    ", deathYear=" + deathYear +
                    '}';
        }
    }

    public int maxAlive(Person[] people,int minYear , int maxYear){
        int tot = 101;
        int startYear = 1900;
        int years[] = new int[tot];
        for (Person p:people) {
            years[p.getBirthYear()-startYear]++;
            years[p.getDeathYear()-startYear]--;
        }
        int total[] = new int[tot];
        total[0]=years[0];
        for (int i = 1; i <tot ; i++) {
            total[i] = total[i-1]+years[i];
        }
        int max = 0;
        int year = 0;
        for (int i=minYear-startYear;i<=maxYear-startYear;i++)
        {
            if(total[i] > max){
                max = total[i];
                year = i;
            }
        }
        return year+startYear;
    }

    public static void main(String[] s){
        q16_10 q = new q16_10();
        List<Person> p = new ArrayList<Person>();
        p.add(new Person(1994,1999));
        p.add(new Person(1904,2000));
        p.add(new Person(1904,2000));
        p.add(new Person(1900,1950));
        p.add(new Person(1914,1960));
        p.add(new Person(1920,1970));

        System.out.println(q.maxAlive(p.toArray(new Person[p.size()]),1905,2000));
    }

}
