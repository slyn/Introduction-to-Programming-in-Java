package projectjava.mymodel;

import java.util.ArrayList;

/**
 * This class is created for calculating prime nummbers. It contains two
 * diffrent method for the calculation. One of them is naive method and the
 * other one is sieve of Erasthotenes. (MODEL)
 *
 * @author Hüsnü
 * @version 1.0
 */
public class Model {

    private double timeNaive, timeErasthotenes;
    private double start, finish;

    public double getTimeNaive() {
        return timeNaive;
    }

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
    public ArrayList<Integer> naiveMethod(int x) {
        start = System.nanoTime();
        boolean control;
        ArrayList<Integer> myList = new ArrayList<>();
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
    public boolean[] erasthotenesMethod(int x) {
        start = System.nanoTime();
        boolean myList[] = new boolean[x];
        for (int i = 0; i < x; i++) {
            myList[i] = true;
        }
        myList[0] = false; // it represent  1
        //myList[1] = true; //          --> 2
        //myList[2] = true; //          --> 3
        for (int i = 2; i < x; i++) {
            for (int j = i; j < x; j++) {
                if (myList[j] && (j + 1) % i == 0) {
                    myList[j] = false;
                }
            }
        }
        finish = System.nanoTime();
        timeErasthotenes = (double) (finish - start) / 1000000000; //convert from nanosecond to second 
        return myList;
    }
}
