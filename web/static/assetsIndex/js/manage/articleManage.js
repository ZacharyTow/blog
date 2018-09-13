
//添加确认
function articleCreateConfirm(userId,manager,author){
    var articleTitle = $("#articleTitle").val();
    var articleContent = $("#articleContent").val();
    var articleBelongBranch = $("#articleBelongBranch").val();
    var articleAuthor = author;
    var articleManager = manager;
    if(articleTitle == ''){
        alert("articleTitle can't null");
        return false;
    }else if(articleContent == ''){
        alert("articleContent can't null");
        return false;
    }else if(articleBelongBranch == ''){
        alert("articleBelongBranch can't null");
        return false;
    }

    var jasonObj = {"articleTitle":articleTitle,"articleContent":articleContent,
        "articleBelongBranch":articleBelongBranch, "articleAuthor":articleAuthor,"articleManager":articleManager};
    $.ajax( {
        type : "post",
        url : "articleCreateConfirm",
        data:JSON.stringify(jasonObj),
        dataType:"text",
        contentType: "application/json",
        success : function(msg) {
            if(msg){
                alert(msg);
            }
            //跳转至管理页面
            var form = $("<form>");
            form.attr("style","display:none");
            form.attr("target","");
            form.attr("method","post");
            //请求地址
            form.attr("action","articleManage");
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
//更新确认
function articleUpdateConfirm(userId,articleId,belong){
    var articleId = articleId;
    var articleTitle = $("#articleTitle").val();
    var articleContent = $("#articleContent").val();
    var articleBelongBranch = $("#articleBelongBranch").val();
    var articleManager = belong;
    var jasonObj = {"articleId":articleId,"articleTitle":articleTitle, "articleContent":articleContent,
        "articleBelongBranch":articleBelongBranch,"articleManager":articleManager};
    $.ajax( {
        type : "post",
        url : "articleUpdateConfirm",
        data:JSON.stringify(jasonObj),
        dataType:"text",
        contentType: "application/json",
        success : function(msg) {
            if(msg){
                alert(msg);
            }
            //跳转至管理页面
            var form = $("<form>");
            form.attr("style","display:none");
            form.attr("target","");
            form.attr("method","post");
            //请求地址
            form.attr("action","articleManage");
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


//删除确认
var articleNoCash = '';

function articleDelete(articleId) {
    articleNoCash = articleId;
    popupDiv('pop-div-confirm');

}
function deleteConfirm(){
    $.ajax( {
        type : "post",
        url : "deleteConfirm",
        data:{'articleId':articleNoCash},
        dataType:"text",
        success : function(msg) {
            if(msg){
                alert(msg);
            }
            window.location.reload();
            hideDiv('pop-div-confirm');
        }
    });
}
//弹窗显示
function popupDiv(div_id) {
    var div_obj = $("#"+div_id);
    var windowWidth = document.body.clientWidth;
    var windowHeight = document.body.clientHeight;
    var popupHeight = div_obj.height();
    var popupWidth = div_obj.width();
    //添加并显示遮罩层
    $("<div id='mask'></div>").addClass("mask")
        .width(windowWidth)
        //					.width(windowWidth + document.body.scrollWidth)
        //					.height(windowHeight + document.body.scrollHeight)
        .height(windowHeight)
        .click(function() {hideDiv(div_id); })
        .appendTo("body")
        .fadeIn(200);
    div_obj.css({"position": "absolute"})
        .animate({left: windowWidth/2-popupWidth/2,
            top: windowHeight/3, opacity: "show" }, "slow");
}
//弹窗隐藏
function hideDiv(div_id) {
    $("#mask").remove();
    $("#" + div_id).animate({left: 0, top: 100, opacity: "hide" }, "slow");
}

