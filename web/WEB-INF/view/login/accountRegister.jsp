<%--
  Created by IntelliJ IDEA.
  User: tao.zhang
  Date: 2018/9/4
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <meta charset="utf-8">
    <title>accountRegister</title>
    <link rel="shortcut icon" href="<c:url value="/static/assetsLogin/ico/favicon.png"/>">
    <link href="<c:url value="/static/assetsIndex/css/base.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/index.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/m.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/bootstrap.css"/>" rel="stylesheet">
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
</header>
<div class="pagebg ab"> </div>
<div class="container">
    <div class="pop-charactor">
        <form action="" method="post">
            <h2>Personal <span class="red"><strong>Infomation</strong></span></h2>
            <label for="loginName">Login Name</label>
            <input type="text" id="loginName" name="loginName" placeholder="enter your login password..." />

            <label for="loginPassword">Login Passworde</label>
            <input type="text" id="loginPassword" name="loginPassword"  placeholder="enter your login password..."/>

            <label for="nickName">nickName</label>
            <input type="password" id="nickName" name="nickName" placeholder="enter your nick name..."/>

            <label for="userSex">userSex</label>
            <input type="text" id="userSex" name="userSex" placeholder="enter your user sex..."/>

            <label for="userBirth">userBirth</label>
            <input type="txet" id="userBirth" name="userBirth" placeholder="enter your user birth..."/>

            <label for="userMail">userMail</label>
            <input type="txet" id="userMail" name="userMail" placeholder="enter your user mail..."/>

            <a onclick="">Register</a>

        </form>
    </div>
</div>
</body>
</html>

