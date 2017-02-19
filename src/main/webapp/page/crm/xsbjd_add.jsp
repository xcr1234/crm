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
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/plugin/My97DatePicker/WdatePicker.js"></script>
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

            var func = function(){
                var price = $(this).find("option:selected").data("price");
                $(this).parents("tr").find(".goodprice").val(price);

            };
            $("select[name='goods']").change(func);
            func.call($("select[name='goods']"));


            $(".delRow").click(function () {
                $(this).parents(".repeatRow").remove();
            });



            $("input[name='count']").change(function () {
                calc.call(this);
            });

            $("input[name='rate']").change(function () {

                calc.call($(this).parents("tr").find("input[name='count']"));



            });

            $("input[name='discount']").change(function () {


                var zk = parseInt($(this).val());
                var total = parseFloat($("input[name='totle_price']").val());
                if($.isNumeric(total)){



                    $("input[name='totle_discount_price']").val((total*zk/100).toFixed(2));
                }

            });






            //clone一定要放在最后面
            var clone = $(".repeatRow").clone(true);

            $("#appendRow").click(function () {

                $(".tableform").append($(clone).clone(true));

            });

        });

        function calc() {

            var val = $(this).val();
            if(!$.isNumeric(val)){

                $(this).parents("tr").find("input[name='per_price_rate']").val("");
                $(this).parents("tr").find("input[name='price_rate']").val("");
                $(this).parents("tr").find("input[name='price']").val("");
                $(this).parents("tr").find("input[name='totle_price']").val("");

            }else{
                var num = parseInt(val);
                var rate = parseInt($(this).parents("tr").find("input[name='rate']").val());
                var price = parseFloat( $(this).parents("tr").find("input[name='goodprice']").val());


                $(this).parents("tr").find("input[name='per_price_rate']").val(price+rate/100*price);
                $(this).parents("tr").find("input[name='price_rate']").val(num*price*rate/100);
                $(this).parents("tr").find("input[name='price']").val(num*price);
                $(this).parents("tr").find("input[name='totle_price']").val(num*price+num*price*rate/100);
            };


            $("input[name='totle_count']").sum("input[name='count']");
            $("input[name='totle_rate']").sum("input[name='rate']");
            $("input[name='totle_pre_price_rate']").sum("input[name='per_price_rate']");
            $("input[name='totle_price_rate']").sum("input[name='price_rate']");
            $("#table1 input[name='totle_price']").sum("#table2 input[name='price']");





            $("input[name='discount']").change();




        };

        $.fn.sum = function (selector) {
            var sum = 0;
            $(selector).each(function () {
                var val = $(this).val();
                if($.isNumeric(val)){
                    sum = sum + parseFloat(val);
                }

            });
            $(this).val(sum);
        }






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
        <div class="formtitle"><span>销售报价单添加</span></div>
        <form action="<%=basePath%>xmjh.do?method=addXsbjd_submit" method="post" name="gh_form">
            <table id="table1">

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
                    <td><input name="yxrq" type="text" class="dfinput"  onClick="WdatePicker()"></td>
                </tr>
                <tr>
                    <td class="td_left">报价日期:</td>
                    <td><input name="bjrq" type="text" class="dfinput"  onClick="WdatePicker()"/><i></i></td>
                    <td class="td_left">创建人:</td>
                    <td>
                        <input name="creator" type="text" class="dfinput" value="${sessionScope.userRole.user.nickName}" readonly="readonly"/><i></i>
                    </td>
                    <td class="td_left">联系电话:</td>
                    <td><input type="text" name="phone" class="dfinput"></td>
                </tr>
                <tr>
                    <td class="td_left">菜单折扣:%</td>
                    <td><input name="discount" type="number" class="dfinput" value="100" /><i></i></td>
                    <td class="td_left">数量合计:</td>
                    <td><input name="totle_count" type="text" class="dfinput" readonly="readonly"/><i></i></td>
                    <td class="td_left">税率合计:</td>
                    <td><input name="totle_rate" type="text" class="dfinput" readonly="readonly"/><i></i>
                    </td>
                </tr>
                <tr>
                    <td class="td_left">含税单价合计:</td>
                    <td><input name="totle_pre_price_rate" type="text" class="dfinput" readonly="readonly"/><i></i></td>
                    <td class="td_left">税金合计:</td>
                    <td><input name="totle_price_rate" type="text" class="dfinput" readonly="readonly"/><i></i></td>
                    <td class="td_left">货款合计:</td>
                    <td><input name="totle_price" type="text" class="dfinput" readonly="readonly"/><i></i>
                    </td>
                </tr>
                <tr>
                    <td class="td_left">折扣后合计:</td>
                    <td><input name="totle_discount_price" type="text" class="dfinput" readonly="readonly"/><i></i></td>
                    <td class="td_left">所属客户</td>
                    <td>
                        <select name="sskh">
                            <c:forEach items="${customerList}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="td_left">创建日期</td>
                    <td><input type="text" value="" id="createdate" name="createdate" class="dfinput"  onClick="WdatePicker()"></td>
                </tr>
            </table>
            <div class="formtitle"><span>报价单商品列表</span></div>
            <table class="tableform" style="    width: 1100px;" id="table2">
                <thead>
                <tr>
                    <th>商品</th>
                    <th>商品单价</th>
                    <th>数量</th>
                    <th>税率%</th>
                    <th>含税单价</th>

                    <th>税金</th>
                    <th>货款</th>
                    <th>合计</th>
                    <th>摘要</th>
                    <th>&nbsp;</th>
                </tr>


                </thead>

                <tbody>
                <tr  class="input repeatRow">
                    <td>
                        <select name="goods">
                            <c:forEach items="${goodsList}" var="item">
                                <option value="${item.id}" data-price="${item.price}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="text" readonly="readonly" class="goodprice" name="goodprice"></td>
                    <td><input type="number" name="count" /></td>
                    <td><input type="number" name="rate" value="0"/></td>
                    <td><input type="number" name="per_price_rate" value="0" readonly="readonly"/></td>

                    <td><input type="number" name="price_rate" readonly="readonly"/></td>
                    <td><input type="number" name="price" readonly="readonly"/></td>
                    <td><input type="number" name="totle_price" readonly="readonly"/></td>
                    <td><input type="text" name="digest"/></td>
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
