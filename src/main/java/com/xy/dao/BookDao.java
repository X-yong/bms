package com.xy.dao;

import java.util.List;
import java.util.Map;

import com.xy.entity.Book;
import com.xy.vo.BookVo;
import com.xy.vo.BorrowBookVo;

public interface BookDao {
	/**
	 * 添加图书
	 * @return
	 */
	public Integer addBookDao(BookVo bookVo);
	/**
	 * 查询图书
	 * @return
	 */
	public List selectBookInfoDao(BookVo bookVo);
	/**
	 * 图书修改
	 *  @return
	 */
	public Integer updateBookDao(BookVo bookVo);
	/**
	 * 图书删除
	 * @return
	 */
	public Integer deleteBookDao(List list);
	/**
	 * 图书借阅
	 * @return
	 */
	public Integer borrowBookDao(BorrowBookVo borrowBookVo);
	/**
	 * 借阅删除
	 * @return
	 */
	public Integer deleteBorrowBookDao(Map map);
	/**
	 * 图书归还
	 * @return
	 */
	public Integer returnBookDao(Integer id);
	
	/**
	 * 图书下载
	 * @return
	 */
	public Integer downloadBookDao();
	
	/**
	 * 图书下载
	 * @return
	 */
	public List getBookTypeDao();
	
	/**
	 * 获取自增id
	 * @return
	 */
	public Integer getAddId();
	/**
	 * 获取图书库存
	 * @param u_id
	 * @return
	 */
	public Integer getBookStockDao(String b_id);
	/**
	 * 更新库存
	 * @return
	 */
	public Integer updateStockDao(BookVo bookVo) ;
	/**
	 * 借还书记录查询
	 * @param borrowBookVo
	 * @return
	 */
	public List qryReturnAndBorrowBookDao(BorrowBookVo borrowBookVo);
	/**
	 * 借阅排行
	 * @return
	 */
	public List rankOfBorrowDao(String b_kind);
	/**
	 * 续借图书
	 * @return
	 */
	public Integer reletBookDao(BorrowBookVo borrowBookVo);
	/**
	 * 通过id查询信息
	 * @return
	 */
	public Book getBookInfoByidDao(String b_id);
	/**
	 * 查询所有记录数
	 * @return
	 */
	public Integer getAllBookRowsDao(String b_kind);
	/**
	 * 查询所有记录数
	 * @return
	 */
	public Integer getAllBorrowBookRowDao();
	/**
	 *查询用户借阅未还记录
	 * @param map
	 * @return
	 */
	public List getUserBorrowBookOnReturnDao(Map map);
	
	/**
	 * 查询借书表个个状态的记录
	 * @param map
	 * @return
	 */
	public List getBorrowBooksBystateDao (Integer state);
	/**
	 * 逾期处理
	 * @param Integer
	 * @return
	 */
	public Integer updateOverdueDealDao (Integer id);
	/**
	 * 预约借书
	 * @param Integer
	 * @return
	 */
	public Integer insertAppointmentDao (BorrowBookVo borrowBookVo);
	/**
	 * 查询预约借书
	 * @param Integer
	 * @return
	 */
	public List qryAppointmentDao (BorrowBookVo borrowBookVo);
	/**
	 * 查询预约所有记录
	 * @param Integer
	 * @return
	 */
	public Integer getAppointmentCountDao();
	/**
	 * 查询预约借书
	 * @param Integer
	 * @return
	 */
	public void deleteAppointmentDao(Integer id);
	
	/**
	 * 查询图书借阅或用户借阅情况
	 * @param Integer
	 * @return
	 */
	public List qryBookByBorrowDao(Map map);
	/**
	 * 删除借阅记录
	 * @param map
	 * @return
	 */
	public Integer deleteBookByBorrowDao(Map map);
	

} 
