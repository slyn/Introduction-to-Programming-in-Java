package projectjava.mymodel;
import projectjava.mygeneric.MyGeneric;

/**
 * This class is created for calculating prime nummbers. It contains two
 * diffrent method for the calculation. One of them is naive method and the
 * other one is sieve of Erasthotenes. (MODEL)
 *
 * @author Hüsnü
 * @version 1.1
 */
public class Model {

    private double timeNaive, timeErasthotenes;
    private double start, finish;
    /**
     * Constructor - Empty
     */
    public Model(){}
    
    /**
     * Encapsulation of the paramater of time value for Naive Method
     * @return time value of Naive Method 
     */
    public double getTimeNaive() {
        return timeNaive;
    }
    /**
     * Encapsulation of the parameter of time value for Erasthotenes Method
     * @return time value of Erasthotenes Method
     */
    public double getTimeErasthotenes() {
        return timeErasthotenes;
    }

    /**
     * This method calculates the prime numbers in naive type.
     *
     * @param x the number of boundary. If method reachs the this number, It
     * stops the calculation.
     * @return arraylist of prime numbers.
     */
    public MyGeneric<Integer> naiveMethod(int x) {//ArrayList<Integer> naiveMethod(int x) {
        start = System.nanoTime();
        boolean control;
        MyGeneric<Integer> myList = new MyGeneric<>();
        for (int i = 2; i <= x; i++) {
            control = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    control = false;
                    break;
                }
            }
            if (control) {
                myList.add(i);
            }
        }
        finish = System.nanoTime();
        timeNaive = (double) (finish - start) / 1000000000; //convert from nanosecond to second 
        return myList;
    }

    /**
     * This method calculates the prime numbers in sieve of Erasthotenes.
     *
     * @param x the number of boundary. If method reachs the this number, It
     * stops the calculation.
     * @return boolean array of prime numbers.
     */
    public MyGeneric<Boolean> erasthotenesMethod(int x) {
        start = System.nanoTime();
        MyGeneric<Boolean> myList = new MyGeneric<>();
        for (int i = 0; i < x; i++) {
            myList.add(Boolean.TRUE);
        }
        myList.set(0,Boolean.FALSE);// it represent  1
        //myList[1] = true; //          --> 2
        //myList[2] = true; //          --> 3
        for (int i = 2; i < x; i++) {
            for (int j = i; j < x; j++) {
                if (myList.get(j) && (j + 1) % i == 0) {
                    myList.set(j, Boolean.FALSE);
                }
            }
        }
        finish = System.nanoTime();
        timeErasthotenes = (double) (finish - start) / 1000000000; //convert from nanosecond to second 
        return myList;
    }
}
