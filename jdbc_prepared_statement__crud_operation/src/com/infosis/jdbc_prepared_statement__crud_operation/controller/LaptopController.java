package com.infosis.jdbc_prepared_statement__crud_operation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import com.infosis.jdbc_prepared_statement__crud_operation.dao.Leptopdao;
import com.infosis.jdbc_prepared_statement__crud_operation.entity.Leptop;
import com.infosis.jdbc_prepared_statement__crud_operation.entity.Leptop;
import com.infosis.jdbc_prepared_statement__crud_operation.service.LeptopService;

public class LaptopController {
    public static void main(String[] args) {

    	try 
         (Scanner sc = new Scanner(System.in)) { // Using 'try-with-resources' to automatically close the scanner
            System.out.println("1.INSERT \n2.DELETE \n3.DisplayByFilterPrice \n4.DISPLAYALL \n5.addMultipleData");
            int choice = sc.nextInt(); // Read user input for choice
            
            Leptopdao dao = new Leptopdao();
            LeptopService ser = new LeptopService();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the laptop id:");
                    int id = sc.nextInt();

                    System.out.println("Enter the laptop name:");
                    String name = sc.next(); 

                    System.out.println("Enter the laptop color:");
                    String color = sc.next(); 

                    System.out.println("Enter the price of the laptop:");
                    double price = sc.nextDouble(); 

                    System.out.println("Enter the MFD (manufacture date) in yyyy-MM-dd format:");
                    String mfd = sc.next(); 

                    // Validate the date input
                    LocalDate manufactureDate = null;
                    try {
                        manufactureDate = LocalDate.parse(mfd);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        return; // Exit early if date is invalid
                    }

                    // Create Laptop object and call Service method to save it
                    Leptop leptop = dao.saveLeptopDao(new Leptop(id, name, color, price, manufactureDate));

                    // Check if the laptop was successfully stored
                    String msg = (leptop != null) ? "Success" : "Data not stored"; 
                    System.out.println(msg);
                }
                break;

                case 2: {
                    System.out.println("Enter the laptop id to delete:");
                    int id = sc.nextInt();
                    int result = dao. deleteLeptopByIdDao(id ); // Use Service to handle deletion

                    String msg = result != 0 ? "Deleted successfully" : "Given id is not present";
                    System.out.println(msg);
                }
                break;
                
                case 3:{
                	System.out.println("Enter the leptop price");
                	double price = sc.nextDouble();
                	
                	List <Leptop> leptops = ser.filterLeptopService(price);
                	
                	for(Leptop leptop : leptops) {
                		System.out.println(leptop);  
                	}
                	
                }

                
                 /*
                case 4: {
                    // Display all laptops
                    List<Leptop> laptops = dao.getAllLeptopDao();
                    for (Leptop laptop : laptops) {
                        System.out.println(laptop);
                    }
                }
               
                break;
                */
            //=====================================   
                /*
                case 4 : {
                	//display one leptop
                	System.out.println("Enter the leptop id ot fetch one date: ");
                	int id = sc.nextInt();
                     Leptop leptop = dao.fetchFirsOneDate(id);
                     System.out.println(leptop);
                }
                break;
                */
          //======================================
                case 5: {
                	System.out.println("how many letpops you want to ad...");
                	int size = sc.nextInt();
                	
                	List <Leptop> leptops = new ArrayList<Leptop>();
                	
                	for(int i=1; i<=size; i++) {
                		System.out.println("Enter the "+i+ "leptops");
                		
                		 System.out.println("Enter the laptop id:");
                         int id = sc.nextInt();

                         System.out.println("Enter the laptop name:");
                         String name = sc.next(); 

                         System.out.println("Enter the laptop color:");
                         String color = sc.next(); 

                         System.out.println("Enter the price of the laptop:");
                         double price = sc.nextDouble(); 
                         
                         System.out.println("Enter the manufacturing date");
                         String mfd = sc.next();
                         
                         
                         LocalDate manufactureDate = null;
                         try {
                             manufactureDate = LocalDate.parse(mfd);
                         } catch (DateTimeParseException e) {
                             System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                             return; // Exit early if date is invalid
                         }

                         // Create Laptop object and call Service method to save it
                         Leptop leptop =  (new Leptop(id, name, color, price, manufactureDate));
                         leptops.add(leptop);
                         
                	}
                	List <Leptop> leptops2 = dao.saveMultipleLeptopDao(leptops);
                         
                         
                         
                         
                	
                	
                }
                
                default: {
                    System.out.println("Invalid choice.");
                }
                break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
 
