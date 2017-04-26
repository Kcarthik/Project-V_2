package com.niit.MuscleMechanic.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.MuscleMechanic.DAO.ProductDAO;
import com.niit.MuscleMechanic.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO prodDao;

	public ProductController() {
		System.out.println("Instantiating ProductController");

	}

	@RequestMapping("/admin/product/showProduct")

	public String showProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";

	}

	@RequestMapping("/admin/product/addProduct")

	public String addProduct(@ModelAttribute(value = "product") Product prod) {
		prodDao.insert(prod);
		return "addProduct";
	}
	
	@RequestMapping("/all/product/getAllProduct")
	public String displayAllProducts(Model model)
	{
		List<Product> prod=prodDao.retrieve();
		model.addAttribute("productlist", prod);
		return "productlist";
	}
	
	@RequestMapping("/admin/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id)
	
	{
		prodDao.delete(id);
		return "redirect:/all/product/getAllProduct";
	}
	
	@RequestMapping("/admin/product/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model)
	
	{
		Product p=prodDao.getProductData(id);
		model.addAttribute("product", p);
		return "viewProduct";
	}

	@RequestMapping(value = "InsertProduct", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product, Model m,@RequestParam("pimage") MultipartFile filedet,BindingResult result) 
	{
		
		String path = "C:\\DT-Batch13\\MyFashion\\src\\main\\webapp\\resources\\images\\";
		path = path + String.valueOf(product.getId()) + ".jpg";
		File f = new File(path);

		
		if (!filedet.isEmpty()) 
		{
			try 
			{
				byte[] bytes = filedet.getBytes();
				System.out.println(bytes.length);
				FileOutputStream fos = new FileOutputStream(f);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(bytes);
				bs.close();
				System.out.println("File Uploaded Successfully");

			} catch (Exception e) 
			{
				System.out.println("Exception Arised:" + e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
		}
		 
		

		
		return "Product";
	}
}


