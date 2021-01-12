package com.zhou.lib.api.service.book;

import com.zhou.lib.api.constants.ResultDTO;
import com.zhou.lib.api.model.book.BookClassDTO;

import java.util.List;


/**
 * @author 12418
 */
public interface BookClassService {
    /**
     * 根据名称模糊查询全部分类信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    ResultDTO findListByName(String name);

    /**
     *  新增
     * @param entity 实体类（不包含ID）
     * @return 影响的是哪一行
     */
    ResultDTO insert(BookClassDTO entity);

    /**
     * 根据id查找数据
     * @param id 数据ID
     * @return
     */

    ResultDTO findById(int id);
    /**
     *  更新
     * @param entity 实体类（包含ID）
     * @return 影响的是哪一行
     */
    ResultDTO update(BookClassDTO entity);
    /**
     *  新增
     * @param id 数据主键
     * @return 影响的是哪一行
     */
    ResultDTO delete(int id);
}
