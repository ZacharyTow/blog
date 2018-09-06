window.onload = function () {

    // 获取对象属性的兼容 obj.currentStyle[attr] 为ie的方式，getComputedStyle(obj,false)[attr]为谷歌的方式
    function getStyle(obj,attr){
        return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle(obj,false)[attr] ;
    };
    // 参数为两个时，是获取对象的属性值，为三个时，是设置对象的属性值
    function css(obj,attr,value){
        return arguments.length == 2 ? getStyle( obj , attr ) :  obj.style[attr] = value ;
    };
    // 构造弹窗
    function pop_window(){
        this.Obtn = document.querySelector('#btn');
        this.Oclose = document.querySelector('#close');
        this.Ologin = document.querySelector('#login');
        this.Omask = document.querySelector('#mask');
    };
    // 绑定弹窗事件
    pop_window.prototype.bind = function(){
        var that = this ;
        this.Obtn.onclick = function(){
            css(that.Ologin,'display','block');
            css(that.Omask,'display','block');
            that.setposition();
        };
        this.Oclose.onclick = function(){
            css(that.Ologin,'display','none');
            css(that.Omask,'display','none');
        };
        window.onresize = document.body.onscroll = function(){
            css(that.Ologin,'display','block');
            css(that.Omask,'display','block');
            that.setposition();
        };
    };
    // 设置弹窗的位置：设置left 和 top 值即可决定弹窗的位置
    pop_window.prototype.setposition = function(){
        var OlogWidth = css(this.Ologin,'width');
        var OlogHeight = css(this.Ologin,'height');
        var scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
        var wind_Width = document.body.clientWidth||document.documentElement.clientWidth;
        var wind_Height = window.innerHeight;
        css(this.Ologin,'left',(parseInt(wind_Width)-parseInt(OlogWidth))/2 + 'px' );
        css(this.Ologin,'top',( (parseInt(wind_Height)-parseInt(OlogHeight) )/2 + parseInt(scrollTop) ) + 'px'  );
    }
    var opop = new pop_window();
    opop.bind();
}

//弹窗隐藏
function hideDiv(div_id) {
    $("#mask").remove();
    $("#" + div_id).animate({left: 0, top: 100, opacity: "hide" }, "slow");
}