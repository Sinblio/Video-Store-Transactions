package edu.iastate.cs228.hw5;


import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author BenSchroeder
 *
 */

/**
 * 
 * The Transactions class simulates video transactions at a video store. 
 *
 */
public class Transactions 
{
	
	/**
	 * The main method generates a simulation of rental and return activities.  
	 *  
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// 1. Construct a VideoStore object.
		// 2. Simulate transactions as in the example given in Section 4 of the 
		//    the project description. 
		VideoStore store = new VideoStore("videoList1.txt");
		Scanner in = new Scanner(System.in);
		int type = 1;
		
		
		System.out.println("Transactions at a Video Store");
		System.out.println("keys: 1 (rent)\t\t2 (bulk rent)");
		System.out.println("      3 (return)\t4 (bulk return)");
		System.out.println("      5 (summary)\t6 (exit)\n");
		
		
		while(type > 0 && type < 6)
		{
			System.out.print("Transaction: ");
			type = Integer.parseInt(in.nextLine());
			String input; 
			
			switch(type) 
			{
				case 1:
					System.out.print("Film to rent: ");
					
					input = in.nextLine();
					
					try
					{
						store.videoRent(VideoStore.parseFilmName(input), VideoStore.parseNumCopies(input));
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					System.out.println();
					
					break;
				
				case 2:
					System.out.print("Video File (rent): ");
					
					input = in.nextLine();
					
					try 
					{
						store.bulkRent(input);
					}
					catch(Exception e) 
					{
						System.out.println(e.getMessage());
					}
					
					System.out.println();
					
					break;
					
				case 3:
					System.out.print("Film to return: ");
					input = in.nextLine();
					try {
						store.videoReturn(VideoStore.parseFilmName(input), VideoStore.parseNumCopies(input));
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					
					break;
				
				case 4:
					System.out.print("Video File (return): ");
					
					input = in.nextLine();
					
					try
					{
						store.bulkReturn(input);
					}
					catch(Exception e) 
					{
						System.out.println(e.getMessage());
					}
					
					System.out.println();
					break;
				
				case 5:
					System.out.println(store.transactionsSummary());
					
					break;
			}
		}
	}
}
