package teacher.service;

import java.util.List;

import teacher.dao.ManagerDao;
import teacher.entity.Manager;

public class ManagerService {
	public List<Manager> selectAllManager() {
		ManagerDao managerDao = new ManagerDao();
		return managerDao.selectAllManager();
	}
}
