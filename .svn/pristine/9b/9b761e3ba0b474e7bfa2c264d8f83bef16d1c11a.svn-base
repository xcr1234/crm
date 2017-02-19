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
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/DateUtil.js"></script>
    <title>交往记录添加</title>
    <script>
     
        $(function () {
        
          var date=new Date();
          var time=formatDate(date, "yyyy-MM-dd");
          $("input[name=createdate]").val(time);
          $("select[name=contactor]").change(function(){
            var customerName=$("#contactor").find("option:selected").attr("customer");
            $("#customerName").val(customerName);
             $("#customerName").attr("readonly","readonly");
             
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

        <div class="formtitle"><span>交往信息</span></div>
        <form action="${pageContext.servletContext.contextPath}/jwjlgl.do?method=jwjl_add" method="post" name="kh_form">
            <table>
                <tr>
                    <td class="td_left">交往人:</td>
                    <td><select name="contactor" id="contactor">
                    <c:forEach items="${page.items}" var="customerLink" varStatus="status">
                    <option value="${customerLink.id}" customer="${customerLink.customer.name}">${status.index+1}:${customerLink.name}</option>
                    </c:forEach>
                    </select><i></i></td>
                    <td class="td_left">创建人:</td>
                    <td><input name="creator_" type="text" readonly="readonly"  class="dfinput" value="${sessionScope.userRole.user.nickName}"/><input name="userRoleId" type="hidden" value="${sessionScope.userRole.id}"/><i></i></td>
                    <td class="td_left">创建日期:</td>
                    <td><input name="createdate" type="text" class="dfinput" readonly="readonly"/></td>
                </tr>

                <tr>
                    <td class="td_left">所属客户:</td>
                    <td><input name="customer" type="text" class="dfinput" id="customerName"/><i></i></td>
                    <td class="td_left">联系电话:</td>
                    <td><input name="phone" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">开始时间:</td>
                    <td><input name="startTime" type="text" class="dfinput" id="d11" onClick="WdatePicker()"/><i></i></td>
                </tr>

                <tr>
                <td class="td_left">结束时间:</td>
                    <td><input name="endTime" type="text" class="dfinput" id="d11" onClick="WdatePicker()"/><i></i></td>
                    <td class="td_left">交往内容:</td>
                    <td><input name="context" value="" type="text" class="dfinput" /><input type="hidden" name="userId" value="${sessionScope.userRole.user.id}"><i></i></td>
                    <td class="td_left">备注:</td>
                   <td><input name="content" value="" type="text" class="dfinput" /><i></i></td>
               </tr>
               <%-- <tr>
               <td class="td_left">点评:</td>
               <td colspan="5"><input name="remark" value="${time}" type="text" class="dfinput"/></td>
               </tr> --%>
            </table>
            </form>
 <input type="submit" value=""/>
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

           