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

/** 机构基本信息 */
@DatabaseTable(tableName = "JG")
@Title("企业")
public class JgJbxx implements Serializable {
	private static final long serialVersionUID = 7217529959178354285L;

	public JgJbxx() {
	}

	@DatabaseField(generatedId = true)
	@Basic(title = "机构编号", index = 1, lines = 1)
	@Show(simple = false, detail = false, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = false)
	private int jgbh;
	@DatabaseField()
	@Basic(title = "组织机构代码", index = 2, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String dwdm;
	@DatabaseField()
	@Basic(title = "单位名称", index = 3, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String dwmc;
	@DatabaseField()
	@Dict(DictConstant.JG_HYLB)
	@Basic(title = "行业类别", index = 4, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String xylb;
	@DatabaseField()
	@Dict(DictConstant.JG_GLBM)
	@Basic(title = "管理部门", index = 5, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String glbm;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "机构所属辖区", index = 6, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String jgssxq;
	@DatabaseField()
	@Dict(DictConstant.DZ_JLX)
	@Basic(title = "街路巷", index = 7, lines = 1)
	@Show(simple = true, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String jgjlx;
	@DatabaseField()
	@Basic(title = "门楼牌号", index = 8, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = true, show = true)
	private String jgmlph;
	@DatabaseField()
	@Dict(DictConstant.DZ_MPHZ)
	@Basic(title = "门牌后缀", index = 9, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String jgmphz;
	@DatabaseField()
	@Basic(title = "门楼详址", index = 10, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String jgmlxz;
	@DatabaseField()
	@Dict(DictConstant.JG_GLJB)
	@Basic(title = "管理级别", index = 11, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String gljb;
	@DatabaseField()
	@Dict(DictConstant.JG_ZDDJ)
	@Basic(title = "重点单位标识", index = 12, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String zddwbs;
	@DatabaseField()
	@Dict(DictConstant.TC_ZRQ)
	@Basic(title = "所属责任区", index = 13, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String szzrq;
	@DatabaseField()
	@Dict(DictConstant.JG_XFDJ)
	@Basic(title = "防火等级", index = 14, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String fhdj;
	@DatabaseField()
	@Basic(title = "单位电话", index = 15, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String dwdh;
	@DatabaseField()
	@Basic(title = "单位传真", index = 16, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String dwcz;
	@DatabaseField()
	@Basic(title = "单位电子邮箱", index = 17, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String dwdzyx;
	@DatabaseField()
	@Dict(DictConstant.JG_DWLX)
	@Basic(title = "单位类型", index = 18, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String jjxz;
	@DatabaseField()
	@Basic(title = "法人代表", index = 19, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String frdb;
	@DatabaseField()
	@Basic(title = "法人代表身份证号", index = 20, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_IDCARD, necessary = false, show = true)
	private String fddbrsfzh;
	@DatabaseField()
	@Basic(title = "法人住址", index = 21, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String frzz;
	@DatabaseField()
	@Basic(title = "法人联系电话", index = 22, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String frlxdh;
	@DatabaseField()
	@Basic(title = "主管部门", index = 23, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String zgbm;
	@DatabaseField()
	@Basic(title = "治安负责人", index = 24, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String zafzr;
	@DatabaseField()
	@Basic(title = "治安负责人身份证号", index = 25, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_IDCARD, necessary = true, show = true)
	private String zafzrsfz;
	@DatabaseField()
	@Basic(title = "治安负责人电话", index = 26, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String zafzrdh;
	@DatabaseField()
	@Dict(DictConstant.RY_XB)
	@Basic(title = "治安负责人性别", index = 27, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = true, show = true)
	private String zafzrxb;
	@DatabaseField()
	@Basic(title = "治安负责人职务", index = 28, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = true, show = true)
	private String zafzrzw;
	@DatabaseField()
	@Basic(title = "从业人数", index = 29, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = true, show = true)
	private String cyrs;
	@DatabaseField()
	@Basic(title = "税务登记号", index = 30, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String swdjh;
	@DatabaseField()
	@Basic(title = "经营范围", index = 31, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String jyfw;
	@DatabaseField()
	@Basic(title = "注册日期", index = 32, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String zcrq;
	@DatabaseField()
	@Basic(title = "注册资本", index = 33, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_NUM, necessary = false, show = true)
	private String zczb;
	@DatabaseField()
	@Basic(title = "注册号", index = 34, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String jgzch;
	@DatabaseField()
	@Dict(DictConstant.TC_XZQH)
	@Basic(title = "注册区划", index = 35, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String zcqh;
	@DatabaseField()
	@Basic(title = "注册地址", index = 36, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zcdz;
	@DatabaseField()
	@Basic(title = "开业时间", index = 37, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String kysj;
	@DatabaseField()
	@Basic(title = "营业执照编号", index = 38, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String yyzzbh;
	@DatabaseField()
	@Basic(title = "发照日期", index = 39, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String fzsj;
	@DatabaseField()
	@Basic(title = "有效期限", index = 40, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String yxqx;
	@DatabaseField()
	@Basic(title = "备注", index = 41, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String bz;
	@DatabaseField()
	@Basic(title = "注销时间", index = 42, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String zxsj;
	@DatabaseField()
	@Basic(title = "注销原因", index = 43, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zxyy;
	@DatabaseField()
	@Dict(DictConstant.TC_ZXBS)
	@Basic(title = "注销标识", index = 44, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String zxbs;
	@DatabaseField()
	@Dict(DictConstant.JG_DWSX)
	@Basic(title = "单位属性", index = 45, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICTS, necessary = false, show = true)
	private String dwsx;
	@DatabaseField()
	@Basic(title = "上级单位编号", index = 46, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String sjdwbh;
	@DatabaseField()
	@Basic(title = "上级单位名称", index = 47, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String sjdwmc;
	@DatabaseField()
	@Basic(title = "机构地址编号", index = 48, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String dzbh;
	@DatabaseField()
	@Basic(title = "外文名", index = 49, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String wwm;
	@DatabaseField()
	@Basic(title = "雇佣单位类型", index = 50, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String gydwlx;
	@DatabaseField()
	@Basic(title = "董事长", index = 51, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String dsz;
	@DatabaseField()
	@Basic(title = "总经理", index = 52, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String zjl;
	@DatabaseField()
	@Basic(title = "分支机构", index = 53, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String fzjg;
	@DatabaseField()
	@Basic(title = "开户银行", index = 54, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String khyx;
	@DatabaseField()
	@Basic(title = "基本账号", index = 55, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String jbzh;
	@DatabaseField()
	@Basic(title = "其他账号", index = 56, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String qtzh;
	@DatabaseField()
	@Dict(DictConstant.TC_GJDQ)
	@Basic(title = "投资国家", index = 57, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String tzgj;
	@DatabaseField()
	@Basic(title = "年审时间", index = 58, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DATE, necessary = false, show = true)
	private String nssj;
	@DatabaseField()
	@Basic(title = "是否有违法经历", index = 59, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String sfywfjl;
	@DatabaseField()
	@Basic(title = "各个股东出资情况", index = 60, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = true)
	private String gggdczqk;
	@DatabaseField()
	@Dict(DictConstant.TC_BMJB)
	@Basic(title = "保密级别", index = 61, lines = 1)
	@Show(simple = false, detail = true, weight = 4)
	@Form(type = SmartInputLine.TYPE_DICT, necessary = false, show = true)
	private String bmjb;
	@DatabaseField()
	@Basic(title = "？？？", index = 62, lines = 1)
	@Show(simple = false, detail = false, weight = 4)
	@Form(type = SmartInputLine.TYPE_EDIT, necessary = false, show = false)
	private String jjlx;

	public int getJgbh() {
		return jgbh;
	}

	public void setJgbh(int jgbh) {
		this.jgbh = jgbh;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getXylb() {
		return xylb;
	}

	public void setXylb(String xylb) {
		this.xylb = xylb;
	}

	public String getGlbm() {
		return glbm;
	}

	public void setGlbm(String glbm) {
		this.glbm = glbm;
	}

	public String getJgssxq() {
		return jgssxq;
	}

	public void setJgssxq(String jgssxq) {
		this.jgssxq = jgssxq;
	}

	public String getJgjlx() {
		return jgjlx;
	}

	public void setJgjlx(String jgjlx) {
		this.jgjlx = jgjlx;
	}

	public String getJgmlph() {
		return jgmlph;
	}

	public void setJgmlph(String jgmlph) {
		this.jgmlph = jgmlph;
	}

	public String getJgmphz() {
		return jgmphz;
	}

	public void setJgmphz(String jgmphz) {
		this.jgmphz = jgmphz;
	}

	public String getJgmlxz() {
		return jgmlxz;
	}

	public void setJgmlxz(String jgmlxz) {
		this.jgmlxz = jgmlxz;
	}

	public String getGljb() {
		return gljb;
	}

	public void setGljb(String gljb) {
		this.gljb = gljb;
	}

	public String getZddwbs() {
		return zddwbs;
	}

	public void setZddwbs(String zddwbs) {
		this.zddwbs = zddwbs;
	}

	public String getSzzrq() {
		return szzrq;
	}

	public void setSzzrq(String szzrq) {
		this.szzrq = szzrq;
	}

	public String getFhdj() {
		return fhdj;
	}

	public void setFhdj(String fhdj) {
		this.fhdj = fhdj;
	}

	public String getDwdh() {
		return dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getDwcz() {
		return dwcz;
	}

	public void setDwcz(String dwcz) {
		this.dwcz = dwcz;
	}

	public String getDwdzyx() {
		return dwdzyx;
	}

	public void setDwdzyx(String dwdzyx) {
		this.dwdzyx = dwdzyx;
	}

	public String getJjxz() {
		return jjxz;
	}

	public void setJjxz(String jjxz) {
		this.jjxz = jjxz;
	}

	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	public String getFddbrsfzh() {
		return fddbrsfzh;
	}

	public void setFddbrsfzh(String fddbrsfzh) {
		this.fddbrsfzh = fddbrsfzh;
	}

	public String getFrzz() {
		return frzz;
	}

	public void setFrzz(String frzz) {
		this.frzz = frzz;
	}

	public String getFrlxdh() {
		return frlxdh;
	}

	public void setFrlxdh(String frlxdh) {
		this.frlxdh = frlxdh;
	}

	public String getZgbm() {
		return zgbm;
	}

	public void setZgbm(String zgbm) {
		this.zgbm = zgbm;
	}

	public String getZafzr() {
		return zafzr;
	}

	public void setZafzr(String zafzr) {
		this.zafzr = zafzr;
	}

	public String getZafzrsfz() {
		return zafzrsfz;
	}

	public void setZafzrsfz(String zafzrsfz) {
		this.zafzrsfz = zafzrsfz;
	}

	public String getZafzrdh() {
		return zafzrdh;
	}

	public void setZafzrdh(String zafzrdh) {
		this.zafzrdh = zafzrdh;
	}

	public String getZafzrxb() {
		return zafzrxb;
	}

	public void setZafzrxb(String zafzrxb) {
		this.zafzrxb = zafzrxb;
	}

	public String getZafzrzw() {
		return zafzrzw;
	}

	public void setZafzrzw(String zafzrzw) {
		this.zafzrzw = zafzrzw;
	}

	public String getCyrs() {
		return cyrs;
	}

	public void setCyrs(String cyrs) {
		this.cyrs = cyrs;
	}

	public String getSwdjh() {
		return swdjh;
	}

	public void setSwdjh(String swdjh) {
		this.swdjh = swdjh;
	}

	public String getJyfw() {
		return jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	public String getZcrq() {
		return zcrq;
	}

	public void setZcrq(String zcrq) {
		this.zcrq = zcrq;
	}

	public String getZczb() {
		return zczb;
	}

	public void setZczb(String zczb) {
		this.zczb = zczb;
	}

	public String getJgzch() {
		return jgzch;
	}

	public void setJgzch(String jgzch) {
		this.jgzch = jgzch;
	}

	public String getZcqh() {
		return zcqh;
	}

	public void setZcqh(String zcqh) {
		this.zcqh = zcqh;
	}

	public String getZcdz() {
		return zcdz;
	}

	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}

	public String getKysj() {
		return kysj;
	}

	public void setKysj(String kysj) {
		this.kysj = kysj;
	}

	public String getYyzzbh() {
		return yyzzbh;
	}

	public void setYyzzbh(String yyzzbh) {
		this.yyzzbh = yyzzbh;
	}

	public String getFzsj() {
		return fzsj;
	}

	public void setFzsj(String fzsj) {
		this.fzsj = fzsj;
	}

	public String getYxqx() {
		return yxqx;
	}

	public void setYxqx(String yxqx) {
		this.yxqx = yxqx;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getZxsj() {
		return zxsj;
	}

	public void setZxsj(String zxsj) {
		this.zxsj = zxsj;
	}

	public String getZxyy() {
		return zxyy;
	}

	public void setZxyy(String zxyy) {
		this.zxyy = zxyy;
	}

	public String getZxbs() {
		return zxbs;
	}

	public void setZxbs(String zxbs) {
		this.zxbs = zxbs;
	}

	public String getDwsx() {
		return dwsx;
	}

	public void setDwsx(String dwsx) {
		this.dwsx = dwsx;
	}

	public String getSjdwbh() {
		return sjdwbh;
	}

	public void setSjdwbh(String sjdwbh) {
		this.sjdwbh = sjdwbh;
	}

	public String getSjdwmc() {
		return sjdwmc;
	}

	public void setSjdwmc(String sjdwmc) {
		this.sjdwmc = sjdwmc;
	}

	public String getDzbh() {
		return dzbh;
	}

	public void setDzbh(String dzbh) {
		this.dzbh = dzbh;
	}

	public String getWwm() {
		return wwm;
	}

	public void setWwm(String wwm) {
		this.wwm = wwm;
	}

	public String getGydwlx() {
		return gydwlx;
	}

	public void setGydwlx(String gydwlx) {
		this.gydwlx = gydwlx;
	}

	public String getDsz() {
		return dsz;
	}

	public void setDsz(String dsz) {
		this.dsz = dsz;
	}

	public String getZjl() {
		return zjl;
	}

	public void setZjl(String zjl) {
		this.zjl = zjl;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	public String getKhyx() {
		return khyx;
	}

	public void setKhyx(String khyx) {
		this.khyx = khyx;
	}

	public String getJbzh() {
		return jbzh;
	}

	public void setJbzh(String jbzh) {
		this.jbzh = jbzh;
	}

	public String getQtzh() {
		return qtzh;
	}

	public void setQtzh(String qtzh) {
		this.qtzh = qtzh;
	}

	public String getTzgj() {
		return tzgj;
	}

	public void setTzgj(String tzgj) {
		this.tzgj = tzgj;
	}

	public String getNssj() {
		return nssj;
	}

	public void setNssj(String nssj) {
		this.nssj = nssj;
	}

	public String getSfywfjl() {
		return sfywfjl;
	}

	public void setSfywfjl(String sfywfjl) {
		this.sfywfjl = sfywfjl;
	}

	public String getGggdczqk() {
		return gggdczqk;
	}

	public void setGggdczqk(String gggdczqk) {
		this.gggdczqk = gggdczqk;
	}

	public String getBmjb() {
		return bmjb;
	}

	public void setBmjb(String bmjb) {
		this.bmjb = bmjb;
	}

	public String getJjlx() {
		return jjlx;
	}

	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}

	@Override
	public String toString() {
		return "JgJbxx [jgbh=" + jgbh + ", dwdm=" + dwdm + ", dwmc=" + dwmc + ", xylb=" + xylb + ", glbm=" + glbm
				+ ", jgssxq=" + jgssxq + ", jgjlx=" + jgjlx + ", jgmlph=" + jgmlph + ", jgmphz=" + jgmphz + ", jgmlxz="
				+ jgmlxz + ", gljb=" + gljb + ", zddwbs=" + zddwbs + ", szzrq=" + szzrq + ", fhdj=" + fhdj + ", dwdh="
				+ dwdh + ", dwcz=" + dwcz + ", dwdzyx=" + dwdzyx + ", jjxz=" + jjxz + ", frdb=" + frdb + ", fddbrsfzh="
				+ fddbrsfzh + ", frzz=" + frzz + ", frlxdh=" + frlxdh + ", zgbm=" + zgbm + ", zafzr=" + zafzr
				+ ", zafzrsfz=" + zafzrsfz + ", zafzrdh=" + zafzrdh + ", zafzrxb=" + zafzrxb + ", zafzrzw=" + zafzrzw
				+ ", cyrs=" + cyrs + ", swdjh=" + swdjh + ", jyfw=" + jyfw + ", zcrq=" + zcrq + ", zczb=" + zczb
				+ ", jgzch=" + jgzch + ", zcqh=" + zcqh + ", zcdz=" + zcdz + ", kysj=" + kysj + ", yyzzbh=" + yyzzbh
				+ ", fzsj=" + fzsj + ", yxqx=" + yxqx + ", bz=" + bz + ", zxsj=" + zxsj + ", zxyy=" + zxyy + ", zxbs="
				+ zxbs + ", dwsx=" + dwsx + ", sjdwbh=" + sjdwbh + ", sjdwmc=" + sjdwmc + ", dzbh=" + dzbh + ", wwm="
				+ wwm + ", gydwlx=" + gydwlx + ", dsz=" + dsz + ", zjl=" + zjl + ", fzjg=" + fzjg + ", khyx=" + khyx
				+ ", jbzh=" + jbzh + ", qtzh=" + qtzh + ", tzgj=" + tzgj + ", nssj=" + nssj + ", sfywfjl=" + sfywfjl
				+ ", gggdczqk=" + gggdczqk + ", bmjb=" + bmjb + ", jjlx=" + jjlx + "]";
	}
}
