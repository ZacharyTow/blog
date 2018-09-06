//更新账户信息
function updateAccountInfo(userId){
    var userId = userId;
    var loginPassword = $("#loginPassword").val();
    var userName = $("#userName").val();
    var userSex = $("#userSex").val();
    var userBirth = $("#userBirth").val();
    var userWork = $("#userWork").val();
    var userPhone = $("#userPhone").val();
    var userAddress = $("#userAddress").val();
    var userMail = $("#userMail").val();
    var userIntroduce = $("#userIntroduce").val();
    if(loginPassword == ''){
        alert("loginPassword can't null!");
        return false;
    }else if(userSex == ''){
        alert("userSex can't null!");
        return false;
    }
    if(userSex != '男' && userSex != '女'){
        alert("userPhone's format wrong! Just be male or female!");
        return false;
    }
    if(!userPhone.match("^((1[3-9][0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$")){
        alert("userPhone's format wrong!");
        return false;
    }
    var jasonObj = {"userId":userId,"loginPassword":loginPassword, "userName":userName,"userSex":userSex,"userBirth":userBirth,
        "userWork":userWork,"userPhone":userPhone, "userAddress":userAddress,"userMail":userMail,"userIntroduce":userIntroduce};
    $.ajax( {
        type : "post",
        url : "accountUpdate",
        data:JSON.stringify(jasonObj),
        dataType:"text",
        contentType: "application/json",
        success : function(msg) {
            if(msg){
                alert(msg);
            }
            // //跳转至账户管理页面
            var form = $("<form>");
            form.attr("style","display:none");
            form.attr("target","");
            form.attr("method","post");
            //请求地址
            form.attr("action","accountManage");
            var input = $("<input>");
            input.attr("type","hidden");
            input.attr("name","userId");
            input.attr("value",userId);
            $("body").append(form);
            form.append(input);
            form.submit();
            form.remove();
        }
    });
}
//注册账户信息
function registerAccountInfo(window){
    var loginName = $("#registeredName").val();
    var loginPassword = $("#registeredPassword").val();
    var userName = $("#userName").val();
    var userPhone = $("#userPhone").val();
    if(loginName == ''){
        alert("loginName can't null!");
        return false;
    }else if(loginPassword == ''){
        alert("loginPassword can't null!");
        return false;
    }else if(userName == ''){
        alert("userName can't null!");
        return false;
    }else if(userPhone == ''){
        alert("userPhone can't null!");
        return false;
    }
    if(!userPhone.match("^((1[3-9][0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$")){
        alert("userPhone's format wrong!");
        return false;
    }

    var jasonObj = {"loginName":loginName,"loginPassword":loginPassword, "userName":userName,"userPhone":userPhone};
    $.ajax( {
        type : "post",
        url : "accountRegister",
        data:JSON.stringify(jasonObj),
        dataType:"text",
        contentType: "application/json",
        success : function(msg) {
            if(msg){
                alert(msg);
            }
            hideDiv(window);
        }
    });
}