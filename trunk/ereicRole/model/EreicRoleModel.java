package com.h2isea.corp.ereicRole.model;

import java.util.List;

import org.mayframework.web.pagination.PagingBean;


public interface EreicRoleModel {
	/**
	 * 增加一条资源记录
	 * @param  被增加的资源对象
	 */
	public void insert(EreicRole obj);
	
	/**
	 * 删除一条资源记录
	 * @param  被删除的资源对象
	 */
	public void delete(EreicRole obj);
	
	/**
	 * 删除多条资源记录
	 * @param deleted 要被删除的多条资源记录的List，每个List元素都是一个资源对象
	 */
	public void delete(List<EreicRole> deleted);
	
	/**
	 * 保存被修改的资源对象
	 * @param equipmentInfo 被修改的资源对象
	 */
	public void update(EreicRole obj);
	
	/**
	 * 查询单条资源类型信息
	 * @param equipmentInfo 包含查询条件的资源对象
	 * @return 被查询到的单条资源对象
	 */
	public EreicRole select(EreicRole obj);
	
	/**
	 * 查询多条资源信息
	 * @param equipmentInfo 包含查询条件的资源对象
	 * @param pb 包含分页信息的分页对象
	 * @return 包含查询结果的 List 对象，每个List元素都是一个资源对象
	 */
	public List<EreicRole> selectMany(EreicRole obj,PagingBean pb);
	public void updateMany(List<EreicRole> inserted, List<EreicRole> updated,List<EreicRole> deleted);
}
