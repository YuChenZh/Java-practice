/**
 * Created by yujingchen on 10/29/17.
 */

public class LinkedListQueue<T> {
    private class QueueNode<T> {
        private T value;
        private QueueNode<T> next;
        private QueueNode(T e, QueueNode<T> n)
        { value = e; next = n; }
    }
    private QueueNode<T> head, tail;
    private int count=0;
    private int size=0;

    public LinkedListQueue(int size) {
        if(size == 0){
            head = tail = (QueueNode<T>) null;}
        }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean isFull() {
        return (count == size);
    }

    public int getCount() {
        return count;
    }

//    public T element() {
//        if (isEmpty()) size=0;
//        return head.value;
//    }

    public void put(T e) {
        QueueNode<T> newNode = new QueueNode<T>(e, null);
        if (isEmpty())
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        ++size;
    }

    public T get() {
        T result = head.value;
        if (!(isEmpty())) {
            result = head.value;
            head = head.next;
            if (head == null)
                tail = null;
            --size;
        }
        return result;
    }

    public static void main(String args[]) {
        BoundedQueue<Integer> queue = new BoundedQueue<Integer>(10);
        for (int i = 0; !queue.isFull(); i++) {
            queue.put(new Integer(i));
            System.out.println("put: " + i);
        }
        System.out.println("count: " + queue.getCount());
        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());
        }
    }
}
