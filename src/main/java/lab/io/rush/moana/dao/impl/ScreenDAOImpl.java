package lab.io.rush.moana.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.jdo.annotations.Transactional;
import javax.persistence.PersistenceContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import lab.io.rush.moana.dao.ScreenDAO;
import lab.io.rush.moana.entity.Customer;
import lab.io.rush.moana.entity.Movie;
import lab.io.rush.moana.entity.Screen;

@Repository("screenDAO")
public class ScreenDAOImpl implements ScreenDAO {

	@Autowired
	@Qualifier("persistenceManagerFactory")
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
			Object obj = pm.getObjectById(Screen.class, id);
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
	public void insert(Screen screen) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(screen);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Override
	public Screen selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Screen screen = null;
		try {
			tx.begin();
			Object obj = pm.getObjectById(Screen.class, id);
			screen = (Screen) pm.detachCopy(obj);
			tx.commit();
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		return screen;
	}

	@Override
	public boolean updateByPrimaryKey(Screen screen) {
		// TODO Auto-generated method stub
		boolean flag = true;
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object obj = pm.getObjectById(Screen.class, screen.getScreen_id());
			BeanUtils.copyProperties(obj, screen);
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
	public List<Screen> getAllScreens(Integer movie_id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Screen> screens = null;
		try {
			tx.begin();
			//Query q = pm.newQuery("SELECT FROM " + Movie.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");
			Query q = pm.newQuery("SELECT FROM " + Screen.class.getName() + " WHERE movie_id == "+movie_id);
			//Query q = pm.newQuery("SQL","SELECT * FROM SCREEN WHERE MOVIE_ID = "+movie_id);
			//q.setClass(Screen.class);
			screens = (List<Screen>) q.execute();
			//System.out.println("test1"+screens);
			tx.commit();
			System.out.println("test2"+screens);
		} catch (Exception e) {
			System.out.println("Exception performing queries : " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return screens;
	}
	
	
}
