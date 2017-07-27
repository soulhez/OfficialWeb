package util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.sun.org.apache.commons.beanutils.BeanUtils;
/**
 * JavaBeanπ§æﬂ¿‡
 * @author 22386
 *
 */
public class WebUtils {
	public static <T> T beanFrom(HttpServletRequest request,Class<T> from){
		T bean;
		try {
			bean = from.newInstance();
			Enumeration<String> names=request.getParameterNames();
			while (names.hasMoreElements()) {
				String name =names.nextElement();
				String value=request.getParameter(name);
				BeanUtils.copyProperty(bean, name, value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return bean;
	}
	public static void copyBean(Object a,Object b){
		try {
			BeanUtilsBean beanUtilsBean = new BeanUtilsBean();  
			beanUtilsBean.copyProperties(a, b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
