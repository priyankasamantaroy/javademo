/*Assignment:2
 * Author:Priyanka Samanta Roy
 * Date:18/05/20
 * Student Id:L00155973
 * 
 * Class ManageProperty: This class will handle all the user operations.
 * main method: This method will first try wheather the file exist or not.
 * 				If the file exist will give the user several options to execute
 * 				else will ask user to add property first then will give others otions to execute.
 * Error and exception handle:
	 * 	If user put any value other than int the program will show 
	 	"message Error! Please enter integer value from the option !!!!!!" and "Exited Successfully!"
	 * 	This programme has set a max bedroom number if it exceeds the programm willa ask again to put values.
	 * 	This programme will not accept any negative value for price, will ask user to put value till the user put positive value.
	 * 	User has to put numeric values in numeric fields(bedroom and price) 
	 	else programm will show error and will repeat the loop again.								
 */
import java.io.*;
import java.util.*;
public class ManageProperty {
   
   public static void main(String args[]) throws IOException, ClassNotFoundException {
	   //declair variables
	   int propertyno;
	   int number = 0;
	   double value;
	   String town = null;
	   String proptype = null;
	   boolean notfind;
	   boolean valid=false;
	   boolean status=false;
	   Scanner keyboardIn = new Scanner (System.in);
	   
	   //declair objects
	   String data_path = "PropertyFile.txt";
	   FileInputStream fis = null;
	   ObjectInputStream ois = null;
	   WriteToFile mc = new WriteToFile();
	   ArrayList<Property> propertylist = null;
	   
	   try {
		   //Create objects to read from file
		   fis = new FileInputStream(data_path);
		   ois = new ObjectInputStream(fis);
		   //Read ArrayList from file	
		   propertylist = (ArrayList<Property>) ois.readObject();
	   }
	   catch(Exception e) {
		   while(status!=true) {
			   System.out.println("No data file available or No Properties available in the data file. Please add property first");
			   status = mc.addProperty(data_path, propertylist);
			   if(status) {
				 //Create objects to read from file
				   fis = new FileInputStream(data_path);
				   ois = new ObjectInputStream(fis);
				   //Read ArrayList from file	
				   propertylist = (ArrayList<Property>) ois.readObject();
			   }
		   }
		   
	   }
	   finally {
		   do {
			    //display menu
				System.out.println("\n1. Add a Property to File:");
				System.out.println("2. View all Properties on File and display total number:");
				System.out.println("3. View Properties by Town:");
				System.out.println("4. View Properties by Type:");	
				System.out.println("5. View Properties within a Maximum price:");
				System.out.println("0. to Exit:");
				//asking for user input
				System.out.println("Please enter an option from above (0 to 5):");
				try {
					number = keyboardIn.nextInt();				
				}
				catch(InputMismatchException e) {
					System.out.println("Error! Please enter integer value from the option !!!!!!");
					System.out.println("Exiting program. Please run again.");
					number=0;
				}
				valid=false;
				//apply swtch condition
				switch(number)
				{	
					//appllying condition or case
					case 1:	//add a property by calling the addproperty method from WriteToFile class
					System.out.println("1.	Add a Property to File:");
					mc.addProperty(data_path, propertylist);
					break;	
					
					case 2:	//View all Properties on File and display total number
						propertyno = 0;
						System.out.println("Details of the property can be seen here:");
						System.out.println("---------------------------------------------------");
					    for(int i=0; i<propertylist.size();i++)
					    {
						   System.out.println(propertylist.get(i).toString());
						   propertyno++;
					    }
					    System.out.println("---------------------------------------------------");
					    System.out.println("Total " + propertyno + " number of properties found.");
					break;
					
					case 3:	//View Properties by Town
						try
						{
							notfind = true;
							propertyno = 0;
							System.out.println("Enter town name to view properties:");							
							town = keyboardIn.next();
							for(int i=0; i<propertylist.size();i++)
							{	
								//converting all the cases to lower so that user can put any values while searching
								if(town.toLowerCase().equals(propertylist.get(i).getTown().toLowerCase()))
								{
									System.out.println(propertylist.get(i).toString());
									notfind=false;
									propertyno++;
								}
							}
							if(notfind)
							{
								System.out.println("---------------------------------------------------");   
								System.out.println("No town found with name "+town);
							}
							else {
								System.out.println("---------------------------------------------------");
							    System.out.println("Total " + propertyno + " number of properties found.");
							}
						}//closeing try block
					    catch (InputMismatchException ex)
					    {
					    	System.out.println("Exception: You must enter String Value!");
					    }
					break;
					
					case 4:	//View Properties by Type
						try {
							notfind = true;
							propertyno = 0;
							System.out.println("Enter property type to view properties:");
							proptype = keyboardIn.next();
							for(int j=0; j<propertylist.size();j++)
							  {	
								   if(proptype.toLowerCase().equals(propertylist.get(j).getType().toLowerCase()))
								   {
									   System.out.println(propertylist.get(j).toString());
									   notfind=false;
									   propertyno++;
								   }
							  }
							if(notfind)
							   {
								System.out.println("---------------------------------------------------");   
								System.out.println("No property type found with name "+proptype);
							   }
							else {
								System.out.println("---------------------------------------------------");
							    System.out.println("Total " + propertyno + " number of properties found.");
							}
						}
						catch (InputMismatchException ex)
					    {
					    	System.out.println("Exception: You must enter String Value!");
					    }
					break;
					
					case 5:	//view within price thet set maximum by user
						try {
							notfind = true;
							propertyno = 0;
							System.out.println("Enter Maximum price to view property within:");
							value = keyboardIn.nextDouble();
							for(int k=0; k<propertylist.size();k++)
							{
								if(propertylist.get(k).getPrice()<=value)
								{
									System.out.println(propertylist.get(k));
									notfind=false;
									propertyno++;
								}
							}
							if(notfind)
							   {
								   System.out.println("---------------------------------------------------");
								   System.out.println("No property found within the price "+value);
							   }
							else {
								System.out.println("---------------------------------------------------");
							    System.out.println("Total " + propertyno + " number of properties found.");
							}
						}
						finally
					    {
					    	System.out.println("Exception: You must enter Double Value!");
					    }
					break;
					
					case 0: 
					System.out.println("Exited Successfully!");
					break;			
				
					default:
					System.out.println("You have entered a wrong option. Please Try again.");
				}//closing switch case
				
		     } while (number!=0);
	   }
	   keyboardIn.close();
	   ois.close();
	   fis.close();	
   }
}
