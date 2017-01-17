<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/plugin/editor/kindeditor.js"></script>

<!-- <script type="text/javascript">
    KE.show({
        id : 'content7',
        afterBlur: function(){
        }
    });
  </script> -->
  
<script type="text/javascript">
$(document).ready(function(e) {
    $("input[name=fsyj]").click(function(){
      $("#email").submit();
      /* var mail_content=$("input[name=mail_content]").val();
      var mail_to=$("input[name=mail_to]").val();
      KE.sync('#content7');
      var mail_context=$("#content7").val();
      
      alert(mail_context);
      console.log($("#content7")); */
/*       alert(mail_context); */
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
    <li><a href="#">生日查询</a></li>
    <li><a href="#">发送祝福</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
    <form action="${pageContext.servletContext.contextPath}/khsrxc.do?method=sendMail" method="post" id="email">
  	<ul> 
    <li><a href="#tab1" class="selected">邮件发送</a></li> 
    <!-- <li><a href="#tab2">自定义</a></li>  -->
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <%-- <div class="formtext">您好！<b>${sessionScope.userRole.user.nickName}</b>，欢迎您使用本系统邮件发送功能！</div> --%>
    
    <ul class="forminfo">
    <li><label>邮件主题：<b>*</b></label><input name="mail_title" type="text" class="dfinput" value="${sessionScope.userRole.user.nickName}发送给${link.name}的生日祝福"  style="width:518px;"/></li>
   
    <li><label>发送给：<b>*</b></label><input name="mail_to" type="text" class="dfinput" value="${link.email}"  style="width:518px;"/></li>

    <li><label>邮件内容：<b>*</b></label>
    
     <input type="hidden" name="userId" value="${sessionScope.userRole.user.id}"/>
     <input type="hidden" name="linkId" value="${link.id}"/>
    <textarea id="content7" name="mail_content" style="width:700px;height:250px;" value="">${content}</textarea>
    
    </li>
    
    <li><label>&nbsp;</label><input name="fsyj" type="button" class="btn" value="发送"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="" type="button" class="btn" value="返回"  onclick="history.go(-1)"/></li>
    </ul>
    </form>
    </div> 
       <font style="color:green;font-size:25px;">${info}</font>
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>
