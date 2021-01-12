package com.zhou.lib.api.model.borrow;


import com.zhou.lib.api.model.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书类实体类
 * @author 12418
 */
@Data
public class BookBorrowDTO extends BaseDTO {
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 借的书的ID
     */
    private int bookId;

    /**
     * 借的书的名称
     */
    private String bookName;

    /**
     * 借了几本
     */
    private int count;

    /**
     * 开始借的时间
     */
    private Date startDate;

    /**
     * 最晚应该还的时间
     */
    private Date endDate;

    /**
     * 借书费用
     */
    private BigDecimal price;

    /**
     * 借书实际费用
     */
    private BigDecimal tradeFee;

}
