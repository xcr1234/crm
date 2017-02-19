<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>left</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
	
	//框架页面从后台获取值
})	
</script>


</head>

<body style="background:#fff3e1;">
	
    
    <dl class="leftmenu">
     <%--   ${menu} --%>
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>客户管理
    </div>
    	<ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.servletContext.contextPath}/ggkhc.do?method=listGgkh" target="rightFrame">公共客户池</a>
            <i></i>
            </div>
            
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="${pageContext.servletContext.contextPath}/khxxgl.do?method=listKhxx&userId=${sessionScope.userRole.user.id}" target="rightFrame">客户信息管理</a>
            <i></i>
            </div>                      
        </li>       
        <li class="active"><cite></cite><a href="${pageContext.servletContext.contextPath}/page/crm/jwjlgl.jsp" target="rightFrame">交往记录管理</a><i></i></li>
        <li><cite></cite><a href="javascript:;" target="rightFrame">客户漏斗图</a><i></i></li>
        <li><cite></cite><a href="${pageContext.servletContext.contextPath}/page/crm/khsrcx.jsp" target="rightFrame">客户生日查询</a><i></i></li>
        <li><cite></cite><a href="${pageContext.servletContext.contextPath}/page/crm/khgh.jsp" target="rightFrame">客户关怀</a><i></i></li>
        <li><cite></cite><a href="${pageContext.servletContext.contextPath}/page/crm/khzy.jsp" target="rightFrame">客户转移</a><i></i></li>    
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>销售计划管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.servletContext.contextPath}/xmjh.do?method=listXmjh" target="rightFrame">项目机会</a><i></i></li>
        <li><cite></cite><a href="javascript:;" target="rightFrame">机会漏斗图</a><i></i></li>
        <li><cite></cite><a href="javascript:;" target="rightFrame">销售标价表</a><i></i></li>
        <li><cite></cite><a href="javascript:;" target="rightFrame">解决方案</a><i></i></li>
        </ul>     
    </dd>    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>产品管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="javascript:;" target="rightFrame">哈哈哈。没有啦</a><i></i></li>
       
        </ul>    
    </dd>  
    
    <c:if test="${sessionScope.userRole.role.name ne '业务员'}">
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>用户管理</div>
    <ul class="menuson">
      <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
        <li><cite></cite><a href="${pageContext.servletContext.contextPath}/yhgl.do?method=listUsers" target="rightFrame">账号管理</a><i></i></li>
       </c:if>
       <li><cite></cite><a href="javascript:;" target="rightFrame">业务员管理</a><i></i></li>
        </ul> 
    </dd>   
    </c:if>
    </dl>
    
</body>
</html>
