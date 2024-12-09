package com.infosis.jdbc_prepared_statement__crud_operation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.infosis.jdbc_prepared_statement__crud_operation.dao.Leptopdao;
import com.infosis.jdbc_prepared_statement__crud_operation.entity.Leptop;

public class LeptopService {

Leptopdao dao = new Leptopdao();

     public Leptop saveLaptopService(Leptop leptop) {
     String lName  = leptop.getName();
     double price =  leptop.getPrice();
	
	if( (lName.length() <=5 ) && (price >=30000 && price <=40000)) {
		return dao.saveLeptopDao(leptop);
	} else {
		System.out.println("leptop length should be 5 or less than ");
		return null;
		
	}

}
     
     public List <Leptop> filterLeptopService(double price){
    	 
    	  List<Leptop> leptops = dao.getAllLeptopDao();
    	  
    	  List<Leptop> filters = leptops .stream().
    	  filter(a->a.getPrice() <=price)
    	  .collect(Collectors.toList());
    	 return filters;
     }


     
     

}
