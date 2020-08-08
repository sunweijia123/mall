package com.wuhan.mall.util;

import java.util.Collection;
import java.util.Map;

/**
 * 判空工具类
 */
public class EmptyUtil {

    //判空
    public static boolean isEmpty(Object obj){
        if (obj == null)
            return true;
        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;
        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();
        if (obj instanceof Map)
            return ((Map) obj).isEmpty();
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    //非空验证
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }
    private boolean validPropertyEmpty(Object ...args) {
        for (int i = 0; i < args.length; i++) {
            if(EmptyUtil.isEmpty(args[i])){
                return true;
            }
        }
        return false;
    }

}
