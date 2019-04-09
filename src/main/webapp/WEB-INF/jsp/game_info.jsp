<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linqiyuan
  Date: 2019-03-28
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游戏详情</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<%@include file="common/header.jsp" %>
<div class="banner-1"></div>
<div class="container-fluid" style="background-color: #fbfbfb">
    <%--游戏图--%>
    <div class="clearfix" style="padding: 1em"></div>
    <div class="game_pic text-center">
        <img src="${pageContext.request.contextPath}/statics/images/gamepic/pic${gameinfoByid.id}.jpg"
             class="img-rounded" style="width: 350px;height: 500px" alt="">
    </div>
    <div class="clearfix" style="padding: 1em 1em"></div>
    <%--游戏简介--%>
    <div class="game_info col-md-12 col-sm-12 ">
        <div class="info col-md-6 col-sm-6  col-md-offset-3 col-sm-offset-3">
            ${gameinfoByid.game_info}
        </div>
    </div>
    <div class="clearfix" style="padding: 1em 1em"></div>

    <%--游戏具体内容--%>
    <div class="game_form col-md-12 col-sm-12 center-block">
        <ul class="list-group col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
            <li class="list-group-item" style="height: 40px">
                <p class="col-md-2 col-md-2">游戏名字：</p>
                <p class="" style="color: #00AFF0">${gameinfoByid.game_name}</p>
            </li>
            <li class="list-group-item" style="height: 40px">
                <p class="col-md-2 col-md-2">游戏价格：</p>
                <p style="color: red">$ ${gameinfoByid.game_price}</p>
            </li>

            <li class="list-group-item" style="height: 40px">
                <p class="col-md-2 col-md-2">最低显卡要求：</p>
                <p style="color: #00AFF0">${gameinfoByid.GPU}</p>
            </li>

            <li class="list-group-item" style="height: 40px">
                <p class="col-md-2 col-md-2">最低CPU要求：</p>
                <p style="color: #00AFF0">${gameinfoByid.cpu}</p>
            </li>

            <li class="list-group-item" style="height: 40px">
                <p class="col-md-2 col-md-2">最低内存要求：</p>
                <p style="color: #00AFF0">${gameinfoByid.memory}</p>
            </li>

            <li class="list-group-item" style="height: 40px">
                <p class="col-md-2 col-md-2">最低系统要求：</p>
                <p style="color: #00AFF0">${gameinfoByid.system}</p>
            </li>


        </ul>
    </div>
    <div class="bt _group" style="margin: 0 auto;width: 200px">
        <a href="${pageContext.request.contextPath}/user/###"
           class="btn btn-success " style="margin-left: 25px">购买</a>
        <a href="${pageContext.request.contextPath}/user/###"
           class="btn btn-info" style="margin-left: 10px; ">加入购物车</a>
    </div>
    <div class="clearfix" style="padding-top: 1em"></div>

    <%--未登录不能评论--%>
    <%--&lt;%&ndash;发表评论区&ndash;%&gt;--%>
    <%--<form class="postComment col-md-12 col-sm-12">--%>
    <%--<textarea class="form-control" style="width: 80%;margin: 0 auto"  rows="3" placeholder="可以在此发表你的评论"></textarea>--%>
    <%--<div class="clearfix"style="padding: 1em"></div>--%>
    <%--<input type="button" class="btn btn-primary col-md-2 col-sm-2 col-md-offset-10 col-sm-offset-10" value="发送评论">--%>

    <%--</form>--%>

    <%--评论专区--%>
    <c:if test="${!empty comment}">
        <c:forEach var="comments" items="${comment}">

            <div id="box" class="comment col-md-12 col-sm-12">
                <div class="col-md-12 col-sm-12"
                     style="height: 120px;background-color: rgba(237,237,237,0.52);margin: 1em">
                        <%--头像--%>
                    <div class="col-md-12 col-sm-12">
                        <img src="${pageContext.request.contextPath}/statics/images/t1.jpg"
                             class="img-circle col-md-3 col-sm-3"
                             style="width: 120px;height: 100px;margin: 10px" alt="">
                        <div class="content col-md-4 col-sm-4" style="margin: 30px 0">
                            <p>${comments.username}:</p>
                            <p>${comments.comment}</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<%@include file="common/footer.jsp" %>
</body>
</html>
