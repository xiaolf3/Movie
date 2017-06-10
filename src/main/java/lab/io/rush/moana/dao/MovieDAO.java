package lab.io.rush.moana.dao;



import java.util.List;

import lab.io.rush.moana.entity.Movie;


public interface MovieDAO {
	boolean deleteByPrimaryKey(Integer id);
	void insert(Movie movie);
	Movie selectByPrimaryKey(Integer id);
	boolean updateByPrimaryKey(Movie movie);
	List<Movie> getAllOnSaleMovies();
}
