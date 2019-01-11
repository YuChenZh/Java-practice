/**
 * Created by yujingchen on 9/30/17.
 */

import java.util.*;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            iter.remove();
            System.out.println(str);
            System.out.println(list);
        }
    }
}
