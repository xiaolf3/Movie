package lab.io.rush.moana.service;

import java.util.List;

import lab.io.rush.moana.entity.Screen;

public interface ScreenService {
	void saveScreen(Screen screen);
	Screen getScreen(Integer id);
	boolean deleteScreen(Integer id);
	boolean updateScreen(Screen screen);
	List<Screen> getAllScreens(Integer movie_id);
}
