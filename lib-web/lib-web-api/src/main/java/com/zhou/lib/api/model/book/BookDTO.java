package com.zhou.lib.api.model.book;
  
import com.zhou.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 579900291761286495L;
    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍分类名称
     */
    private  int bookClassId;

    /**
     * 书籍价格
     */
    private BigDecimal bookPrice;

    /**
     * 书籍出版社
     */
    private Date bookPublish;

    /**
     * 书籍作者
     */
    private String bookAuthor;


    /**
     * 书籍图片（多个图片用分号隔开）
     */
    private String bookImg;

    /**
     * 出版日期
     */
    private Date publishDate;



}
