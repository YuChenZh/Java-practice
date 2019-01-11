/**
 * Created by yujingchen on 11/21/17.
 */
import java.util.*;

public class Super {
    public Super() {
        overrideMe();
    }

    public void overrideMe () {
    }
}
class Sub extends Super {

    private final Date date;  // filled in by constructor

    public Sub() {
        date = new Date();
    }
    @Override public void overrideMe () {
        System.out.println(date);
    }

    public static void main (String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
