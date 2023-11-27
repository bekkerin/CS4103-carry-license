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
        { "TEP2", 19, false,   false,false, Status.DENIED },
        { "TEP3", 30, false,   false,false, Status.DENIED },
        { "TEP4", 90, false,   false,false, Status.DENIED },
        { "TEP5", -10, false,   false,false, Status.ERROR },

        { "TBV1", 0, true,   true,true, Status.DENIED },
        { "TBV2", 17, false,   false,false, Status.DENIED },
        { "TBV3", 18, false,   false,false, Status.DENIED },
        { "TBV4", 20,false,   false,false, Status.DENIED },
        { "TBV5", 21, false,   false,false, Status.DENIED },
        { "TBV6", 80, false,   false,false, Status.DENIED },
        { "TBV7", 81, false,   false,false, Status.DENIED },
        { "TBV8", Integer.MAX_VALUE, false,   false,false, Status.DENIED },
        { "TBV9", Integer.MIN_VALUE, false,   false,false, Status.ERROR },
        { "TBV10", -1, false,   false,false, Status.ERROR },

        {"	TDT1	",	15,	true,	true,	false, Status.DENIED	},
        {"	TDT2	",	15,	true,	false,	true,	Status.DENIED	},
        {"	TDT3	",	15,	true,	false,	false,	Status.DENIED	},
        {"	TDT4	",	15,	false,	true,	true,	Status.DENIED	},
        {"	TDT5	",	15,	false,	true,	false,	Status.DENIED	},
        {"	TDT6	",	15,	false,	false,	true,	Status.DENIED	},
        {"	TDT7	",	19,	true,	true,	true,	Status.GRANTED	},
        {"	TDT8	",	19,	true,	true,	false,	Status.GRANTED	},
        {"	TDT9	",	19,	true,	false,	true,	Status.DENIED	},
        {"	TDT10	",	19,	true,	false,	false,	Status.DENIED	},
        {"	TDT11	",	19,	false,	true,	true,	Status.DENIED	},
        {"	TDT12	",	19,	false,	true,	false,	Status.DENIED	},
        {"	TDT13	",	19,	false,	false,	true,	Status.DENIED	},
        {"	TDT14	",	30,	true,	true,	true,	Status.GRANTED	},
        {"	TDT15	",	30,	true,	true,	false,	Status.TEMPORARY	},
        {"	TDT16	",	30,	true,	false,	true,	Status.DENIED	},
        {"	TDT17	",	30,	true,	false,	false,	Status.DENIED	},
        {"	TDT18	",	30,	false,	true,	true,	Status.GRANTED	},
        {"	TDT19	",	30,	false,	true,	false,	Status.TEMPORARY	},
        {"	TDT20	",	30,	false,	false,	true,	Status.DENIED	},
        {"	TDT21	",	90,	true,	true,	true,	Status.DENIED	},
        {"	TDT22	",	90,	true,	true,	false,	Status.DENIED	},
        {"	TDT23	",	90,	true,	false,	true,	Status.DENIED	},
        {"	TDT24	",	90,	true,	false,	false,	Status.DENIED	},
        {"	TDT25	",	90,	false,	true,	true,	Status.DENIED	},
        {"	TDT26	",	90,	false,	true,	false,	Status.DENIED	},
        {"	TDT27	",	90,	false,	false,	true,	Status.DENIED	},
        
        {"	TSC1	",	25,	false,	true,	true,	Status.GRANTED	},

        {"	TBC1	",	25,	true,	true,	true,	Status.GRANTED	},
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



