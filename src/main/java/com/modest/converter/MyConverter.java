package com.modest.converter;


import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * description
 *
 * @author modest
 * @date 2019/07/18
 */
public class MyConverter implements Converter {
    /**
     *
     * @param aClass 需要被转换的类
     * @param value 需要转换的对象
     * @return
     */
    @Override
    public Object convert(Class aClass, Object value) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse((String)value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
