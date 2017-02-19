<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>项目机会查看</title>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
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
            /* height: 25px;*/
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
            /*height:18px;*/
        }
    </style>
</head>
<body>

<div class="tip">

    <div class="ke-dialog-body">
        <div class="formtitle"><span>项目机会添加</span></div>
        <form action="<%=basePath%>xmjh.do?method=add_submit" method="post" name="gh_form">
            <table>
                <tr>
                    <td class="td_left">机会编号:</td>
                    <td><input name="code" type="text" class="dfinput" disabled="disabled" value="${customChance.code}"/><i></i></td>
                    <td class="td_left">机会名称:</td>
                    <td><input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.name}"/><i></i></td>
                    <td class="td_left">客户名称:</td>
                    <td>
                        <input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.customer.name}"/><i></i>
                    </td>
                </tr>

                <tr>
                    <td class="td_left">机会类型</td>
                    <td style="text-align: center;">
                        <input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.type.name}"/><i></i>
                    </td>
                    <td class="td_left">机会阶段:</td>
                    <td style="text-align: center;" >
                        <input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.chanceStage.name}"/><i></i>
                    </td>
                    <td class="td_left">成交可能性:</td>
                    <td style="text-align: center;">
                        <input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.possibility}"/><i></i>
                    </td>
                </tr>

                <tr>
                    <td class="td_left">附件信息:</td>
                    <td>
                        <input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.attach.name}"/><i></i>
                    </td>
                    <td class="td_left">创建人:</td>
                    <td  style="text-align: center;">
                        <input name="name" type="text" class="dfinput" disabled="disabled" value="${customChance.creator.nickName}"/><i></i>
                    </td>
                    <td class="td_left">创建日期:</td>
                    <td><input name="createdate" id="createdate" class="dfinput" disabled="disabled" value="${customChance.createdate}"  type="text" class="createdate"/><i></i></td>
                </tr>
            </table>

            <div style="text-align: center;margin-top: 5px;">


                <button type="button" disabled="disabled" class="scbtn sure" name="save">保存</button>
                <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
