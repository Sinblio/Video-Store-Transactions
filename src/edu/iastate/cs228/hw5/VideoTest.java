package edu.iastate.cs228.hw5;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.assertTrue; 
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.fail;

public class VideoTest 
{
	public static void main(String[] args)
	{
		Video j = new Video("The Godfather", 3);
		Video k = new Video("The Godfather");
		
		assertTrue(j.getFilm() == k.getFilm());
		assertTrue(j.getNumCopies() == 3);
		assertTrue(k.getNumAvailableCopies() == 1);
		
		k.addNumCopies(2);
		
		assertTrue(k.getNumAvailableCopies() == 3);
		
		try 
		{
			k.rentCopies(2);
		} 
		catch (IllegalArgumentException | AllCopiesRentedOutException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(k.getNumAvailableCopies() == 1);
		assertTrue(k.getNumRentedCopies() ==2);
		
	}
}
