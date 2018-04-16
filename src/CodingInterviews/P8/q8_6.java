package CodingInterviews.P8;

import java.util.*;

/**
 * Created by max on 12/27/2016.
 */
public class q8_6 {
    public static class Tower{
        private int index;
        private Stack<Integer> discs;

        public Tower(int index) {
            this.index = index;
            discs = new Stack<>();
        }

        public Tower(int index,int discs) {
            this.index = index;
            this.discs = new Stack<>();
            for (int i = 0; i < discs; i++) {
                this.discs.add(i);
            }
        }

        public int getIndex() {
            return index;
        }

        public Stack<Integer> getDiscs() {
            return discs;
        }

        public void addDisk(int k){
            if(discs.isEmpty() || discs.peek() < k) {
                discs.push(k);
            }
            else
            {
                throw new RuntimeException("Invalid disk");
            }
        }

        public int removeDisk(){
            return discs.pop();
        }

        public int topDisk(){
            return discs.peek();
        }

        public boolean hasDisks(){
            return !discs.isEmpty();
        }

        public void moveTopToAnotherTower(Tower another){
            another.addDisk(discs.pop());
        }

        public void moveAllDisks(Tower t,Tower helper){
            moveNDisks(discs.size(),t,helper);
        }

        private void moveNDisks(int n ,Tower t,Tower helper){
            if(n>0){
                moveNDisks(n-1,helper,t);
                System.out.println("Moving Disk:" + discs.peek()+" from:"+index+" to:"+t.getIndex());
                moveTopToAnotherTower(t);
                helper.moveNDisks(n-1,t,this);
            }
        }
    }

    public static void main(String[] st){
        Tower t1 = new Tower(1,6);
        Tower t2 = new Tower(2);
        Tower t3 = new Tower(3);

        t1.moveAllDisks(t2,t3);
    }


}
