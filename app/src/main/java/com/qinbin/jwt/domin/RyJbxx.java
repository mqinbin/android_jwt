package com.qinbin.jwt.domin;

import java.io.Serializable;

import com.qinbin.jwt.anno.Basic;
import com.qinbin.jwt.anno.Dict;
import com.qinbin.jwt.anno.Form;
import com.qinbin.jwt.anno.Show;
import com.qinbin.jwt.anno.Title;
import com.qinbin.jwt.constant.DictConstant;
import com.qinbin.jwt.ui.widget.SmartInputLine;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "RY")
@Title("公民")
public class RyJbxx implements Serializable {
	private static final long serialVersionUID = -4574029970070962598L;

	public RyJbxx() {
	}

	@DatabaseField(generatedId = true)
	@Basic(title = "人员编号", index = 1, lines = 1)
	@Show(simple = false, detail = false, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = false)
	private int rybh;
	@DatabaseField()
	@Basic(title = "公民身份证号", index = 2, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_IDCARD, necessary = true, show = true)
	private String gmsfhm;
	@DatabaseField()
	@Basic(title = "姓名", index = 3, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String xm;
	@DatabaseField()
	@Basic(title = "出生日期", index = 4, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = true, show = true)
	private String csrq;
	@DatabaseField()
	@Basic(title = "曾用名", index = 5, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String cym;
	@DatabaseField()
	@Basic(title = "别名绰号", index = 6, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String bmch;
	@DatabaseField()
	@Basic(title = "英文姓", index = 7, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String ywx;
	@DatabaseField()
	@Basic(title = "英文名", index = 8, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String ywm;
	@DatabaseField()
	@Dict(DictConstant.RY_ZJZL)
	@Basic(title = "证件种类", index = 9, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String zjzl;
	@DatabaseField()
	@Basic(title = "证件号码", index = 10, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zjhm;
	@DatabaseField()
	@Dict(DictConstant.RY_XB)
	@Basic(title = "性别", index = 11, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String xb;
	@DatabaseField()
	@Dict(DictConstant.RY_MZ)
	@Basic(title = "民族", index = 12, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String mz;
	@DatabaseField()
	@Dict(DictConstant.RY_ZJXY)
	@Basic(title = "宗教信仰", index = 13, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String zjxy;
	@DatabaseField()
	@Dict(DictConstant.RY_ZZMM)
	@Basic(title = "政治面貌", index = 14, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String zzmm;
	@DatabaseField()
	@Dict(DictConstant.RY_WHCD)
	@Basic(title = "文化程度", index = 15, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String whcd;
	@DatabaseField()
	@Dict(DictConstant.RY_HYZK)
	@Basic(title = "婚姻状况", index = 16, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String hyzk;
	@DatabaseField()
	@Dict(DictConstant.RY_BY)
	@Basic(title = "兵役状况", index = 17, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String byzk;
	@DatabaseField()
	@Basic(title = "身高", index = 18, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = false, show = true)
	private String sg;
	@DatabaseField()
	@Dict(DictConstant.RY_ZYLB)
	@Basic(title = "职业类别", index = 19, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String zylb;
	@DatabaseField()
	@Basic(title = "服务处所", index = 20, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String fwcs;
	@DatabaseField()
	@Dict(DictConstant.RY_XX)
	@Basic(title = "血型", index = 21, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String xx;
	@DatabaseField()
	@Dict(DictConstant.RY_SF)
	@Basic(title = "身份", index = 22, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICTS, necessary = false, show = true)
	private String sf;
	@DatabaseField()
	@Basic(title = "职业", index = 23, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zy;
	@DatabaseField()
	@Basic(title = "联系电话", index = 24, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_PHONE, necessary = true, show = true)
	private String lxdh;
	@DatabaseField()
	@Dict(DictConstant.RY_HKLB)
	@Basic(title = "户口类型", index = 25, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String hklx;
	@DatabaseField()
	@Dict(DictConstant.RY_LB)
	@Basic(title = "人员类别", index = 26, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String rylb;
	@DatabaseField()
	@Dict(DictConstant.RY_SX)
	@Basic(title = "人员属性", index = 27, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICTS, necessary = true, show = true)
	private String rysx;
	@DatabaseField()
	@Basic(title = "人员住址编号", index = 28, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String ryzzbh;
	@DatabaseField()
	@Dict(DictConstant.RY_ZC)
	@Basic(title = "专长", index = 29, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICTS, necessary = false, show = true)
	private String zc;
	@DatabaseField()
	@Dict(DictConstant.RY_ZW)
	@Basic(title = "职务", index = 30, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String zw;
	@DatabaseField()
	@Dict(DictConstant.RY_KY)
	@Basic(title = "中文水平", index = 31, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String zwsp;
	@DatabaseField()
	@Basic(title = "死亡日期", index = 32, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String swrq;
	@DatabaseField()
	@Basic(title = "死亡证明编号", index = 33, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String swzmbh;
	@DatabaseField()
	@Dict(DictConstant.TC_GJDQ)
	@Basic(title = "国家地区", index = 34, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String gjdq;
	@DatabaseField()
	@Basic(title = "出生时间", index = 35, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String cssj;
	@DatabaseField()
	@Basic(title = "出生证明编号", index = 36, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String cszmbh;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "出生地区", index = 37, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String csdq;
	@DatabaseField()
	@Basic(title = "出生详址", index = 38, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String csxz;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "出生区县", index = 39, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String csqx;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "籍贯地区", index = 40, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String jgdq;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "籍贯区县", index = 41, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String jgqx;
	@DatabaseField()
	@Basic(title = "籍贯详址", index = 42, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String jgxz;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "户籍区划", index = 43, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String hjqh;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "户籍区划名称", index = 44, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String hjqhmc;
	@DatabaseField()
	@Basic(title = "户籍责任区", index = 45, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String hjzrq;
	@DatabaseField()
	@Basic(title = "户籍详址", index = 46, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String hjxz;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "现住址区划", index = 47, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String xzzqh;
	@DatabaseField()
	@Basic(title = "现住址区划名称", index = 48, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String xzzqhmc;
	@DatabaseField()
	@Dict(DictConstant.TC_ZRQ)
	@Basic(title = "现住址责任区", index = 49, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String xzzzrq;
	@DatabaseField()
	@Basic(title = "现住址详址", index = 50, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String xzzxz;
	@DatabaseField()
	@Dict(DictConstant.TC_XXJB)
	@Basic(title = "信息级别", index = 51, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String xxjb;
	@DatabaseField()
	@Basic(title = "指纹编号", index = 52, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zwbh;
	@DatabaseField()
	@Basic(title = "DNA编号", index = 53, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String dnabh;

	public int getRybh() {
		return rybh;
	}

	public void setRybh(int rybh) {
		this.rybh = rybh;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
	}

	public String getBmch() {
		return bmch;
	}

	public void setBmch(String bmch) {
		this.bmch = bmch;
	}

	public String getYwx() {
		return ywx;
	}

	public void setYwx(String ywx) {
		this.ywx = ywx;
	}

	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	public String getZjzl() {
		return zjzl;
	}

	public void setZjzl(String zjzl) {
		this.zjzl = zjzl;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getZjxy() {
		return zjxy;
	}

	public void setZjxy(String zjxy) {
		this.zjxy = zjxy;
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	public String getByzk() {
		return byzk;
	}

	public void setByzk(String byzk) {
		this.byzk = byzk;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getZylb() {
		return zylb;
	}

	public void setZylb(String zylb) {
		this.zylb = zylb;
	}

	public String getFwcs() {
		return fwcs;
	}

	public void setFwcs(String fwcs) {
		this.fwcs = fwcs;
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getHklx() {
		return hklx;
	}

	public void setHklx(String hklx) {
		this.hklx = hklx;
	}

	public String getRylb() {
		return rylb;
	}

	public void setRylb(String rylb) {
		this.rylb = rylb;
	}

	public String getRysx() {
		return rysx;
	}

	public void setRysx(String rysx) {
		this.rysx = rysx;
	}

	public String getRyzzbh() {
		return ryzzbh;
	}

	public void setRyzzbh(String ryzzbh) {
		this.ryzzbh = ryzzbh;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getZwsp() {
		return zwsp;
	}

	public void setZwsp(String zwsp) {
		this.zwsp = zwsp;
	}

	public String getSwrq() {
		return swrq;
	}

	public void setSwrq(String swrq) {
		this.swrq = swrq;
	}

	public String getSwzmbh() {
		return swzmbh;
	}

	public void setSwzmbh(String swzmbh) {
		this.swzmbh = swzmbh;
	}

	public String getGjdq() {
		return gjdq;
	}

	public void setGjdq(String gjdq) {
		this.gjdq = gjdq;
	}

	public String getCssj() {
		return cssj;
	}

	public void setCssj(String cssj) {
		this.cssj = cssj;
	}

	public String getCszmbh() {
		return cszmbh;
	}

	public void setCszmbh(String cszmbh) {
		this.cszmbh = cszmbh;
	}

	public String getCsdq() {
		return csdq;
	}

	public void setCsdq(String csdq) {
		this.csdq = csdq;
	}

	public String getCsxz() {
		return csxz;
	}

	public void setCsxz(String csxz) {
		this.csxz = csxz;
	}

	public String getCsqx() {
		return csqx;
	}

	public void setCsqx(String csqx) {
		this.csqx = csqx;
	}

	public String getJgdq() {
		return jgdq;
	}

	public void setJgdq(String jgdq) {
		this.jgdq = jgdq;
	}

	public String getJgqx() {
		return jgqx;
	}

	public void setJgqx(String jgqx) {
		this.jgqx = jgqx;
	}

	public String getJgxz() {
		return jgxz;
	}

	public void setJgxz(String jgxz) {
		this.jgxz = jgxz;
	}

	public String getHjqh() {
		return hjqh;
	}

	public void setHjqh(String hjqh) {
		this.hjqh = hjqh;
	}

	public String getHjqhmc() {
		return hjqhmc;
	}

	public void setHjqhmc(String hjqhmc) {
		this.hjqhmc = hjqhmc;
	}

	public String getHjzrq() {
		return hjzrq;
	}

	public void setHjzrq(String hjzrq) {
		this.hjzrq = hjzrq;
	}

	public String getHjxz() {
		return hjxz;
	}

	public void setHjxz(String hjxz) {
		this.hjxz = hjxz;
	}

	public String getXzzqh() {
		return xzzqh;
	}

	public void setXzzqh(String xzzqh) {
		this.xzzqh = xzzqh;
	}

	public String getXzzqhmc() {
		return xzzqhmc;
	}

	public void setXzzqhmc(String xzzqhmc) {
		this.xzzqhmc = xzzqhmc;
	}

	public String getXzzzrq() {
		return xzzzrq;
	}

	public void setXzzzrq(String xzzzrq) {
		this.xzzzrq = xzzzrq;
	}

	public String getXzzxz() {
		return xzzxz;
	}

	public void setXzzxz(String xzzxz) {
		this.xzzxz = xzzxz;
	}

	public String getXxjb() {
		return xxjb;
	}

	public void setXxjb(String xxjb) {
		this.xxjb = xxjb;
	}

	public String getZwbh() {
		return zwbh;
	}

	public void setZwbh(String zwbh) {
		this.zwbh = zwbh;
	}

	public String getDnabh() {
		return dnabh;
	}

	public void setDnabh(String dnabh) {
		this.dnabh = dnabh;
	}

	@Override
	public String toString() {
		return "RyJbxx [rybh=" + rybh + ", gmsfhm=" + gmsfhm + ", xm=" + xm + ", csrq=" + csrq + ", cym=" + cym
				+ ", bmch=" + bmch + ", ywx=" + ywx + ", ywm=" + ywm + ", zjzl=" + zjzl + ", zjhm=" + zjhm + ", xb="
				+ xb + ", mz=" + mz + ", zjxy=" + zjxy + ", zzmm=" + zzmm + ", whcd=" + whcd + ", hyzk=" + hyzk
				+ ", byzk=" + byzk + ", sg=" + sg + ", zylb=" + zylb + ", fwcs=" + fwcs + ", xx=" + xx + ", sf=" + sf
				+ ", zy=" + zy + ", lxdh=" + lxdh + ", hklx=" + hklx + ", rylb=" + rylb + ", rysx=" + rysx
				+ ", ryzzbh=" + ryzzbh + ", zc=" + zc + ", zw=" + zw + ", zwsp=" + zwsp + ", swrq=" + swrq
				+ ", swzmbh=" + swzmbh + ", gjdq=" + gjdq + ", cssj=" + cssj + ", cszmbh=" + cszmbh + ", csdq=" + csdq
				+ ", csxz=" + csxz + ", csqx=" + csqx + ", jgdq=" + jgdq + ", jgqx=" + jgqx + ", jgxz=" + jgxz
				+ ", hjqh=" + hjqh + ", hjqhmc=" + hjqhmc + ", hjzrq=" + hjzrq + ", hjxz=" + hjxz + ", xzzqh=" + xzzqh
				+ ", xzzqhmc=" + xzzqhmc + ", xzzzrq=" + xzzzrq + ", xzzxz=" + xzzxz + ", xxjb=" + xxjb + ", zwbh="
				+ zwbh + ", dnabh=" + dnabh + "]";
	}

}
