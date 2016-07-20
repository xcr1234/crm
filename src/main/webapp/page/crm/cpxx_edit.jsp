<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>新建客户</title>
    <script>
     
        $(function () {
        
        /*  $("#customer_province").click(function(){
            $("#customer_province").children().remove();
            $("#customer_city").children().remove();
            $("#customer_county").children().remove();
            var s=["customer_province","customer_city","customer_county"];//三个select的id  
            var opt0 = [${customer.province},${customer.city},${customer.county}];//初始值
            _init_area();
         }) */
           s=["customer_province","customer_city","customer_county"];//三个select的id  
          var  province="${customer.province}";
          var city="${customer.city}";
          var county="${customer.county}";
          opt0 =[province,city,county];//初始值 */
          console.log(opt0);
         
           $(".delRow").click(function () {
                $(this).parents(".repeatRow").remove();
            });


            var clone = $(".repeatRow").clone(true);
            
            $("#appendRow").click(function () {
                $(".tableform").append($(clone).clone(true));
            });
            
            $("button[name=save]").click(function(){
              $("form[name=kh_form]").submit();
            });
 
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
        input{
         disabled:true;
        }
    </style>
</head>
<body>

        <div class="formtitle"><span>客户基本信息</span></div>
        <form action="${pageContext.servletContext.contextPath}/cpxxgl.do?method=edit&goodsId=${goods.id}" method="post" name="kh_form">
            <table>
                <tr>
                    <td class="td_left">产品名称:</td>
                    <td><input name="customer_name" type="text" class="dfinput" value="${goods.name}" /><i></i></td>
                    <td class="td_left">客户编码:</td>
                    <td><input name="customer_code" type="text" class="dfinput"  value="${goods.code}"/><i></i></td>
                    <td class="td_left">规格型号:</td>
                    <td><input name="customer_code" type="text" class="dfinput"  value="${customer.creator.nickName}"/><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">联系方式:</td>
                    <td><input name="customer_phone" type="text" class="dfinput" value="${customer.phone}" /><i></i></td>
                    <td class="td_left">邮箱:</td>
                    <td><input name="customer_email" type="text" class="dfinput" value="${customer.email}" /><i></i></td>
                    <td class="td_left">详细地址:</td>
                    <td><input name="customer_adress" type="text" class="dfinput" value="${customer.adress}" /><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">QQ:</td>
                    <td><input name="customer_qq" type="text" class="dfinput" value="${customer.qq}" /><i></i></td>
                    <td class="td_left">省:</td>
                   <td><select name="customer_province" id="customer_province" class="dfinput">
                    <%--  <option>${customer.province}</option> --%>
                   </select><i></i></td>
                   <td class="td_left">市:</td>
                   <td><select name="customer_city" id="customer_city" class="dfinput" >
                   <%-- <option>${customer.city}</option> --%>
                   </select><i></i></td>
               </tr>

                <tr>
                    <td class="td_left">县:</td>
                   <td><select name="customer_county" id="customer_county" class="dfinput">
                    <%-- <option>${customer.county}</option> --%>
                   </select><i></i></td>
                    <td class="td_left">销售负责人:</td>
                     <td><select name="salesid" type="text">
                     <c:forEach items="${userRoleList}" var="u" varStatus="status">
                       <c:if test="${customer.sales.id eq u.user.id}">
                       <option  selected="selected"  value="${u.user.id}">${status.index+1}:${u.role.name}--${u.user.nickName}"</option>
                       </c:if>
                       <c:if test="${customer.sales.id ne u.user.id}">
                         <option   value="${u.user.id}">${status.index+1}:${u.role.name}--${u.user.nickName}"</option>
                       </c:if>
                    </c:forEach>
                    </select></td>
                    <td class="td_left">客户类型:</td>
                    <td><select name="dicAll_typeid" type="text">
                       <option>--</option>
                       <c:forEach items="${result.o}" var="dic" varStatus="status">
                       <c:if test="${customer.type.id eq dic.id}">
                       <option selected="selected" value="${dic.id}">${status.index+1}:${dic.name}</option>
                       </c:if>
                       <c:if test="${customer.type.id ne dic.id}">
                       <option value="${dic.id}">${status.index+1}:${dic.name}</option>
                       </c:if>
                       </c:forEach>
                        </select><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">创建日期:</td>
                    <td><input name="customer_createdate" type="text" class="dfinput" id="d12" style="width:180px;" value="${customer.createdate}" /><img onclick="WdatePicker({el:'d12'})" src="${pageContext.servletContext.contextPath}/plugin/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" style="display:inline;"><i></i></td>
                </tr>
            </table>

            <input type="submit" value=""/>
        <div style="text-align: center;margin-top: 5px;">
            <button type="button" class="scbtn sure" name="save">更新</button>
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
