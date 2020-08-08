package com.wuhan.mall.util;
/**
 * 全局常量定义
 *
 */
public class GlobalConstant {
	
	/** 请求数据字符编码 */
	public static final String PLATFORM_CHARACTER_ENCODING = "UTF-8";
	/** 请求数据格式类型 */
	public static final String PLATFORM_RESPONSE_CONTENTTYPE_JSON = "application/json";
	/** 请求数据格式类型 */
    public  static final String CONTENTTYPE_JSON_UTF_8 = "application/json;charset=utf-8";
    
    /** 数据库类型 */
    public  static final String DB_DIALECT_TYPE = "mysql";
    
	/** 判断IP格式和范围 */
	public static final String REGEX_IP = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
	/** 正则表达式：验证手机号 */
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

}
