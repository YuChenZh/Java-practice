import java.util.ArrayList;
import java.util.List;

public class Subclass extends IntSet {
    private List<Integer> sub;

    public Subclass (int i) { sub = new ArrayList<Integer>(i); }

//    private Subclass (List<Integer> list) { sub = list; }

    @Override public Subclass clone() {
        return (Subclass)super.clone();
    }

}
