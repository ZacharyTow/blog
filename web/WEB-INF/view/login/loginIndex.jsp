<%--
  Created by IntelliJ IDEA.
  User: Zt
  Date: 2018/8/16
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Blog Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" >

    <link href="<c:url value="/static/assetsIndex/css/index.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/assetsIndex/css/pop.css"/>" rel="stylesheet">


    <link rel="stylesheet" type="text/css" href="<c:url value="/static/assetsLogin/bootstrap/css/bootstrap.min.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/assetsLogin/bootstrap/css/form-elements.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/assetsLogin/bootstrap/css/style.css"/>" >

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="<c:url value="/static/assetsLogin/ico/favicon.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/static/assetsLogin/ico/apple-touch-icon-144-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/static/assetsLogin/ico/apple-touch-icon-114-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/static/assetsLogin/ico/apple-touch-icon-72-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" href="<c:url value="/static/assetsLogin/ico/apple-touch-icon-57-precomposed.png"/>" >

    <!--[if lt IE 9]>
    <script type="text/javascript" charset="utf-8" src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script type="text/javascript" charset="utf-8" src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Javascript -->
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsLogin/js/jquery-1.11.1.min.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsLogin/bootstrap/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsLogin/js/jquery.backstretch.min.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsLogin/js/jquery.backstretch.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsLogin/js/scripts.js"/>"></script>
    <!--[if lt IE 10]>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsLogin/js/placeholder.js"/>"></script>
    <![endif]-->
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsIndex/js/manage/indexPageManage.js"/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value="/static/assetsIndex/js/manage/accountManage.js"/>"></script>

</head>
<body >
<%--登陆主页--%>
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Blog Login Page</strong> </h1>
                    <div class="description">
                        <p>
                            You can learn from others and share your insights here.
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to your blog</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>

                    <div class="form-bottom">
                        <form role="form" action="login" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="loginName">Username</label>
                                <input type="text" name="loginName" placeholder="Username..." class="form-username form-control" id="loginName">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="loginPassword">Password</label>
                                <input type="password" name="loginPassword" placeholder="Password..." class="form-password form-control" id="loginPassword">
                            </div>
                            <button type="submit" class="btn">Sign in</button>
                            <div class="text-left" >
                                <a href="#" class="pull-left" style="color: #2aabd2">忘记密码？</a>
                                <a onclick="jumpToRegister()" class="pull-right" style="color: #2aabd2">注册账号</a>
                            </div>
                            <div>
                                <p style="text-align:center;vertical-align: middle;color: red"><span class="num" >${message}</span></p>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>Or login with:</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-2" href="#">
                            <i class="fa fa-qq"></i> QQ
                        </a>
                        <a class="btn btn-link-2" href="#">
                            <i class="fa fa-wechat"></i> WeChat
                        </a>
                        <a class="btn btn-link-2" href="#">
                            <i class="fa fa-envelope"></i> E-Mail
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--注册弹窗--%>
<div id="pop-div-confirm"  class="register">
    <div class="pop-charactor" >
        <form action="" method="post">
            <h2 style="color: white">Register Infomation</h2>
            <p for="registeredName">Login Name</p>
            <input type="text" id="registeredName" placeholder="enter your login password..." />

            <p for="registeredPassword">Login Password</p>
            <input type="password" id="registeredPassword" autocomplete="new-password" placeholder="enter your registered password..."/>

            <p for="userName">userName</p>
            <input type="text" id="userName"  placeholder="enter your user name..."/>

            <p for="userPhone">userPhone</p>
            <input type="txet" id="userPhone" style="margin-bottom: 30px" placeholder="enter your user phone..."/>

            <a style="background: #199872;border:10px solid  #199872;" onclick="registerAccountInfo('pop-div-confirm')">Register</a>
            <a style="background: #d0e9c6;border:10px solid #d0e9c6;color: #010101;" onclick="hideDiv('pop-div-confirm')">Return</a>


        </form>
    </div>
</div>

</body>
</html>
