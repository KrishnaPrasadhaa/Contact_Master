package Main;

import java.util.Scanner;

import Bean.PhoneBook;
import DAO.PhoneDAO;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		 while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add a Contact");
	            System.out.println("2. Search for a Contact");
	            System.out.println("3. Update a Contact");
	            System.out.println("4. Delete a Contact");
	            System.out.println("5. Display All contacts:");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            System.out.println();
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                	System.out.print("Enter Name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter Phone Number: ");
	                    String phoneNumber = scanner.next();
	                    scanner.nextLine();
	                    System.out.print("Enter Email: ");
	                    String email = scanner.nextLine();
	                    System.out.print("Enter Address: ");
	                    String address = scanner.nextLine();
	                    PhoneBook pb=new PhoneBook();
	                    pb.setName(name);
	                    pb.setPhoneNumber(phoneNumber);
	                    pb.setEmail(email);
	                    pb.setAddress(address);
	                    PhoneDAO pd=new PhoneDAO();
	                    int res0=pd.insert(pb);
	                    if(res0==1) {
	                    	System.out.println();
	                    	System.out.println("Contact added Successfully!!!");
	                    	System.out.println("________________________________");
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println("Oops Something Went Wrong!!!");
	                    	System.out.println("________________________________");
	                    }
	                    break;
	                case 2:
	                    System.out.print("Enter Name to search: ");
	                    name = scanner.nextLine();
	                    PhoneDAO pd1=new PhoneDAO();
	                    int res1=pd1.searchContact(name);
	                    if(res1==1) {
	                    	System.out.println();
	                    	System.out.println("Contact Successfully Displayed!!!");
	                    	System.out.println("________________________________");
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println("Contact not found!!!");
	                    	System.out.println("________________________________");
	                    }
	                    break;
	                case 3:
	                    System.out.print("Enter Id to update: ");
	                    int id = scanner.nextInt();
	                    System.out.print("Enter Name to update: ");
	                    scanner.nextLine();
	                    name = scanner.nextLine();
	                    System.out.print("Enter new Phone Number: ");
	                    phoneNumber = scanner.nextLine();
	                    System.out.print("Enter new Email: ");
	                    email = scanner.nextLine();
	                    System.out.print("Enter new Address: ");
	                    address = scanner.nextLine();
	                    PhoneDAO pd2=new PhoneDAO();
	                    int res2=pd2.updateContact(id,name, phoneNumber, email, address);
	                    if(res2>0) {
	                    	System.out.println();
	                    	System.out.println("Contact Updated Successfully!!!");
	                    	System.out.println("________________________________");
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println("Contact not found to update!!!");
	                    	System.out.println("________________________________");
	                    }
	                    break;
	                case 4:
	                    System.out.print("Enter Name to delete: ");
	                    name = scanner.nextLine();
	                    PhoneDAO pd3=new PhoneDAO();
	                    int res3=pd3.deleteContact(name);
	                    if(res3==1) {
	                    	System.out.println();
	                    	System.out.println("Contact Deleted!!!");
	                    	System.out.println("________________________________");
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println("Contact not found to delete!!!");
	                    	System.out.println("________________________________");
	                    }
	                    break;
	                case 5:                  
	                    PhoneDAO pd4=new PhoneDAO();
	                    int res4=pd4.displayContact();
	                    if(res4>0) {
	                    	System.out.println();
	                    	System.out.println("Successfully Displayed Contacts!!!");
	                    	System.out.println("________________________________");
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println("Oops Something Went Wrong!!!");
	                    	System.out.println("________________________________");
	                    }
	                    break;
	                case 6:
	                	System.out.println();
	                    System.out.println("Exiting the Phone Book. Goodbye!!!");
	                    System.out.println("________________________________");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	}

}
