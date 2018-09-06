<%--
  Created by IntelliJ IDEA.
  User: tao.zhang
  Date: 2018/8/17
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <meta charset="utf-8">
    <title>accountManagement</title>
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
    <script src="<c:url value="/static/assetsIndex/js/manage/accountManage.js"/>"></script>

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
            <li><a onclick="jumpToIndex('${blogUser.userId}')">首页推荐</a></li>
            <li><a onclick="jumpToArticleManage('${blogUser.userId}')">博文管理</a> </li>
            <li><a onclick="jumpToMessageBoard('${blogUser.userId}')">留言板</a></li>
            <li><a onclick="jumpToTraceTimeline('${blogUser.userId}')">时间轴</a></li>
            <li><a onclick="jumpToAccountManage('${blogUser.userId}')">账号管理</a></li>
        </nav>
    </div>
</header>
<div class="pagebg ab"> </div>
<div class="container">
    <div class="form-base">
            <h2>Personal <span class="red"><strong>Infomation</strong></span></h2>
            <label for="loginName">Login Name</label>
            <div id="reminderName" style="display:none;color:#B50000" size="50px" >just modify it when registering</div>
            <input type="text" id="loginName" onclick = $("#reminderName").show(); onblur = $("#reminderName").hide();
                   style="background-color:#f8f8f8 " value="${blogUser.loginName}" readonly="readonly"/>

            <label for="loginPassword">Login Passworde</label>
            <div id="reminderPassword" style="display:none;color:#B50000" size="50px" >Enter a more secure password</div>
            <input type="password" id="loginPassword" name="loginPassword" onclick = $("#reminderPassword").show(); onblur = $("#reminderPassword").hide();
                   value="${blogUser.loginPassword}" />

            <label for="userName">userName</label>
            <input type="text" id="userName" name="userName"  value="${blogUser.userName}"/>

            <label for="userSex">userSex</label>
            <input type="text" id="userSex" name="userSex"  value="${blogUser.userSex}"/>

            <label for="userBirth">userBirth</label>
            <input type="date"  id="userBirth" name="userBirth"  value="<fmt:formatDate value='${blogUser.userBirth}' type='date' pattern='yyyy-MM-dd'/>"/>

            <label for="userMail">userMail</label>
            <input type="txet" id="userMail" name="userMail"  value="${blogUser.userMail}"/>
    </div>

    <div class="form-charactor">
            <label for="userWork">userWork</label>
            <input type="text" id="userWork" name="userWork"  value="${blogUser.userWork}"/>

            <label for="userPhone">userPhone</label>
            <input type="text" id="userPhone" name="userPhone"  value="${blogUser.userPhone}"/>

            <label for="userAddress">userAddress</label>
            <input type="text" id="userAddress" name="userAddress"  value="${blogUser.userAddress}"/>

            <label for="userIntroduce">userIntroduce</label>
            <textarea type="txet" id="userIntroduce" name="userIntroduce" >${blogUser.userIntroduce}</textarea>

            <div class="blank"></div>

            <a onclick="updateAccountInfo('${blogUser.userId}')">Save Changes</a>
    </div>
</div>
</body>
</html>
