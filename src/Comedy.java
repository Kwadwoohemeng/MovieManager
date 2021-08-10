/**
 * Program to review Chapter 1-4 - Comedy.java (Exam 1)
 * @author Kwadwo Ohemeng 
 * @version 1.0
 * Date: October 1, 2020
 */

public class Comedy extends Movie {
	
	/** sets title and rating to " ".
	*/
  
  // Constructors
   public Comedy() { // default constructor
	   super();
	   
   }
   
   /** sets title and rating of the comedy movies.
	*/
  
  public Comedy(String title, String rating) { //  constructor
	  super(title,rating);
  }
  
 
/** calculates late fee for comedy movies
 * @return defaultLateFee: late fee for comedy movies.
  	*/
		
	public double getLateFee(int days) {
	double LateFeeRate = 2.00;
	double LateFee = LateFeeRate*days;
	return LateFee;
		}
	
	
	/** printing the comedy movie information
	 * @return output: comedy movie information
	  	*/
		
		public String toString() {
			String output = "Comedy" + "\t\t";
			output += super.toString(); 
			return output;
		}
	
}// end of class
