package com.zhou.lib.service.borrow;

import com.zhou.lib.api.constants.ResultDTO;
import com.zhou.lib.api.enums.HttpCode;
import com.zhou.lib.api.enums.ValidFlagEnum;
import com.zhou.lib.api.model.book.BookDTO;
import com.zhou.lib.api.model.borrow.BookBorrowDTO;
import com.zhou.lib.api.service.borrow.BookBorrowService;
import com.zhou.lib.dao.mapper.book.BookMapper;
import com.zhou.lib.dao.mapper. borrow.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书逻辑处理
 * @author 12418
 */
@Service
public class BookBorrowServiceImpl implements BookBorrowService {
    @Autowired
    private BookBorrowMapper bookBorrowMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {
        //Step1:非法校验
        //要借的书的编号
        if(0 >= bookId) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍编号不合法，请确认所选书籍是否存在！");
        }

        //租借起始日期截至日期（日期前后的顺序的非法校验交给前端来做）
        if(startDate.after(endDate)) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "起始日期不饿能晚于归还日期");
        }
        //Step2: 获取书籍
        BookDTO bookDTO = bookMapper.findById(bookId);
        if(borrowCount <= 0) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "借阅数量需要大于零！");
        }
        //2.1 书籍存在性判断
        if(null == bookDTO) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍不存在！");
        }
        //2.2 数量是否足够的校验
        int bookCount = bookDTO.getBookCount();
        if(bookCount <= 0) {
            //TODO 在查找书籍的时候如果返回的书籍数量为0，钱都安直接禁用租界按钮，同时加一个效果：当前书籍已经被租借光了
            return new ResultDTO(HttpCode.FAIL.getCode(), "当前书籍已经被租借光了，请看看别的书吧~");
        }
        if(borrowCount > bookCount) {
            return new ResultDTO(HttpCode.FAIL.getCode(), "借阅数量超过书籍存量，当前剩余数量：" + bookCount);
        }
        //Step3 真正的借书操作
        int result = doInsertBookBorrowRecord(bookId,bookDTO,borrowCount,startDate,endDate,userId,userName,vipFlag);
        if(result <= 0) {
            //新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(),"借书失败，您可以尝试重新借书或者联系图书管理员处理");
        }

        //Step4 减少书籍数量
        bookDTO.setBookCount(bookCount - borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.update(bookDTO);
        return new ResultDTO(HttpCode.SUCCESS.getCode(),"借书成功");
    }

    private int doInsertBookBorrowRecord(int bookId, BookDTO bookDTO, int borrowCount, Date startDate, Date endDate, int userId, String userName, boolean vipFlag) {
        BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setBookName(bookDTO.getBookName());
        //用户名信息我们可以从session获取： HttpSession session = request.getSession();
        bookBorrowDTO.setCount(borrowCount);
        bookBorrowDTO.setStartDate(startDate);
        bookBorrowDTO.setEndDate(endDate);
        bookBorrowDTO.setUserId(userId);
        bookBorrowDTO.setUserName(userName);
        //设置书籍价格
        BigDecimal bookPrice = bookDTO.getBookPrice();
        long days = (endDate.getTime() - startDate.getTime()) / (24*60*60*1000);
        long totalPrice = bookPrice.intValue()*days;
        bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));
        if(vipFlag) {
            //实际的交易价格，vip用户免费
            bookBorrowDTO.setTradeFee(new BigDecimal(0));
        }
        bookBorrowDTO.setCreateDate(new Date());
        bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);
        //新增
        int result = bookBorrowMapper.insert(bookBorrowDTO);
        return result;
    }
}
