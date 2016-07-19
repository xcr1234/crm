<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://oraclewdp.com/page" prefix="p" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>客户联系图</title>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/plugin/highcharts/js/highcharts.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/plugin/highcharts/js/modules/funnel.js"></script>
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
    <script>


        $(function () {
            $('#chart').highcharts({
                chart: {
                    type: 'funnel',
                    marginRight: 100
                },
                title: {
                    text: '客户未联系天数',
                    x: -50
                },
                plotOptions: {
                    series: {
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b> ({point.y:,.0f})',
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black',
                            softConnector: true
                        },
                        neckWidth: '30%',
                        neckHeight: '25%'

                        //-- Other available options
                        // height: pixels or percent
                        // width: pixels or percent
                    }
                },
                legend: {
                    enabled: false
                },
                series: [{
                    name: '客户数量',
                    data: [
                        <c:forEach var="item" items="${list}">
                            ['${item.get("days")}',${item.get("count")}],
                        </c:forEach>
                    ]
                }]
            });


        });
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">CRM</a></li>
        <li><a href="#">客户管理</a></li>
        <li><a href="#">客户分析图</a></li>

    </ul>
</div>
<div style="width: 550px;height: 450px;float: left" id="chart">

</div>
<div style="float: left;margin: 30px 30px">
<table class="tablelist" style="width: 500px">
    <thead>
    <tr>
        <th>未联系天数</th>
        <th>所占比例</th>
        <th>客户数</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.get("days")}</td>
            <td>${item.get("percent")}%</td>
            <td>${item.get("count")}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>
</body>
</html>
