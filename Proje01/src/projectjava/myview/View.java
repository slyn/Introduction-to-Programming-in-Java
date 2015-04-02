package projectjava.myview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is created for user interactivities. It contains diffent methods
 * in order to inform user. (VIEW)
 *
 * @author Hüsnü
 * @version View
 */
public class View {

    /**
     * This method uses for inform the user about calculation results.
     *
     * @param myListInt This arraylist should keep the prime numbers which
     * calculated with Naive Method.
     * @param timeNaive This double variable should keep execution time for
     * Naive Method.
     * @param myListBoolean This boolean array should keep the boolean results
     * for Erasthotenes Method.
     * @param timeErasthotenes This double variable should keep execution time
     * for Erasthotenes Method.
     */
    public void showResult(ArrayList<Integer> myListInt, double timeNaive,
            boolean[] myListBoolean, double timeErasthotenes) {
        System.out.println("##### CALCULATION RESULT #####");
        System.out.println(":: Naive Method :: ");
        displayNumberNaive(myListInt);
        displayTime(timeNaive);
        System.out.println("---------------");
        System.out.println(":: Erasthotenes Method :: ");
        displayNumerErasthotenes(myListBoolean);
        displayTime(timeErasthotenes);
        System.out.println("---------------");
    }

    /**
     * This method uses for displaying naive method results
     *
     * @param myList This arraylist should keep the prime numbers which
     * calculated with Naive Method.
     */
    public void displayNumberNaive(ArrayList<Integer> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(" " + myList.get(i) + " ");
        }
        System.out.println("\n");
    }

    /**
     * This method uses for displaying Erasthotenes method results
     *
     * @param myList This boolean array should keep the boolean results for
     * Erasthotenes Method.
     */
    public void displayNumerErasthotenes(boolean[] myList) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i]) {
                System.out.print(" " + (i + 1) + " ");
            }
        }
        System.out.println("\n");
    }

    /**
     * This method uses for displaying execution times of Naive and Erasthotenes
     * type calculations.
     *
     * @param time variable for execution time
     */
    public void displayTime(double time) {
        System.out.println("Calculation : " + time + " seconds");
    }

    /**
     * This method uses for taking numbers from user. It controls the number and
     * if number is smaller than 2, it informs user.
     *
     * @return the number of boundary value.
     */
    public int takeNumber() {
        int x; // for keeping boundary value
        System.out.print("Please enter a number : ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        if (x < 2) {
            System.err.println("Number is not exceptable !!");
            System.exit(x);
        }
        return x;
    }
}
