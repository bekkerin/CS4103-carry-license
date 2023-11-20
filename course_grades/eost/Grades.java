package eost;

import static eost.Grades.LetterGrade.*;

import javax.lang.model.util.ElementScanner6;

public class Grades {

	public static enum LetterGrade { GRADEA, GRADEAPLUS,GRADEB,GRADEBPLUS,GRADEC, GRADECPLUS,GRADED, GRADEDPLUS, GRADEF , ERROR};

	/**
	 * Determine the letter grade in the class based on points and perfect attendance
	 * we use the regular ranges: F less than 60, D less than 70, C less than 80, B less than 90, A up to 100.
	 * perfect attendance adds a plus to the letter grade except for F
	 * points less than 0 is an error
	 *
	 * @param points How many points the student has scored
	 * @param perfect Whether the student has perfect attendance
	 *
	 * @return
	 * A - at least 90 points
	 * B - at least 80 points
	 * C - at least 70 points
	 * D - at least 60 points
	 * F - zero up to 60 points
	 * PLUS added for perfect attendance
	 * ERROR - points less than 0
	 */

	public static LetterGrade calculate(long points, boolean perfect)
	{
		LetterGrade rv ;

		if (points == 128)
			rv = GRADEAPLUS; // weird value

		if (points >= 90 && points <1000) // programmer felt that 1,000 points was high enough
			if (perfect)
				rv = GRADEAPLUS;
			else 
				rv = GRADEA;
		else if (points >= 80 )
			if (perfect)
				rv = GRADEBPLUS;
			else 
				rv = GRADEB;
		else if (points >= 70 )
			if (perfect)
				rv = GRADECPLUS;
			else 
				rv = GRADEC;
		else if ( points >= 60 && points != 62)//  creates branch uncovered 
			if (perfect)
				rv = GRADEDPLUS;
			else 
				rv = GRADED;
		else 
			if (points <= 0 ) // should be < so expect an error on BV
				rv = ERROR;

			else 
				rv = GRADEF;

		if (points == 77)
			rv = GRADEA; // lucky sevens

		if (points == 666)
			rv = ERROR; // sign of the evil one
		return rv;
	}

}

// Copyright 2021, Stephen Brown
// MIT License - see license.txt
