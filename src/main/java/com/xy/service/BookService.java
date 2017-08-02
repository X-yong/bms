package com.xy.service;

import java.util.List;
import java.util.Map;

import com.xy.entity.Book;
import com.xy.vo.BookVo;
import com.xy.vo.BorrowBookVo;

public interface BookService {
	/**
	 * 添加图书
	 * @return
	 */
	public Integer addBookService(BookVo bookVo);
	/**
	 * 查询图书
	 * @return
	 */
	public List selectBookInfoService(BookVo bookVo);
	/**
	 * 图书修改
	 *  @return
	 */
	public Integer updateBookService(BookVo bookVo);
	/**
	 * 图书删除
	 * @return
	 */
	public Integer deleteBookService(List list);
	/**
	 * 图书借阅
	 * @return
	 */
	public Integer borrowBookService(BorrowBookVo borrowBookVo);
	/**
	 * 图书归还
	 * @return
	 */
	public Integer returnBookService(BorrowBookVo borrowBookVo);
	/**
	 * 图书上传
	 * @return
	 */
	public Integer uploadBookService();
	/**
	 * 图书导入
	 * @return
	 */
	public Integer importBookService(List list);
	/**
	 * 图书下载
	 * @return
	 */
	public void downloadBookService(String u_id);
	
	/**
	 * 获取图书类别
	 * @return
	 */
	public List getBookTypeService();
	/**
	 * 获取图书库存
	 * @return
	 */
	public Integer getBookStockService(String b_id);
	/**
	 * 修改图书库存
	 * @return
	 */
	public Integer updateStockService(BookVo bookVo);
	/**
	 * 借还书记录查询
	 * @param borrowBookVo
	 * @return
	 */
	public List qryReturnAndBorrowBookService(BorrowBookVo borrowBookVo);
	/**
	 * 借阅排行
	 * @return
	 */
	public List rankOfBorrowService(String b_kind);
	
	/**
	 * 续借
	 * @return
	 */
	public Integer reletBookService(BorrowBookVo borrowBookVo);
	
	public Book getBookInfoByidService(String b_id);
	/**
	 * 查询所有记录数
	 * @return
	 */
	public Integer getAllBookRowsService(String b_kind);
	/**
	 *  查询所有借阅记录数
	 * @return
	 */
	public Integer getAllBorrowBookRowService();
	/**
	 *查询用户借阅未还记录
	 * @param borrowBookVo
	 * @return
	 */
	public List getUserBorrowBookOnReturnService(String u_id, String b_id);
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
	public Integer addCommentService (Map map);
	/**
	 * 查询借书表个个状态的记录
	 * @param map
	 * @return
	 */
	public void qryborrowBooksBystateService(Integer state);
	/**
	 * 预约借书
	 * @param map
	 * @return
	 */
	public Integer insertAppointmentService(BorrowBookVo borrowBookVo);
	/**
	 * 预约处理
	 * @param borrowBookVo
	 * @return
	 */
	public void appointmentService();
	/**
	 * 预约处理
	 * @param borrowBookVo
	 * @return
	 */
	public List qryAppointmentService(BorrowBookVo borrowBookVo);
	/**
	 * 查询预约借书所有记录
	 * @return
	 */
	public Integer getAppointmentCountService();
	/**
	 * 删除预约
	 * @param id
	 * @return
	 */
	public void deleteAppointmentService(String[] id,String[] b_id);
	/**
	 * 查询图书借阅或用户借阅情况
	 * @param Integer
	 * @return
	 */
	public List qryBookByBorrowService(Map map);
	
}			  
