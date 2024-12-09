package com.infosis.jdbc_prepared_statement__crud_operation.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Leptop implements Serializable {
	

	private int id;
	private String name;
	private String color;
	private double price;
	private LocalDate mfd;
	
// generate the no arg constructor
	public Leptop() {
		super();
		
	}
     
	public Leptop(int id, String name, String color, double price, LocalDate mfd) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.mfd = mfd;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id, mfd, name, price);
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	
    @Override
    public String toString() {
        return "Leptop [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", mfd=" + mfd + "]";
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leptop other = (Leptop) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(mfd, other.mfd)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
    
   
    
	   
	}

	


