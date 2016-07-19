<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>项目机会</title>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
    <script>
        Date.prototype.format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        };
        $(function(){

            $("#createdate").val(new Date().format("yyyy/MM/dd"));
        })
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
                    <td><input name="code" type="text" class="dfinput" disabled="disabled" value="系统自动生成"/><i></i></td>
                    <td class="td_left">机会名称:</td>
                    <td><input name="name" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">客户名称:</td>
                    <td>
                        <select style="text-align: center;" name="customer">
                            <c:forEach items="${customer}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="td_left">机会类型</td>
                    <td style="text-align: center;">
                        <select style="width: 100px;" name="type">
                            <c:forEach items="${jhlx}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">机会阶段:</td>
                    <td style="text-align: center;" >
                        <select style="width: 100px;" name="chanceStage">
                            <c:forEach items="${jhjd}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">成交可能性:</td>
                    <td style="text-align: center;">
                        <select style="width: 100px;" name="possibility">
                            <c:forEach items="${cjknx}" var="item">
                                <option value="${item.name}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="td_left">附件信息:</td>
                    <td>
                        <select style="text-align: center;" name="attach">
                            <c:forEach items="${attach}" var="item">
                                <option value="-1">请选择</option>
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">创建人:</td>
                    <td  style="text-align: center;">
                        <select style="text-align: center;" name="creator">
                            <c:forEach items="${userList}" var="item">
                                <option value="${item.id}">${item.nickName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">创建日期:</td>
                    <td><input name="createdate" id="createdate" type="text" class="dfinput"/><i></i></td>
                </tr>
            </table>

        <div style="text-align: center;margin-top: 5px;">


            <button type="submit" class="scbtn sure" name="save">保存</button>
            <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
        </div>
        </form>
    </div>
</div>

</body>
</html>
