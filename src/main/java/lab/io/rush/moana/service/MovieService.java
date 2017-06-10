package lab.io.rush.moana.service;

import java.util.List;

import lab.io.rush.moana.entity.Movie;

public interface MovieService {
	void saveMovie(Movie movie);
	Movie getMovie(Integer id);
	boolean deleteMovie(Integer id);
	boolean updateMovie(Movie movie);
	List<Movie> getAllOnSaleMovies();
}
