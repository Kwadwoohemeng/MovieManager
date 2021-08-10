/**
 * Program to review Chapter 1-4 - Action.java (Exam 1)
 * @author Kwadwo Ohemeng 
 * @version 1.0
 * Date: October 1, 2020
 */

public class Action extends Movie {
	
	/** sets title and rating to " ".
	*/
  
  // Constructors
   public Action() { // default constructor
	   super();
	   
   }
   
   /** sets title and rating of the action movie.
	*/
  
  public Action (String title, String rating) { //  constructor
	  super(title,rating);
  }
  
 
/** calculates late fee for action movies
 * @return defaultLateFee: late fee for action movies.
  	*/
		
	public double getLateFee(int days) {
	double LateFeeRate = 3.00;
	double LateFee = LateFeeRate*days;
	return LateFee;
		}
	
	
	/** printing the action movie information
	 * @return output: action movie information
	  	*/
		
		public String toString() {
			String output = "Action " + "\t\t";
			output += super.toString();
			return output;
		}
	
}// end of class
