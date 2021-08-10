/**
 * Program to review Chapter 1-4 - Movie.java (Exam 1)
 * @author Kwadwo Ohemeng 
 * @version 1.0
 * Date: October 1, 2020
 */

public class Movie {
	private String title;
	private String rating;
	
	
	/** sets title and rating to " ".
	*/
  
  // Constructors
   public Movie() { // default constructor
	   title = rating  =  " " ;  
	   
   }
   
   /** sets title and rating of the movie.
	*/
  
  public Movie (String title, String rating) { //  constructor
	   this.title = title ; this.rating = rating ;
  }
  
 // member methods
  
  
  /** gets title of the movie 
 	 * @return title: title of the movie 
 	 */
 	
 	public String getTitle(){ 
 		return title;
 		}
 	
  
	 /** gets rating of the movie 
	 * @return rating: rating of the movie
	 */
	public String getRating(){
	    return rating;
	  }
	
	
	
	 /** sets title of the movie 
	 * @param title: title of the movie
	 */
	
	public void setTitle(String title){ 
		 this.title = title;
		}
	
	/** sets rating of the movie 
    * @param rating: rating of the movie
  	*/
	
	public void setRating(String rating){
	this.rating = rating; 
		}

	
		
	/** printing the movie information
	 * @return output: movie information
	  	*/
		
		public String toString(){
			String output; 
			output = String.format("%-38s\t%-18s\n",title, rating);
			return output;
		}
		
	/** calculates late fee for movies
	 * @return defaultLateFee: late fee for movies.
	  	*/
			
		public double getLateFee(int days) {
		double LateFeeRate = 2.00;
		double LateFee = LateFeeRate*days;
		return LateFee;
			}
	


}// end of class
