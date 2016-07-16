<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户关怀 - 添加</title>
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
        <div class="formtitle"><span>客户关怀</span></div>
        <form action="" method="post" name="gh_form">
            <table>
                <tr>
                <td class="td_left">关怀客户编号:</td>
                <td><input name="customerId" type="number" class="dfinput"/><i></i></td>
                <td class="td_left">关怀日期:</td>
                <td><input name="date" type="text" class="dfinput"/><i></i></td>
                <td class="td_left">联系人电话:</td>
                <td><input name="phone" type="text" class="dfinput"/><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">联系人手机:</td>
                    <td><input name="phone2" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">内容:</td>
                    <td><input name="content" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">备注:</td>
                    <td><input name="remark" type="text" class="dfinput"/><i></i></td>
                </tr>
            </table>

            <div style="text-align: center;margin-top: 5px;">


                <button type="button" class="scbtn sure" name="save">保存</button>
                <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
            </div>

            <div id="return_info"></div>


        </form>
    </div>
</div>

</body>
</html>
