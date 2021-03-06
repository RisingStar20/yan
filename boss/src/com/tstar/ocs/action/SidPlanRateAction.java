package com.tstar.ocs.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.ocs.model.SidPlanRate;
import com.tstar.ocs.service.SidPlanRateService;

public class SidPlanRateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private SidPlanRateService service;
	
	private String id;
	private String fk;
	private SidPlanRate obj;
	private List<SidPlanRate> lst;
	private String resNum;
	private String res;
	
	public void setId(String id) { this.id = id; }
	public String getId() { return id; }
	
	public void setFk(String fk) { this.fk = fk; }
	public String getFk() { return fk; }
	
	public void setObj(SidPlanRate obj) { this.obj = obj; }
	public SidPlanRate getObj() { return obj; }
	
	public void setLst(List<SidPlanRate> lst) { this.lst = lst; }
	public List<SidPlanRate> getLst() { return lst; }
	
	public void setResNum(String resNum) { this.resNum = resNum; }
	public String getResNum() { return resNum; }
	
	public void setRes(String res) { this.res = res; }
	public String getRes() { return res; }
	
	// DataTable分页需要
	public int getRecordsTotal() { return lst == null ? 0 : lst.size(); }
	public int getRecordsFiltered() { return lst == null ? 0 : lst.size(); }
	
	public String findByFk() {
		if (fk == null || "".equals(fk)) {
			lst = new ArrayList<SidPlanRate>();
		} else {
			lst = service.selectByFk(fk);
		}
		return "getRecords";
	}
	
	public String insert() {
		String[] r = service.insert(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String update() {
		String[] r = service.update(obj);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
	
	public String delete() {
		String[] r = service.delete(id);
		resNum = r[0];
		res = r[1];
		return "getRecords";
	}
}
