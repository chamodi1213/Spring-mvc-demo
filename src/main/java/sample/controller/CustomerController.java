package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sample.entity.Customer;
import sample.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model themodel) {

		List<Customer> theCustomers = customerService.getCustomers();

		themodel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

	@GetMapping("showFormForAdd")
	public String addCustomer(Model theModel){

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";

	}

	@GetMapping("showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId, Model theModel){

		Customer customer = customerService.getCustomer(theId);

//		set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}


}
