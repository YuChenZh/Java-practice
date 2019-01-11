/**
 * Created by yujingchen on 10/29/17.
 */
public class BoundedQueueBackup<T> {

    protected T rep[];
    protected int front = 0;
    protected int back = -1;
    protected int size = 0;
    protected int count = 0;

    public BoundedQueueBackup(int size) {
        if (size > 0) {
            this.size = size;
            rep = (T[])new Object[size];
            back = size - 1;
        }
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == size);
    }

    public int getCount() {
        return count;
    }

    public void put(T e) {
        if (e != null && !isFull()) {
            back++;
            if (back >= size)
                back = 0;
            rep[back] = e;
            count++;
        }
    }

    public T get() {
        T result = null;
        if (!isEmpty()) {
            result = rep[front];
            rep[front] = null;
            front++;
            if (front >= size)
                front = 0;
            count--;
        }
        return result;
    }

    public boolean repOK() {

        if(size<0) return false;

        return true;
    }

    public static void main(String args[]) {
        BoundedQueueBackup<Integer> queue = new BoundedQueueBackup<Integer>(10);
        for (int i = 0; !queue.isFull(); i++) {
            queue.put(new Integer(i));
            System.out.println("put: " + i);
        }
        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());
        }
    }
}
