<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://oraclewdp.com/page" prefix="p" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>公共客户池</title>
    
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
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/xlsx.core.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/blob.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/FileSaver.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/excel/tableexport-3.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/DateUtil.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$.fn.tableExport.xlsx = {
    defaultClass: "xlsx",
    buttonContent: "确认导出",
    mimeType: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    fileExtension: ".xlsx"
};
$("#export").click(function(){
 var tableName="公共客户池"; //初始化表名
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

 var customerId=null;
 var userId=null;
 //分配销售负责人(业务员)
 $("#fpku").change(function(){
 userId= $("#fpku option:selected").attr("value");
 });
 
 
 //删除操作
 $("a[name=delete]").click(function(the){
 var customerId=$(this).attr("value");
 if(confirm("确定要删除数据吗")){
   window.location.href="${pageContext.servletContext.contextPath}/ggkhc.do?method=delete&customerId="+customerId;
    }else{
   }
 

/* $.ajax({ 
type : "post", 
url : "http://localhost:8090/webplus3/_web/sns/delBlog.do?_p=YXM9Mw__&id=" + id, 
success : function(data) { 
if(data == "success") { 
$(the).parents("tr").remove(); 
parent.initDraft(); 
} 
} 

});  */
 });
 
 
 $(".click").click(function(){
 
   customerId=$(this).attr("value");
  console.log(customerId+"--"+userId);
  $(".tip").fadeIn(200);  
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

//分配客户
  $(".sure").click(function(){
  userId=$(":selected","#fpkh").attr("value");
  var url="${pageContext.servletContext.contextPath}/ggkhc.do?method=fpkh&customerId="+customerId+"&userId="+userId;
  var data={customerId:customerId,userId:userId};
  $.getJSON(url,data,function(){
  $(".tip").fadeOut(100);
  alert("分配成功！");
  window.location.href="${pageContext.servletContext.contextPath}/ggkhc.do?method=fpkh&customerId="+customerId+"&userId="+userId;
  });
  
  
  
  window.location.href="${pageContext.servletContext.contextPath}/ggkhc.do?method=listGgkh";
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

 $("button[name=save]").click(function(){
/*  var name=$(".tip input[name=name]").val(); //客户名称
 var creator=$(".tip input[name=creator]").val(); //创建人
 var phone=$(".tip input[name=phone]").val();  //联系方式
 var email=$(".tip input[name=email]").val();  //邮箱
 var adress=$(".tip input[name=adress]").val();   //详细地址
 var qq=$(".tip input[name=qq]").val();      //qq
 var provence=$(".tip input[name=provence]").val();  //省
 var city=$(".tip input[name=city]").val();     //市
 var county=$(".tip input[name=county]").val(); //县
 var sales=$(".tip input[name=sales]").val();    //销售负责人
 var customer_type=$(".tip input[name=customer_type]").val();  //客户类型
 var createdate=$(".tip input[name=createdate]").val();  //创建日期 */
 
 /* var data=name+creator+phone+email+adress+qq+provence+city+county+sales+customer_type; */
 /* var data={customer_name:name,user_creatorid:creator,customer_phone:phone,customer_email:email,customer_adress:adress,customer_qq:qq,provence:provence,city:city,county:county,sales:sales,dicAll_typeid:customer_type,customer_createdate:createdate}; */
 $("#return_info").load(url,data,function(){

 });
 })

$("#search").click(function(){
   var name=$("li input[name=name]").val();
   var code=$("li input[name=code]").val();
   var customer_type=$("li select[name=customer_type]").val();
   var data={name:name,code:code,customer_type:customer_type};
   var url="${pageContext.servletContext.contextPath}/ggkhc.do?method=searchGgku";
   
   window.location.href=url+"&name="+name+"&code="+code+"&customer_type="+customer_type;
  /*  $.getJSON(url,data,function(result){
     
   })  */
 })
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
	  height:40px;
	}
	tbody td{
		width: 400px;
		height:30px;
		border:solid 1px #d7a372;
	}
	tbody tr{
	height:40px;
	}
	.dfinput{
		width: 250px;
		height: 25px;
	}
	.td_left{
		width: 100px;
		}
	.tip{width:500px; height:300px; position:absolute;top:10%; left:10%;background:#fcfdfd;box-shadow:1px 8px 10px 1px #9b9b9b;border-radius:1px;behavior:url(js/pie.htc); display:none; z-index:111111;}

 select {
	 font-size:14px;
	 padding-left: 10px;
   opacity: 1;
    display:block;
    width: 150px;
	height: 32px;
	border-width: 1px;
    border-style: solid;
    border-color: rgb(195, 171, 125) rgb(231, 213, 186) rgb(231, 213, 186) rgb(195, 171, 125);
}

 option{
	 font-size:14px;
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
     <li><a href="#">客户管理</a></li>
    <li><a href="#">交往记录</a></li>
   
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<c:if test="${sessionScope.userRole.role.name eq '管理员'}">
        <li  onclick="location.href='${pageContext.servletContext.contextPath}/ggkhc.do?method=listSelect'"><span><img src="images/t01.png" /></span>新建客户</li>
        </c:if>
        <li  id="search"><span><img src="${pageContext.servletContext.contextPath}/images/ico06.png" /></span>查询</li>
       <li id="export"><span><img src="${pageContext.servletContext.contextPath}/images/lc04.png" width="25px" height="25px"/></span>导出报表</li>          
        </ul>
    </div>
    
    <ul class="seachform">
    <li><label>客户名称</label><input name="name" type="text" class="scinput" /></li>
    <li><label>客户编码</label><input name="code" type="text" class="scinput" /></li>
    <li><label>客户类型</label>  
	<select name="customer_type">
	   <option value="no" selected="selected">--</option>
	   <c:forEach items="${khlx}" var="dic" varStatus="status">
	     <option name="fpku" value="${dic.id}">${status.index+1}:${dic.name}</option>
	    </c:forEach>	
	</select>
 
   </li>
    <%-- <li><label>客户来源</label>  
    <div class="vocation">
	<select name="">
	   <option selected="selected">--</option>
	   <c:forEach items="${khly}" var="dic" varStatus="status">
	     <option value="${dic.id}">${status.index+1}:${dic.name}</option>
	    </c:forEach>	
	</select>
   </li> --%>
    
    </ul>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th style="width: 100px">序号</th>
        <th>客户名称</th>
        <th style="width:200px;">客户编码</th>
        <th>省份</th>
        <th>城市</th>
        <th>区/县</th>
        <th>电话</th>
	  	<th>创建人</th>
	  	<th>创建日期</th>
	  	<th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr style="height:40px;">
        <c:forEach items="${page.items}" var="customer" varStatus="status">
          <td style="width: 50px">${status.index+1}</td>
          <td>${customer.name}</td>
          <td style="width:180px;">${customer.code}</td>
          <td style="width:100px;">${customer.province}</td>
          <td style="width:100px;">${customer.city}</td>
          <td>${customer.county}</td>
          <td style="width:180px;">${customer.phone}</td>
          <td>${customer.creator.nickName}</td>
          <td>${customer.createdate}</td>
          <td>
             <a href="${pageContext.servletContext.contextPath}/ggkhc.do?method=detail&id=${customer.id}">查看</a>&nbsp;
             <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
             <a href="${pageContext.servletContext.contextPath}/ggkhc.do?method=edit&id=${customer.id}">编辑</a>&nbsp;
             <a href="#" value="${customer.id}" name="delete" >删除</a>&nbsp;
             <a href="#" class="click" value="${customer.id}">分配</a>&nbsp;
            </c:if>
           </td>
        </tr>
         </c:forEach>
        </tbody>
    </table>
    
    <p:page pages="${page}" link="ggkhc.do?method=listGgkh&" prev="上一页" first="首页" last="尾页" next="下一页" ulClass="paginList" />
  <%--  <c:if test="${page.pageCount gt 0}">
    <div class="pagin">
    	<div class="message">共<i class="blue">${page.count}</i>条记录，当前显示第&nbsp;<i class="blue">${page.current}&nbsp;</i>页</div>
        <ul class="paginList">
        <c:if test="${page.pageCount lt 7}">
           <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
             <c:forEach begin="1" step="1" var="index" end="${page.pageCount}" >
	             <c:if test="${page.current eq index}">
	              <li class="paginItem current"><a href="javascript:;">${index}</a></li>
	             </c:if>
	             <c:if test="${page.current ne index}">
	              <li class="paginItem"><a href="javascript:;">${index}</a></li>
	             </c:if>
             </c:forEach>
          <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </c:if>
        
        <c:if test="${page.current>7}">
            <c:if test="${page.current le page.count-3}">
              <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
              <c:forEach begin="${page.current-3}" step="1" var="index" end="${page.current+3}" >
	             <c:if test="${page.current eq index}">
	              <li class="paginItem current"><a href="javascript:;">${index}</a></li>
	             </c:if>
	             <c:if test="${page.current ne index}">
	              <li class="paginItem"><a href="javascript:;">${index}</a></li>
	             </c:if>
             </c:forEach>
             <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
             </c:if>
             
             <c:if test="${page.current gt page.count-3}">
                 <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
              <c:forEach begin="${page.count-6}" step="1" var="index" end="${page.count}" >
	             <c:if test="${page.current eq index}">
	              <li class="paginItem current"><a href="javascript:;">${index}</a></li>
	             </c:if>
	             <c:if test="${page.current ne index}">
	              <li class="paginItem"><a href="javascript:;">${index}</a></li>
	             </c:if>
             </c:forEach>
             <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            </c:if>
      </c:if>
  </c:if>          --%>
           
  
   
    </div>
    
    <div id="return_info"></div>
    
 <!--转移客户对话框开始  -->
        <div class="tip">
    	<div class="tiptop"><span>转移客户</span><a></a></div>
        
      <div class="tipinfo">
      <p style="font-size:30px;">分配给--></p>
        <select id="fpkh">
        <c:forEach items="${userRolePages.items}" var="u" varStatus="status">
        <option value="${u.user.id}">${status.index+1}:${u.role.name}--${u.user.nickName}</option>
        </c:forEach>
        </select>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
   <!-- 结束 --> 
   </div>
     
    </div>

    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
