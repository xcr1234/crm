<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/city.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/plugin/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/MD5.js"></script>
    <title>新建客户</title>
    <script>
     
        $(function () {
          $("#qxfp").change(function(){
            if(confirm("选择后将不可更改，您确定要继续吗？")){
               var Id=$(this).val();
               var roleId={roleId:Id};
                $.getJSON("${pageContext.servletContext.contextPath}/yhgl.do?method=getCode",roleId,function(data){
                 $("input[name=user_userName]").val(data);
                  $("input[name=user_password]").val($.md5(data));
                  var name=data.substring(data.length-4, data.length);
                  if(Id=="1"){
                    name='管理员'+name;
                  }
                  if(Id=="2"){
                    name='业务经理'+name;
                  }
                  if(Id=="3"){
                    name='业务员'+name;
                  }
                  $("input[name=user_nickName]").val(name);
                  $("#qxfp").attr("readonly","readonly");
               }) 
			    }else{
			   }
          });
          
            $(".delRow").click(function () {
                $(this).parents(".repeatRow").remove();
            });


            var clone = $(".repeatRow").clone(true);
            
            $("#appendRow").click(function () {
                $(".tableform").append($(clone).clone(true));
            });
            
            $("button[name=save]").click(function(){
              $("form[name=kh_form]").submit();
            })

              _init_area();


            
        });
    </script>
    <style type="text/css">
        body{
            /*background-color: red;*/

        }
        th{
            text-align:center;
        }
        td{
            width: 200px;
            padding-left: 10px;
            border:solid 1px #d7a372;
        }
        .dfinput{
            width: 250px;
            height: 25px;
        }
        .td_left{
            width: 100px;
        }
        .tip{width:1400px; height:600px; background:#fcfdfd;box-shadow:1px 8px 10px 1px #9b9b9b;border-radius:1px;behavior:url(js/pie.htc);  z-index:111111;
            display: block;padding: 20px 20px;
        }

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
</head>
<body>

        <div class="formtitle"><span>用户信息</span></div>
        <form action="${pageContext.servletContext.contextPath}/yhgl.do?method=user_add" method="post" name="kh_form">
            <table>
            <tr>   
                    <td class="td_left">权限分配:</td>
                    <td><select name="role_name" id="qxfp">
                    <option value="0">请选择</option>
                    <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
                    <option value="1">管理员</option>
                    <option value="2">业务经理</option>
                    </c:if>
                    <option value="3">业务员</option>
                    </select><i></i></td>
                    <td colspan="2"><font style="color:green;">请选择您想分配的权限</font><input type="hidden" value="${sessionScope.userRole.user.id}" name="userId"/></td>
                </tr>
                <tr>
                    <td class="td_left">用户姓名:</td>
                    <td><input name="user_nickName" type="text" value="系统自动生成" class="dfinput" readonly="readonly"/><i></i></td>
                    <td class="td_left">用户账号:</td>
                    <td><input name="user_userName" value="系统自动生成" type="text" class="dfinput" readonly="readonly"/><i></i></td>
                    <td class="td_left">用户密码:</td>
                    <td><input name="user_password" type="text" value="系统自动生成" class="dfinput" readonly="readonly"/></td>
                </tr>

                
               </table>
            </form>
        <div style="text-align: center;margin-top: 5px;">
           <!--  <button type="button" class="scbtn" id="appendRow">添加一行</button> -->
            <button type="button" class="scbtn sure" name="save">保存</button>
            <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
        </div>

        <div id="return_info"><font style="color:green;">${result.info}</font></div>

    <!--<div class="tipbtn">
    <input name="" type="button"  class="sure" value="确定" />&nbsp;
    <input name="" type="button"  class="cancel" value="取消" />
    </div>-->

</div>
</body>
</html>

           