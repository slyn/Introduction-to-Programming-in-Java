package project3.mycontroller;

import project3.myexception.MySmallerThanException;
import project3.mymodel.Model;
import project3.myview.View;

/**
 * This class connects Model and View class. It combines some methods for
 * spesific jobs. (For example, findPrimeNumbers method consists of Naive Method
 * and Erasthotenes Method ) (CONTROLLER)
 *
 * @author Hüsnü
 * @version 1.2
 */
public class Controller {

    /**
     * Boundary number
     */
    private int x;
    /**
     * Object of view class for reaching methods of View class.
     */
    private View myView = new View();
    /**
     * Object of model class for reaching methods of Model class.
     */
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
                } catch (NumberFormatException | MySmallerThanException e) {
                    err = myApp[i].myView.warnUser(e.getMessage());
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
        boolean err = false;
        try {
            myView.checkNumber(x);
        } catch (MySmallerThanException e) {
            err = true;
            throw new MySmallerThanException();
        }
        if (!err) {
            this.x = x;
        }
    }

    /**
     * Constructor - with String value
     *
     * @param val boundary value for prime number calculation
     * @throws MySmallerThanException when users enter smaller number than two
     * @throws NumberFormatException when users enter uncovertable string value.
     */
    public Controller(String val) throws MySmallerThanException, NumberFormatException {
        int number = 0;
        boolean err = false;
        try {
            number = (int) Double.parseDouble(val);
        } catch (Exception e) {
            err = true;
            throw new NumberFormatException();
        }
        try {
            myView.checkNumber(number);
        } catch (MySmallerThanException e) {
            err = true;
            throw new MySmallerThanException();
        }
        if (!err) {
            this.x = number;
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
