<%--
  Created by IntelliJ IDEA.
  User: tao.zhang
  Date: 2018/8/27
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>articleCreate</title>
    <link rel="shortcut icon" href="<c:url value="/static/assetsLogin/ico/favicon.png"/>">
    <link href="<c:url value="/static/assetsIndex/css/base.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/index.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/m.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/style.css"/>" rel="stylesheet" media="all">
    <script src="<c:url value="/static/assetsIndex/js/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/jquery/jquery.easyfader.min.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/scrollReveal.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/common.js"/>"></script>
    <%--调用函数跳转Controller--%>
    <script src="<c:url value="/static/assetsIndex/js/manage/indexPageManage.js"/>"></script>
    <script src="<c:url value="/static/assetsIndex/js/manage/articleManage.js"/>"></script>

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

    <div class="pagebg ab"> </div>
    <div class="container">
        <div class="news_infos">
            <div class="box">
                <div class="box-head">
                    <h2>Add New Article</h2>
                </div>

                <%--@elvariable id="blogArticle" type="Play"--%>
                <form>
                    <div class="form">
                        <p>
                            <span class="req">max 100 symbols</span>
                            <label>Article Title <span>(Required Field)</span></label>
                            <input id="articleTitle" type="text" class="field size1" />
                        </p>
                        <p>
                            <span class="req">max 100 symbols</span>
                            <label>Content <span>(Required Field)</span></label>
                            <textarea id="articleContent" class="field size1" rows="10" cols="30"></textarea>
                        </p>
                        <p>
                            <label>Branch</label>
                            <input id="articleBelongBranch" type="text" />
                        </p>
                        </div>
                        <a style="float: right;color:#2ab39a;margin-right: 10%"
                           onclick="articleCreateConfirm('${blogUser.userId}','${blogUser.loginName}','${blogUser.userName}')" >保存</a>
                        <a style="float: right;color:#ac2925;margin-right: -15%;" onclick="jumpToArticleManage('${blogUser.userId}')">返回</a>
                </form>

            </div>
        </div>
        <div class="sidebar">
            <h2 class="hometitle">个人简介</h2>
            <div class="about">
                <p class="avatar"> <img src="<c:url value="/static/assetsIndex/images/avatar.jpg"/>" alt=""> </p>
                <p class="abname">blogUser|${blogUser.userName}</p>
                <p class="abposition">${blogUser.userWork}</p>
                <p class="abtext">${blogUser.userIntroduce}</p>
            </div>
            <div class="weixin">
                <h2 class="hometitle">微信关注</h2>
                <ul>
                    <img src="<c:url value="/static/assetsIndex/images/wx.jpg"/>">
                </ul>
            </div>
        </div>
     </div>

    <footer>
        <p>Design by <a target="_blank">${blogArticle.articleAuthor}的个人博客</a> <a >蜀ICP备11002373号-1</a></p>
    </footer>

    <a href="#" class="cd-top">Top</a>
</body>
</html>
