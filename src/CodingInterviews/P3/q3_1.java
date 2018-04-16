package CodingInterviews.P3;

/**
 * Created by max on 12/18/2016.
 */
public class q3_1 {
    public static class ThreeInOne{
        public static final int STACK_LEN = 1000;
        public static final int STACK_NUM = 3;
        private int[] arr;
        private int[] sizes;


        public ThreeInOne(){
            arr = new int[STACK_NUM*STACK_LEN];
            sizes = new int[STACK_NUM];
        }

        public void push(int stackNum , int val){
            if(sizes[stackNum]==STACK_LEN-1) throw new RuntimeException("Stuck is full");
            arr[stackNum*STACK_LEN+sizes[stackNum]] = val;
            sizes[stackNum]++;
        }
        public int pop(int stackNum){
            if(isEmpty(stackNum)) throw new RuntimeException("No elements");
            int val = arr[stackNum* STACK_LEN +sizes[stackNum]];
            sizes[stackNum]--;

            return val;
        }
        public int pick(int stackNum) {
            return arr[stackNum * STACK_LEN + sizes[stackNum]];
        }
        public boolean isEmpty(int stackNum){
            return sizes[stackNum] == 0;
        }
        public void print(int stackNum){
            StringBuilder s = new StringBuilder();
            for (int i = STACK_LEN * stackNum + sizes[stackNum] - 1; i >= STACK_LEN * stackNum; i--)
            {
                s.append(arr[i]);
                if(i>STACK_LEN * stackNum){
                    s.append(",");
                }
            }
            System.out.println(s.toString());
        }
        public void printAll(){
            System.out.println("=========================");
            for (int i=0;i<STACK_NUM;i++)
            {
                System.out.println("Stack "+i+":");
                print(i);
            }
        }
    }

    public static void main(String[] args){
        ThreeInOne stacks = new ThreeInOne();
        stacks.printAll();
        stacks.push(0, 10);
        stacks.printAll();
        stacks.push(1, 20);
        stacks.printAll();
        stacks.push(2, 30);
        stacks.printAll();

        stacks.push(1, 21);
        stacks.printAll();
        stacks.push(0, 11);
        stacks.printAll();
        stacks.push(0, 12);
        stacks.printAll();

        stacks.pop(0);
        stacks.printAll();

        stacks.push(2, 31);
        stacks.printAll();

        stacks.push(0, 13);
        stacks.printAll();
        stacks.push(1, 22);
        stacks.printAll();

        stacks.push(2, 31);
        stacks.printAll();
        stacks.push(2, 32);
        stacks.printAll();
        stacks.push(2, 33);
        stacks.printAll();
        stacks.push(2, 34);
        stacks.printAll();

        stacks.pop(1);
        stacks.printAll();
        stacks.push(2, 35);
        stacks.printAll();
    }
}
