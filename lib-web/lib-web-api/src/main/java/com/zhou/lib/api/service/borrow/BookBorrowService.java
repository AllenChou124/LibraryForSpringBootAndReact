package com.zhou.lib.api.service.borrow;

import com.zhou.lib.api.constants.ResultDTO;

import java.util.Date;

/**
 * 借书还书接口层
 * @author 12418
 */
public interface BookBorrowService {
    ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag);

}
