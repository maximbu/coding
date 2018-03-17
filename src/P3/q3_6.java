package P3;


import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * Created by max on 12/22/2016.
 */
public class q3_6 {
    public static class ShelterAnimal {
        private Timestamp date;
        private String name;
        public ShelterAnimal (String name){
            date = new Timestamp(System.currentTimeMillis());
            this.name= name;
        }
        public Timestamp getDate(){
            return date;
        }
        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return "ShelterAnimal{" +
                    "date=" + date +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class ShelterDog extends ShelterAnimal {
        public ShelterDog(String name){
            super(name);
        }
    }

    public static  class ShelterCat extends ShelterAnimal {
        public ShelterCat(String name){
            super(name);
        }
    }

    public static class Shelter{
        LinkedList<ShelterDog> dogs;
        LinkedList<ShelterCat> cats;
        public Shelter(){
            dogs = new LinkedList<>();
            cats = new LinkedList<>();
        }

        public void add(ShelterAnimal a){
            if(a instanceof ShelterDog){
                dogs.add((ShelterDog)a);
            }
            if(a instanceof ShelterCat){
                cats.add((ShelterCat)a);
            }

        }

        public ShelterCat getCat(){
            return cats.remove();
        }
        public ShelterDog getDog(){
            return dogs.remove();
        }

        public ShelterAnimal getLatest(){
            if(cats.isEmpty()){
                return dogs.remove();
            }
            if(dogs.isEmpty()){
                return cats.remove();
            }
            if(dogs.peek().getDate().before(cats.peek().getDate())){
                return dogs.remove();
            }
            return cats.remove();
        }



    }

    public static void main(String[] st) throws InterruptedException {
        Shelter s = new Shelter();
        s.add(new ShelterCat("cat1"));
        Thread.sleep(10);
        s.add(new ShelterCat("cat2"));
        Thread.sleep(10);
        s.add(new ShelterDog("dog1"));
        Thread.sleep(10);
        s.add(new ShelterDog("dog2"));
        Thread.sleep(10);
        s.add(new ShelterCat("cat3"));
        Thread.sleep(10);
        s.add(new ShelterDog("dog3"));

        ShelterAnimal cat1 = s.getLatest();
        ShelterAnimal dog1 = s.getDog();
        ShelterAnimal cat2 = s.getLatest();
        ShelterAnimal dog2 = s.getLatest();
        ShelterAnimal cat3 = s.getCat();
        ShelterAnimal dog3 = s.getDog();

    }
}
