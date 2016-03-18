import java.text.DecimalFormat;
import java.io.*;
import java.util.*;

class List
{
	private Person student[];	// stores array elements
	private int capacity;		// actual array capacity
	private int size;			// number of elements in the array
   
	public List(int c)
	{
		capacity = c;
		size = 0;
		student = new Person[capacity];            
	}

	public void getList() throws IOException
	{
		FileReader inFile = new FileReader("./src/students.dat");	
		BufferedReader inStream = new BufferedReader(inFile);	     
		String s1,s2,s3,s4;
		int age, id;
		double gpa;						
		int index = 0;
		while( ((s1 = inStream.readLine()) != null) && 
			   ((s2 = inStream.readLine()) != null) && 
			   ((s3 = inStream.readLine()) != null) &&
			   ((s4 = inStream.readLine()) != null) )	
		{
			String name = s1;
			id = Integer.parseInt(s2);
			age = Integer.parseInt(s3);
			gpa = Double.parseDouble(s4);

			student[index] = new Person(name,id,age,gpa);       
			index++;
		}   
		inStream.close(); 
		size = index;   					
	}
	
	private String spaces(String name)
    {
    	int tab = 24 - name.length();
    	String temp = "";
    	for (int j = 1; j <= tab; j++)
    	    temp += " ";
    	return temp;    
    }
      
	public void display(String listInfo)
	{
		DecimalFormat output = new DecimalFormat("0.000");
		System.out.println("\nDISPLAYING "+ listInfo);
		System.out.println("\nStudent ID#     Student Name            Age         GPA");
		System.out.println("============================================================");
		     
		for (int k = 0; k < size; k++)
			System.out.println(student[k].id + "          "+student[k].name + spaces(student[k].name) + 
				student[k].age + "          " + output.format(student[k].gpa));
	}   
	
	public void pause() 
	{   
		Scanner input = new Scanner(System.in);	 
		String dummy;
		System.out.println("\nPress <Enter> to continue.");						
		dummy = input.nextLine();								
	}

	public void displayStudent(int index)
	{
		
	}   

	private void swap(int x, int y)
	{
		Person temp[] = new Person[1];
		temp[0] = student[x];
		student[x]=student[y];
		student[y] = temp[0];
			
	}  

	public void gpaSort(){
		for (int p = 0; p<size; p++)
			for (int q = 0; q<size-1-p; q++)
				if(student[q].gpa<student[q+1].gpa)
					swap(q,q+1);
			
	}
	

	public void ageSort()
	{

	}
	
	public void idSort()
	{

	}
	
//	public int search(int studentID)
//	{

//	}		
	
	public void delete(int index)
	{
		// Precondition:  "index" stores the index of a student object that exists in the "student" array.
		// Postcondition: The student object at index "index" is removed from the "student" array.
		//                All other objects in the "student" array are unaffected.
		
		

	}	
}    
