<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"
           uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>销售报价单添加</title>
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

            $("#createdate").val(new Date().format("yyyy-MM-dd"));
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
    <script type="text/javascript">

        $(function () {
            $(".delRow").click(function () {
                $(this).parents(".repeatRow").remove();
            });


            var clone = $(".repeatRow").clone(true);

            $("#appendRow").click(function () {

                $(".tableform").append($(clone).clone(true));

            });





        });
    </script>
</head>
<body>
<div class="tip">
    <div class="ke-dialog-body">
        <div class="formtitle"><span>销售报价单添加</span></div>
        <form action="<%=basePath%>xmjh.do?method=addXsbjd_submit" method="post" name="gh_form">
            <table>

                <tr>
                    <td class="td_left">报价单编号:</td>
                    <td><input name="code" type="text" class="dfinput" disabled="disabled" value="系统自动生成"/><i></i></td>
                    <td class="td_left">报价人:</td>
                    <td>
                        <select name="bjr">
                            <c:forEach items="${userList}" var="item">
                                <option value="${item.id}">${item.nickName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">有效日期:</td>
                    <td><input name="yxrq" type="text" class="dfinput"></td>
                </tr>
                <tr>
                    <td class="td_left">报价日期:</td>
                    <td><input name="bjrq" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">创建人:</td>
                    <td>
                        <input name="creator" type="text" class="dfinput"/><i></i>
                    </td>
                    <td class="td_left">联系电话:</td>
                    <td><input type="text" name="phone" class="dfinput"></td>
                </tr>
                <tr>
                    <td class="td_left">菜单折扣:</td>
                    <td><input name="cdzk" type="text" class="dfinput" /><i></i></td>
                    <td class="td_left">数量合计:</td>
                    <td><input name="totle_count" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">税率合计:</td>
                    <td><input name="totle_rate" type="text" class="dfinput"/><i></i>
                    </td>
                </tr>
                <tr>
                    <td class="td_left">含税单价合计:</td>
                    <td><input name="totle_pre_price_rate" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">税金合计:</td>
                    <td><input name="totle_price_rate" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">货款合计:</td>
                    <td><input name="totle_price" type="text" class="dfinput"/><i></i>
                    </td>
                </tr>
                <tr>
                    <td class="td_left">折扣后合计:</td>
                    <td><input name="totle_discount_price" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">所属客户</td>
                    <td>
                        <select name="sskh">
                            <c:forEach items="${customerList}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">创建日期</td>
                    <td><input type="text" value="" id="createdate" name="createdate"></td>
                </tr>
            </table>
            <div class="formtitle"><span>报价单商品列表</span></div>
            <table class="tableform" style="    width: 1100px;">
                <thead>
                <tr>
                    <th>商品</th>
                    <th>数量</th>
                    <th>税率%</th>
                    <th>含税单价</th>
                    <th>摘要</th>
                    <th>税金</th>
                    <th>货款</th>
                    <th>合计</th>
                    <th>&nbsp;</th>
                </tr>


                </thead>

                <tbody>
                <tr  class="input repeatRow">
                    <td>
                        <select name="goods">
                            <c:forEach items="${goodsList}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="text" name="count"/></td>
                    <td><input type="text" name="rate"/></td>
                    <td><input type="text" name="per_price_rate"/></td>
                    <td><input type="text" name="digest"/></td>
                    <td><input type="text" name="price_rate"/></td>
                    <td><input type="text" name="price"/></td>
                    <td><input type="text" name="totle_price"/></td>
                    <td style="text-align: center"><a href="javascript:;"  class="delRow">删除</a></td>
                </tr>

                </tbody>
            </table>



        <div style="text-align: center;margin-top: 5px;">

            <button type="button" class="scbtn" id="appendRow">添加一行</button>
            <button type="submit" class="scbtn sure" name="save">保存</button>
            <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
        </div>

        </form>
    </div>
</div>
</body>
</html>
