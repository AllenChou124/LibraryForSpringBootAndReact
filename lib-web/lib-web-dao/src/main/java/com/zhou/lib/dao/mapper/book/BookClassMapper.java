package com.zhou.lib.dao.mapper.book;

import com.zhou.lib.api.model.book.BookClassDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 12418
 */
@Mapper
public interface BookClassMapper {
    /**
     * 根据名称模糊查询全部分类信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    List<BookClassDTO> findListByName(String name);

    /**
     *  新增
     * @param entity 实体类（不包含ID）
     * @return 影响的是哪一行
     */
    int insert(BookClassDTO entity);

    /**
     * 根据id查找数据
     * @param id 数据ID
     * @return
     */

    BookClassDTO findById(int id);
    /**
     *  更新
     * @param entity 实体类（包含ID）
     * @return 影响的是哪一行
     */
    int update(BookClassDTO entity);
    /**
     *  新增
     * @param id 数据主键
     * @return 影响的是哪一行
     */
    int delete(int id);
}
