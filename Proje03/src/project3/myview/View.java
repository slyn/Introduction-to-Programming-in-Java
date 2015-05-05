package project3.myview;

import java.util.InputMismatchException;
import java.util.Scanner;
import project3.mycontroller.Controller;
import project3.myexception.MySmallerThanException;
import project3.mygeneric.MyGeneric;

/**
 * This class is created for user interactivities. It contains diffent methods
 * in order to inform user. (VIEW)
 *
 * @author Hüsnü
 * @version 1.2
 */
public class View {

    /**
     * This method uses for inform the user about calculation results.
     *
     * @param myListInt This Integer list should keep the prime numbers which
     * calculated with Naive Method.(Created with MyGeneric Class)
     * @param timeNaive This double variable should keep execution time for
     * Naive Method.
     * @param myListBoolean This is Boolean list should keep the boolean results
     * for Erasthotenes Method.(Created with MyGeneric Class)
     * @param timeErasthotenes This double variable should keep execution time
     * for Erasthotenes Method.
     */
    public void showResult(MyGeneric<Integer> myListInt, double timeNaive,
            MyGeneric<Boolean> myListBoolean, double timeErasthotenes) {
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
     * @param myList This Integer list should keep the prime numbers which
     * calculated with Naive Method.(Created With MyGeneric Class)
     */
    public void displayNumberNaive(MyGeneric<Integer> myList) {
        for (Integer a : myList) { //Foreach Loop Used
            System.out.print(" " + a + " ");
        }
        System.out.println("\n");
    }

    /**
     * This method uses for displaying Erasthotenes method results
     *
     * @param myList This boolean list should keep the boolean results for
     * Erasthotenes Method.(Created with MyGeneric Class)
     */
    public void displayNumerErasthotenes(MyGeneric<Boolean> myList) {
        int i = 0;
        for (Boolean element : myList) { //Foreach Loop Used
            if (element) {
                System.out.print(" " + (i + 1) + " ");
            }
            i++;
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
     * @throws MySmallerThanException when the number is smaller than 2,
     * @exception InputMismatchException when the user enter the character
     * instead of number.
     * @return the number of boundary value.
     */
    public int takeNumber() throws MySmallerThanException {
        int x; // for keeping boundary value
        System.out.print("Please enter a number : ");
        Scanner sc = new Scanner(System.in);
        try {
            x = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You did't enter a integer number !! \n");
            //System.exit(0); //If the user doesn't enter the acceptable number, Program will be terminated.
            return takeNumber();//If the user doesn't enter the acceptable number, program asks number  again.
        }
        checkNumber(x);
        return x;
    }

    /**
     * This method checks the boundary number. If it is smaller than two, method
     * throws an exception
     *
     * @param x Boundary number
     * @throws MySmallerThanException If number is smaller than two, exception
     * informs user.
     */
    public void checkNumber(int x) throws MySmallerThanException {
        if (x < 2) {
            throw new MySmallerThanException("Number is not exceptable!! \nNumber should be greater than 2");
        }
    }
    /**
     * This method informs user about exception message.
     * 
     * @param message string message of exception
     * @return always return true because it represents 'an error occur'.
     */
    public boolean warnUser(String message){
        System.out.println("Number is not exceptable!! \n" + message);
        return true;
    }
}
