<%--
  Created by IntelliJ IDEA.
  User: Zt
  Date: 2018/8/22
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>articleManage</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="<c:url value="/static/assetsLogin/ico/favicon.png"/>">
    <link href="<c:url value="/static/assetsIndex/css/base.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/index.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/m.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/pop.css"/>" rel="stylesheet">
    <script src="<c:url value="/static/assetsIndex/js/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/jquery/jquery.easyfader.min.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/scrollReveal.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/common.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/page/page.js"/>"></script>
    <%--调用函数跳转Controller--%>
    <script src="<c:url value="/static/assetsIndex/js/manage/indexPageManage.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/manage/articleManage.js"/>"></script>

    <!--[if lt IE 9]>
    <script src="<c:url value="/static/assetsIndex/js/modernizr.js"/>"></script>
    <![endif]-->
</head>
<body>
    <%--导航栏--%>
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
    <div class="pagebg ab"> </div>
    <div class="container">
        <h2 class="t_nav">
            <p class="n2">博文管理</p>
            <a onclick="jumpToCreate('${blogUser.userId}')" class="n3">添加</a></h2>
        <div class="articlebox">
            <c:forEach items="${blogArticles}" var="blogArticle">
                <div class="articles" data-scroll-reveal="enter bottom over 1s" >
                    <h3 class="articletitle"><p target="_blank">${blogArticle.articleTitle}</p></h3>
                    <p class="articletext">${blogArticle.articleContent}</p>
                    <div class="articleinfo">
                        <ul id="listArticle">
                            <li class="author">${blogArticle.articleAuthor}</li>
                            <li class="lmname" name="articleBelongBranch">${blogArticle.articleBelongBranch}</li>
                            <li class="timer"><fmt:formatDate value='${blogArticle.articleDate}' type='date' pattern='yyyy-MM-dd'/></li>
                            <%--阅读数量显示--%>
                            <c:if test="${blogArticle.articleReaded < 999}">
                                <li class="view"><span>${blogArticle.articleReaded}</span>已阅读</li>
                            </c:if>
                            <c:if test="${blogArticle.articleReaded > 999 and blogArticle.articleReaded < 100000}">
                                <li class="view"><span>999+</span>已阅读</li>
                            </c:if>
                            <c:if test="${blogArticle.articleReaded > 100000}">
                                <li class="view"><span>10W+</span>已阅读</li>
                            </c:if>
                            <%--点赞数量显示--%>
                            <c:if test="${blogArticle.articleLiked < 999}">
                                <li class="like">${blogArticle.articleLiked}</li>
                            </c:if>
                            <c:if test="${blogArticle.articleLiked > 999 and blogArticle.articleLiked < 100000}">
                                <li class="like">999+</li>
                            </c:if>
                            <c:if test="${blogArticle.articleLiked >100000}">
                                <li class="like">10W+</li>
                            </c:if>
                            <a style="float: right;color:#2ab39a;margin-right: 5%" onclick="jumpToUpdate('${blogArticle.articleId}')" >修改</a>
                            <a style="float: right;color:#ac2925;margin-right: -10%;" onclick="articleDelete('${blogArticle.articleId}')">删除</a>
                        </ul>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <footer>
        <p>Design by <a target="_blank">${blogUser.userName}的个人博客</a> <a >蜀ICP备11002373号-1</a></p>
    </footer>

    <div id='pop-div-confirm'  class="pop-box delete" style="height: 150px">
        <div style="border-bottom: 1px solid lavender;height: 40px;line-height: 40px"><p style="font-size: 20px;margin-left: 5px;margin-top: 5px;margin-left: 10px;display: inline">提示</p></div>
        <div class="pop-box-body" style="text-align: center;height: 40px;line-height: 40px">
            <span style="font-size: 20px">确定要删除吗?</span>
        </div>
        <div style="border-top: 1px solid lavender;margin-bottom: 0px;text-align:center;height: 60px;line-height: 60px">
            <input  type="button" onclick="deleteConfirm()"  class="btn btn-primary" value="确定" style="margin-left: 5px;"/>
            <input  type="button" onclick="hideDiv('pop-div-confirm')"  class="btn btn-primary" value="取消" style="margin-left: 5px;"/>
        </div>
    </div>
    <a href="#" class="cd-top">Top</a>

</body>
</html>
