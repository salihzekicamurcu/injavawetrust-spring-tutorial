package _37.aspectj.transaction.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _37.aspectj.transaction.model.Address;
import _37.aspectj.transaction.model.Customer;
import _37.aspectj.transaction.service.CustomerServiceImpl;


public class SpringJPADeclarativeTransactionTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("37.aspectj.transaction.xml");

		// get ProductService bean
		CustomerServiceImpl productService = context.getBean(CustomerServiceImpl.class);

		// prepare Customer and Address data.
		Customer customer = new Customer(1, "Levent", "Erguder");
		Address address = new Address(1, "Java Street", "34000", "Istanbul");
		customer.setAddress(address);

		//
		Customer customer2 = new Customer(2, "Orcun", "Erpis");
		Address address2 = new Address(2, "Bakanliklar Street", "06000", "Ankara");
		customer2.setAddress(address2);

		Customer customer3 = new Customer(3, "Hakan", "Gencel");
		// duplicate Address id , throw exception
		// customers3 record will be rollbacked too.
		Address address3 = new Address(2, "Alemdag Road", "34000", "Istanbul");
		customer3.setAddress(address3);

		productService.insertCustomerData(customer);
		productService.insertCustomerData(customer2);

		try {
			productService.insertCustomerData(customer3);
		} catch (Exception e) {
			System.out.println("Rollback...");
			System.out.println(e.getMessage());
		}

		//
		System.out.println("Customer List : ");
		for (Customer customerRecord : productService.listCustomers()) {
			System.out.println(customerRecord);
		}

		context.close();

	}
}