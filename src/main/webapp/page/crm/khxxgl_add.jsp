
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户信息管理</title>
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
<div class="tip">

    <div class="ke-dialog-body">
        <div class="formtitle"><span>客户信息添加</span></div>
        <form action="" method="post" name="gh_form">
            <table>
                <tr>
                    <td class="td_left">客户名称：</td>
                    <td><input name="customerId" type="number" class="dfinput"/><i></i></td>
                    <td class="td_left">客户编码:</td>
                    <td><input name="date" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">客户类型：</td>
                    <td><select value="请选择">
                        <option>一般客户</option>
                        <option>VIP客户</option>
                        <option>潜在客户</option>
                        <option>长期跟踪客户</option>
                        <option>重要客户</option>
                        <option>流失客户</option>
                        <option>A客户</option>
                    </select><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">客户来源：</td>
                    <td> <select value="请选择">
                        <option>客户介绍</option>
                        <option>广告</option>
                        <option>网络搜索</option>
                        <option>朋友介绍</option>
                        <option>其他</option>
                    </select><i></i></td>
                    <td class="td_left">所在市:</td>
                    <td><input name="" type="text" class="dfinput" class="" /><i></i></td>
                    <td class="td_left">&nbsp;</td>
                    <td>&nbsp;<i></i></td>
                </tr>
            </table>
        </form>
        <div style="text-align: center;margin-top: 5px;">


            <button type="button" class="scbtn sure" name="save">保存</button>
            <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
        </div>

    </div>
</div>

</body>
</html>
