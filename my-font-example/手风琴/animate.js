

function animate(ele,json,fn){
    clearInterval(ele.timer);
    ele.timer = setInterval(function(){
        var flag = true;
        for(var key in json){
            var now_position = getStyle(ele,key);
            var target_position = json[key];
            var speed = target_position - now_position;
            speed = speed>0 ? Math.ceil(speed/10) : Math.floor(speed/10);

            ele.style[key] = now_position + speed + "px";

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