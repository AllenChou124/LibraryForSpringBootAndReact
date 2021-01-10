package com.zhou.lib.api.model.book;

import com.zhou.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 书籍分类实体类
 */
@Data
public class BookClassDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 6388571251266099182L;
    /**
     * 分类名称
     */
    private String name;
}
