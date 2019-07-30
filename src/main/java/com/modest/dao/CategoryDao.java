package com.modest.dao;

import com.modest.domain.Category;

import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/24
 */
public interface CategoryDao {
    List<Category> findAll() throws Exception;
}
