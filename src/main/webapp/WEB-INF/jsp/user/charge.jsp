<%--
  Created by IntelliJ IDEA.
  User: linqiyuan
  Date: 2019-03-29
  Time: 08:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值页面</title>
    <%@include file="common/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contentType}/statics/css/chargeCss.css">
</head>
<body>
<%@include file="common/header.jsp" %>
<div class="banner-1"></div>

<%--充值页面--%>
<div class="container-fluid">
    <div class="clearfix" style="padding: 1em"></div>
    <%--充值说明--%>
    <div class="alert alert-info charge_info">
        <div class="info_title">
            <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span> 充值中心
        </div>
        <div class="clearfix" style="padding: 1em;"></div>
        <div class="info_content">
            <h4 style="padding-bottom: 1em">1. 请选择合适的充值方式</h4>

            <h4>2. 请选择你需要充值的数额</h4>
        </div>
    </div>

    <div class="clearfix" style="padding: 1em;"></div>

    <%--充值人--%>
    <div class="panel charge_user">
        <div class="panel-body">
            <div class="user col-md-4 col-sm-4">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>充值人：
            </div>
            <%--剩余余额--%>
            <div class="cashLeft col-md-3 col-sm-3 col-md-offset-3 col-sm-offset-3">
                <span class="glyphicon glyphicon-yen" aria-hidden="true">剩余余额：</span>
            </div>
        </div>
    </div>

    <%--充值金额选择--%>
    <div class="charge_method">
        <form class="form-horizontal">
            <div class="radio">
                <button  class="btn btn-default btn-lg charge_btn" value="10">10元</button>
                <button  class="btn btn-default btn-lg charge_btn" value="10">20元</button>
                <button  class="btn btn-default btn-lg charge_btn" value="10">50元</button>
                <button  class="btn btn-default btn-lg charge_btn" value="10">100元</button>
                <input value="" class="btn btn-default btn-lg charge_btn" placeholder="请输入你想充值的金额" style="width: 240px">
            </div>
        </form>

        <%--充值方式--%>
        <div class="method" style="margin-top: 4em">
            <p class="col-md-1 col-sm-1">充值方式：</p>
            <div class="radio-inline col-md-3 col-sm-3">
                <label style="padding-left: 1em" class="radio-inline">
                    <input type="radio">微信
                </label>
                <label style="padding-left: 10em" class="radio-inline">
                    <input type="radio">支付宝
                </label>
            </div>
        </div>

<div class="clearfix" style="padding: 1em"></div>
        <%--显示应付款--%>
        <div class="payCash" style="margin-top: 3em;height: 50px">
            <div class="" style="margin: auto 0;height: 100%">
            <p class="col-md-1 col-sm-1" style="height: 100%;margin-top: 15px;">应支付金额：</p>
            <p class="col-md-2 col-sm-2" style="color: red;font-size: 2em">$ 200</p>
            </div>
        </div>



    </div>


<%--分割线--%>
    <div class="fenge">
    <p>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
    </div>


    <div class="fukuang">
        <button class="btn btn-info btn-lg">确认付款</button>
    </div>
</div>


<%@include file="common/footer.jsp" %>
</body>
</html>