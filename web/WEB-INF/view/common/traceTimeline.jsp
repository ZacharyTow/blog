<%--
  Created by IntelliJ IDEA.
  User: tao.zhang
  Date: 2018/8/17
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>traceTimeline</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="<c:url value="/static/assetsLogin/ico/favicon.png"/>">
    <link href="<c:url value="/static/assetsIndex/css/base.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/index.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/m.css"/>" rel="stylesheet">
    <script src="<c:url value="/static/assetsIndex/js/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/jquery/jquery.easyfader.min.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/scrollReveal.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/common.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/page/page.js"/>"></script>
<%--调用函数跳转Controller--%>
    <script src="<c:url value="/static/assetsIndex/js/manage/indexPageManage.js"/>"></script>
    <!--[if lt IE 9]>
    <script src="<c:url value="/static/assetsIndex/js/modernizr.js"/>"></script>
    <![endif]-->
</head>
<body>
    <header>
        <%--主菜单--%>
        <div class="menu">
            <nav class="nav" id="topnav">
                <h1 class="logo" style="color: white">${blogUser.userName}的博客</h1>
                <li><a onclick="jumpToIndex('${blogUser.userId}','All')">首页推荐</a></li>
                <li><a onclick="jumpToArticleManage('${blogUser.userId}')">博文管理</a> </li>
                <li><a onclick="jumpToMessageBoard('${blogUser.userId}')">留言板</a></li>
                <li><a onclick="jumpToTraceTimeline('${blogUser.userId}')">时间轴</a></li>
                <li><a onclick="jumpToAccountManage('${blogUser.userId}')">账号管理</a></li>
            </nav>
        </div>
    </header>

    <div class="pagebg timer"> </div>
    <div class="container">
        <h2 class="t_nav">
            <p class="n2">时间轴</p>
            <span>时光飞逝，机会就在我们眼前，何时找到了灵感，就要把握机遇，我们需要智慧和勇气去把握机会。</span></h2>
        <%--<h2 class="t_nav"></h2>--%>
            <div class="timebox">
                <ul id="list" style="display:none;">
                    <c:forEach items="${blogTimelines}" var="blogTimeline">
                    <li>
                        <span><fmt:formatDate value='${blogTimeline.timelineDate}' type='date' pattern='yyyy-MM-dd'/></span>
                        <a title="${blogTimeline.timelineTitle}">${blogTimeline.timelineTitle}</a>
                    </li>
                    </c:forEach>
                </ul>
                <ul id="list2"></ul>
            </div>
        <script src="<c:url value="/static/assetsIndex/js/page/page2.js"/>"></script>
    </div>
</body>
</html>
