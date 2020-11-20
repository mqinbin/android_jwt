package com.qinbin.jwt.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.qinbin.jwt.ui.widget.SmartInputLine;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Form {
	/** see SmartInputLine.TYPE_* */
	public int type() default SmartInputLine.TYPE_EDIT;
	public boolean show() default true;
	public boolean necessary() default true;
}
