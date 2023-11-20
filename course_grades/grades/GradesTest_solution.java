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
        { "TEP1",         55,         true,       LetterGrade.GRADEF },
        { "TEP2",         65,         false,       LetterGrade.GRADED },
        { "TEP3",         75,         false,       LetterGrade.GRADEC },
        { "TEP4",         85,         false,       LetterGrade.GRADEB },
        { "TEP5",         95,         false,       LetterGrade.GRADEA },
        { "TEP6",         -10,         false,       LetterGrade.ERROR },
        { "TBV1",         0,         true,       LetterGrade.GRADEF },
        { "TBV2",         59,         false,       LetterGrade.GRADEF },
        { "TBV3",         60,         false,       LetterGrade.GRADED },
        { "TBV4",         69,         false,       LetterGrade.GRADED },
        { "TBV5",         70,         false,       LetterGrade.GRADEC },
        { "TBV6",         79,         false,       LetterGrade.GRADEC },
        { "TBV7",         80,         false,       LetterGrade.GRADEB },
        { "TBV8",         89,         false,       LetterGrade.GRADEB },
        { "TBV9",         90,         false,       LetterGrade.GRADEA },
        { "TBV10",        Long.MAX_VALUE,         false,       LetterGrade.GRADEA },
        { "TBV11",        Long.MIN_VALUE ,         false,       LetterGrade.ERROR },
        { "TBV12",         -1,         false,       LetterGrade.ERROR },
        { "TDT1",         55,         true,       LetterGrade.GRADEF },
        { "TDT2",         65,         true,       LetterGrade.GRADEDPLUS },
        { "TDT3",         75,         true,       LetterGrade.GRADECPLUS },
        { "TDT4",         85,         true,       LetterGrade.GRADEBPLUS },
        { "TDT5",         95,         true,       LetterGrade.GRADEAPLUS },
        { "TSC1",         128,         true,       LetterGrade.GRADEAPLUS },
        { "TSC2",         77,         true,       LetterGrade.GRADECPLUS },
        { "TSC3",         666,         true,       LetterGrade.GRADEAPLUS },
        { "TBC1",         62,         true,       LetterGrade.GRADEF },

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



