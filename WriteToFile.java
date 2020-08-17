/*Assignment:2
 * Author:Priyanka Samanta Roy
 * Date:18/05/20
 * Student Id:L00155973
 * Class WriteToFile: This class contains a method to do write operation
 * 
 * addProperty: This method write to file
 * 		Parameter - 
 * 		1. data_path: path of the file where to write
 * 		2. propertylistfrom: Array list for Property class
 * 		Returns - true if successfully writes else false
 * 		Details - 
 * 			first check the path and arraylist parameter. if array list is null or doesn't contain any object
 * 			then create new arraylist.
 * 			get the maximum property id from the array list so we can append new property to the existing properties
 */
import java.io.*;
import java.lang.*; //to handle runtime exception
import java.util.*;

public class WriteToFile 
{	
	boolean status=false; //This variable track wheather the add property is succesfull or not
	   public boolean addProperty(String data_path, ArrayList<Property> propertylistfrom) throws IOException 
	   {
		   try {
			 //declair variables
			   int bedno = 0;
			   double value = 0.0;
			   int max_prop = 100;
			   String st = null;
			   String town = null;
			   String county = null;
			   String proptype = null;			   
			   boolean valid = false;			     
			   ArrayList<Property> propertylist;
			   
			   Scanner keyboardIn = new Scanner (System.in);			   
			   //Create objects to read to file
			   FileOutputStream fos = new FileOutputStream(data_path);
			   ObjectOutputStream os = new ObjectOutputStream(fos); 
			   
			   //Read ArrayList from file	
			   if(propertylistfrom == null) {
				   propertylist = new ArrayList<>();
			   }
			   else {
				   propertylist = propertylistfrom;
			   }
			   
			   //getting max property no
			   for(int i=0; i<propertylist.size();i++)
			    {
				   if(max_prop<propertylist.get(i).getPropertyNo()) {
					   max_prop  =  propertylist.get(i).getPropertyNo();
				   }
			    }
			   
			   //validating Street Name
				while(valid != true) {
					System.out.print("Enter Street name: ");
					st = keyboardIn.nextLine();
					if(st.trim().length() > 0) {
						valid = true;
					}
				}
				valid = false;
				
				//validating town
				while(valid != true) {
					System.out.print("Enter town: ");
					town = keyboardIn.nextLine();
					if(town.trim().length() > 0) {
						valid = true;
					}
				}
				valid = false;
				
				//validating county
				while(valid != true) {
					System.out.print("Enter county name: ");
					county = keyboardIn.nextLine();
					if(county.trim().length() > 0) {
						valid = true;
					}
				}
				valid = false;
				
				//validating property type
				while(valid != true) {
					System.out.print("Enter property type: ");
					proptype = keyboardIn.nextLine();
					if(proptype.trim().length() > 0) {
						valid = true;
					}
				}
				valid = false;
				
				//validating number of bedrooms
				while(valid != true) {
					System.out.print("Enter number of bedrooms between(0 to 20): ");
					bedno = keyboardIn.nextInt();
					if(bedno >= 0 && bedno <= 20)
					{
						valid = true;
					}
				}
				valid = false;
				
				//validating price
				while(valid != true) {
					System.out.print("Enter price for property: ");
					value = keyboardIn.nextDouble();
					if(value > 0) {
						valid = true;
					}
				}
				valid = false;

		        //create new object with attributes add it to the Property ArrayList
		        propertylist.add(new Property(max_prop+1, st, town, county, proptype, bedno, value));
		        os.writeObject(propertylist);
		 	    os.close();
			    fos.close();
			    //keyboardIn.close();
		        System.out.println("Added Successfully!");
		        status=true;
		   }
		   catch(InputMismatchException e) {
				System.out.println("Error! Invalid user input!");
				status=false;
			}
		   finally {
			   return status;
		   }
		}
	   
	
}//close class
					    	 
	    	 
	    	 
	   
		   
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		