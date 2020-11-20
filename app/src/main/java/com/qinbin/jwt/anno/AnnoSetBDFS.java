package com.qinbin.jwt.anno;

import java.lang.reflect.Field;

public class AnnoSetBDFS implements Comparable<AnnoSetBDFS>{
	
	private final Field field;
	private final Basic basic;
	private final Dict dict;
	private final Form form;
	private final Show show;

	public AnnoSetBDFS(Field field,Basic basic, Dict dict, Form form, Show show) {
		if(field == null || basic ==null){
			throw new IllegalArgumentException("basic shoul NOT be null!");
		}
		this.field = field;
		this.basic = basic;
		this.dict = dict;
		this.form = form;
		this.show = show;
	}

	public boolean isNull() {
		return basic == null & dict == null & form == null & show == null;
	}

	@Override
	public int compareTo(AnnoSetBDFS another) {
		if(Double.compare(this.basic.index(), another.basic.index()) ==0){
			return this.basic.title().compareTo(another.basic.title());
		}else{
			return Double.compare(this.basic.index(), another.basic.index());
		}
	}

	public Field getField() {
		return field;
	}

	public Basic getBasic() {
		return basic;
	}

	public Dict getDict() {
		return dict;
	}

	public Form getForm() {
		return form;
	}

	public Show getShow() {
		return show;
	}

	@Override
	public String toString() {
		return "AnnoSetBDFS [field=" + field + ", basic=" + basic + ", dict=" + dict + ", form=" + form + ", show="
				+ show + "]";
	}
	
	
}
