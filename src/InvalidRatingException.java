
/**
 * Program to review Chapter 1-4 - InvalidRatingException.java (Exam 1)
 * @author Kwadwo Ohemeng 
 * @version 1.0
 * Date: October 1, 2020
 */

import java.util.InputMismatchException;
 
public class InvalidRatingException extends Exception {
	/** Default constructor from Exception;
	*/
	public InvalidRatingException() {
		super();
	}
	
	/** Constructor
	*/
	
	public InvalidRatingException(String message) {
		super(message);
	}

}
