// Lab18avst.java
// The Student Records Algorithm Program
// This is the student, starting version of the Lab18a lab assignment.

import java.io.*;
import java.util.*;

      	
public class Runner
{
	public static void main(String[] args) throws IOException
	{
		List studentArray = new List(100);
		studentArray.getList();
		studentArray.display("UNSORTED LIST OF STUDENTS");
		studentArray.pause();
		
		studentArray.gpaSort(); 
		studentArray.display("STUDENTS SORTED IN DESCENDING ORDER BY GPA");
		studentArray.pause();
		
		studentArray.ageSort(); 
		studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY AGE");
		studentArray.pause();	
		
		studentArray.idSort();  
		studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY ID#");
		studentArray.pause();	
		
//		int studentID = getID();
//		int index = studentArray.search(studentID);
//		
//		if (index == -1)
//		    System.out.println("There is no student with an ID# of "+studentID+".\n");
//		else
//		{
//			studentArray.displayStudent(index);   // displays the information for the found student
//			studentArray.delete(index);           // remove the same student from the array
//			studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY ID# WITHOUT STUDENT# "+studentID);
//			studentArray.pause();
//		}    
	}
	
	public static int getID()
	{
		Scanner input = new Scanner(System.in);	 
		System.out.print("\nEnter the 6-digit ID of the student.  { 100000 - 999999 }  -->  ");
		return input.nextInt();
	}
}
