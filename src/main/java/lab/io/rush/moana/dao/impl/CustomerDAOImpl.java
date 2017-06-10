package lab.io.rush.moana.dao.impl;

import java.lang.reflect.InvocationTargetException;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import lab.io.rush.moana.dao.CustomerDAO;
import lab.io.rush.moana.entity.Customer;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	@Qualifier("persistenceManagerFactoryProxy")
	PersistenceManagerFactory persistenceManagerFactory;

	protected PersistenceManager getPersistenceManager() {
		return persistenceManagerFactory.getPersistenceManager();
	}

	@Override
	public boolean deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		boolean flag = true;
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object obj = pm.getObjectById(Customer.class, id);
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
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(customer);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Override
	public Customer selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Customer customer = null;
		try {
			tx.begin();
			Object obj = pm.getObjectById(Customer.class, id);
			System.out.println(obj);
			customer = (Customer) pm.detachCopy(obj);

			tx.commit();
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

		return customer;
	}

	@Override
	public boolean updateByPrimaryKey(Customer customer) {
		boolean flag = true;
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object obj = pm.getObjectById(Customer.class, customer.getCustomer_id());
			BeanUtils.copyProperties(obj, customer);
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

}
