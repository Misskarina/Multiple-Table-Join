package com.karina.multiple_tables;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	@Autowired
	CustomerRepository crepo;
	
	
	@RequestMapping("/test")
	public String test()
	{
	
		return"data tested";
	}
	@RequestMapping("/save")
	public String save()
	{
		Customer c=new Customer();
		c.setName("Ahaan");
		c.setPhone_no(5678854);
		
		Address a=new Address();
		a.setCity("Ranchi");
		a.setPincode(834001);
		
		Order o=new Order();
		o.setProduct_name("book");
		o.setQuantity("one");
		o.setPrice(450);
		
		Order o1=new Order();
		o1.setProduct_name("T-shirrt");
		o1.setQuantity("2");
		o1.setPrice(750);
		
		List<Order>list=Arrays.asList(o,o1);
		a.setOrder(list);
		c.setAddress(a);
		a.setCustomer(c);
		
		
		crepo.save(c);
		return"data saved";
		
	}
	

}
