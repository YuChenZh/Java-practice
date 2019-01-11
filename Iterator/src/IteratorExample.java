import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class IteratorExample<E> implements Iterator<E> {

    private final ArrayList<E> examples;
    private int index;

    public IteratorExample(ArrayList<E> examples) {
        this.examples = examples;
        index = 0;
    }

    @Override
    public E next() {
        if(hasNext()) {
            return examples.get(index++);
        } else {
            throw new NoSuchElementException("There are no elements size = " + examples.size());
        }
    }

    @Override
    public boolean hasNext() {
        return examples.size() != index;
    }

    @Override
    public void remove() {
        if(index <= 0) {
            throw new IllegalStateException("You can't delete element before first next() method call");
        }
        examples.remove(--index);
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        IteratorExample<String> iter = new IteratorExample(list);
        while (iter.hasNext()) {
//            System.out.println(iter.index);
//            iter.remove();
            String str = iter.next();
            System.out.println(iter.index);
            iter.remove();
            System.out.println(str);
            System.out.println(list);
        }
    }
}