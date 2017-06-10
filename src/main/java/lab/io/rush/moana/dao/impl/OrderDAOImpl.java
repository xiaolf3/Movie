package lab.io.rush.moana.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import lab.io.rush.moana.dao.OrderDAO;
import lab.io.rush.moana.entity.Customer;
import lab.io.rush.moana.entity.Order;
import lab.io.rush.moana.entity.Screen;
@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	@Qualifier("persistenceManagerFactoryProxy")
	PersistenceManagerFactory persistenceManagerFactory;

	protected PersistenceManager getPersistenceManager() {
		return persistenceManagerFactory.getPersistenceManager();
	}
	
	
	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		boolean flag = true;
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object obj = pm.getObjectById(Order.class, id);
			pm.deletePersistent(obj);
		} catch (JDOObjectNotFoundException e) {
			flag = false;
			e.printStackTrace();
		}finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return flag;
	}

	@Override
	public void insert(Order order) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(order);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Override
	public Order selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Order order = null;
		Order result = new Order();
		try {
			tx.begin();
			order = pm.getObjectById(Order.class, id);
			System.out.println(order);
			BeanUtils.copyProperties(result, order);
			System.out.println(result);
			tx.commit();
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		return result;
	}

	@Override
	public boolean updateByPrimaryKey(Order order) {
		// TODO Auto-generated method stub
		boolean flag = true;
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object obj = pm.getObjectById(Order.class, order.getOrder_id());
			BeanUtils.copyProperties(obj, order);
			// pm.makePersistent(obj);
			tx.commit();
		} catch (JDOObjectNotFoundException e) {
			flag = false;
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return flag;
	}


	@Override
	public List<Order> getOrdersByMovieAndCustomer(String customer_id, Integer movie_id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Order> orders = null;
		try {
			tx.begin();
			//Query q = pm.newQuery("SELECT FROM " + Movie.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");
			//Query q = pm.newQuery("SELECT FROM " + Order.class.getName() + " WHERE movie_id == "+movie_id+" AND customer_id == "+customer_id);
			Query q = pm.newQuery("SQL","SELECT * FROM ORDERS WHERE MOVIE_ID = '"+movie_id+"' AND CUSTOMER_ID = '"+customer_id+"'");
			q.setClass(Screen.class);
			orders = (List<Order>) q.execute();
			System.out.println("test1"+orders);
			tx.commit();
			System.out.println("test2"+orders);
		} catch (Exception e) {
			System.out.println("Exception performing queries : " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return orders;
	}
	
}
