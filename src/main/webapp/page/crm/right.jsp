<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>CRM</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>

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
					<li class="click"><span><img src="images/t01.png" /></span>添加</li>
					<li class="click"><span><img src="images/ico06.png" /></span>查询</li>
					<li><span><img src="images/t03.png" /></span>重置</li>
				</ul>
			</div>
			<div class="formbody">
			<form action="">
			<table class="">
        
        <tbody>
				 
				 <tr>
					<td class="td_left">客户名称：</td>
					<td><input name="" type="text" class="dfinput" /></td>
					<td class="td_left">客户编码:</td>
					<td><input name="" type="text" class="dfinput" /></td>
				  <td class="td_left"> 客户类型：</td>
					<td><select value="请选择">
							<option>一般客户</option>
							<option>VIP客户</option>
							<option>潜在客户</option>
							<option>长期跟踪客户</option>
							<option>重要客户</option>
							<option>流失客户</option>
							<option>A客户</option>
						  </select>
					</td>
					</tr>
				<tr>
						<td class="td_left"> 客户来源；</td>
						<td>
						  <select value="请选择">
							<option>客户介绍</option>
							<option>广告</option>
							<option>网络搜索</option>
							<option>朋友介绍</option>
							<option>其他</option>
						  </select>
						</td>
						<td class="td_left">所   在   市:</td>
						<td>
						<input name="" type="text" class="dfinput" class="" />
					  </td>
					  <td class="td_left">创   建  人：</td>
					  <td>
						<input name="" type="text" class="dfinput"  />
				   	</td>
						
					
				</tr>
				
				<tr>
					<td class="td_left">创建日期:</td>
					<td>
						<input name="" type="text" class="dfinput"  />
					</td>
					<td class="td_left">客户电话：</td>
					<td>
						<input name="" type="text" class="dfinput"  />
					</td>
					<td class="td_left">联系电话：</td>
					<td>
						<input name="" type="text" class="dfinput"  />
					</td>
			</tr>	
			<tr>	
					<td class="td_left">联系人手机：</td>
					<td>
						<input name="" type="text" class="dfinput"  />
					</td>	
			</tr>
			  
        </tbody>
			  
			</table>
			
			</form>
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