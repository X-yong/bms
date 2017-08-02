package com.xy.service;

import java.util.List;
import java.util.Map;

import com.xy.entity.User;
import com.xy.vo.MessageVo;
import com.xy.vo.UserVo;

public interface UserService {
	/**
	 * 用户登陆
	 * @param admin
	 * @return
	 */
	public User loginService(UserVo userVo);
	/**
	 * 用户注册
	 * @return
	 */
	public Integer userRegistrationService(UserVo userVo);
	/**
	 * 用户查询
	 * @return
	 */
	public List selectUserInfoService(UserVo userVo);

	/**
	 * 用户修改,冻结
	 * @return
	 */
	public Integer updateUserByIdService(UserVo userVo);
	/**
	 * 用户删除
	 * @return
	 */
	public Integer deleteUserByIdService(List list);
	/**
	 * 通过u_id查询信息
	 * @param u_id
	 * @return
	 */
	public User getUserInfoByIdService(String u_id);
	/**
	 *查询所有用户记录
	 * @param u_id
	 * @return
	 */
	public Integer getAllUserRowsDao(String authority_id);
	
	/**
	 * 获取消息
	 * @param map
	 * @return
	 */
	public List getMessageService(MessageVo messageVo);
	/**
	 * 修改消息状态
	 * @param map
	 * @return
	 */
	public Integer updateMessageByIdService(Map map);
	/**
	 * 插入消息
	 * @param map
	 * @return
	 */
	public Integer insertMessageService(Map map);
	/**
	 * 查询消息记录
	 * @param ru_id
	 * @return
	 */
	public Integer getAllMessageRowsService(String ru_id);
}			  
