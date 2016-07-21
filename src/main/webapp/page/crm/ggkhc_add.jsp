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
    <title>新建客户</title>
    <script>
     
        $(function () {
          
            var date=new Date();
            var time=formatDate(date, "yyyy-MM-dd");
            $("input[name=customer_createdate]").val(time);
           
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

        <div class="formtitle"><span>客户基本信息</span></div>
        <form action="${pageContext.servletContext.contextPath}/ggkhc.do?method=kh_add" method="post" name="kh_form">
            <table>
                <tr>
                    <td class="td_left">客户名称:</td>
                    <td><input name="customer_name" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">客户编码:</td>
                    <td><input name="customer_code" type="text" class="dfinput" readonly="readonly" value="客户编码由系统自动生成"/><i></i></td>
                    <td class="td_left">创建人:</td>
                    <td><input name="user_creatorName" type="text" class="dfinput" readonly="readonly" value="${sessionScope.userRole.user.nickName}"/><i></i>
                         <input type="hidden" name="user_creatorid" value="${sessionScope.userRole.user.id}"/>
                    <%-- <select name="user_creatorid" readonly="readonly">
                    <c:forEach items="${userRoleList}" var="u" varStatus="status">
                    <option value="${u.user.id}">${status.index+1}:${u.role.name}--${u.user.nickName}</option>
                    </c:forEach>
                    </select> --%>
                    </td>
                </tr>

                <tr>
                    <td class="td_left">联系方式:</td>
                    
                    <td><input name="customer_phone" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">邮箱:</td>
                   
                    <td><input name="customer_email" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">详细地址:</td>

                    <td><input name="customer_adress" type="text" class="dfinput"/><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">QQ:</td>
                    <td><input name="customer_qq" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">省:</td>
                   <td><select name="customer_province" id="customer_province" class="dfinput"></select><i></i></td>
                   <td class="td_left">市:</td>
                   <td><select name="customer_city" id="customer_city" class="dfinput"></select><i></i></td>
               </tr>

                <tr>
                    <td class="td_left">县:</td>
                   <td><select name="customer_county" id="customer_county" class="dfinput"></select><i></i></td>
                    <td class="td_left">销售负责人:</td>
                     <td>
                     <c:if test="${sessionScope.userRole.role.name eq '管理员'}">
                     <select name="salesid" type="text">
                     <c:forEach items="${userRoleList}" var="u" varStatus="status">
                    <option value="${u.user.id}">${status.index+1}:${u.role.name}--${u.user.nickName}</option>
                    </c:forEach>
                    </select>
                    </c:if>
                    <c:if test="${sessionScope.userRole.role.name ne '管理员'}">
                     <input readonly="readonly" type="text" value="${sessionScope.userRole.role.name}:${sessionScope.userRole.user.nickName}"/><input name="salesid" type="hidden" class="dfinput" value="${sessionScope.userRole.user.id}"/><i></i>
                     </c:if>
                    </td>
                    <td class="td_left">客户类型:</td>
                    <td><select name="dicAll_typeid" type="text">
                       <option>请选择</option>
                       <c:forEach items="${result.o}" var="dic" varStatus="status">
                       <option value="${dic.id}">${status.index+1}:${dic.name}</option>
                       </c:forEach>
                        </select><i></i></td>
                   <!--  <td><input name="dicAll_typeid" type="text" class="dfinput"/><i></i></td> -->
                </tr>

                <tr>
                    <td class="td_left">创建日期:</td>
                    <td><input name="customer_createdate" type="text" class="dfinput" id="d12" style="width:180px;" readonly="readonly"/><img onclick="WdatePicker({el:'d12'})" src="${pageContext.servletContext.contextPath}/plugin/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" style="display:inline;"><i></i></td>
                </tr>
            </table>

            <input type="submit" value=""/>


        <div class="formtitle"><span>客户联系人</span></div>
        <table class="tableform">

            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>职位</th>
                <th>手机</th>
                <th>工作电话</th>
                <th>E-mail</th>
                <th>出生日期</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <tr class="input repeatRow">
                <td><input type="text" name="listCustomerLink_name"/></td>
                <td style="text-align: center;">
                    <select style="font-size: 25px;width: 100px;" name="listCustomerLink_sexid">
                        <option value="1" style="font-size: 25px;">男</option>
                        <option value="0" style="font-size: 25px;">女</option>
                    </select>
                </td>

                </td>
                <td><input type="text" name="listCustomerLink_position"/></td>
                <td><input type="text" name="listCustomerLink_phone"/></td>
                <td><input type="text" name="listCustomerLink_phone2"/></td>
                <td><input type="text" name="listCustomerLink_email"/></td>
                <td><input type="text" name="listCustomerLink_birthdate" id="d11" onClick="WdatePicker()"/></td>
                <td ><input type="text" name="listCustomerLink_content"/></td>
                <td style="text-align: center;"><a href="javascript:;" class="delRow">删除</a></td>
            </tr>
        </table>
        </form>
        <div style="text-align: center;margin-top: 5px;">

            <button type="button" class="scbtn" id="appendRow">添加一行</button>
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
