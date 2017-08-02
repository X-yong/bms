package com.xy.dao;

import java.util.List;

import com.xy.entity.Authority;
import com.xy.vo.AuthorityVo;
import com.xy.vo.UserVo;

public interface AuthorityDao {
	/**
	 * 查询权限
	 * @return
	 */
	public Authority qryAuthorityDao(UserVo userVo);
	/**
	 * 授予权限
	 * @return
	 */
	public Integer grantAuthorityDao(AuthorityVo authorityVo);
	/**
	 * 撤销权限
	 * @return
	 */
	public Integer removeAuthorityDao(List list);
	/**
	 * 新增授权
	 * @param authorityVo
	 * @return
	 */
	public Integer insertAuthorityDao(AuthorityVo authorityVo);
	
	
} 
