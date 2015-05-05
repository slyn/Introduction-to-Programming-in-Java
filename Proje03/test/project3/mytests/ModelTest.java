package project3.mytests;

import org.junit.Test;
import static org.junit.Assert.*;
import project3.mygeneric.MyGeneric;
import project3.mymodel.Model;

/**
 * Test case of model methods.It tests naiveMethod and erasthotenesMethod.
 *
 * @author Hüsnü
 * @version 1.0
 */
public class ModelTest {

    /**
     * Test of naiveMethod method, of class Model.
     */
    @Test
    public void testNaiveMethod() {
        int x = 18;
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17};//expected values
        int[] resultNumbers = new int[7];       //methods results
        Model testInstance = new Model();
        //
        MyGeneric<Integer> result = testInstance.naiveMethod(x);

        for (int i = 0; i < 7; i++) {
            resultNumbers[i] = result.get(i);
        }

        assertEquals(primeNumbers.length, resultNumbers.length);
        assertEquals("testNaiveMethod ", primeNumbers[6], resultNumbers[6]);
        assertTrue(result.get(0) == 2);
        assertArrayEquals("Collections values ​​in both arrays are not identical!", primeNumbers, resultNumbers);
        //
        MyGeneric<Integer> result01 = testInstance.naiveMethod(17);
        int[] resultNumbers01 = new int[7];
        for (int i = 0; i < 7; i++) {
            resultNumbers01[i] = result01.get(i);
        }
        assertArrayEquals("Collections values ​​in both arrays are not identical!", primeNumbers, resultNumbers01);

    }

    /**
     * Test of erasthotenesMethod method, of class Model.
     */
    @Test
    public void testErasthotenesMethod() {

        Model testInstance = new Model();
        boolean[] expResult = {Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE}; //1,2,3,4,5,6
        boolean[] testResult = new boolean[6];
        MyGeneric<Boolean> result = testInstance.erasthotenesMethod(6);

        for (int i = 0; i < 6; i++) {
            testResult[i] = result.get(i);
        }

        assertTrue(testResult.length == expResult.length);
        assertNotNull(" erasthotenesMethod result shouldn't be null", testInstance.erasthotenesMethod(9));
        assertTrue(testResult[1]); //2
        assertFalse(testResult[3]); //4

    }

}
