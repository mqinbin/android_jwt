package com.qinbin.jwt.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictConstant {

	/** 车辆-号牌种类 */
	public static final String CL_HPZL = "CL_HPZL";
	/** 车辆-车身颜色 */
	public static final String CL_CSYS = "CL_CSYS";
	/** 车辆-燃料种类 */
	public static final String CL_RLZL = "CL_RLZL";
	/** 车辆-状态̬ */
	public static final String CL_ZT = "CL_ZT";

	/** 人员-性别 */
	public static final String RY_XB = "RY_XB";
	/** 人员-证件种类 */
	public static final String RY_ZJZL = "RY_ZJZL";
	/** 人员-民族 */
	public static final String RY_MZ = "RY_MZ";
	/** 人员-宗教信仰 */
	public static final String RY_ZJXY = "RY_ZJXY";
	/** 人员-政治面貌 */
	public static final String RY_ZZMM = "RY_ZZMM";
	/** 人员-文化程度 */
	public static final String RY_WHCD = "RY_WHCD";
	/** 人员-户口种类 */
	public static final String RY_HYZK = "RY_HYZK";
	/** 人员-兵役状况 */
	public static final String RY_BY = "RY_BY";
	/** 人员-职业类别 */
	public static final String RY_ZYLB = "RY_ZYLB";
	/** 人员-血型 */
	public static final String RY_XX = "RY_XX";
	/** 人员-身份 */
	public static final String RY_SF = "RY_SF";
	/** 人员-户口类别 */
	public static final String RY_HKLB = "RY_HKLB";
	/** 人员-类别 */
	public static final String RY_LB = "RY_LB";
	/** 人员-属性 */
	public static final String RY_SX = "RY_SX";
	/** 人员-专长 */
	public static final String RY_ZC = "RY_ZC";
	/** 人员-职务 */
	public static final String RY_ZW = "RY_ZW";
	/** 人员-口音 */
	public static final String RY_KY = "RY_KY";

	/** 机构-行业类别*/
	public static final String JG_HYLB = "JG_HYLB";
	/** 机构-管理部门*/
	public static final String JG_GLBM = "JG_GLBM";
	/** 机构-管理级别*/
	public static final String JG_GLJB = "JG_GLJB";
	/** 机构-重点等级*/
	public static final String JG_ZDDJ = "JG_ZDDJ";
	/** 机构-消防等级*/
	public static final String JG_XFDJ = "JG_XFDJ";
	/** 机构-单位类型*/
	public static final String JG_DWLX = "JG_DWLX";
	/** 机构-单位属性*/
	public static final String JG_DWSX = "JG_DWSX";

	/** 地址-街路巷 */
	public static final String DZ_JLX = "DZ_JLX";
	/** 地址 -门牌后缀 */
	public static final String DZ_MPHZ = "DZ_MPHZ";

	/** 保密级别 */
	public static final String TC_BMJB = "TC_BMJB";
	/** 责任区 */
	public static final String TC_ZRQ = "TC_ZRQ";
	/** 注销标识 */
	public static final String TC_ZXBS = "TC_ZXBS";
	/** 信息级别 */
	public static final String TC_XXJB = "TC_XXJB";
	/** 国家地区 */
	public static final String TC_GJDQ = "TC_GJDQ";
	/** 行政区划 */
	public static final String TC_XZQH = "TC_XZQH";

	/** 多层字典 */
	private static final Set<String> LEVEL_DICTSET;
	/** 字典层级 */
	private static final Map<String,int[]> LEVEL_DICMAP;
	
	/** 位字典 */
	private static final Set<String> BIT_DICTSET;

	static {
		Map<String,int[]> levelMap = new HashMap<String, int[]>();
		HashSet<String> levelSet = new HashSet<String>();
		levelSet.add(TC_XZQH);
		levelMap.put(TC_XZQH, new int[]{2,2,2});
		levelSet.add(TC_ZRQ);
		levelMap.put(TC_ZRQ, new int[]{6,2});
		
		// TODO add more dict
		
		
		LEVEL_DICTSET = Collections.unmodifiableSet(levelSet);
		LEVEL_DICMAP = Collections.unmodifiableMap(levelMap);
		assert(LEVEL_DICTSET.size() == LEVEL_DICMAP.size());
		
		
		HashSet<String> bitSet = new HashSet<String>();
		bitSet.add(RY_SX);
		bitSet.add(JG_DWSX);
		// TODO add more dict
		BIT_DICTSET = Collections.unmodifiableSet(levelSet);
	}

	public static boolean isLevelDict(String dictName) {
		return LEVEL_DICTSET.contains(dictName);
	}
	
	public static int[] dictLvs(String dictName) {
		return LEVEL_DICMAP.get(dictName);
	}
	

	public static boolean isBitDict(String dictName) {
		return BIT_DICTSET.contains(dictName);
	}
}
