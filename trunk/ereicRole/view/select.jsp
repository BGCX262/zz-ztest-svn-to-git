<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/may.tld" prefix="may"%>
<may:doctype></may:doctype>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<may:import cmp="may-all.cmp" />
		<may:import myjs="com/h2isea/corp/ereicRole/view/select.js"/>
		<link rel="stylesheet" type="text/css" href="/WebReport/ReportServer?op=resource&resource=/com/fr/web/core/page.css"></link>      
	    <link rel="stylesheet" type="text/css" href="/WebReport/ReportServer?op=resource&resource=/com/fr/web/load.css"></link>      
	    <script type="text/javascript" src="/WebReport/ReportServer?op=resource&resource=/com/fr/web/load.js"></script> 
	</head>
	
	<may:body debug="true">
	<may:set id="selectset" label="查询条件" layout="100%" toolbar="selectToolbar">
			<may:toolbar id="selectToolbar">
            		<may:text type="button" id="select" value="查询" onclick="doSelect()"></may:text>
            		<may:text type="button" id="reset" value="重置" onclick="doReset()"></may:text>            		
        </may:toolbar>
		<may:text label="ID" type="hidden" id="id"   align="left"  layout="3" ></may:text>
		<may:text label="项目编码" type="normal" id="projectCode"   align="left"  layout="4" ></may:text>
    	<may:text label="项目名称" type="normal" id="projectName" align="left"  layout="4" ></may:text>
		<may:text label="产品编码" type="normal" id="productCode"   align="left"  layout="4" ></may:text>
    	<may:text label="产品名称" type="normal" id="productName" align="left"  layout="4" ></may:text>
    </may:set>
    
		<may:set id="resultset" label="查询结果"  layout="100%" toolbar="resultToolbar">
     		 <may:toolbar id="resultToolbar">
     		 	   <may:text type="button" id="insert" value="增加" onclick="doInsert()"></may:text>
     		
            		<may:text type="button" id="update" value="保存" onclick="doSave()"></may:text>
            		<may:text type="button" id="delete" value="删除" onclick="doDelete()"></may:text>
             </may:toolbar>         	
	            <may:grid id="resultgrid" height="300px" layout="1">
	                 <may:column label="se"     width="30"    type="se"  align="center"   sort="str"  id="!selected"></may:column>
	                 <may:column label="ID"     width="150"    type="ed"  align="left"   sort="str"  id="id" hide="true"></may:column>
	                 <may:column label="项目编码"     width="150"    type="ed"  align="left"   sort="str"  id="projectCode"  rule="notnull"></may:column>
					 <may:column label="项目名称"     width="150"    type="ed"  align="left"   sort="str"  id="projectName"  ></may:column>
					 <may:column label="产品编码"     width="150"    type="ed"  align="left"   sort="str"  id="productCode"  rule="notnull"></may:column>
					 <may:column label="产品名称"     width="150"    type="ed"  align="left"   sort="str"  id="productName"  ></may:column>
					 <may:column label="每日最多吊数"     width="150"    type="ed"  align="left"   sort="str"  id="maxLiftUp"></may:column>
					 <may:column label="每天只能吊1吊的分段重量下限"     width="150"    type="ed"  align="left"   sort="str"  id="minSectionWeight"></may:column>
					 <may:column label="船艏分段号"     width="150"    type="ed"  align="left"   sort="str"  id="fSectionCode"></may:column>
					 <may:column label="船艉分段号"     width="150"    type="ed"  align="left"   sort="str"  id="aSectionCode"></may:column>					
					 <may:column label="备注"     width="300"    type="ed"  align="left"   sort="str"  id="remark" ></may:column>
	            </may:grid>
		</may:set>  
		
	</may:body>
</html>