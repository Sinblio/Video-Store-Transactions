package edu.iastate.cs228.hw5;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.assertTrue; 
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

public class VideoStoreTest 
{
	public static void main(String args[])
	{
		VideoStore j;
		try {
			j = new VideoStore("videoList1.txt");
		} catch (FileNotFoundException e2) 
		{
			j = null;
		}
		
		assertTrue(j.available("The Godfather"));
		
		try 
		{
			j.videoRent("The Godfather", 1);
		} 
		catch (IllegalArgumentException | FilmNotInInventoryException | AllCopiesRentedOutException e) 
		{
			
		}
		
		assertFalse(j.available("The Godfather"));
		
		try {
			j.bulkRent("videolist2.txt");
		} catch (FileNotFoundException | IllegalArgumentException | FilmNotInInventoryException | AllCopiesRentedOutException e1) 
		{
			
		}
		
		try 
		{
			j.videoRent("Brokeback Mountain", 1);
		} 
		catch (IllegalArgumentException | FilmNotInInventoryException | AllCopiesRentedOutException e) 
		{
			
		}
		
		try 
		{
			j.videoReturn("Slumdog Millionaire", 2);
		} catch (IllegalArgumentException | FilmNotInInventoryException e1) 
		{
			
		}
		
		try 
		{
			j.videoRent("The Silence of the Lambs", 1);
		} catch (IllegalArgumentException | FilmNotInInventoryException | AllCopiesRentedOutException e) 
		{
			
		}
		
		try 
		{
			j.videoRent("Singin' in the Rain", 2);
		} catch (IllegalArgumentException | FilmNotInInventoryException | AllCopiesRentedOutException e) 
		{
			
		}
		
		try 
		{
			j.bulkReturn("videoList3.txt");
		} catch (FileNotFoundException | IllegalArgumentException | FilmNotInInventoryException e) 
		{
			
		}
		
		System.out.println(j.transactionsSummary());
		
	}
}
