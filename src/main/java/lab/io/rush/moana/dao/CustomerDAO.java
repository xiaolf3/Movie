package lab.io.rush.moana.dao;



import lab.io.rush.moana.entity.Customer;


public interface CustomerDAO {
	boolean deleteByPrimaryKey(String id);
	void insert(Customer customer);
	Customer selectByPrimaryKey(String id);
	boolean updateByPrimaryKey(Customer customer);
}
