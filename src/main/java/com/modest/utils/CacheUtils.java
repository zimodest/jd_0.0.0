package com.modest.utils;

import com.modest.service.impl.CategoryServiceImpl;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * description
 *
 * @author modest
 * @date 2019/07/31
 */
public class CacheUtils {

    private static Cache cache = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"))
            .getCache("categoryCache");

    private CacheUtils() {}


    public static Cache getCache() {
        return cache;
    }

}
