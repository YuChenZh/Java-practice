/*
@author: Yujing Chen

*/
import java.util.*;

public class BoundedQueue<T> {

    List<T> q;
    protected int size = 0;

    public BoundedQueue(int size) {
            this.q = new ArrayList<T>(size);
            this.size = size;
    }

    public boolean isEmpty() {
        return this.q.isEmpty();
    }

    public boolean isFull() {
        return (this.q.size() == size);
    }

    public int getCount() {
        return this.q.size();
    }

    public void put(T k){
        if (q != null && !isFull()) {
            this.q.add(0, k);
        }
    }

    public T get(){
        T a = null;
        if (!q.isEmpty()) {
            a = this.q.get(q.size() - 1);
            this.q.remove(q.size() - 1);
        }
        return a;
    }

    // Effects: return true is the rep invariant holds for this; otherwise false
    public boolean repOK() {
        if (q == null || !q.isEmpty())
            return false;
        return true;
    }

    public void putAll( Iterable<? extends T> src) {

        for (T e : src) { put(e); }
    }

    // method 1
    public List getAll() {
        ArrayList result = new ArrayList();
        while (!isEmpty()) {
            result.add(get());
        }
        return result;
    }

//    // method 2
//    public void getAll(Collection<? super T> dst) {
//        while (!isEmpty()) {
//            dst.add(get());
//        }
//        System.out.print(dst);
//    }

    public String toString()
    {
        return q.toString();
    }

    public static void main(String args[]) {
        BoundedQueue<Integer> queue = new BoundedQueue<Integer>(10);

        for (int i = 0; !queue.isFull(); i++) {
            queue.put(new Integer(i));
            System.out.println("put: " + i);
        }
        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());

        }
        ArrayList names = new ArrayList();
        names.add(1);
        names.add(2);
        names.add(3);
        names.add(4);
        queue.putAll(names);

        // method 1
        System.out.println("getAll: " + queue.getAll());

//        // method 2
//        ArrayList names2 = new ArrayList();
//        queue.getAll(names2);


    }
}