package com.h2isea.corp.ereicRole.ctrl;

import java.util.List;

import org.mayframework.web.mvc.multiaction.MultiActionController;
import org.mayframework.web.pagination.PagingBean;
import org.mayframework.web.servlet.ModelAndView;

import com.h2isea.corp.ereicRole.model.EreicRole;
import com.h2isea.corp.ereicRole.model.EreicRoleModel;

public class EreicRoleController extends MultiActionController {
	
	/**
	 * 定义引用的逻辑层对象
	 */
	private EreicRoleModel ereicRoleModel=null;

	public EreicRoleModel getEreicRoleModel() {
		return ereicRoleModel;
	}

	public void setEreicRoleModel(EreicRoleModel ereicRoleModel) {
		this.ereicRoleModel = ereicRoleModel;
	}

	/**
	 * 访问索引界面
	 */
	public ModelAndView forSelect() {
		return new ModelAndView("select");
	}
	
	public ModelAndView forSearch() {
		return new ModelAndView("select");
	}
	
	/**
	 * 查询多条资源信息
	 * 
	 * @param productinfo
	 *            保留查询条件的资源对象
	 * @param pb
	 *            包含分页信息的分页对象
	 * @return List，List中的元素就是查询返回的资源对象
	 */
	public List<EreicRole> selectMany(EreicRole ereicRole, PagingBean pb) {
		List<EreicRole> list = null;

		try {
			list = this.ereicRoleModel.selectMany(ereicRole, pb);
			
		} catch (Exception e) {
			e.printStackTrace();
			putError("查询时出错了：" + e.getMessage());
		}
		return list;
	}

	/**
	 * 获取资源业务逻辑对象
	 * 
	 * @return 资源逻辑对象
	 */
	public void updateMany(List<EreicRole> inserted, List<EreicRole> updated,List<EreicRole> deleted, EreicRole productinfo)
	{
		try{
			this.ereicRoleModel.updateMany(inserted,updated,deleted);
			putMessage("保存成功！");
		}catch(Exception e){
			if(e.getMessage().indexOf("ORA-01401")>0){
				putError("字段值太长!");
				return;
			}else if(e.getMessage().indexOf("ORA-00001")>0){
				putError("违反唯一性约束!");	
				return;
			}else{
				e.printStackTrace();
				putMessage("操作失败!");
			}
		}		
	}
}
