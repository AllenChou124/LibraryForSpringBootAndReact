package com.zhou.lib.web.book;

import com.zhou.lib.api.constants.ResultDTO;
import com.zhou.lib.api.enums.HttpCode;
import com.zhou.lib.api.model.book.BookDTO;
import com.zhou.lib.api.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autho 124180
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookService bookService;

    /**
     * 根据名称查找分类信息
     * @param bookDTO 书籍实体类书籍名称
     * @return
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(@RequestBody BookDTO bookDTO) {
        try{
            return bookService.findListByName(bookDTO.getBookName());
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 根据id查找分类信息
     * @param bookDTO 数据主键
     * @return
     */
    @RequestMapping("/findById")
    public ResultDTO findById(@RequestBody BookDTO bookDTO) {
        try{
            return bookService.findById(bookDTO.getId());
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 新增
     * @param bookDTO 数据实体类
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(@RequestBody BookDTO bookDTO) {
        try{
            return bookService.insert(bookDTO);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 更新
     * @param bookDTO 数据实体类
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(@RequestBody BookDTO bookDTO) {
        try{
            return bookService.update(bookDTO);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 根据id删除分类信息
     * @param bookDTO 书籍实体类ID
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody BookDTO bookDTO) {
        try{
            return bookService.delete(bookDTO.getId());
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }
}
