package com.java.employ;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class MainEmploy {
		
		static EmployBAL bal;
		static Scanner sc;
		
		static
		{
			bal=new EmployBAL();
			sc=new Scanner(System.in);
		}
		
		public static void main(String[] args) 
		{
			int choice;
			do
			{
				System.out.println(" O P T I O N S ");
				System.out.println("-----------------");
				System.out.println(" 1. Add Employee ");
				System.out.println(" 2. Show Employee ");
				System.out.println(" 3. Search Employee ");
				System.out.println(" 4. Delete Employ ");
				System.out.println(" 5. Update Employ ");
				System.out.println(" 6. Write Employ ");
				System.out.println(" 7. Read Employ ");
				System.out.println(" 8. Exit");
				System.out.println(" Enter your Choice ");
				choice=sc.nextInt();
			
			switch(choice)
			{
			case 1 : 
				try {
					addEmployMain();
				} catch (EmployException e) {
					
					System.err.println(e.getMessage());
				}
				break;
				
			case 2 :
				showEmployMain();
				break;
				
			case 3 :
				searchEmployMain();
				break;
				
			case 4 :
				deleteEmployMain();
				break;
			case 5 :
				try {
					updateEmployMain();
				} catch (EmployException e) {
					
					e.printStackTrace();
				}
				break;
			case 6 :
				try {
					writeEmployFileMain();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				break;
			case 7:
				
				try {
					readEmployFileMain();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				
			break;
			}
			}while(true);
			
		}
		public static void writeEmployFileMain() throws FileNotFoundException, IOException
		{
			
				System.out.println(bal.writeEmployFilebal());
			
		}
		
		public static void readEmployFileMain() throws ClassNotFoundException, IOException
		{
			System.out.println(bal.readEmployFileBal());
		}
		
		public static void showEmployMain()
		{
			List<Employ> employList= bal.showEmployBal();
			for(Employ employ : employList)
			{
				System.out.println(employ);
			}
			
			
		}
		
		public static void addEmployMain() throws EmployException
		{
			Employ employ=new Employ();
			System.out.println(" Enter employ number ");
			employ.setEmpNo(sc.nextInt());
			System.out.println(" Enter employee name ");
			employ.setName(sc.next());
			System.out.println(" Enter Gender MALE/FEMALE ");
			employ.setGender(Gender.valueOf(sc.next()));
			System.out.println(" Enter Department ");
			employ.setDept(sc.next());
			System.out.println(" Enter Designation ");
			employ.setDesig(sc.next());
			System.out.println(" Enter basic ");
			employ.setBasic(sc.nextDouble());
			System.out.println(bal.addEmployBal(employ));
			
		}
		
		public static void updateEmployMain() throws EmployException
		{
			Employ employ=new Employ();
			System.out.println(" Enter employ number ");
			employ.setEmpNo(sc.nextInt());
			System.out.println(" Enter employee name ");
			employ.setName(sc.next());
			System.out.println(" Enter Gender MALE/FEMALE ");
			employ.setGender(Gender.valueOf(sc.next()));
			System.out.println(" Enter Department ");
			employ.setDept(sc.next());
			System.out.println(" Enter Designation ");
			employ.setDesig(sc.next());
			System.out.println(" Enter basic ");
			employ.setBasic(sc.nextDouble());
			System.out.println(bal.updateEmployBal(employ));
			
		}
		
		public static void searchEmployMain()
		{
			int empno;
			System.out.println(" Enter employee number whose details to be found ");
			 empno=sc.nextInt();
			Employ employfound=bal.searchEmployBal(empno);
			if(employfound!=null)
			{
				System.out.println(employfound);
			}
			else
			{
				System.out.println(" ***** Employ record not found***** ");
			}
					
				
			
		}
		
		public static void deleteEmployMain()
		{
			int empno;
			System.out.println(" Enter employee number whose details to be deleted ");
			 empno=sc.nextInt();
			System.out.println(bal.deleteEmployBal(empno));
		}
			
			
	}



