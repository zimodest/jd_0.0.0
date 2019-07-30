package com.modest.service;

import com.modest.domain.Category;

import java.util.List;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public interface CategoryService {
    List<Category> findAll() throws Exception;
}
