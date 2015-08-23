var mdp=May.MDP;
var queryString="id,projectCode,projectName,productCode,productName,maxLiftUp,minSectionWeight,fSectionCode,aSectionCode,remark";
var grid;
var queryIds="id,projectCode,projectName,productCode,productName,maxLiftUp,minSectionWeight,fSectionCode,aSectionCode";
var dataSrc;
var win;
var planIds = "";
May.ready(function(){
	
	mdp.init();
	doSelect();
	grid=May.getCmp("resultgrid");
	grid.enableEditEvents(true, false, false);
	May.getCmp("id").focus();
});

function doSelectE()
{
	May.$("reportPane").src=webRoot+"/ReportServer?reportlet=/com/h2isea/corp/stdShipS/Sline.cpt&product=YL&version=1";
}

function doInsert()
{   
	

	var newId=May.UUID();
	grid.addRow(newId,"");
	grid.showRow(newId);
}

function doSave()
{  	
	grid.editStop();
	var ids=grid.getChangedRows(true);
	var idA=ids.split(",");
	//扩展Array方法,对数组中的元素进行批量处理,参数a为forEach方法传入，其值为数组的成员
	var tmp=1;
	idA.forEach(function(a){
		var dataSrc=May.getData("resultgrid",{rowId:a,colIds:queryString});
		if(dataSrc.productCode==''||dataSrc.projectCode==''){
			alert('红星为必添项');
			tmp=0;
			return;
		} 
	});
	if(tmp){
		mdp.call("resultgrid","",webRoot+'/EreicRoleController.may?method=updateMany',{success:function(){
			
		doSelect();			
		}});

		}
}

function doSelect(){
	
	mdp.call(queryString,"resultgrid",webRoot + "/EreicRoleController.may?method=selectMany");
	
}

function doReset(){
//	mdp.reset(queryIds);
	//一种
//-------------------------------------------------
	May.setVal('id','');
	May.setVal('projectCode','');
	May.setVal('projectName','');
	May.setVal('productName','');
	May.setVal('productCode','');
	May.setVal('maxLiftUp','');
	May.setVal('minSectionWeight','');
	May.setVal('fSectionCode','');
	May.setVal('aSectionCode','');
	May.setVal('remark','');
}
//----------------------选择产品类型-----11-19---------------------------------------------
/*添加查询项目的索引
 * 给每个 win 类型的 text 组件绑定一个特定的 beforewinpop ，在弹出之前将自身的window 获取后设置给 currTextWin
*/
function id_beforeWinPop() {
	currWinTextId = "win";
	return true;// 返回 true 标签窗口正常弹出， false 则阻止
}
 

function forPTypeRadio() {
	var selectedIds = resultgrid.getSelectedRowId();
	if (!selectedIds) {
		alert('请选择需要选择产品类型的行');
		return;
	}
	var tmp=1;
	var dataSrc=May.getData("resultgrid",{rowId:selectedIds,colIds:"productCode,productName"});
	if (dataSrc.productCode==""||dataSrc.productName==''){
		alert('请先增加产品编码和名称');
		tmp=0;
		return;
	}
	if(tmp)win = May.window(webRoot + '/globalCtrl.may?method=forPTypeRadio',
			"选择产品类型", 800, 600).ready(function() {
	}).show();
}

function doGlobalPType() {
	var ids = resultgrid.getSelectedRowId();
	var idA = ids.split(",");
	idA.forEach(function(id) {
		var obj = {
			rowId : id,
			data : {
				productTypeCode : dataSrc.productTypeCode,
				productTypeName : dataSrc.productTypeName
			}
		}
		May.setData("resultgrid", obj);
	});
//	resultgrid.editStop();
//	mdp.call("resultgrid", "",webRoot + '/ProductinfoController.may?method=updateMany');
}

//---------------------------------------------------------------------

function doDelete(){
	var ids=grid.getSelectedRowId();
	if (!ids) {
		alert('未选中有效的行！');
		return;
	}
	if(May.confirm("是否删除?")){
		var idA=ids.split(",");
		//扩展Array方法,对数组中的元素进行批量处理,参数a为forEach方法传入，其值为数组的成员
		idA.forEach(function(a){
			grid.deleteRow(a);
		});
		mdp.call("resultgrid","",webRoot + "/EreicRoleController.may?method=updateMany");
	}
	
}
