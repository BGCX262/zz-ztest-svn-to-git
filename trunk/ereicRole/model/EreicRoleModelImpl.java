package com.h2isea.corp.ereicRole.model;

import java.util.List;
import java.util.UUID;

import org.mayframework.persistence.SimpleDAO;
import org.mayframework.web.pagination.PagingBean;


public class EreicRoleModelImpl implements EreicRoleModel{
	/**
	 * 设置 持久层 访问对象 
	 */
	private SimpleDAO simpleDAO = null;
	
	public SimpleDAO getSimpleDAO() {
		return simpleDAO;
	}
	public void setSimpleDAO(SimpleDAO simpleDAO) {
		this.simpleDAO = simpleDAO;
	}
	
	public void delete(EreicRole obj) {
		this.simpleDAO.delete("ereicRole.delete", obj)	;
		
	}

	public void delete(List<EreicRole> deleted) {
		for (EreicRole m : deleted){
			this.delete(m);
		}
		
	}

	public void insert(EreicRole obj) {
		if(obj.getId()==null) obj.setId(UUID.randomUUID().toString());
		this.simpleDAO.insert("ereicRole.insert", obj)	;
		
	}

	public EreicRole select(EreicRole obj) {
		EreicRole m = (EreicRole)this.simpleDAO.queryForObject("ereicRole.select", obj);
		return  m;
	}

	public List<EreicRole> selectMany(EreicRole obj, PagingBean pb) {
		pb.setAllNum((Integer)this.simpleDAO.queryForObject("ereicRole.count", obj));
		return (List<EreicRole>)this.simpleDAO.queryForList("ereicRole.selectMany", obj,pb);
	}

	public void update(EreicRole obj) {
		this.simpleDAO.update("ereicRole.update", obj)	;
		
	}

	public void updateMany(List<EreicRole> inserted,List<EreicRole> updated, List<EreicRole> deleted) {
		for(EreicRole m:updated)
		{
			this.update(m);	
		}
		
		for(EreicRole n:deleted){
			
			this.delete(n);
		}
		for(EreicRole p:inserted)
		{this.insert(p);}
	}
			
}
