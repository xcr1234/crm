<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://oraclewdp.com/page" prefix="p" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>机会分析图</title>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/plugin/highcharts/js/highcharts.js"></script>
    <style type="text/css">
        body{
            /*background-color: red;*/
            font-size:"200";
        }
        th{
            text-align:center;
            height:40px;
        }
        tbody td{
            width: 400px;
            height:30px;
            border:solid 1px #d7a372;
        }
        tbody tr{
            height:40px;
        }
        .dfinput{
            width: 250px;
            height: 25px;
        }
        .td_left{
            width: 100px;
        }
        .tip{width:500px; height:300px; position:absolute;top:10%; left:10%;background:#fcfdfd;box-shadow:1px 8px 10px 1px #9b9b9b;border-radius:1px;behavior:url(js/pie.htc); display:none; z-index:111111;}

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
    <script type="text/javascript">

        $(byStage);

        function byStage() {
            //通过机会阶段获得表单中的数据

            $("#tbody").empty();

            $.get("${pageContext.servletContext.contextPath}/xmjh.do?method=byStage",function (data) {

                var arr = data;

                var chartData = [];


                for(var i=0;i<arr.length;i++){
                    var bean = arr[i].bean;
                    var tr = $("<tr></tr>");
                    $("<td></td>").text(bean.poss+"%").appendTo(tr);
                    $("<td></td>").text(bean.count).appendTo(tr);
                    $("<td></td>").text(bean.percent+"%").appendTo(tr);
                    $("<td></td>").text(bean.stage).appendTo(tr);
                    $("#tbody").append(tr);

                    var a = {};
                    a.name = bean.stage;
                    a.y = bean.count;
                    chartData.push(a);

                }

                //更新图表

                updateChart(chartData,"销售机会分析图 - 按机会阶段");

            });

        }
        
        function byPoss() {
            $("#tbody").empty();

            $.get("${pageContext.servletContext.contextPath}/xmjh.do?method=byPoss",function (arr) {

                var chartData = [];

                for(var i=0;i<arr.length;i++){
                    var bean = arr[i].bean;
                    var tr = $("<tr></tr>");
                    $("<td></td>").text(bean.poss+"%").appendTo(tr);
                    $("<td></td>").text(bean.count).appendTo(tr);
                    $("<td></td>").text(bean.percent+"%").appendTo(tr);
                    $("<td>-</td>").appendTo(tr);
                    $("tbody").append(tr);

                    var c = {};
                    c.name = bean.poss+"%";
                    c.y = bean.count;
                    chartData.push(c);

                }

                updateChart(chartData,"销售机会分析图 - 按成交可能性");



            });
        }

        function updateChart(chartData,title) {
            $("#chart").highcharts({
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text:title
                }, tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: false
                        },
                        showInLegend: true
                    }
                },
                series: [{
                    type: 'pie',
                    name: '所占比例',
                    data: chartData
                }]


            });
        }


    </script>
</head>

<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">CRM</a></li>
        <li><a href="#">销售计划管理</a></li>
        <li><a href="#">项目机会分析图</a></li>

    </ul>
</div>
<div class="rightinfo">


    <div class="tools">
        <ul class="toolbar">
            <li onclick="byStage()"><span><img src="images/t04.png" /></span>按机会阶段</li>
            <li onclick="byPoss()"><span><img src="${pageContext.servletContext.contextPath}/images/t04.png" /></span>按成交可能性</li>

        </ul>
    </div>
    <div style="width: 550px;height: 450px;float: left" id="chart">

    </div>
    <div style="float: left;margin: 30px 30px">
        <table class="tablelist" style="width: 500px">
            <thead>
                <tr>
                    <th style="width: 127px">平均成交可能性</th>
                    <th style="width: 117px">机会数量</th>
                    <th style="width: 136px">所占比例</th>
                    <th style="width: 119px">机会阶段</th>
                </tr>
            </thead>
            <tbody id="tbody">

            </tbody>
        </table>
    </div>
</div>

</body>
</html>
