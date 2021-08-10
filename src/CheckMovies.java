/**
 * Program to review Chapters 1-4 - CheckMovies.java (Exam 1)
 * @author Kwadwo Ohemeng 
 * @version 1.0
 * Date: October 1, 2020
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class CheckMovies {
	public static void main(String[] args) {
		
	Scanner keyboard =  new Scanner(System.in);
	int operation = 0;
	Movie[] movieList = new Movie[100];
	int count = 0;
	String type = " ";
	String title = " ";
	String rating = " ";
	String rating2 = " ";
	String movieTitle = " ";
	Movie[] desiredTitles = new Movie[100];	
	int days = 0;
	double lateFee = 0;
	
	File file = new File("movies.txt");
	Scanner readFile = null;
	
	try {
		readFile =  new Scanner(file);
		}
	catch (FileNotFoundException e) {
		System.out.println("File not found.");
		System.exit(0);
	}
	
	while (readFile.hasNext()) {
		type = readFile.nextLine();
		title = readFile.nextLine();
		rating = readFile.nextLine();
		if (type.equals("Action")){
		Action a = new Action (title,rating);
		movieList[count++] = a;
		}
		else if (type.equals("Drama")) {
		Drama d = new Drama (title,rating);
		movieList[count++] = d;
		}
		else if (type.equals("Comedy")) {
		Comedy c = new Comedy(title,rating);
		movieList[count++] = c;
		}
		
	}
	readFile.close();
	
	do {
		printMenu();
		try {
		operation = keyboard.nextInt();
		switch(operation) {
			case 1:
				System.out.println("Enter title: ");
				keyboard.nextLine();
				movieTitle = keyboard.nextLine();
				desiredTitles = searchTitle(movieTitle,count,movieList);
				if (desiredTitles != null){
				System.out.println("Movies  found: ");
				System.out.printf("%-10s\t%-38s\t%-10s\n","Type" ,"Title", " Rating");
				for (int i = 0; i < desiredTitles.length ;i++){
					System.out.printf("%-80s\n",desiredTitles[i].toString());
					}
				}
				else
					System.out.println("No Movies found.");
				break;
	
			case 2:
				System.out.println("Enter rating of movies: ");
				keyboard.nextLine();
				rating2 = keyboard.nextLine();
				checkRating(rating2);
				desiredTitles = searchRating(rating2,count,movieList);
				if ( desiredTitles != null){
					System.out.println("Movies  found: ");
					System.out.printf("%-10s\t%-38s\t%-10s\n","Type" ,"Title", " Rating");
					for (int i = 0; i < desiredTitles.length ;i++){
						System.out.printf("%-80s\n",desiredTitles[i].toString());
						}
					}
					else
						System.out.println("No movies found.");
				break;
				
			case 3:
				viewAll(movieList,count);
				break;
				
			case 4:
				System.out.println("Enter title: ");
				keyboard.nextLine();
				movieTitle = keyboard.nextLine();
				desiredTitles = searchTitle(movieTitle,count,movieList);
				if ( desiredTitles != null){
				System.out.println("Enter number of days the movie is late: ");
				days = keyboard.nextInt();
						lateFee = desiredTitles[0].getLateFee(days);
					}
				else 
					System.out.println("Movie title not found.");
				System.out.println("Late fee = $ " + lateFee );
				break;
			case 5:
				break;
			}
		}
		catch (InvalidRatingException e) { // From specific to general so we reorder them
			System.out.println(e.getMessage());
		}
		
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
	} while (operation != 5);
	
	System.out.println("Exiting Program...");

	} // end of main method
	
	
	/** displays the user options in a menu
	no parameters
	no return value
	*/

public static void printMenu () {
	System.out.println("Select Operation: ");
	System.out.println("1: Find a movie");
	System.out.println("2: Find movies with a given rating");
	System.out.println("3: List all movies");
	System.out.println("4: Calculate Late fee");
	System.out.println("5: Exit Program");
	
}

/** performs search on the array of movie titles using a title
* This method is an accessor.
* @param title: desired title.
* @param count: number of movies
* @param movieArray: array of movies.
* 
* @return list: the desired titles.
*/

public static Movie[] searchTitle(String title,int count, Movie[] movieArray) { 
	int newCount = 0;
	Movie[] newTitles = new Movie [count];
	for (int i = 0; i < count; i++){
		if (movieArray[i].getTitle().equals(title)) {
			newTitles[newCount++] = movieArray[i];
		}
	}
	if (newCount != 0) {
	Movie[] list = new Movie [newCount];
	for (int i = 0; i < newCount; i++){
			list[i] = newTitles[i];
		}
	return list;
	}
	else
	return null;
}



/** performs search on the array of movie titles using a rating
* This method is an accessor.
* @param title: desired title.
* @param count: number of movies
* @param movieArray: array of movies.
* 
* @return list: the desired titles.
*/

public static Movie[] searchRating(String rating,int count, Movie[] movieArray) { 
	int newCount = 0;
	Movie[] newTitles = new Movie [count];
	for (int i = 0; i < count; i++){
		if (movieArray[i].getRating().equals(rating)) {
			newTitles[newCount++] = movieArray[i];
		}
	}
	if (newCount != 0) {
	Movie[] list = new Movie [newCount];
	for (int i = 0; i < newCount; i++){
			list[i] = newTitles[i];
		}
	return list;
	}
	else
	return null;
}



/** ensures rating is in a correct format.
* This method is an accessor.
* @param r: rating being checked
* no return value.
*/

public static void checkRating (String Cn) throws InvalidRatingException {
	String CN =  Cn;  //auto-boxing
	if (!CN.matches("(G|PG|R|PG-13)")){
		throw new InvalidRatingException("Invalid Rating. Must be (G|PG|R|PG-13)” if the rating is invalid");
	}
}




/** prints list of titles with their information
* This method is an accessor.
* @param movieList:list of all movies
* no return value.
*/

public static void viewAll(Movie[]list,int count) { 
	System.out.printf("%-10s\t%-38s\t%-10s\n","Type" ,"Title", " Rating");
	for (int i = 0; i < count ;i++){
		System.out.printf("%-80s\n",list[i].toString());
		}
	}


	

	
	
	
	

}// end of class

