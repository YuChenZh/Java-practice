/**
 * Created by yujingchen on 12/5/17.
 */
import com.sun.beans.editors.DoubleEditor;

import java.util.*;

/*public class Coins {
    public static final int PENNY = 1;
    public static final int NICKLE = 5;
    public static final int DIME = 10;
    public static final int QUARTER = 25;

    public static void main(String[] args) {
        Integer a=new Integer(10);
        a.toString();
        String nickle=new Integer(NICKLE).toString();
        System.out.print(nickle);
    }

}
*/



public class Coins {


    enum Coin {

        A(5),
        B(4),
        C(3),
        D(2);

        int value;
        Coin(int a)
        {
            this.value = a;
        }

    }
    enum Suit { SPADE, DIAMOND, CLUB, HEART}
    public static void main(String[] args) {
        Integer a=new Integer(10);
        a.toString();
        Coin B=Coin.B;
        int b=B.value;

        for (Coin c : Coin.values())

            System.out.println(c.toString()+":"+c.value);

        System.out.println("b="+b);
        System.out.println(B.toString());
        System.out.println(Suit.CLUB);
    }
}