package com.qinbin.jwt.domin;

import com.qinbin.jwt.R;

public enum RwtxEnum {
	RY1(R.drawable.ry,"人员1",RyJbxx.class),
	JG1(R.drawable.jg,"机构1",JgJbxx.class),
	RY2(R.drawable.ry,"人员2",RyJbxx.class),
	JDC1(R.drawable.jdc,"机动车1",Jdc.class),
	JG2(R.drawable.jg,"机构2",JgJbxx.class),
	JDC2(R.drawable.jdc,"机动车2",Jdc.class),
	RY3(R.drawable.ry,"人员3",RyJbxx.class),
	JDC4(R.drawable.jdc,"机动车4",Jdc.class),
	JG3(R.drawable.jg,"机构3",JgJbxx.class),
	JDC3(R.drawable.jdc,"机动车3",Jdc.class),
	JG4(R.drawable.jg,"机构4",JgJbxx.class);
	
	private final int iconRes;
	private final String type;
	private final Class<?> klass;
	private RwtxEnum(int iconRes, String type, Class<?> klass) {
		this.iconRes = iconRes;
		this.type = type;
		this.klass = klass;
	}
	public int getIconRes() {
		return iconRes;
	}
	public String getType() {
		return type;
	}
	public Class<?> getKlass() {
		return klass;
	}

	
}
