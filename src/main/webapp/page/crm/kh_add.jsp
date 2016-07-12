<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>新建客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />

  </head>
	 <style type="text/css">
			td{
				width: 400px;
				border:solid 1px #d7a372;
			}
			.dfinput{
				width: 250px;
			}
			.td_left{
				width: 100px;
			}
		</style>
<body>

	<div class="place">
    <ul class="placeul">
      <li>添加客户</li>
    </ul>
    </div>
    
    <div class="formbody">
    
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
    	<button type="button" class="scbtn">保存</button>
    	<button type="button" class="scbtn">关闭</button>
    </div>
    
    
    </div>


</body>

</html>
