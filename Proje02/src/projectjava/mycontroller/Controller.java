package projectjava.mycontroller;

import projectjava.exception.MySmallerThanException;
import projectjava.mymodel.Model;
import projectjava.myview.View;

/**
 * This class connects Model and View class. It combines some methods for
 * spesific jobs. (For example, findPrimeNumbers method consists of Naive Method
 * and Erasthotenes Method ) (CONTROLLER)
 *
 * @author Hüsnü
 * @version 1.1
 */
public class Controller {

    private int x; // boundary number
    private View myView = new View();
    private Model myModel = new Model();

    /**
     * Main method of the project.
     *
     * @param args number values which will accepted as boundaries to calculate
     * prime numbers.
     */
    public static void main(String[] args) {

        if (args.length != 0) { //If the program starts with initial arguments
            Controller[] myApp = new Controller[args.length];
            for (int i = 0; i < args.length; i++) {
                boolean err = false; // If program discovers an error, 'err' will be true
                try {
                    myApp[i] = new Controller(Integer.valueOf(args[i]));
                } catch (NumberFormatException e) {
                    System.out.println("You did't enter a integer number !! \n");
                    err = true;
                } catch (MySmallerThanException e) {
                    System.out.println(e.getMessage());
                    err = true;
                }
                if (!err) {//If the program doesn't discover an error
                    myApp[i].findPrimeNumbers();
                    myApp[i].showPrimeNumber();
                }

            }
        } else { //If the program doesn't start with inital arguments
            Controller myApp = null;
            boolean err = false;
            try {
                myApp = new Controller();
            } catch (MySmallerThanException e) {
                System.out.println(e.getMessage());
                err = true;
            }
            if (!err) {
                myApp.findPrimeNumbers();
                myApp.showPrimeNumber();
            }

        }
    }

    /**
     * Constructor - empty
     *
     * @throws MySmallerThanException when users enter smaller number than two
     */
    public Controller() throws MySmallerThanException {
        this.x = myView.takeNumber();
    }

    /**
     * Constructor - with number
     *
     * @param x boundary value for prime number calculation
     * @throws MySmallerThanException when users enter smaller number than two
     */
    public Controller(int x) throws MySmallerThanException {
        if (x >= 2) {
            this.x = x;
        } else {
            throw new MySmallerThanException("Number is not exceptable!! \nNumber should be greater than 2");
        }
    }

    /**
     * This method runs the methods of model_class for calculation.
     */
    public void findPrimeNumbers() {
        myModel.naiveMethod(x);
        myModel.erasthotenesMethod(x);
    }

    /**
     * This method runs the methods of view_class for displaying the prime
     * numbers and execution time.
     */
    public void showPrimeNumber() {
        myView.showResult(myModel.naiveMethod(x), myModel.getTimeNaive(),
                myModel.erasthotenesMethod(x), myModel.getTimeErasthotenes());
    }
}
