package lab.io.rush.moana.service;

import java.util.List;

import lab.io.rush.moana.entity.Order;

public interface OrderService {
	void saveOrder(Order order);
	Order getOrder(Integer id);
	boolean deleteOrder(Integer id);
	boolean updateOrder(Order order);
	List<Order> getOrdersByMovieAndCustomer(String customer_id, Integer movie_id);
}
