package com.spring.util;

import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import oracle.sql.CLOB;

public class ObjectUtil {
	
    /**
     * 判断对象是否为空,为空返回true否则返回false
     * 
     * @param obj
     *            待判断对象
     * @return boolean
     */
    public static boolean isEmpty(Object obj) {
	if (obj == null) {
	    return true;
	}

	if (obj instanceof Collection) {
	    Collection<?> c = (Collection<?>) obj;
	    return c.size() < 1;
	}

	if (obj instanceof String) {
	    String s = (String) obj;
	    if ("null".equals(s.toLowerCase())) {
		return true;
	    }
	    return s.isEmpty();
	}
	return false;
    }

    /**
     * 判断元素是否有为空的
     * 
     * @param objs
     * @return
     */
    public static boolean isEmptyOr(Object... objs) {
	boolean b = false;
	for (Object object : objs) {
	    b |= isEmpty(object);
	}
	return b;
    }

    /**
     * 判断元素是否都为空
     * 
     * @param objects
     * @return
     */
    public static boolean isEmptyAnd(Object... objects) {
	boolean b = true;
	for (Object object : objects) {
	    b &= isEmpty(object);
	}
	return b;
    }

    /**
     * 判断对象是否不为空,非空返回true否则返回false
     * 
     * @param obj
     *            待判断对象
     * @return boolean;
     */
    public static boolean isNotEmpty(Object obj) {
	return !isEmpty(obj);
    }

    /**
     * 将Object转换为字符串,如果为null返回"",否则返回toString
     * 
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
	if (obj == null) {
	    return "";
	}
	if (obj instanceof Integer) {
	    return obj + "";
	} else {
	    return obj.toString();
	}
    }

    /**
     * @param String
     * @return boolean
     */
    public static boolean isNumeric(String str) {
	for (int i = str.length(); --i >= 0;) {
	    if (!Character.isDigit(str.charAt(i))) {
		return false;
	    }
	}
	return true;
    }

    
    public static String hideName(String name, String hideName) {
	if (hideName.equals("true") && ObjectUtil.isNotEmpty(name)) {
	   return name.substring(0, 1) + "**";
	}
	return name;
    }
    
    public static String listToString(List<String> list,String separator){
    	StringBuilder s = new StringBuilder();
    	for(int i=0;i<list.size();i++){
    		s.append(list.get(i)).append(separator);
    	}
    	return s.toString().substring(0,s.toString().length()-separator.length());
    }
    
  //oracle.sql.Clob类型转换成String类型
    public static String ClobToString(CLOB clob) {
        String reString = "";
        Reader is = null;
        try {
            is = clob.getCharacterStream();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            //执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try {
                s = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }
    
    /**
     * 把LIST<BEAN> 转LIST<hashmap>
     * @param obj  new一个bean对象
     * @param dataIni LIST<BEAN>
     * @return LIST<hashmap>
     * @throws Exception
     */
    public static ArrayList ListBeanToListMap(Object obj, List dataIni) throws Exception {
    	ArrayList dataList = new ArrayList();

    	Object objTmp = null;
    	for (int i = 0; i < dataIni.size(); i++) {
    	    HashMap dataMap = new HashMap();
    	    Object a = null;
    	    Class ownerClass = obj.getClass();

    	    Object bpoObj = null;

    	    bpoObj = ownerClass.newInstance();

    	    bpoObj = dataIni.get(i);

    	    Field[] abc = ownerClass.getDeclaredFields();

    	    String pd_name = "";
    	    dataMap.clear();
    	    for (Field f : abc) {
    		PropertyDescriptor pd = null;

    		pd = new PropertyDescriptor(f.getName(), ownerClass);

    		pd_name = pd.getName();

    		Method rM = pd.getReadMethod();// 获得读方法

    		objTmp = rM.invoke(bpoObj, new Object[] {});
    		// System.out.println(objTmp.getClass());
    		// 对数据库记录为空 但查询出来为NULL的数据转换
    		if (null == objTmp) {
    		    objTmp = "";
    		}
    		// if (objTmp.getClass().isInstance(String.class))
    		// {
    		// if(((String)objTmp).equals("null"))
    		// {
    		// objTmp="";
    		// }
    		// }

    		dataMap.put(pd_name, objTmp);
    	    }
    	    dataList.add(dataMap);
    	}

    	return dataList;
        }
}
