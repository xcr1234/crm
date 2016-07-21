<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/xlsx.core.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/blob.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/FileSaver.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/tableexport-3.2.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/DateUtil.js"></script>
<script language="javascript">
$(function(){
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
$.fn.tableExport.xlsx = {
    defaultClass: "xlsx",
    buttonContent: "确认导出",
    mimeType: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    fileExtension: ".xlsx"
};
$("#export").click(function(){
 var tableName="客户关怀表"; //初始化表名
 var column=9;  //初始化忽略的列，从0开始。
 var date=new Date();
 var time=formatDate(date, "yyyy-MM-dd");
 var fileName=tableName+"-第"+${page.current}+'页-'+time;
	$("table").tableExport({
	    headings: true, 
	    footers: true, 
	    formats: ["xlsx"],
	    fileName: fileName,
	    bootstrap: false,
	    position: "bottom",
	    ignoreRows: null,
	    ignoreCols: column
}); 
});
      
  /*$(".click").click(function(){
  $(".tip").fadeIn(200);
   });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});*/

});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">客户关怀</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click" onclick="location.href='khgh_add.jsp'"><span><img src="${pageContext.servletContext.contextPath}/images/t01.png" /></span>新建关怀信息</li>
        <li><span><img src="${pageContext.servletContext.contextPath}/images/ico06.png" /></span>查询</li>
        <li id="export"><span><img src="${pageContext.servletContext.contextPath}/images/lc04.png" width="25px" height="25px"/></span>导出报表</li>
        </ul>
    
     </div>
     <ul class="seachform">
    <li><label>关怀客户</label><input name="name" type="text" class="scinput" /></li>
    <li><label>创建人</label><input name="code" type="text" class="scinput" /></li>
    <li><label>关怀内容</label>  
	<input name="code" type="text" class="scinput" />
 
   </li>
    
    </ul>
     
     <table class="tablelist" id="tablelist">
    	<thead>
    	<tr>
        <th style="width: 100px">序号</th>
        <th>关怀客户</th>
        <th style="width:200px;">关怀日期</th>
        <th>联系人电话</th>
        <th>联系人手机</th>
        <th>创建人</th>
        <th>创建日期</th>
        <th>关怀内容</th>
	  	<th>备注</th>
	  	<th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr style="height:40px;">
        <c:forEach items="${page.items}" var="o" varStatus="status">
          <td style="width: 50px">${status.index+1}</td>
          <td style="width:100px;">${o.customer.name}</td>
          <td>${o.date}</td>
          <td>${o.phone}</td>
          <td>${o.phone2}</td>
          <td>${o.creator.nickName}</td>
          <td style="width:100px;">${o.creatdate}</td>
          <td style="width:180px;">${o.content}</td>
          <td>${o.remark}</td>
          <td>
             <a href="${pageContext.servletContext.contextPath}/khgh.do?method=detail&id=${o.id}">查看</a>&nbsp;
             <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
             <a href="${pageContext.servletContext.contextPath}/cpxxgl.do?method=edit&id=${o.id}">编辑</a>&nbsp;
             <a href="#" value="${o.id}" name="delete" >删除</a>&nbsp;
            </c:if>
           </td>
        </tr>
         </c:forEach>
        </tbody>
    </table>
    
    <p:page pages="${page}" link="khgh.do?method=listKhgh&userRoleId=${sessionScope.userRole.id}" prev="上一页" first="首页" last="尾页" next="下一页" ulClass="paginList" />
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
