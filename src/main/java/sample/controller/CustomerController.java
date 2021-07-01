package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.dao.CustomerDAO;
import sample.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model themodel) {

		List<Customer> theCustomers = customerDAO.getCustomers();

		themodel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
