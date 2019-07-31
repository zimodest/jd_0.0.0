package com.modest.service.impl;

import com.modest.dao.CategoryDao;
import com.modest.dao.impl.CategoryDaoImpl;
import com.modest.domain.Category;
import com.modest.service.CategoryService;
import com.modest.utils.CacheUtils;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.List;
import java.util.Objects;

/**
 * description
 *
 * @author modest
 * @date 2019/07/28
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() throws Exception{

        /**
         * 缓存的逻辑
         * 1）从缓存中获取数据(集合数据)
         * 2）判断集合中是否存在数据
         *      如果不存在
         *          直接读取数据库中的信息
         *          将当前读取的数据添加到缓存中
         *      如果存在
         *          直接在缓存中获取
         */

        //缓存处理器
//        CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
//
//        //通过缓存文件中的标识名称来获取缓存对象
//        Cache cache = cacheManager.getCache("categoryCache");
        Cache cache = CacheUtils.getCache();

        Element element = cache.get("cList");

        List<Category> list = null;
        if (Objects.isNull(element)) {
            System.out.println("当前分类信息数据从后台数据库获取...");
            list = categoryDao.findAll();
            cache.put(new Element("cList",list));
        } else {
            System.out.println("当前分类信息从缓存中获取");
            list = (List<Category>) element.getObjectValue();
        }


        return list;
    }
}
