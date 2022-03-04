package edu.iastate.cs228.hw5;

/**
 * 
 * @author BenSchroeder
 *
 */

public class Video implements Comparable<Video>
{
	private String film;           // film title for the video
	private int numCopies; 
	private int numRentedCopies; 
	
	/**
	 * 
	 * @param film
	 * @param n
	 * @throws IllegalArgumentException if copies <= 0
	 */
	public Video(String film, int n) throws IllegalArgumentException 
	{
		if (n <= 0)
			throw new IllegalArgumentException("Copies <= 0");
		
		this.film = film;
		numCopies = n;
		numRentedCopies = 0;
	}
	
	
	public Video(String film)
	{
		this(film, 1); 
	}

	
	public String getFilm()
	{
		return film; 
	}
	

	public int getNumCopies()
	{
		return numCopies; 
	}

	
	/**
	 * 
	 * @param n
	 * @throws IllegalArgumentException if n <= 0
	 */
	public void addNumCopies(int n) throws IllegalArgumentException
	{
		if (n <= 0)
			throw new IllegalArgumentException("Number of copies added <= 0");
		
		this.numCopies += n;
	}
		
	public int getNumAvailableCopies()
	{
		return numCopies - numRentedCopies; 
	}


	public int getNumRentedCopies()
	{
		return numRentedCopies; 
	}

	
	/**
	 * Updates numRentedCopies.  If n + numRentedCopies > numCopies, sets numRentedCopies 
	 * to numCopies.  (In other words, rent out all the available copies.) 
	 * 
	 * @param n
	 * @throws IllegalArgumentException if n <= 0
	 * @throws AllCopiesRentedOutException if numRentedCopies == numCopies 
	 */
    public void rentCopies(int n) throws IllegalArgumentException, AllCopiesRentedOutException
    {
    	if (n <= 0)
    		throw new IllegalArgumentException("n <= 0");
    	
    	if (this.numRentedCopies == this.numCopies)
    		throw new AllCopiesRentedOutException("numRentedCopies == numCopies");
    	
    	if (n + this.numRentedCopies > this.numCopies)
    		this.numRentedCopies = this.numCopies;
    	else
    		this.numRentedCopies += n;
    }
    
    
    /**
     * Updates numRentedCopies.  If n > numRentedCopies, set numRentedCopies to zero.  
     * 
     * @param n
     * @throws IllegalArgumentException if n <= 0  
     */
    public void returnCopies(int n) throws IllegalArgumentException
    {
    	if (n <= 0)
    		throw new IllegalArgumentException("n <= 0");
    	
    	if (n > this.numRentedCopies)
    		this.numRentedCopies = 0;
    	else
    		this.numRentedCopies -= n;
    }
	

    /**
	 * Compares two videos by name using string comparison.
	 */
	public int compareTo(Video vd)
	{
		int out = this.film.compareTo(vd.film); 
		return out;
	}
	
	
	/**
	 * Write in the format "<film> (<numCopies>:<numRentedCopies>)", where every substring 
	 * in the form of a variable name delimited by a pair of angle brackets is replaced with the 
	 * value of the variable. For example, if a Video object has its private instance variables 
	 * take on the values below: 
	 * 
	 * film == "Forrest Gump" 
	 * numCopies == 2
	 * numRentedCopies == 1 
	 *  
	 * then the method returns the string "Forrest Gump (2:1)". 
	 */
	@Override 
	public String toString()
	{
		String out = film;
		out += " (" + this.numCopies + ":" + this.numRentedCopies + ")";
		return out; 
	}
}
