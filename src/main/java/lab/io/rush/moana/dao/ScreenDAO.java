package lab.io.rush.moana.dao;



import java.util.List;

import lab.io.rush.moana.entity.Screen;


public interface ScreenDAO {

	boolean deleteByPrimaryKey(Integer id);
	void insert(Screen screen);
	Screen selectByPrimaryKey(Integer id);
	boolean updateByPrimaryKey(Screen screen);
	List<Screen> getAllScreens(Integer movie_id);
}
