package com.xy.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.constants.constants;
import com.xy.dao.BookDao;
import com.xy.dao.CommentDao;
import com.xy.dao.UserDao;
import com.xy.entity.Book;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.util.CreateTime;
import com.xy.util.MapToBean;
import com.xy.vo.BookVo;
import com.xy.vo.BorrowBookVo;
import com.xy.vo.UserVo;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao bookDao;
	@Resource
	private UserDao userDao;
	@Resource
	private CommentDao commentDao;

	public Integer addBookService(BookVo bookVo) {
		Integer id = bookDao.getAddId();
		bookVo.setId(id);
		return bookDao.addBookDao(bookVo);
	}

	public List selectBookInfoService(BookVo bookVo) {

		return bookDao.selectBookInfoDao(bookVo);
	}

	public Integer updateBookService(BookVo bookVo) {

		return bookDao.updateBookDao(bookVo);
	}

	public Integer deleteBookService(List list) {
		Map map = new HashMap();
		BorrowBookVo borrowBookVo = new BorrowBookVo();
		for (int i = 0; i < list.size(); i++) {
			map.put(constants.b_id, list.get(i));
			map.put(constants.bo_state, 1);
			List rl = bookDao.qryBookByBorrowDao(map);//查询图书是否有借阅记录
			String b_id = (String) list.get(i);
			if (rl.size() > 0) {
				throw new RuntimeException("图书id为:"+b_id+"借阅中,不能删除"); 		
			}
			borrowBookVo.setB_id(b_id);
		    List br = bookDao.qryAppointmentDao(borrowBookVo);
		    if (br.size() > 0) {
		    	throw new RuntimeException("图书id为:"+b_id+"已被预约,不能删除");
			}
		}
		 
		return bookDao.deleteBookDao(list);
	}

	public Integer borrowBookService(BorrowBookVo borrowBookVo) {
		BookVo bookVo = new BookVo();
		List idList = borrowBookVo.getIdList();
		if (idList.size() != 0) {
			for (int i = 0, len = idList.size(); i < len; i++) {
				borrowBookVo.setB_id((String) idList.get(i));
				bookDao.borrowBookDao(borrowBookVo);
				// 修改库存
				bookVo.setB_id((String) idList.get(i));
				List rlList = bookDao.selectBookInfoDao(bookVo);
				Book book = (Book) rlList.get(0);
				Integer bStock = book.getB_stock();
				Integer bAccount = book.getB_account();
				bStock = bStock - 1;
				bAccount = bAccount + 1;
				bookVo.setB_stock(bStock);
				bookVo.setB_account(bAccount);
				bookDao.updateStockDao(bookVo);
				// 减信用值
				User user = userDao.getUserInfoByIdDao(borrowBookVo.getU_id());
				Integer u_credit = user.getU_credit();
				u_credit = u_credit - 1;
				UserVo userVo = new UserVo();
				userVo.setU_id(borrowBookVo.getU_id());
				userVo.setU_credit(u_credit);
				userDao.updateUserByIdDao(userVo);
			}
		}

		return 1;
	}

	public Integer returnBookService(BorrowBookVo borrowBookVo) {
		BookVo bookVo = new BookVo();
		List idList = borrowBookVo.getIdList();
		List<String> bidList = borrowBookVo.getBidList();
		if (idList.size() != 0) {
			for (int i = 0, len = idList.size(); i < len; i++) {
				String id = (String) idList.get(i);
				bookDao.returnBookDao(Integer.valueOf(id));
			}
			for (String bid : bidList) {
				// 修改库存
				Integer stock = bookDao.getBookStockDao(bid);
				stock = stock + 1;
				bookVo.setB_stock(stock);
				bookVo.setB_id(bid);
				bookDao.updateStockDao(bookVo);
			}
		}
		return 1;
	}

	public Integer uploadBookService() {
		// TODO Auto-generated method stub
		return null;
	}

	public void downloadBookService(String b_id) {
		// 图书计数加1
		Book bookinfo = bookDao.getBookInfoByidDao(b_id);
		Integer bAccount = bookinfo.getB_account();
		bAccount = bAccount + 1;
		BookVo bookVo = new BookVo();
		bookVo.setB_id(b_id);
		bookVo.setB_account(bAccount);
		bookDao.updateStockDao(bookVo);
	}

	public List getBookTypeService() {

		return bookDao.getBookTypeDao();
	}

	public Integer importBookService() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer importBookService(List list) {
		if (list.size() != 0) {
			BookVo bookVo = new BookVo();
			for (int i = 0, len = list.size(); i < len; i++) {
				Map map = (Map) list.get(i);
				BookVo bookVos = (BookVo) MapToBean.mapToBean(map, bookVo);
				Integer id = bookDao.getAddId();
				bookVo.setId(id);
				bookDao.addBookDao(bookVo);
			}
		}
		return 1;
	}

	public Integer getBookStockService(String b_id) {

		return bookDao.getBookStockDao(b_id);
	}

	public List qryReturnAndBorrowBookService(BorrowBookVo borrowBookVo) {

		return bookDao.qryReturnAndBorrowBookDao(borrowBookVo);
	}

	public List rankOfBorrowService(String b_kind) {
		return bookDao.rankOfBorrowDao(b_kind);
	}

	public Integer reletBookService(BorrowBookVo borrowBookVo) {
		return bookDao.reletBookDao(borrowBookVo);
	}

	public Book getBookInfoByidService(String b_id) {

		return bookDao.getBookInfoByidDao(b_id);
	}

	public Integer getAllBookRowsService(String b_kind) {
		return bookDao.getAllBookRowsDao(b_kind);
	}

	public Integer getAllBorrowBookRowService() {
		return bookDao.getAllBorrowBookRowDao();
	}

	public List getUserBorrowBookOnReturnService(String u_id, String b_id) {
		Map map = new HashMap();
		map.put(constants.u_id, u_id);
		map.put(constants.b_id, b_id);
		return bookDao.getUserBorrowBookOnReturnDao(map);
	}

	public List qryBookCommentDao(String b_id) {
		return commentDao.qryBookCommentDao(b_id);
	}

	public Integer addCommentService(Map map) {
		return commentDao.addCommentDao(map);
	}

	public void qryborrowBooksBystateService(Integer state) {
		List rList = bookDao.getBorrowBooksBystateDao(state);
		// 获取Calendar实例
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar currentTime = Calendar.getInstance();
		Calendar compareTime = Calendar.getInstance();
		String cuTime = df.format(new Date());
		Date t = null;		
		try {
			t = df.parse(cuTime);

			// System.err.println(currentTime);
			UserVo userVo = new UserVo();
			for (int i = 0, len = rList.size(); i < len; i++) {
				Map map = (Map) rList.get(i);
				Integer bostate = (Integer) map.get(constants.bo_state);
				
				Date sh_time = (Date) map.get(constants.sh_time);

				compareTime.setTime(sh_time);
				currentTime.setTime(t);
				// 逾期
				if (currentTime.compareTo(compareTime) > 0) {
					Integer id = (Integer) map.get(constants.ID);
					String u_id = (String) map.get(constants.u_id);
					userVo.setU_id(u_id);
					// 改状态为已逾期，并扣相应费用
					User user = userDao.getUserInfoByIdDao(u_id);
					Double balance = user.getU_balance();
					Integer day = new CreateTime().countTwoDate(compareTime, currentTime);
					if (day > 0) {
						if (0 == bostate) {
							bookDao.updateOverdueDealDao(id);
						}
						if (balance > 0.00) {
							balance = balance - 0.1 * day;
							userVo.setU_balance(balance);
							userDao.updateUserByIdDao(userVo);
						} else {
							// 若用户余额为零且存在逾期图书，将用户锁定
							userVo.setU_state(0);
							userDao.updateUserByIdDao(userVo);
						}
						continue;
					}
				}
				currentTime.add(Calendar.DATE, 1);// 获取当前日期后一天

				// 逾期警告
				if (currentTime.compareTo(compareTime) > 0) {
					Map rMap = new HashMap();
					rMap.put("su_id", "001");
					rMap.put("ru_id", map.get(constants.u_id));
					rMap.put("s_content", "用户u_id为:" + map.get(constants.u_id) + ",所借图书《" + map.get(constants.b_name)
							+ "》即将逾期，请在到期日之前办理续借或者归还，以免影响您的信誉。谢谢合作！");
					userDao.insertMessageDao(rMap);
				}

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Integer insertAppointmentService(BorrowBookVo borrowBookVo) {

		return bookDao.insertAppointmentDao(borrowBookVo);
	}

	public void appointmentService() {
		BorrowBookVo borrowBookVo = new BorrowBookVo();
		List rlist = bookDao.qryAppointmentDao(borrowBookVo);
		if (rlist.size() > 0) {
			for (int i = 0, len = rlist.size(); i < len; i++) {
				BorrowBookVo borr = (BorrowBookVo) rlist.get(i);

				Date b_appointtime = borr.getB_appointtime();
				long b = b_appointtime.getTime();
				Date currTime = new Date();
				long a = currTime.getTime();
				long c = a - b;

				if (c > 0) {
					// 删除预约，并将相应图书库存加1
					Integer id = borr.getId();
					bookDao.deleteAppointmentDao(id);
					Integer stock = bookDao.getBookStockDao(borr.getB_id());
					stock = stock + 1;
					BookVo bookVo = new BookVo();
					bookVo.setB_stock(stock);
					bookVo.setB_id(borr.getB_id());
					bookDao.updateStockDao(bookVo);
				}
			}

		}
	}

	public Integer updateStockService(BookVo bookVo) {

		return bookDao.updateStockDao(bookVo);
	}

	public List qryAppointmentService(BorrowBookVo borrowBookVo) {

		return bookDao.qryAppointmentDao(borrowBookVo);
	}

	public Integer getAppointmentCountService() {

		return bookDao.getAppointmentCountDao();
	}

	public void deleteAppointmentService(String[] id, String[] b_id) {
		for (int i = 0; i < id.length; i++) {
			bookDao.deleteAppointmentDao(Integer.valueOf(id[i]));
			// 修改库存
			Integer stock = bookDao.getBookStockDao(b_id[i]);
			stock = stock + 1;
			BookVo bookVo = new BookVo();
			bookVo.setB_stock(stock);
			bookVo.setB_id(b_id[i]);
			bookDao.updateStockDao(bookVo);
		}
	}

	public List qryBookByBorrowService(Map map) {
		
		return bookDao.qryBookByBorrowDao(map);
	}

}
