package project3.mytests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This class is created for test suite.
 * 
 * @author Hüsnü
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({
    ModelTest.class,
    SituationTest.class})
public class AllTests {
    //
}
