package space;
import java.io.*;
import java.util.*;


public class space {

	
	
	String space3000(String name,String destination1, String destination2)
	{
		
	   
		  Boolean flag = false; 
		  
		  
		  ArrayList<String> list1 = new ArrayList<String>();
		  ArrayList<String> list2 = new ArrayList<String>();
		  
		  
		 
		 String read="";
		 
		  
	       File fname  = new File(name);
		 try
		 {
		  Scanner spacefile = new Scanner(fname); 
		 
		   while (spacefile.hasNextLine())
		   {
			    
			    
			    String line = spacefile.nextLine();
			   
			   for (int counter =0; counter<line.length();counter++)    /*/ copy the contents of the file to collection list1 
			                                                             and list2 i.e each columns */
			   {
				   if( line.charAt(counter)!=',') 
				   {
		              	read = read + String.valueOf(line.charAt(counter)); // read until end of comma i.e first column
		              	
		              	
		              	
		              	
		              	if(counter + 1 ==line.length()) // read  from comma until end of line i.e second column to list2 
		              	{
		              		list2.add(read); 
		              		
		              		read="";
		              	}
				   }
			   
				   else
					   
				   {
					    
					   list1.add(read);  // copy string before comma column one to list1
					    read="";
					     
					     
				   }
			 
			   } //end of for loop
			   
			   
		} // end of while loop
			 
			   
		         
		
		   
		  spacefile.close();  // close File Scanner
		 } // end of try
		 
		 catch(IOException ex)  // exception if given file is not found
		 {
			 System.out.println(" Exception the following  file is not found --> \t" +name);
		 }
		 
		 
		  for (int counter3 = 0 ;counter3<list1.size();counter3++)  // check if the Destinations are available in the list
		  {
			  if (destination1.equals( list1.get(counter3) )|| destination2.equals(list2.get(counter3)))
			     
			      flag = true;
		
			  else if (destination2.equals( list1.get(counter3) )|| destination1.equals(list2.get(counter3)))
		        
                   flag = true;		  
		  
		  }
			  
		 if (flag == true)
		     return(" yes ");
		 else
		    return ("no");
	}
	
	
	
	
	 public  static void main(String args[])
	 {
	     String name ,destination1 ,destination2;    

	     Scanner sc = new Scanner(System.in);
	     
	     System.out.println("Enter the file name"); // The file name is collected from user
	     
	     name = sc.nextLine(); 
	     
	     System.out.println("Enter the Desinations");	 
	     
	       
	      destination1 = sc.nextLine();
	      destination2 = sc.nextLine();
	      
	      sc.close();
	      space obj = new space();  
	     
	      System.out.println(obj.space3000(name,destination1,destination2));
	 
	 }


}

