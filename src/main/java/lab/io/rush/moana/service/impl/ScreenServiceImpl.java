package lab.io.rush.moana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.io.rush.moana.dao.ScreenDAO;
import lab.io.rush.moana.entity.Movie;
import lab.io.rush.moana.entity.Screen;
import lab.io.rush.moana.service.ScreenService;

@Service("screenService")
public class ScreenServiceImpl implements ScreenService{

	@Autowired
	ScreenDAO screenDAO;

	@Override
	public void saveScreen(Screen screen) {
		// TODO Auto-generated method stub
		screenDAO.insert(screen);
	}

	@Override
	public Screen getScreen(Integer id) {
		// TODO Auto-generated method stub
		return screenDAO.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteScreen(Integer id) {
		// TODO Auto-generated method stub
		return screenDAO.deleteByPrimaryKey(id);
	}

	@Override
	public boolean updateScreen(Screen screen) {
		// TODO Auto-generated method stub
		return screenDAO.updateByPrimaryKey(screen);
	}

	@Override
	public List<Screen> getAllScreens(Integer movie_id) {
		// TODO Auto-generated method stub
		return screenDAO.getAllScreens(movie_id);
	}
	
	
}
