package eost;

import static eost.License.Decide;
import static eost.License.Status.DENIED;
import static eost.License.Status.ERROR;
import static eost.License.Status.GRANTED;
import static eost.License.Status.TEMPORARY;

import javax.lang.model.util.ElementScanner6;

public class License {

	public static enum Status { GRANTED, DENIED, TEMPORARY, ERROR};

	/**
	 * Determine whether someone gets a license to carry concealed based on several factors.
     * Age: Must be at least 21 years old (or at least 18 years old and a member of the military or honorably discharged veteran). Applicants over 80 years old do not qualify and are denied. Negative ages result in an error.
     * Criminal History: Must not have a felony conviction or be subject to an outstanding felony warrant
     * Training: completed a firearms safety training course. If they have not, they can get a temporary license for 90 days to complete the course.
	 *
	 * @param age integer
     * @param military boolean 
     * @param no_criminal boolean
     * @param trained boolean
	 *
	 * @return
	 * GRANTED - all conditions are met. license is granted for five years
     * DENIED - at least one disqualifying condition. license is denied
     * TEMPORARY - licensed for up to 90 days after which the license is either granted or denied
     * ERROR - for incomplete information or incorrect data
	 */

	public static Status Decide(int age, boolean military,  boolean no_criminal, boolean trained)
	{
		Status rv = DENIED; 

        if (age >= 21 && ( no_criminal  && trained ) )
            rv = GRANTED;
        else if (  no_criminal )
            if (military  && age >= 18)
                rv = GRANTED;
            else if (!trained)
                rv = TEMPORARY;
            else
                rv = DENIED;
        else if (age < 21)
            if (age < 0)
                rv = ERROR;
            else
                rv = DENIED;

		
                
		return rv;
	}

}

// Copyright 2021, Stephen Brown
// MIT License - see license.txt
