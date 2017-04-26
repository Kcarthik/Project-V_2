package com.niit.MuscleMechanic.MuscleMechanicBackEnd;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MuscleMechanic.DAO.CartDAO;
import com.niit.MuscleMechanic.DAO.CartItemDAO;
import com.niit.MuscleMechanic.DAO.CategoryDAO;
import com.niit.MuscleMechanic.DAO.ProductDAO;
import com.niit.MuscleMechanic.model.Cart;
import com.niit.MuscleMechanic.model.CartItem;
import com.niit.MuscleMechanic.model.Category;
import com.niit.MuscleMechanic.model.Product;


public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.MuscleMechanic");
		context.refresh();
		
		
		
//CartItem cartItem=new CartItem();
//		
//		cartItem.setId(1);
//		cartItem.setQuantity(90);
//		cartItem.setTotalPrice(9000);
//		CartItemDAO cartItemDAO=(CartItemDAO) context.getBean("cartItemDAO");
//		cartItemDAO.addCartItem(cartItem);
//		
		
		/*List<Product> products= productDAO.retrieve();
		System.out.println(products);*/
		
		/*Supplier supplier=new Supplier();
		
		supplier.setId(3);
		supplier.setSupplierName("Mark");
		supplier.setSupplierAddress("12,6th cross, langford road ");
		
		SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplierDAO.insert(supplier);
		
		List<Supplier> suppliers=supplierDAO.getAllSuppliers();
		System.out.println(suppliers);
		
		supplierDAO.delete(2);*/
		
	}

}
