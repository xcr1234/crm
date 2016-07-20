<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>销售报价单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
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
});

});
</script>
</head>
<style type="text/css">
	body{
		/*background-color: red;*/
		font-size:"200";
	}
	th{
	  text-align:center;
	}
	td{
		width: 400px;
		border:solid 1px #d7a372;
	}
	.dfinput{
		width: 250px;
		height: 25px;
	}
	.td_left{
		width: 100px;
		}
	.tip{width:1400px; height:600px; position:absolute;top:10%; left:10%;background:#fcfdfd;box-shadow:1px 8px 10px 1px #9b9b9b;border-radius:1px;behavior:url(js/pie.htc); display:none; z-index:111111;}
    option {
	font-size: 25px;
}
 select {
   opacity: 1;
    display:block;
    width: 150px;
	height: 32px;
	border-width: 1px;
    border-style: solid;
    border-color: rgb(195, 171, 125) rgb(231, 213, 186) rgb(231, 213, 186) rgb(195, 171, 125);
}

input[type=checkbox]{
	width:25px;
	height:18px;
} 
</style>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">CRM</a></li>
     <li><a href="#">销售机会管理</a></li>
    <li><a href="#">销售报价单</a></li>
   
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click" onclick="location.href='${pageContext.servletContext.contextPath}/xmjh.do?method=addXsbjd'"><span><img src="images/t01.png" /></span>新建报价单</li>
        <li class="click"><span><img src="images/ico06.png" /></span>查询</li>
        <li><span><img src="images/t05.png" /></span>重置</li>     
        </ul>
    </div>
    
    <ul class="seachform">
    <li><label>报价单编号</label><input name="" type="text" class="scinput" /></li>
    <li><label>客户名称</label><input name="" type="text" class="scinput" /></li>
    <li><label>创建日期 </label><input name="" type="text" class="scinput" /></li>
    
    </ul>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th style="width: 150px"><input name="" type="checkbox" value="" checked="checked"/>全选</th>
        <th>报价单编号</th>
        <th>创建人</th>
        <th>报价日期</th>
        <th>创建日期</th>
        <th>报价有效期</th>
	  	<th>所属客户</th>
	  	<th>报价人</th>
	  	<th>总金额</th>
	  	<th>操作</th>
        </tr>
        </thead>
        <tbody>
		<c:forEach items="${pages.items}" var="item">
        <tr>
          <td style="width: 150px"><input name="" type="checkbox" value="" checked="checked"/></td>
          <td>${item.code}</td>
          <td>${item.creator}</td>
          <td>${item.bjrq}</td>
          <td>${item.createdate}</td>
          <td>${item.yxrq}</td>
          <td>${item.sskh.name}</td>
          <td>${item.bjr.nickName}</td>
          <td>￥${item.totleDiscountPrice}</td>
          <td><a href="${pageContext.servletContext.contextPath}/xmjh.do?method=view&id=${item.id}">查看</a>&nbsp;<a href="#">编辑</a>&nbsp;</td>
        </tr>
		</c:forEach>
        </tbody>
    </table>

		<p:page pages="${page}" link="xmjh.do?method=listXsbjd" prev="上一页" first="首页" last="尾页" next="下一页" ulClass="paginList" />


		<!--<div class="pagin">
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
        </div>-->

     	<%--
     <!--添加用户对话框开始-->
    <div class="tip">
    	<div class="ke-dialog-body">
    	 <div class="formtitle"><span>新建报价信息</span></div>
    <form action="" method="post">
    	<table>
    		<tr>
    			<td class="td_left">报价单编号:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">报价人:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">创建人:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    		</tr>
    		
    		<tr>
    			<td class="td_left">报价日期:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">创建日期:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">报价有效日期:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    		</tr>
    		
    		<tr>
    			<td class="td_left">所属客户:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    		</tr>
    		
    	</table>
    	
    	<input type="submit" value=""/>
    </form>
    
     <div class="formtitle"><span>客户联系人</span></div>
      <table class="tableform">
      	<thead>
      		<tr>
      			<th>姓名</th>
      			<th>性别</th>
      			<th>职位</th>
      			<th>手机</th>
      			<th>工作电话</th>
      			<th>E-mail</th>	
      			<th>生日</th>
      			<th>备注</th>
      			<th>操作</th>
      		</tr>	
      	</thead>
      	<tbody>
      		<tr>
      			<td><input type="text"/></td>
      			<td style="text-align: center;">
      					<select style="font-size: 25px;width: 100px;">
      					<option value="1" style="font-size: 25px;">男</option>
      					<option value="0" style="font-size: 25px;">女</option>
      				</select>	
      			</td>
      				
      			</td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td style="text-align: center;"><a href="#">删除</a></td>
      		</tr>
      		<tr>
      			<td><input type="text"/></td>
      			<td style="text-align: center;">
      					<select style="font-size: 25px;width: 100px;">
      					<option value="1" style="font-size: 25px;">男</option>
      					<option value="0" style="font-size: 25px;">女</option>
      				</select>	
      			</td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td><input type="text" name=""/></td>
      			<td style="text-align: center;"><a href="#">删除</a></td>
      		</tr>
      </tbody>
      </table>
    <div style="text-align: center;margin-top: 5px;">
    	
    	<button type="button" class="scbtn">添加一行</button>
    	<button type="button" class="scbtn sure">保存</button>
    	<button type="button" class="scbtn cancel">关闭</button>
    </div>
    
    </div>

        <!--<div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>-->
    
   </div>
    <!--
	作者：gui
	时间：2016-07-13
	描述：对话框结束
-->
--%>
        
    
  
    
    </div>

    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
