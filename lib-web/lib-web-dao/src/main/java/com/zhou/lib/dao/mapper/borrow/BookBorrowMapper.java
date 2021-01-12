package com.zhou.lib.dao.mapper.borrow;

import com.zhou.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 12418
 */
@Mapper
public interface BookBorrowMapper {

    int insert(BookBorrowDTO bookBorrowDTO);
}
