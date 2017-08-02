package com.xy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.constants.constants;
import com.xy.dao.AuthorityDao;
import com.xy.dao.UserDao;
import com.xy.entity.Authority;
import com.xy.enums.AuthorityEnum;
import com.xy.service.AuthorityService;
import com.xy.vo.AuthorityVo;
import com.xy.vo.UserVo;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

	@Resource
	private AuthorityDao  authorityDao;
	
	@Resource
	private UserDao  userDao;
	/**
	 * 权限查询
	 */
	public Authority qryAuthorityService(UserVo userVo) {
		
		return authorityDao.qryAuthorityDao(userVo);
	}
	/**
	 * 授予权限
	 */
	public Integer grantAuthorityService(AuthorityVo authorityVo) {
		
	    Integer r = authorityDao.grantAuthorityDao(authorityVo);
	    String id= authorityVo.getAuthority_id();
	    Map map = new HashMap();
		if (r != null) {
			// 判断是否撤销了管理员权限
			if (id.indexOf(AuthorityEnum.admin.getValue()) < 0) {
				map.put(constants.u_id, authorityVo.getU_id());
				map.put(constants.flag, null);
				userDao.setRootValueDao(map);
			}else {
				map.put(constants.u_id, authorityVo.getU_id());
			    map.put(constants.flag, 1);
			    userDao.setRootValueDao(map);
			}
		}
		return r; 
	}
	/**
	 * 撤销查询
	 */
	public Integer removeAuthorityService(List list) {

		return authorityDao.removeAuthorityDao(list);
	}
	public Integer insertAuthorityService(AuthorityVo authorityVo) {
		
		return authorityDao.insertAuthorityDao(authorityVo);
	}
	
	
}
