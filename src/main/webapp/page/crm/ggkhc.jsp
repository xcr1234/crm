<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>公共客户池</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
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
		font-size:"100";
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
</style>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
     <li><a href="#">客户管理</a></li>
    <li><a href="#">公共客户池</a></li>
   
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>新建客户</li>
        <li class="click"><span><img src="images/ico06.png" /></span>查询</li>
        <li><span><img src="images/t03.png" /></span>重置</li>     
        </ul>
		</br>
    </div>
    
     <table border=0><tr height="10"><td></td></tr></table><!--行高占位-->      
  	<div style='height:25px;text-align:left;overflow:hidden;'>
     <table  width="1355">
    	<tr>
    		<td width="180">
    				客户姓名&nbsp;&nbsp;&nbsp;: <input name="khxm" type="text" size=12 class="dfinput"></td>
    		<td width="180" >
        		客户性别&nbsp;&nbsp;&nbsp;：<input  name = "khxb" type="text" size=12 class="dfinput"></td>
        <td width="180">
        		客户编码&nbsp;&nbsp;&nbsp;：<input  name = "khbm" type="text" size=12 class="dfinput"></td>
    		<td width="180">
    			客户类型&nbsp;&nbsp;&nbsp;：
        		<select name="khlx"  style="width:94px;position:relative;top:-2">
        			<option value="-1">请选择</option>
	   				<option value="0">一般客户</option>
	   				<option value="1">VIP客户</option>
	   				<option value="2">潜在客户</option>
	   				<option value="4">重要客户</option>
	   				<option value="5">已流失客户</option>
				 </select>
    		</td>
    	</tr>
    	<!--<tr>
    		<td>所在省:<input name="" type="text"></td>
    		<td>所在市:<input name="" type="text"></td>
    		<td>所在县:<input name="" type="text"></td>
    	</tr>
    	<tr>
    		<td>创建人:<input name="" type="text"></td>
    		<td colspan="2">创建日期：<input name ="" type="datetime">——<input name="" type="datetime"></td>
    	</tr>
    	<tr>
    		<td>客户电话:<input name="khdh" type="text"></td>
    		<td>联系人电话:<input name="" type="text"></td>
    		<td>联系人手机:<input name="" type="text"></td>
    	</tr>-->
    </table>
 	</div>
      <table border=0><tr height="10"><td></td></tr></table><!--行高占位-->  
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>客户姓名</th>
        <th>省</th>
        <th>市</th>
        <th>县</th>
        <th>电话</th>
	  		<th>创建人</th>
	  		<th>创建日期</th>
	  		<th>操作</th>
        </tr>
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
     
     
     	
     <!--添加用户对话框开始-->
    <div class="tip">
    	<div class="ke-dialog-body">
    	 <div class="formtitle"><span>客户基本信息</span></div>
    <form action="" method="post">
    	<table>
    		<tr>
    			<td class="td_left">客户名称:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">客户编码:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">创建人:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    		</tr>
    		
    		<tr>
    			<td class="td_left">联系方式:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">邮箱:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">详细地址:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    		</tr>
    		
    		<tr>
    			<td class="td_left">QQ:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">省:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">市:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    		</tr>
    		
    		<tr>
    			<td class="td_left">县:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">销售负责人:</td>
    			<td><input name="" type="text" class="dfinput"/><i></i></td>
    			<td class="td_left">客户类型:</td>
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
        
    
  
    
    </div>

    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
