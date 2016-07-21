<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>客户生日查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>

<script type="text/javascript">
$(document).ready(function(e) {
  $("a[name=fszf]").click(function(){
    var userId=${sessionScope.userRole.user.id};
    var cusLinkId=$(this).attr("cusLinkId");
    window.location.href="${pageContext.servletContext.contextPath}/khsrxc.do?method=toSendMail&userId="+userId+"&cusLinkId="+cusLinkId;
  });
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">CRM</a></li>
    <li><a href="#">客户生日查询</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">本周客户生日</a></li> 
    <li><a href="#tab2">本月客户生日</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
     
     <table class="tablelist">
    	<thead>
    	<tr>
    	<th>序号</th>
        <th>所属客户</th>
        <th>客户姓名</th>
        <th>客户性别</th>
        <th>客户手机</th>
        <th>工作电话</th>
        <th>出生日期</th>
        <th>邮箱</th>
        <th>操作</th>
        </tr>
        </thead>
         <tbody>
         <c:forEach items="${page.items}" var="o" varStatus="status">
        <tr style="height:40px;">
          <td style="width: 50px">${status.index+1}</td>
          <td style="width:180px;">${o.customer.name}</td>
          <td style="width:180px;">${o.name}</td>
          <td style="width:200px;">${o.sex ?'男':'女'}</td>
          <td style="width:200px;">${o.phone}</td>
          <td style="width:180px;">${o.phone2}</td>
          <td style="width:180px;">${o.birthdate}</td>
          <td>${o.email}</td>
          <td style="width:150px;">
            <%--  <a href="${pageContext.servletContext.contextPath}/khxx.do?method=detail&id=${o.id}">查看</a>&nbsp;
             <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
             <a href="${pageContext.servletContext.contextPath}/khxx.do?method=edit&id=${o.id}">编辑</a>&nbsp;
             <a href="#" value="${customer.id}" name="delete" >删除</a>&nbsp;
             <a href="#" class="click" value="${customer.id}">分配</a>&nbsp;
            </c:if> --%>
             <a href="#" name="fszf" class="click" userId="${sessionScope.userRole.user.id}" cusLinkId="${o.id}">发送祝福</a>&nbsp;
           </td>
        </tr>
         </c:forEach>
        </tbody>
        
    </table>
  
  
    
    </div> 
    
    
  	<div id="tab2" class="tabson">
    
     <table class="tablelist">
    	<thead>
    	<tr>
    	<th>序号</th>
        <th>所属客户</th>
        <th>客户姓名</th>
        <th>客户性别</th>
        <th>客户手机</th>
        <th>工作电话</th>
        <th>出生日期</th>
        <th>邮箱</th>
        <th>操作</th>
        </tr>
        </thead>
         <tbody>
         <c:forEach items="${page2.items}" var="o" varStatus="status">
        <tr style="height:40px;">
          <td style="width: 50px">${status.index+1}</td>
          <td style="width:180px;">${o.customer.name}</td>
          <td style="width:180px;">${o.name}</td>
          <td style="width:200px;">${o.sex ?'男':'女'}</td>
          <td style="width:200px;">${o.phone}</td>
          <td>${o.phone2}</td>
          <td style="width:180px;">${o.birthdate}</td>
          <td>${o.email}</td>
          <td style="width:200px;">
            <%--  <a href="${pageContext.servletContext.contextPath}/khxx.do?method=detail&id=${o.id}">查看</a>&nbsp;
             <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
             <a href="${pageContext.servletContext.contextPath}/khxx.do?method=edit&id=${o.id}">编辑</a>&nbsp;
             <a href="#" value="${customer.id}" name="delete" >删除</a>&nbsp;
             <a href="#" class="click" value="${customer.id}">分配</a>&nbsp;
            </c:if> --%>
            <a href="#" name="fszf" class="click" userId="${sessionScope.userRole.user.id}" cusLinkId="${o.id}">发送祝福</a>&nbsp;
           </td>
        </tr>
         </c:forEach>
        </tbody>
        
    </table>
   
    </div>
       
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    


</body>

</html>