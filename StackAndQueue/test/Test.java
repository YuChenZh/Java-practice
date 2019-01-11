/**
 * Created by yujingchen on 10/31/17.
 */
import java.util.*;

public class Test {
    public static void main(String args[]) {
        String           string = "bat";
        Integer          x = 7;
        Object[]         objects;
        List             rawList;
        List < Object >  objectList;
        List < String >  stringList;

        objects = new String[1];
        objects[0] = string;
        objects[0] = x;

        objects = new Object[1];
        objects[0] = string;
        objects[0] = x;

        stringList = new ArrayList < String >();
        stringList.add(string);

//        objectList = new ArrayList < String >();
//        objectList.add(string);

        objectList = new ArrayList < Object >();
        objectList.add(string) ;
        objectList.add(x);

        rawList = new ArrayList();
        rawList.add(string);
        rawList.add(x);

    }
}
