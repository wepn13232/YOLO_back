<%--
  Created by IntelliJ IDEA.
  User: linqiyuan
  Date: 2019-03-26
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header navbar-left wthree">
                <h1><a href="${pageContext.request.contextPath}/index">You3Dm<span>Gamer Heaven</span></a></h1>
            </div>
            <!-- navigation -->
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="header-right wthree">
                <div class="top-nav-text">

                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-left cl-effect-14">
                        <li><a href="${pageContext.request.contextPath}/user/index">主页</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/profile">游戏商城</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/about">社区论坛</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/###">我的购物车/订单</a></li>


                    </ul>
                    <div class="clearfix"> </div>
                </div><!-- //navigation -->
            </div>
            <div class="clearfix"> </div>
        </div>
    </nav>
</div>
