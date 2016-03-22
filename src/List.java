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
		System.out.println("\nStudent Record for ID# "+ student[index].id+ "\n");
		System.out.println("Name: " + student[index].name);
		System.out.println("Age:  " + student[index].age);
		System.out.println("GPA:  " + student[index].gpa);
		
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
		for (int p = 0; p<size; p++)
			for (int q = 0; q<size-1-p; q++)
				if(student[q].age>student[q+1].age)
					swap(q,q+1);
		
	}
	
	public void idSort()
	{
		for (int p = 0; p<size; p++)
			for (int q = 0; q<size-1-p; q++)
				if(student[q].id>student[q+1].id)
					swap(q,q+1);
	}
	
	public int search(int studentID)
	{
		idSort();
		
		boolean found = false;
		int lo = 0;
		int hi = size-1;
		int mid = 0;
		while (lo <= hi && !found)
		{
			mid = (lo + hi) / 2;
			if (student[mid].id == studentID)
				found = true;
			else
			{
				if (studentID > student[mid].id)
					lo = mid + 1;
				else
					hi = mid - 1;
			}
		}
		if (found)
			return mid;
		else
			return -1;

	}		
	
	public void delete(int index)
	{
		for(int k = index; k < size-1; k++){
			student[k] = student[k+1];
		}
		size--;
		// Precondition:  "index" stores the index of a student object that exists in the "student" array.
		// Postcondition: The student object at index "index" is removed from the "student" array.
		//                All other objects in the "student" array are unaffected.
		
		

	}	
}    
