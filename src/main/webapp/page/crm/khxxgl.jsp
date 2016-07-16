<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>客户信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>

		<script type="text/javascript">
			$(document).ready(function(){
			/*  $(".click").click(function(){
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
		
		<style type="text/css">
			td{
		width: 400px;
		border:solid 2px #d7a372;
	}
	.dfinput{
		width: 250px;
	}
	.td_left{
		width: 100px;
	}

		</style>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li><a href="#">首页</a></li>
				<li><a href="#">客户信息管理</a></li>

			</ul>
		</div>

		<div class="rightinfo">

			<div class="tools">
				<ul class="toolbar">
					<li class="click"  onclick="location.href='<%=basePath%>page/crm/khxxgl_add.jsp'"><span><img src="images/t01.png" /></span>添加</li>
					<li class="click"><span><img src="images/ico06.png" /></span>查询</li>
					<li><span><img src="images/t03.png" /></span>重置</li>
				</ul>
			</div>
			<div class="formbody">

			</div>
		    <table class="tablelist">
			     <thead>
						<th>
							<input name="" type="checkbox" value="" checked="checked" />
						</th>
						<th width="100px"><a href="#">客户来源</a></th>
						<th><a href="#">客户名称</a></th>
						<th><a href="#">省份</a></th>
						<th><a href="#">城市</a></th>
						<th><a href="#">电话</a></th>
						<th><a href="#">创建人</a></th>
						<th><a href="#">创建日期</a></th>
						<th><a href="#">说明</a></th>
						<th><a href="#">客户区别</a></th>
						<th><a href="#">操作</a></th>
					
			    </thead>
			  </table>

			<div class="pagin">

				<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
				<ul class="paginList">
					<li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
					<li class="paginItem"><a href="javascript:;">1</a></li>
					<li class="paginItem current"><a href="javascript:;">2</a></li>
					<li class="paginItem"><a href="javascript:;">3</a></li>
					<li class="paginItem"><a href="javascript:;">4</a></li>
					<li class="paginItem"><a href="javascript:;">5</a></li>
					<li class="paginItem more"><a href="javascript:;">...</a></li>
					<li class="paginItem"><a href="javascript:;">10</a></li>
					<li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
				</ul>
			</div>

			<div class="tip">
				<div class="tiptop"><span>提示信息</span>
					<a></a>
				</div>

				<div class="tipinfo">
					<span><img src="images/ticon.png" /></span>
					<div class="tipright">
						<p>是否确认对信息的修改 ？</p>
						<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
					</div>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="确定" />&nbsp;
					<input name="" type="button" class="cancel" value="取消" />
				</div>

			</div>
		</div>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>