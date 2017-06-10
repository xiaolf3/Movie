package lab.io.rush.moana.dao;



import java.util.List;

import lab.io.rush.moana.entity.Order;


public interface OrderDAO {
	boolean deleteByPrimaryKey(Integer id);
	void insert(Order order);
	Order selectByPrimaryKey(Integer id);
	boolean updateByPrimaryKey(Order order);
	List<Order> getOrdersByMovieAndCustomer(String customer_id,Integer movie_id);
}
