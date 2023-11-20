/*
 * GradesTest - ep
 */
package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import eost.Grades;
import eost.Grades.LetterGrade;
import eost.Grades.LetterGrade;
import static eost.Grades.LetterGrade.*;

public class GradesTest {

   // EP test data followed by BVA test data and then by DT test data and then by the BC test data
   private static Object[][] testData1 = new Object[][] {
      //  test,         points,     perfect,     expected
        { "test name",         55,         true,       LetterGrade.GRADEF },


   };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_premium( String id, long points, boolean perfect, LetterGrade expected)
    {
       assertEquals( Grades.calculate( points, perfect ), expected );
    }

}



