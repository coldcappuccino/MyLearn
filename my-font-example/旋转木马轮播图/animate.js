

function animate(ele,json,fn){
    clearInterval(ele.timer);
    ele.timer = setInterval(function(){
        var flag = true;
        for(var key in json){
            //判断特殊的key值
            var now_position;
            if(key === "opacity"){
                //处理透明度，乘100方便处理
                if(getStyle(ele,key)!=undefined){
                    now_position = Math.round(getStyle(ele,key)*100);
                }else{
                    now_position = 0;
                }

            }else{
                now_position = parseInt(getStyle(ele,key)) || 0;
            }

            var target_position = json[key];
            var speed = target_position - now_position;
            speed = speed>0 ? Math.ceil(speed/10) : Math.floor(speed/10);

            if(key === "opacity"){
                //没有px
                ele.style[key] = (now_position + speed)/100;
            }else if(key === "z-index"){
                //z-index属性直接赋值
                ele.style[key] = json[key];
            }else{
                ele.style[key] = now_position + speed + "px";
            }

            if(now_position != target_position){
                flag = false;
            }
        }

        if(flag){
            clearInterval(ele.timer)
            if(fn){
                fn();
            }
        }
    },30);
}

function getStyle(ele,attr){
    if(window.getComputedStyle){
        return window.getComputedStyle(ele,null)[attr];
    }else{
        return ele.currentStyle[attr];
    }
}