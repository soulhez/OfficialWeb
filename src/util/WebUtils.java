package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
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
	public static String getPath(HttpServletRequest request){
		return request.getSession().getServletContext().getRealPath("/")+"\\news\\";
	}
	@SuppressWarnings("unchecked")
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
	public static int newFile(String path,String fileName,String content){
		int num=0;
		File file=new File(path+fileName+".txt");
		Writer writer=null;
		BufferedWriter bwriter=null;
		try {
			writer=new FileWriter(file);
			bwriter=new BufferedWriter(writer);
			try {
				bwriter.write(content);
				num=1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(bwriter!=null){
				try {
					bwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return num;
	}
	public static String readFile(String path,String name){
		String str=null;
		File file=new File(path+name+".txt");
		InputStreamReader isr = null;
		BufferedReader breader=null;
		try {
			isr=new InputStreamReader(new FileInputStream(file), "UTF-8");
			breader=new BufferedReader(isr);
			str=breader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(breader!=null){
				try {
					breader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr!=null){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return str; 
	}
	public static boolean deleteFile(String path,String name){
		File file=new File(path+name+".txt");
		return file.delete();
	}
}
