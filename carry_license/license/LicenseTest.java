/*
 * LicenseTest
 */
package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import eost.License;
import eost.License.Status;
import static eost.License.Status.*;

public class LicenseTest {

   // EP test data followed by BVA test data and then by DT test data and then by the BC test data
   private static Object[][] testData1 = new Object[][] {
      //  test  age   military  no_criminal     trained expected
        { "TEP1", 15, true,   true, true, Status.DENIED },

   };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_premium(String id, int age, boolean military,  boolean no_criminal, boolean trained, Status expected)
    {
       assertEquals( License.Decide( age, military,  no_criminal, trained ), expected );
    }

}



