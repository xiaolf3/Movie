package lab.io.rush.moana.service;

import lab.io.rush.moana.entity.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);
	Customer getCustomer(String id);
	boolean deleteCustomer(String id);
	boolean updateCustomer(Customer customer);
}
