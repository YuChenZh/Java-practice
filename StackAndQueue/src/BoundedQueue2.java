/**
 * Created by yujingchen on 10/25/17.
 */
public class BoundedQueue2<E>
{
    // Overview:  a BoundedQueue2 is a mutable, bounded FIFO data structure
    // of fixed size , with size being fixed at 2.
    // A typical Queue is [], [o1], or [o1, o2], where neither o1 nor o2
    // are ever null.  Older elements are listed before newer ones.

    private final E[] elements;
    private int size, front, back;
    private final int CAPACITY = 2;

    public BoundedQueue2 ()
    {
        elements = (E[]) new Object [CAPACITY];
        size  = 0; front = 0; back  = 0;
    }

    public void enQueue (E o)
            throws NullPointerException, IllegalStateException
    {  // Modifies: this
        // Effects:   If argument is null throw NullPointerException
        // else if this is full, throw IllegalStateException,
        // else make o the newest element of this
        if (o == null)
            throw new NullPointerException ("BoundedQueue2.enQueue");
        else if (size == CAPACITY)
            throw new IllegalStateException ("BoundedQueue2.enQueue");
        else
        {
            size++;
            elements [back] = o;
            back = (back+1) % CAPACITY;
        }
    }

    public E deQueue () throws IllegalStateException
    {  // Modifies: this
        // Effects:   If queue is empty, throw IllegalStateException,
        // else remove and return oldest element of this

        if (size == 0)
            throw new IllegalStateException ("BoundedQueue2.deQueue");
        else
        {
            size--;
            E o = elements [ (front % CAPACITY) ];
            elements [front] = null;
            front = (front+1) % CAPACITY;
            return o;
        }
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }
    public boolean isFull()
    {
        return (size == CAPACITY);
    }

    public String toString()
    {
        String result = "[";
        for (int i = 0; i < size; i++)
        {
            result += elements[ (front + i) % CAPACITY ] . toString();
            if (i < size -1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public static void main(String args[]) {
        BoundedQueue2<String> queue = new BoundedQueue2<String>();
        queue.enQueue("a");
        queue.deQueue();

    }

}
