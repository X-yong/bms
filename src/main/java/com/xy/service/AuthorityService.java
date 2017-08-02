package com.xy.service;

import com.xy.entity.Authority;
import com.xy.vo.AuthorityVo;
import com.xy.vo.UserVo;

public interface AuthorityService {
	/**
	 * 查询权限
	 * @param admin
	 * @return
	 */
	public Authority qryAuthorityService(UserVo userVo);
	/**
	 * 授予权限
	 * @return
	 */
	public Integer grantAuthorityService(AuthorityVo authorityVo);
	
	/**
	 * 新增授权
	 * @param authorityVo
	 * @return
	 */
	public Integer insertAuthorityService(AuthorityVo authorityVo);
}			  
