package lab.io.rush.moana.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
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

import lab.io.rush.moana.dao.MovieDAO;
import lab.io.rush.moana.entity.Customer;
import lab.io.rush.moana.entity.Movie;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {

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
			Object obj = pm.getObjectById(Movie.class, id);
			pm.deletePersistent(obj);
		} catch (JDOObjectNotFoundException e) {
			flag = false;
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
	public void insert(Movie movie) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(movie);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Override
	public Movie selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Movie movie = null;
		try{
			Object obj = pm.getObjectById(Movie.class, id);
			movie = (Movie) pm.detachCopy(obj);
			System.out.println(movie);
		} catch (JDOObjectNotFoundException e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}

		return movie;
	}

	@Override
	public boolean updateByPrimaryKey(Movie movie) {
		// TODO Auto-generated method stub
		boolean flag = true;
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Object obj = pm.getObjectById(Movie.class, movie.getMovie_id());
			BeanUtils.copyProperties(obj, movie);
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
	public List<Movie> getAllOnSaleMovies() {
		// TODO Auto-generated method stub
		PersistenceManager pm = getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Movie> movies = null;
		try {
			tx.begin();
			//Query q = pm.newQuery("SELECT FROM " + Movie.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");
			Query q = pm.newQuery("SELECT FROM " + Movie.class.getName()+" WHERE status == 1");
			movies = (List<Movie>) q.execute();
			

			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception performing queries : " + e.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return movies;
	}

}
