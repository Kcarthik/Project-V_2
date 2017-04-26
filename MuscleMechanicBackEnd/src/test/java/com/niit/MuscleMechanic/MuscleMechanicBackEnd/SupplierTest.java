package com.niit.MuscleMechanic.MuscleMechanicBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MuscleMechanic.DAO.SupplierDAO;
import com.niit.MuscleMechanic.DAO.SupplierDAOimpl;
import com.niit.MuscleMechanic.model.Supplier;

public class SupplierTest {
@Autowired
    static AnnotationConfigApplicationContext context;

@Autowired
	static Supplier supplier;
	
	@Autowired
	static
	SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{    supplier = new Supplier();
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MuscleMechanic");
		context.refresh();
		
		supplierDAO=context.getBean(SupplierDAOimpl.class);
		
		supplier=context.getBean(Supplier.class);
		
	}
	

	@Test
	public void insertTestCase()
	{
		supplier.setId(1);
		supplier.setSupplierAddress("HSBR layout,hebbal");
		supplier.setSupplierName("Muscle mechanic");
		boolean flag=supplierDAO.insert(supplier);
	    assertEquals("",true,flag);
	}
	
	
	@Test
	public void deleteTestCase()
	{
	}
	
	
}
