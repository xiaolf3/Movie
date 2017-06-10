package lab.io.rush.moana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.io.rush.moana.dao.OrderDAO;
import lab.io.rush.moana.entity.Order;
import lab.io.rush.moana.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.insert(order);
	}

	@Override
	public Order getOrder(Integer id) {
		// TODO Auto-generated method stub
		return orderDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		return orderDAO.deleteByPrimaryKey(id);
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDAO.updateByPrimaryKey(order);
	}

	@Override
	public List<Order> getOrdersByMovieAndCustomer(String customer_id, Integer movie_id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrdersByMovieAndCustomer(customer_id, movie_id);
	}
	

}
