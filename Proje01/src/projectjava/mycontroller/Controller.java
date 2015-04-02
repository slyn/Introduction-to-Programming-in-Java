package projectjava.mycontroller;

import projectjava.mymodel.Model;
import projectjava.myview.View;

/**
 * This class connects Model and View class. It combines some methods for
 * spesific jobs. (For example, findPrimeNumbers method consists of Naive Method
 * and Erasthotenes Method ) (CONTROLLER)
 *
 * @author Hüsnü
 * @version 1.0
 */
public class Controller {

    private int x; // boundary number
    private View myView = new View();
    private Model myModel = new Model();

    public static void main(String[] args) {
        Controller[] myApp = null;
        if (args.length != 0) {
            myApp = new Controller[args.length];
            for (int i = 0; i < args.length; i++) {
                myApp[i] = new Controller(Integer.valueOf(args[i]));
                myApp[i].findPrimeNumbers();
                myApp[i].showPrimeNumber();
            }
        } else {
            //For the testing of program
            myApp = new Controller[2];

            myApp[0] = new Controller(16);
            myApp[0].findPrimeNumbers();
            myApp[0].showPrimeNumber();

            myApp[1] = new Controller();
            myApp[1].findPrimeNumbers();
            myApp[1].showPrimeNumber();
        }
    }

    public Controller() {
        this.x = myView.takeNumber();
    }

    public Controller(int x) {
        if (x >= 2) {
            this.x = x;
        } else {
            System.err.println("Number is not exceptable !!");
            System.exit(x);
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
