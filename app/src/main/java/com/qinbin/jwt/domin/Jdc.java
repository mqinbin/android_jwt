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

/** 机动车 */
@DatabaseTable(tableName = "JDC")
@Title("机动车")
public class Jdc implements Serializable {

	private static final long serialVersionUID = -4952877872462176329L;

	public Jdc() {
	}

	@DatabaseField()
	@Basic(title = "机动车所有人", index = 1, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String jdcsyr;
	@DatabaseField()
	@Basic(title = "车主身份证号", index = 2, lines = 1)
	@Show(simple = true, detail = true, weight = 6)
	@Form(type = SmartInputLine.TYPE_IDCARD, necessary = true, show = true)
	private String sfzh;
	@DatabaseField()
	@Basic(title = "车主联系方式", index = 3, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_PHONE, necessary = true, show = true)
	private String lxfs;
	@DatabaseField()
	@Basic(title = "登记住址详址", index = 4, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String djzzxz;
	@DatabaseField()
	@Basic(title = "住址地址详址", index = 5, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zzdzxz;
	@DatabaseField()
	@Dict(DictConstant.RY_ZJZL)
	@Basic(title = "身份证件种类", index = 6, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String sfzjzl;
	@DatabaseField()
	@Dict(DictConstant.CL_HPZL)
	@Basic(title = "号牌类型", index = 7, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String hpzl;
	@DatabaseField()
	@Basic(title = "号牌号码", index = 8, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_CARID, necessary = true, show = true)
	private String hphm;
	@DatabaseField()
	@Basic(title = "车辆品牌", index = 9, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String clpp1;
	@DatabaseField()
	@Dict(DictConstant.CL_CSYS)
	@Basic(title = "车身颜色 ", index = 10, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String csys;
	@DatabaseField()
	@Basic(title = "车辆型号", index = 11, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String clxh;
	@DatabaseField()
	@Basic(title = "车辆识别代号", index = 12, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String clsbdh;
	@DatabaseField()
	@Basic(title = "初次登记日期", index = 13, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String ccdjrq;
	@DatabaseField()
	@Basic(title = "出厂日期", index = 14, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String ccrq;
	@DatabaseField()
	@Basic(title = "发动机型号", index = 15, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String fdjxh;
	@DatabaseField()
	@Basic(title = "发动机号", index = 16, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String fdjh;
	@DatabaseField()
	@Basic(title = "核定载质量", index = 17, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String hdzzl;
	@DatabaseField()
	@Basic(title = "功率", index = 18, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = false, show = true)
	private String gl;
	@DatabaseField()
	@Basic(title = "总质量", index = 19, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = false, show = true)
	private String zzl;
	@DatabaseField()
	@Basic(title = "排量", index = 20, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = false, show = true)
	private String pl;
	@DatabaseField()
	@Dict(DictConstant.CL_RLZL)
	@Basic(title = "燃料种类", index = 21, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String rlzl;
	@DatabaseField()
	@Dict(DictConstant.CL_ZT)
	@Basic(title = "机动车状态 ", index = 22, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String jdczt;
	// FIXME
	@DatabaseField( generatedId = true)
	@Basic(title = "？？", index = 23, lines = 1)
	@Show(simple = false, detail = false, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = false)
	private int zqyzl;
	@DatabaseField()
	@Basic(title = "核定载客", index = 24, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String hdzk;

	public String getJdcsyr() {
		return jdcsyr;
	}

	public void setJdcsyr(String jdcsyr) {
		this.jdcsyr = jdcsyr;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	public String getDjzzxz() {
		return djzzxz;
	}

	public void setDjzzxz(String djzzxz) {
		this.djzzxz = djzzxz;
	}

	public String getZzdzxz() {
		return zzdzxz;
	}

	public void setZzdzxz(String zzdzxz) {
		this.zzdzxz = zzdzxz;
	}

	public String getSfzjzl() {
		return sfzjzl;
	}

	public void setSfzjzl(String sfzjzl) {
		this.sfzjzl = sfzjzl;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getClpp1() {
		return clpp1;
	}

	public void setClpp1(String clpp1) {
		this.clpp1 = clpp1;
	}

	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	public String getCcdjrq() {
		return ccdjrq;
	}

	public void setCcdjrq(String ccdjrq) {
		this.ccdjrq = ccdjrq;
	}

	public String getCcrq() {
		return ccrq;
	}

	public void setCcrq(String ccrq) {
		this.ccrq = ccrq;
	}

	public String getFdjxh() {
		return fdjxh;
	}

	public void setFdjxh(String fdjxh) {
		this.fdjxh = fdjxh;
	}

	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	public String getHdzzl() {
		return hdzzl;
	}

	public void setHdzzl(String hdzzl) {
		this.hdzzl = hdzzl;
	}

	public String getGl() {
		return gl;
	}

	public void setGl(String gl) {
		this.gl = gl;
	}

	public String getZzl() {
		return zzl;
	}

	public void setZzl(String zzl) {
		this.zzl = zzl;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getRlzl() {
		return rlzl;
	}

	public void setRlzl(String rlzl) {
		this.rlzl = rlzl;
	}

	public String getJdczt() {
		return jdczt;
	}

	public void setJdczt(String jdczt) {
		this.jdczt = jdczt;
	}

	public int getZqyzl() {
		return zqyzl;
	}

	public void setZqyzl(int zqyzl) {
		this.zqyzl = zqyzl;
	}

	public String getHdzk() {
		return hdzk;
	}

	public void setHdzk(String hdzk) {
		this.hdzk = hdzk;
	}

	@Override
	public String toString() {
		return "Jdc [jdcsyr=" + jdcsyr + ", sfzh=" + sfzh + ", lxfs=" + lxfs + ", djzzxz=" + djzzxz + ", zzdzxz="
				+ zzdzxz + ", sfzjzl=" + sfzjzl + ", hpzl=" + hpzl + ", hphm=" + hphm + ", clpp1=" + clpp1 + ", csys="
				+ csys + ", clxh=" + clxh + ", clsbdh=" + clsbdh + ", ccdjrq=" + ccdjrq + ", ccrq=" + ccrq + ", fdjxh="
				+ fdjxh + ", fdjh=" + fdjh + ", hdzzl=" + hdzzl + ", gl=" + gl + ", zzl=" + zzl + ", pl=" + pl
				+ ", rlzl=" + rlzl + ", jdczt=" + jdczt + ", zqyzl=" + zqyzl + ", hdzk=" + hdzk + "]";
	}

}
