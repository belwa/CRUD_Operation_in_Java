package com.infosis.jdbc_prepared_statement__crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infosis.jdbc_prepared_statement__crud_operation.connection.LeptopConnection;
import com.infosis.jdbc_prepared_statement__crud_operation.entity.Leptop;

public class Leptopdao {
    
    Connection connection = LeptopConnection.getLeptopConnection();
    
    private final String INSERTLEPTOPQUERY = "INSERT INTO leptop(id, name, color, price, mfd) VALUES(?,?,?,?,?)";
    private final String DELETELEPTOPQUERY  = "DELETE FROM LEPTOP WHERE ID = ?";
    private final String DISPLAYLEPTOPQUERY =  "SELECT* FROM leptop";
    private final String DISPLAYFETCHQUERY = "SELECT* FROM leptop WHERE ID = ?";
 
    public Leptop saveLeptopDao(Leptop leptop) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERTLEPTOPQUERY);
           
            ps.setInt(1, leptop.getId());
            ps.setString(2, leptop.getName());  // Assuming getName() returns String
            ps.setString(3, leptop.getColor()); // Assuming getColor() returns String
            ps.setDouble(4, leptop.getPrice()); // Assuming getPrice() returns double or float
            ps.setObject(5, leptop.getMfd());   // Assuming getMfd() returns an appropriate object, e.g., Date
            
            int a = ps.executeUpdate();
            return a != 0 ? leptop : null;
            
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
            
        }
        
        }
        
        public  int deleteLeptopByIdDao(int leptopId) {
        	try {
        	 PreparedStatement ps = connection.prepareStatement(DELETELEPTOPQUERY);
        	ps.setInt(1,leptopId);
        	return ps.executeUpdate();
        } catch(SQLException e) {
        	e.printStackTrace();
        	return 0;
        }
    }
        
        public List <Leptop> getAllLeptopDao(){
        	List <Leptop> l1 = new ArrayList<>();
        	
        	try {
        	 PreparedStatement ps = connection.prepareStatement(DISPLAYLEPTOPQUERY);
        	 ResultSet set = ps.executeQuery();
        	 List <Leptop> leptop = new ArrayList <Leptop>();;
        	 while(set.next()) {
        		 int id = set.getInt("id");
        		 String name = set.getString("name");
        		 String color = set.getString("color");
        		 double price = set.getDouble("price");
        		 LocalDate mfd = set.getDate("mfd").toLocalDate();
        		 Leptop l2 = new Leptop(id, name, color, price, mfd);
        		 l1.add(l2);
        		 
        	 }
        	 return l1  ;
        		 
        	 } catch(SQLException e) {
        		 e.printStackTrace();
        		 return null;
        	 }
        	
        	
        	
        
        	
        }

        
        
        public  Leptop fetchFirsOneDate(int leptopId) {
        	try {
        	 PreparedStatement ps = connection.prepareStatement(DISPLAYFETCHQUERY);
        	ps.setInt(1,leptopId);
        	ResultSet set  = ps.executeQuery();
        	set.next();
        	
         		 int id = set.getInt("id");
           		 String name = set.getString("name");
           		 String color = set.getString("color");
           		 double price = set.getDouble("price");
           		 LocalDate mfd = set.getDate("mfd").toLocalDate();
           		 
           		 Leptop leptop = new Leptop(id, name, color, price, mfd);
           		 
           		 return leptop;
           		 
        	} catch(SQLException e) {
        		e.printStackTrace();
        		return null;
        	}
        }
        
       public List <Leptop> saveMultipleLeptopDao(List<Leptop>leptops) {
    	   
    	   try {
			PreparedStatement ps = connection.prepareStatement(INSERTLEPTOPQUERY);
			
             for(Leptop leptop : leptops) {
            ps.setInt(1, leptop.getId());
            ps.setString(2, leptop.getName());  // Assuming getName() returns String
            ps.setString(3, leptop.getColor()); // Assuming getColor() returns String
            ps.setDouble(4, leptop.getPrice()); // Assuming getPrice() returns double or float
            ps.setObject(5, leptop.getMfd());   // Assuming getMfd() returns an appropriate object, e.g., Date
            ps.addBatch();
             }
             
             int a [] = ps.executeBatch();
             System.out.println(a.length+ " no of effected ");
             return leptops;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	   
       }
        
      
     
		
			
		}
        
        
        

        	 
           		 
           	 
       	
       		 
       		 
       	 
     
        
        




