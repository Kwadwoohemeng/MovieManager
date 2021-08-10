/**
 * Program to review Chapter 1-4 - Drama.java (Exam 1)
 * @author Kwadwo Ohemeng 
 * @version 1.0
 * Date: October 1, 2020
 */

public class Drama extends Movie {
	
	/** sets title and rating to " ".
	*/
  
  // Constructors
   public Drama() { // default constructor
	   super();
	   
   }
   
   /** sets title and rating of the drama movie.
	*/
  
  public Drama(String title, String rating) { //  constructor
	  super(title,rating);
  }
  
 
/** calculates late fee for drama movies
 * @return defaultLateFee: late fee for action movies.
  	*/
		
	public double getLateFee(int days) {
	double LateFeeRate = 2.50;
	double LateFee = LateFeeRate*days;
	return LateFee;
		}
	
	
	/** printing the drama movie information
	 * @return output: drama movie information
	  	*/
		
		public String toString() {
			String output = "Drama " + " \t\t";
			output += super.toString();
			return output;
		}
	
}// end of class
