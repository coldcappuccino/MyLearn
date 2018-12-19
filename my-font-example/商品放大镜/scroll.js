
function scroll(){
    //如果这个属性存在，那么返回值应该是0-无穷大
    //如果没有返回值是undefined
    //只要判断不是undefined就可以调用此方法
    if (window.pageYOffset !==undefined) {
        var json = {
            "top":window.pageYOffset,
            "left":window.pageXOffset
        };
        return json;
    }else if (document.compatMode === "CSS1Compat") {//有DTD约束
        return {
            "top":document.documentElement.scrollTop,
            "left":document.documentElement.scrollLeft
        };
    }else{//没有DTD约束
        return {
            "top":document.body.scrollTop,
            "left":document.body.scrollLeft
        };
    }
}