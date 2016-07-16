<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>交往记录管理</title>
    
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
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 152
	});
});
</script>
</head>

<body class="sarchbody">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    
    <ul class="seachform1">
    
    <li><label>项目名称</label><input name="" type="text" class="scinput1" /></li>
    <li><label>学校名称</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>项目状态</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>    

    
    </ul>
    
    <ul class="seachform2">
    
    <li><label>项目编号</label><input name="" type="text" class="scinput1" /></li>
    <li><label>项目类型</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>项目领域</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>立项部门</label><input name="" type="text" class="scinput1" /></li>
    <li><label>经费范围</label><input name="" type="text" class="scinput1" /></li>
    <li><label>一</label><input name="" type="text" class="scinput1" /></li>
    <li><label>负责人</label><input name="" type="text" class="scinput1" /></li>
    <li><label>立项时间</label><input name="" type="text" class="scinput1" /></li>
    <li><label>一</label><input name="" type="text" class="scinput1" /></li>      

    
    </ul>
    
    <ul class="seachform1">
    <li class="sarchbtn"><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/>   <input name="" type="button" class="scbtn1" value="更多条件"/>   <input name="" type="button" class="scbtn2" value="导出"/></li>  
    </ul>
    
    <script language="javascript">
	$(document).ready(function() 
{ 
    $(".scbtn1").click(function() 
    {      
        if( $(".seachform2").hasClass("hideclass") ) 
        { 
            $(".seachform2").removeClass("hideClass"); 
        } 
        else 
        { 
            $(".seachform2").addClass("hideClass"); 
        }    
    }); 
}); 
	
	
	</script>
    
    
    <script type="text/javascript">
$(document).ready(function(){
  $(".scbtn1").click(function(){
  $(".seachform2").fadeIn(200);
  }); 


});
</script>

    
    
    
    <div class="formtitle"><span>项目列表</span></div>
    
   <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>客户类型<i class="sort"><img src="images/px.gif" /></i></th>
        <th>客户姓名</th>
        <th>交往人</th>
        <th>交往内容</th>
        <th>创建人</th>
        <th>创建日期</th>
        <th>联系电话</th>
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
    

       
	</div> 
 

    
    
    </div>


</body>

</html>
