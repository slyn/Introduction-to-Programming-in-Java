package projectjava.mygeneric;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This generic class is created for keeping the results of Erasthotenes Method and Naive Method.
 * 
 * @author Hüsnü
 * @version 1.0
 * @param <B> keeping boolean value
 */
public class MyGeneric <B> implements Iterable<B> { //Iterator<B>,extends Boolean
    List<B> contents;
    /**
     * Costructor - Empty
     */
    public MyGeneric() {
        contents = new LinkedList<>();//
    }
    /**
     * This method is created for adding elements into the Generic List.
     * @param obj the element which should be added.
     */
    public void add(B obj) {
        contents.add(obj);
    }
    /**
     * This method is created for setting the value value of specific index.
     * @param x index number which is wanted to set the value.
     * @param obj new value of specific index
     */
    public void set(int x,B obj){
        contents.set(x, obj);
    }
    /**
     * This method helps to reach the value of specific index.
     * @param index index number which is wanted to know the value.
     * @return it returns the value of specific index.
     */
    public B get(int index){
       return contents.get(index);
    }    

    /**
     * This method is obligatory for Iterable interface. Added for using For-each Loop
     * 
     * @return it returns the iterator of LinkedList
     */
    @Override
    public Iterator<B> iterator() {
        Iterator<B> i = contents.iterator();
        return i;
    }
}
