package CodingInterviews2018.P3;


public class q3_1 {
    private static class MultiStacks<T> {
        int STACK_SIZE = 1000;
        private T[] arr;
        private int[] sizes;
        int stacks;

        public MultiStacks(int stacks) {
            this.stacks = stacks;
            arr = (T[]) new Object[STACK_SIZE * stacks];
            sizes = new int[stacks];
        }

        public void push(int stack, T item) {
            if (getLastElementIndex(stack) >= stack * STACK_SIZE) {
                throw new IllegalStateException("stack is out of space");
            }
            arr[getLastElementIndex(stack)] = item;
            sizes[stack - 1]++;
        }

        public T pop(int stack) {
            if (isEmpty(stack)) {
                throw new IllegalStateException("stack is empty");
            }
            T ret = arr[getLastElementIndex(stack) - 1];
            sizes[stack - 1]--;
            return ret;
        }

        public boolean isEmpty(int stack) {
            return size(stack) == 0;
        }

        public int size(int stack) {
            return sizes[stack - 1];
        }

        private int getLastElementIndex(int stack) {
            return (STACK_SIZE * (stack - 1)) + size(stack);
        }

        public void print(int stackNum) {
            StringBuilder s = new StringBuilder();
            int last = getLastElementIndex(stackNum) - 1;
            int size = size(stackNum);
            for (int i = 0; i < size - 1; i++) {
                s.append(arr[last - i]);
                s.append(",");
            }
            if (size > 0) {
                s.append(arr[last - size + 1]);
            }
            System.out.println(s.toString());
        }

        public void printAll() {
            System.out.println("=========================");
            for (int i = 1; i <= stacks; i++) {
                System.out.println("Stack " + i + ":");
                print(i);
            }
        }

    }

    public static void main(String[] args) {
        var stacks = new MultiStacks<Integer>(3);
        stacks.printAll();
        stacks.push(1, 10);
        stacks.printAll();
        stacks.push(2, 20);
        stacks.printAll();
        stacks.push(3, 30);
        stacks.printAll();

        stacks.push(2, 21);
        stacks.printAll();
        stacks.push(1, 11);
        stacks.printAll();
        stacks.push(1, 12);
        stacks.printAll();

        stacks.pop(1);
        stacks.printAll();

        stacks.push(3, 31);
        stacks.printAll();

        stacks.push(1, 13);
        stacks.printAll();
        stacks.push(2, 22);
        stacks.printAll();

        stacks.push(3, 31);
        stacks.printAll();
        stacks.push(3, 32);
        stacks.printAll();
        stacks.push(3, 33);
        stacks.printAll();
        stacks.push(3, 34);
        stacks.printAll();

        stacks.pop(2);
        stacks.printAll();
        stacks.push(3, 35);
        stacks.printAll();
    }

}
