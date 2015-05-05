package project3.mytests;

import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

import project3.mycontroller.Controller;
import project3.myexception.MySmallerThanException;
import project3.mygeneric.MyGeneric;
import project3.mymodel.Model;

/**
 * This class is created in order to test defined situations. This class has
 * some methods which test these situations : * Test Border Situations * Test
 * Normal Situations * Test Abnormal Situations
 *
 * @author Hüsnü
 * @version 1.0
 */
public class SituationTest {

    // prime numbers 2,3,4,7,11,13,17,19,23,29...
    /**
     * it is necessary for testing the boundary.
     */
    Controller testController;
    /**
     * it is necessary for testing the boundary.
     */
    Controller testController01;

    //Border Situation 
    /**
     * This method is created for testing the boundary situations.(Test Borders
     * for naiveMethod and erasthotenesMethod).
     *
     */
    @Test
    public void testBorder() {
        try {
            testController = new Controller(23);
            testController01 = new Controller(28);
            testController.findPrimeNumbers();
            testController01.findPrimeNumbers();
        } catch (MySmallerThanException e) { //
        }

        //Test border of erasthotenesMethod
        Model testBorder = new Model();
        try {
            MyGeneric<Boolean> result01 = testBorder.erasthotenesMethod(23);
            MyGeneric<Boolean> result02 = testBorder.erasthotenesMethod(28);
            assertTrue("Indexes are not equal !!", Objects.equals(result01.get(22), result02.get(22))); //

            // index-23 keeps data for number 24. "24 is not a prime number - value should be false."( Result01 shouldn't have index for 23)
            assertFalse(result01.get(23));
            //assert false : "Index out of bounds error should be - Unexpected result set";
            fail("Index out of bounds error should be - Unexpected result set"); //
        } catch (IndexOutOfBoundsException e) {
            assert true; //
        }

        //Test border of naiveMethod
        try {
            MyGeneric<Integer> result01 = testBorder.naiveMethod(23);
            MyGeneric<Integer> result02 = testBorder.naiveMethod(28);
            assertEquals("Result sizes are not equal !!", result01.sizeData(), result02.sizeData());
            //assertTrue(result01.get(8)==23);
            assertTrue("Indexes are not equal !!", Objects.equals(result01.get(8), result02.get(8))); //23 == 23

            // index-9 keeps data for number 29. "29 is not in our boundary - Index out of Bounds Exception should be thrown."( Result02 shouldn't have index for 29)
            assertTrue(result02.get(9) == 29);
            //assert false : "Index out of bounds error should be - Unexpected result set";
            fail("Index out of bounds error should be - Unexpected result set"); //
        } catch (IndexOutOfBoundsException e) {
            assert true; //
        }
    }

    /**
     * This method is created for testing the negative boundary input. It tests
     * exceptions situations with negative, 0, and 2 input values.
     *
     */
    @Test
    public void testNegativeBoundary() {
        // Negative boundary
        try {
            testController = new Controller(-23);
            fail("MySmallerThanException exception should be thrown");
        } catch (MySmallerThanException e) {
            assert true;
        }
        // 0
        try {
            testController01 = new Controller(0);
            fail("MySmallerThanException exception should be thrown");
        } catch (MySmallerThanException e) {
            assert true;
        }
        // 2
        try {
            testController = new Controller(2);
            assert true;
        } catch (MySmallerThanException e) {
            fail("MySmallerThanException exception should not be thrown");
        }
    }

    /**
     * This method is created for testing the normal situation. It tests the
     * program activities with all proper values.
     */
    @Test
    public void testNormalSituation() {
        // Testing of boundary
        int index = 19;
        try {
            testController = new Controller(index);
            testController.findPrimeNumbers();
        } catch (MySmallerThanException e) { //
            fail("Here shouldn't be MySmallerthanException !!");
        }
        // Testing of calculation results
        Model testInstance = new Model();
        MyGeneric<Integer> testResultNaive = testInstance.naiveMethod(index);
        MyGeneric<Boolean> testResultErasthotenes = testInstance.erasthotenesMethod(index);

        int primeFounded = 0;
        for (Boolean b : testResultErasthotenes) {
            if (b) {
                primeFounded++;
            }
        }
        assertEquals("Counted prime numbers should be same !!", testResultNaive.sizeData(), primeFounded);
    }

    /**
     * This method is created for testing the abnormal situations like double
     * and string type boundaries. It tests exceptions via different boundary
     * format.
     */
    @Test
    public void testAbormalSituation() {
        // negative and double value
        try {
            testController = new Controller((int) -23.18);
            testController.findPrimeNumbers();
            fail("Here should be MySmallerthanException !!");
        } catch (MySmallerThanException e) { //
            assert true;
        }

        //Convertable string - negative value
        try {
            testController = new Controller("-12");
            testController.findPrimeNumbers();
            fail("Here should be MySmallerthanException !!");
        } catch (MySmallerThanException e) { //
            assert true;
        }

        //Convertable string - double value
        try {
            testController = new Controller("12.5");
            testController.findPrimeNumbers();
        } catch (NumberFormatException e) { //
            fail("Here should be NumberFormatException !!");
        } catch (MySmallerThanException ex) {
            //
        }

        // String value 
        try {
            testController = new Controller("Husnu");
            testController.findPrimeNumbers();
            fail("Here should be NumberFormatException !!");
        } catch (MySmallerThanException e) { //
            assert false;
        } catch (NumberFormatException e) { //
            assert true;
        }
    }
}
