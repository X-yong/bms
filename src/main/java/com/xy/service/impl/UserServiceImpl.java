package com.xy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.constants.constants;
import com.xy.dao.AuthorityDao;
import com.xy.dao.BookDao;
import com.xy.dao.UserDao;
import com.xy.entity.User;
import com.xy.service.UserService;
import com.xy.vo.BorrowBookVo;
import com.xy.vo.MessageVo;
import com.xy.vo.UserVo;

@Service("loginService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private BookDao bookDao;
	
	@Resource
	private AuthorityDao authorityDao;
	
	public User loginService(UserVo userVo) {
		return userDao.loginDao(userVo) ;
	}

	public Integer userRegistrationService(UserVo userVo) {
		
		return userDao.userRegistrationDao(userVo);
	}

	public List selectUserInfoService(UserVo userVo) {
		
		return userDao.selectUserInfoDao(userVo);
	}

	public Integer updateUserByIdService(UserVo userVo) {
		
		return userDao.updateUserByIdDao(userVo);
	}

	public Integer deleteUserByIdService(List list) {
		BorrowBookVo borrowBookVo = new BorrowBookVo();
		Map map = new HashMap();
		map.put(constants.bo_state, 1);
		for (int i = 0; i < list.size(); i++) {
			String u_id = (String) list.get(i);
			borrowBookVo.setU_id(u_id);
		    List rlist = bookDao.qryAppointmentDao(borrowBookVo);
		    if (rlist.size() > 0) {
				throw new RuntimeException("用户存在预约图书，不可删除");
			}
		    map.put(constants.u_id,u_id);
		   List bList = bookDao.qryBookByBorrowDao(map);
		   if (bList.size() > 0) {
			   throw new RuntimeException("用户存在未还图书，不可删除");
		   }		
		}
		authorityDao.removeAuthorityDao(list);
		Integer rlInteger = userDao.deleteUserByIdDao(list);
		
		return rlInteger;
	}

	public User getUserInfoByIdService(String u_id) {
		
		return userDao.getUserInfoByIdDao(u_id);
	}

	public Integer getAllUserRowsDao(String authority_id) {
		
		return userDao.getAllUserRowsDao(authority_id);
	}

	public List getMessageService(MessageVo messageVo) {
		return userDao.getMessageDao(messageVo);
	}

	public Integer updateMessageByIdService(Map map) {
		return userDao.updateMessageByIdDao(map);
	}

	public Integer insertMessageService(Map map) {
		return userDao.insertMessageDao(map);
	}

	public Integer getAllMessageRowsService(String ru_id) {
		return userDao.getAllMessageRowsDao(ru_id);
	}

}
