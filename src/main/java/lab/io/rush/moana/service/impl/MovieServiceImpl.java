package lab.io.rush.moana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.io.rush.moana.dao.MovieDAO;
import lab.io.rush.moana.entity.Movie;
import lab.io.rush.moana.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDAO movieDAO;
	
	@Override
	public void saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieDAO.insert(movie);
	}

	@Override
	public Movie getMovie(Integer id) {
		// TODO Auto-generated method stub
		return movieDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteMovie(Integer id) {
		// TODO Auto-generated method stub
		return movieDAO.deleteByPrimaryKey(id);
	}

	@Override
	public boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDAO.updateByPrimaryKey(movie);
	}

	@Override
	public List<Movie> getAllOnSaleMovies() {
		// TODO Auto-generated method stub
		return movieDAO.getAllOnSaleMovies();
	}
	
}
