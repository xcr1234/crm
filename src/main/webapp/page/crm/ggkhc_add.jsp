<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/city.js"></script>
    <title>新建客户</title>
    <script>
        $(function () {

            $(".delRow").on("click",function () {
                $(this).parents(".repeatRow").remove();
            });


            var clone = $(".repeatRow").clone(true);
            
            $("#appendRow").on("click",function () {
                $(".tableform").append($(clone).clone(true));
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
    </style>
</head>
<body>
<div class="tip">
    <div class="ke-dialog-body">
        <div class="formtitle"><span>客户基本信息</span></div>
        <form action="" method="post" name="kh_form">
            <table>
                <tr>
                    <td class="td_left">客户名称:</td>
                    <td><input name="name" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">客户编码:</td>
                    <td><input name="code" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">创建人:</td>
                    <td><input name="creator" type="text" class="dfinput"/><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">联系方式:</td>
                    <td><input name="phone" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">邮箱:</td>
                    <td><input name="email" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">详细地址:</td>
                    <td><input name="adress" type="text" class="dfinput"/><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">QQ:</td>
                    <td><input name="qq" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">省:</td>
                    <td><select name="province" id="province" class="dfinput"></select><i></i></td>
                    <td class="td_left">市:</td>
                    <td><select name="city" id="city" class="dfinput"></select><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">县:</td>
                    <td><select name="area" id="area" class="dfinput"></select><i></i></td>
                    <td class="td_left">销售负责人:</td>
                    <td><input name="sales" type="text" class="dfinput"/><i></i></td>
                    <td class="td_left">客户类型:</td>
                    <td><input name="customer_type" type="text" class="dfinput"/><i></i></td>
                </tr>

                <tr>
                    <td class="td_left">创建日期:</td>
                    <td><input name="createdate" type="text" class="dfinput"/><i></i></td>
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
                <th>生日</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <tr class="input repeatRow">
                <td><input type="text"/></td>
                <td style="text-align: center;">
                    <select style="font-size: 25px;width: 100px;">
                        <option value="1" style="font-size: 25px;">男</option>
                        <option value="0" style="font-size: 25px;">女</option>
                    </select>
                </td>

                </td>
                <td><input type="text" name=""/></td>
                <td><input type="text" name=""/></td>
                <td><input type="text" name=""/></td>
                <td><input type="text" name=""/></td>
                <td><input type="text" name=""/></td>
                <td><input type="text" name=""/></td>
                <td style="text-align: center;"><a href="javascript:;" class="delRow">删除</a></td>
            </tr>
            



        </table>
        </form>
        <div style="text-align: center;margin-top: 5px;">

            <button type="button" class="scbtn" id="appendRow">添加一行</button>
            <button type="button" class="scbtn sure" name="save">保存</button>
            <button type="button" class="scbtn cancel" onclick="history.go(-1)">关闭</button>
        </div>

        <div id="return_info"></div>

    </div>

    <!--<div class="tipbtn">
    <input name="" type="button"  class="sure" value="确定" />&nbsp;
    <input name="" type="button"  class="cancel" value="取消" />
    </div>-->

</div>
</body>
</html>
