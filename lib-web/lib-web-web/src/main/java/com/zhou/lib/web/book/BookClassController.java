package com.zhou.lib.web.book;

import com.zhou.lib.api.constants.ResultDTO;
import com.zhou.lib.api.enums.HttpCode;
import com.zhou.lib.api.model.book.BookClassDTO;
import com.zhou.lib.api.service.BookClassService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍分类访问层
 * @author 12418
 */
@Component
@RestController
@RequestMapping("/bookClass")
public class BookClassController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookClassService bookClassService;

    /**
     * 根据名称查找分类信息
     * @param name 分类名
     * @return
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(String name) {
        try{
            return bookClassService.findListByName(name);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 根据id查找分类信息
     * @param id 数据主键
     * @return
     */
    @RequestMapping("/findById")
    public ResultDTO findById(int id) {
        try{
            return bookClassService.findById(id);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 新增
     * @param bookClassDTO 数据实体类
     * @return
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookClassDTO bookClassDTO) {
        try{
            return bookClassService.insert(bookClassDTO);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 更新
     * @param bookClassDTO 数据实体类
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(BookClassDTO bookClassDTO) {
        try{
            return bookClassService.update(bookClassDTO);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }

    /**
     * 根据id删除分类信息
     * @param id 数据主键
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO update(int id) {
        try{
            return bookClassService.delete(id);
        } catch(Exception e) {
            logger.error("系统异常" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(),"系统异常");
        }
    }
}
