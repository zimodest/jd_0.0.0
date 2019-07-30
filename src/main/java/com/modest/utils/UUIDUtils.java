package com.modest.utils;

import java.util.UUID;

/**
 * @author
 */
public class UUIDUtils {
	/**
	 * 随机生成id
	 * UUID.randomUUID().toString()返回结果是：44e128a5-ac7a-4c9a-be4c-224b6bf81b20
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 生成随机码
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
	
	public static void main(String[] args) {
		System.out.println(getId());
	}
}
