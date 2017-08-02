package com.xy.dao;

import java.util.List;
import java.util.Map;

import com.xy.entity.User;
import com.xy.vo.MessageVo;
import com.xy.vo.UserVo;

public interface UserDao {
	/**
	 * 用户登陆
	 * @return
	 */
	public User loginDao(UserVo userVo);
	/**
	 * 用户注册
	 * @return
	 */
	public Integer userRegistrationDao(UserVo userVo);
	/**
	 * 用户查询
	 * @return
	 */
	public List selectUserInfoDao(UserVo userVo);

	/**
	 * 用户修改,冻结
	 * @return
	 */
	public Integer updateUserByIdDao(UserVo userVo);
	/**
	 * 用户删除
	 * @return
	 */
	public Integer deleteUserByIdDao(List list);
	/**
	 * 设置系统管理员标记
	 */
	public void setRootValueDao(Map map);
	/**
	 * 通过u_id 查询信息
	 * @return 
	 */
	public User getUserInfoByIdDao(String u_id);
	/**
	 * 查询所有用户记录
	 * @return 
	 */
	public Integer getAllUserRowsDao(String authority_id);
	
	/**
	 * 获取消息
	 * @param map
	 * @return
	 */
	public List getMessageDao(MessageVo messageVo);
	/**
	 * 修改消息状态
	 * @param map
	 * @return
	 */
	public Integer updateMessageByIdDao(Map map);
	/**
	 * 插入消息
	 * @param map
	 * @return
	 */
	public Integer insertMessageDao(Map map);
	/**
	 * 查询所有消息记录
	 * @return 
	 */
	public Integer getAllMessageRowsDao(String ru_id);
	
	
} 
