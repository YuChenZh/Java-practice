/*
@author: Yujing Chen
*/

import java.util.List;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

interface Searchable<E>
{
    public E getElementAt(int index);
    public int getElementCount();
}

class NotFoundException extends Exception
{
    public NotFoundException(String exception )
    {
        super();
        System.out.println(exception);
    }
}

/* 8.8 */
interface Indexer<E> extends Searchable<E>
{
    public E getElementAt(int index);
    public int getElementCount();
}

class ListIndexer<E> extends LinkedList<E> implements Indexer<E>
{
    public E getElementAt(int index)
    {
        return super.get(index);
    }
    public int getElementCount()
    {
        return super.size();
    }
}

public class TestSearch
{
    public static <E> int search (Indexer<E> c, E x) throws NullPointerException, NotFoundException, ClassCastException
    {
        if(c==null)throw new NullPointerException("Null Pointer Exception");
        if(!(c instanceof Searchable))throw new ClassCastException("Class Cast Exception");
        for(int i=0; i<c.getElementCount(); i++)
        {
            E e=c.getElementAt(i);
            if(!(e instanceof Comparable))throw new ClassCastException("Class Cast Exception");
            if(e.equals(x))return i;
        }
        throw new NotFoundException("Not Found Exception");
    }
}

/* 8.9 */

//interface ListIndexer<E> extends List<E>
//{
//    public E get(int index);
//    public int size();
//}

class TestSearch1
{
    public static <E> int search (ListIndexer<E> c, E x) throws NullPointerException, NotFoundException, ClassCastException
    {
        if(c==null||x==null)throw new NullPointerException("Null Pointer Exception");
        for(int i=0; i<c.size(); i++)
        {
            E e=c.get(i);
            if(e==null)throw new NullPointerException("Null Pointer Exception");
            if(!(e instanceof Comparable))throw new ClassCastException("Class Cast Exception");
            if(e.equals(x))return i;
        }
        throw new NotFoundException("Not Found Exception");
    }
}