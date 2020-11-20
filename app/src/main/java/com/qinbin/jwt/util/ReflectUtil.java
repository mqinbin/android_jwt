package com.qinbin.jwt.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import android.graphics.Shader.TileMode;

import com.qinbin.jwt.anno.AnnoSetBDFS;
import com.qinbin.jwt.anno.Basic;
import com.qinbin.jwt.anno.Dict;
import com.qinbin.jwt.anno.Form;
import com.qinbin.jwt.anno.Show;
import com.qinbin.jwt.anno.Title;

public class ReflectUtil {

	private static HashMap<String, Field[]> cfCache = new HashMap<String, Field[]>();

	public static Field[] getDeclaredAccessibleFields(Class<?> kls) {
		String className = kls.getName();
		if (!cfCache.containsKey(className)) {
			Field[] fs = kls.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				fs[i].setAccessible(true);
			}
			cfCache.put(className, fs);
		}
		return cfCache.get(className);
	}

	private static HashMap<String, AnnoSetBDFS[]> caCache = new HashMap<String, AnnoSetBDFS[]>();

	public static AnnoSetBDFS[] getOrderedAnnoBDFS(Class<?> kls) {
		String className = kls.getName();
		System.out.println("className" + className);
		if (!caCache.containsKey(className)) {
			Field[] fields = getDeclaredAccessibleFields(kls);
			List<AnnoSetBDFS> result = new ArrayList<AnnoSetBDFS>();
			for (int i = 0; i < fields.length; i++) {
				System.out.println("i" + i);
				if (fields[i].isAnnotationPresent(Basic.class)) {
					System.out.println(fields[i].isAnnotationPresent(Basic.class));
					result.add(new AnnoSetBDFS(fields[i], fields[i].getAnnotation(Basic.class), fields[i]
							.getAnnotation(Dict.class), fields[i].getAnnotation(Form.class), fields[i]
							.getAnnotation(Show.class)));
				}
			}
			Collections.sort(result);
			caCache.put(className, result.toArray(new AnnoSetBDFS[result.size()]));

		}
		return caCache.get(className);
	}

	public static String getFieldStringValue(Field field, Object o) {
		field.setAccessible(true);
		Object vaule = null;
		try {
			vaule = field.get(o);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("the object gived has no such field");
		}
		if (vaule == null) {
			return "";
		} else {
			return vaule.toString();
		}
	}

	public static boolean setFieldValue(Field field, Object o, String value) {
		field.setAccessible(true);
		try {
			field.set(o, value);
			return true;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("field type is not String or field and object not match");
		}
		return false;

	}
	
	public static String getTitlte(Class<?> klass){
		if(klass.isAnnotationPresent(Title.class)){
			return klass.getAnnotation(Title.class).value();
		}else{
			return "";
		}
	}
}
