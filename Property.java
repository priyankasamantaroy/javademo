/*Assignment:2
 * Author:Priyanka Samanta Roy
 * Date:18/05/20
 * Student Id:L00155973
 * This programm will present the Property class along with some functions
 * */

import java.io.*;
public class Property implements Serializable	
{
	
	private static final long serialVersionUID = 1L;//Found a runtime exception in class serialisation.This code will handle the Serial version exception
	//instance variables
	   private int propertyNo;	
	   private static int nextPropertyNo = 100;	//making the propertynumber unique using Static access modifier
	   private String street;
	   private String town;
	   private String county;
	   private String propertyType;
	   private int noBeds;
	   private double price;
	   
	   //Default constructor
	   public Property()
	   {	
		  propertyNo = nextPropertyNo++;	//adding unique propertynumber
	      street = "";
	      town = "";
	      county = "";
	      propertyType = "";
	      noBeds = 0;
	      price = 0.0;
	   }
	   
	   public Property(int propno, String s, String t, String c, String type, int beds, double p) throws IllegalArgumentException{
	   if(beds<0 || p<=0)
	   {
		   throw new IllegalArgumentException ("Account cannot be opened with negative balance");
		   
	   }
	   else
	   {	
		  propertyNo = propno;	//adding unique propertynumber
	      street = s;
	      town = t;
	      county = c;
	      propertyType = type;
	      noBeds = beds;
	      price = p;
	   }
	  }//closing method
	   
	   //Methods
	   public String getStreet()
	   {
	      return street;
	   }
	   
	   public String getTown()
	   {
	      return town;
	   }
	   
	   public String getCounty()
	   {
	      return county;
	   }
	   public String getType()
	   {
		   return propertyType;
	   }
	     
	   public String toString()
	   {
	      return "Property No: "+ propertyNo+ "\tStreet: "+ street+ "\tTown: "+town+ "\tCounty: "+county+
	      "\tType: "+propertyType+ "\tNo Beds: "+noBeds+ "\tPrice: "+price;
	   }
	   
	   public double getPrice()
	   {
		   return price;
	   }
	   
	   public int getPropertyNo()
	   {
		   return propertyNo;
	   }
	
}//class ended
