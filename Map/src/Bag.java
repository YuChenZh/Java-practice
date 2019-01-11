/**
 * Created by yujingchen on 10/11/17.
 */
import java.util.*;
import java.util.Map.Entry;

// See Liskov exercise 7.11
// This version is generified
public class Bag<E> {

    // rep: map each object to the count of that object in this
    // rep-inv:  range of map contains only positive integers
    // Example:  A bag of 2 cats and a dog is map = { cat=2, dog=1 }

    private Map<E, Integer> map;

    public Bag() {
        map = new HashMap<E, Integer>();
    }

    // add 1 occurrence of e to this
    public void insert(E e) {
        if (!(map.containsKey(e))){
            map.put(e,1);
        }
        else {
            Integer i = (Integer) map.get(e) + 1;
            map.put(e,i);
        }
    }

    // remove 1 occurrence of e from this
    public void remove(E e) {
        if ((Integer) map.get(e) == 1){
            map.remove(e);
        }
        else if((Integer) map.get(e) > 1) {
            Integer i = (Integer) map.get(e) - 1;
            map.put(e,i);
        }
    }

    // return true iff e is in this
    public boolean isIn(E e) {
        return map.containsKey(e);
    }

    // return cardinality of this
    public int size() {return map.size();}

    // if this is empty throw ISE
    // else return arbitrary element of this
    public E choose() {
       if(map.isEmpty()) throw new IllegalStateException("Bag.choose");
        // return random key
        Random random = new Random();
        List<E> keys = new ArrayList<>(map.keySet());
        E randomKey = keys.get(random.nextInt(keys.size()) );
        return randomKey;
    }

    // conveniently, the <E,Integer> map is exactly the abstract state
    public String toString() { return map.toString(); }

    public boolean repOK() {
        for (Entry<E, Integer> entry : map.entrySet()) {
            if ((entry.getValue() < 1)) return false;
            if (entry.getKey() == null) return false;

            for (Entry<E, Integer> entry1 : map.entrySet()) {
                if ((entry1.getKey() == entry.getKey()) && (entry1.getValue() != entry.getValue())) return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        // initialization of our map
        Bag<String> list = new Bag<String>();

        // adding elements to our hashmap
        list.insert("cat");
        list.insert("dog");
        System.out.println("map is:" + list);
        list.insert("dog");
        System.out.println("map is:" + list);
        list.remove("cat");
        System.out.println("map is:" + list);
        list.remove("dog");
        System.out.println("map is:" + list);

        System.out.println("element is:" + list.choose());

    }

}
