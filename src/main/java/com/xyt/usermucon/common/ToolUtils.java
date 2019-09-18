package com.xyt.usermucon.common;

import lh.toolclass.LhClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ToolUtils {
    private static Logger logger = LoggerFactory.getLogger(ToolUtils.class);
    public static String getPowerKey(short port) throws Exception {
        return LhClass.getPowerKey(port);
    }

    /**
          * 实体类转map
          * @param obj
          * @return
          */
    public static Map<String, Object> convertBeanToMap(Object obj) {
        if (obj == null) {
         return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                  // 得到property对应的getter方法
                   Method getter = property.getReadMethod();
                   Object value = getter.invoke(obj);
                   if(null==value){
                      map.put(key,"");
                   }else{
                    map.put(key,value);
                }
              }

            }
        } catch (Exception e) {
           logger.info("convertBean2Map Error {}" ,e);
        }
         return map;
        }

}
