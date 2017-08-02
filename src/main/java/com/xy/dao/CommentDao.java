package com.xy.dao;

import java.util.List;
import java.util.Map;
/**
 * 评论
 * @author soonsmile
 *
 */
public interface CommentDao {
	
	/**
	 *查询图书评论
	 * @param map
	 * @return
	 */
	public List qryBookCommentDao(String b_id);
	/**
	 *插入图书评论
	 * @param map
	 * @return
	 */
	public Integer addCommentDao (Map map);
	/**
	 * 删除评论
	 * @param map
	 * @return
	 */
	public Integer deleteCommentDao(Map map);
	

} 
