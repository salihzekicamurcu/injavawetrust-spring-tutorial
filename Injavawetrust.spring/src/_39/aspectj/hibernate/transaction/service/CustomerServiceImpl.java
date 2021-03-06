package _39.aspectj.hibernate.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _39.aspectj.hibernate.transaction.dao.AddressDAO;
import _39.aspectj.hibernate.transaction.dao.CustomerDAO;
import _39.aspectj.hibernate.transaction.model.Customer;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AddressDAO addressDao;

	@Override
	public void insertCustomerData(Customer customer) {
		customerDAO.insertCustomer(customer);
		addressDao.insertAddress(customer.getAddress());
	}

	@Override
	public List<Customer> listCustomers() {
		return customerDAO.findAllCustomers();
	}

}
