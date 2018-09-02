package CodingInterviews2018.P3;

import java.util.Date;
import java.util.LinkedList;

public class q3_6 {
    private static class Animal{
        Date addedDate;
        String name;

        protected Animal(String name){
            addedDate = new Date();
            this.name = name;
        }
        public Date getAddedDate(){
            return addedDate;
        }

        public String getName() {
            return name;
        }
    }
    private static class Cat extends Animal{

        public Cat(String name){
            super(name);
        }
    }
    private static class Dog extends Animal{

        public Dog (String name){
            super(name);
        }
    }

    private static class AnimalShelter{
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Dog> dogs = new LinkedList<>();

        public void addDog(String name){
            dogs.add(new Dog(name));
        }

        public void addCat(String name){
            cats.add(new Cat(name));
        }

        public Cat getCat(){
            return cats.remove();
        }

        public Dog getDog(){
            return dogs.remove();
        }

        public Animal getAny(){
            if(dogs.isEmpty()) return cats.remove();
            if(cats.isEmpty()) return dogs.remove();
            if(dogs.peek().getAddedDate().before(cats.peek().getAddedDate())){
                return dogs.remove();
            }
            return cats.remove();
        }

    }

    public static void main(String[] st) throws InterruptedException {
        AnimalShelter s = new AnimalShelter();
        s.addCat("cat1");
        Thread.sleep(10);
        s.addCat("cat2");
        Thread.sleep(10);
        s.addDog("dog1");
        Thread.sleep(10);
        s.addDog("dog2");
        Thread.sleep(10);
        s.addCat("cat3");
        Thread.sleep(10);
        s.addDog("dog3");

        Animal cat1 = s.getAny();
        System.out.println("expected "+"cat1"+" got: "+cat1.getName());
        Animal dog1 = s.getDog();
        System.out.println("expected "+"dog1"+" got: "+dog1.getName());
        Animal cat2 = s.getAny();
        System.out.println("expected "+"cat2"+" got: "+cat2.getName());
        Animal dog2 = s.getAny();
        System.out.println("expected "+"dog2"+" got: "+dog2.getName());
        Animal cat3 = s.getCat();
        System.out.println("expected "+"cat3"+" got: "+cat3.getName());
        Animal dog3 = s.getDog();
        System.out.println("expected "+"dog3"+" got: "+dog3.getName());

    }

}
