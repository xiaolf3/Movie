package lab.io.rush.moana.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.io.rush.moana.dao.CustomerDAO;
import lab.io.rush.moana.entity.Customer;
import lab.io.rush.moana.entity.Movie;
import lab.io.rush.moana.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.insert(customer);
	}

	@Override
	public Customer getCustomer(String id) {
		// TODO Auto-generated method stub
		return customerDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return customerDAO.deleteByPrimaryKey(id);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateByPrimaryKey(customer);
	}
	
	
}
