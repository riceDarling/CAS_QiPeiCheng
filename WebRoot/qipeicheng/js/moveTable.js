$(function () {

    function isNullOrUndefined(obj) {
        if (typeof (obj) == "undefined" || obj == null) {
            return true;
        }
        return false;
    }

    function registerTableDragEvent() {

        var dragTH; //记录拖拽的列
        //第一步按下
        $('#moveTable td').mousedown(function (e) {
            e = e || window.event;
            if (e.offsetX > $(this).innerWidth() - 10) {
                dragTH = $(this);
                dragTH.mouseDown = true;
                dragTH.oldX = e.pageX || e.clientX;
                dragTH.oldWidth = $(this).innerWidth();
            }
        })
        //第二步 拖动
        $('#moveTable td').mousemove(function (e) {
            //改鼠标样式
            if (e.offsetX > $(this).innerWidth() - 10) {
                $(this).css({
                    cursor: "e-resize"
                });
            } else {
                $(this).css({
                    cursor: "default"
                });
            }
            if (isNullOrUndefined(dragTH)) {
                dragTH = $(this);
            }
            if (!isNullOrUndefined(dragTH.mouseDown) && dragTH.mouseDown == true) {
                var difference = (e.pageX - dragTH.oldX) || (e.clientX - dragTH.oldX);
                var newWidth = dragTH.oldWidth + difference; //新的宽度
                dragTH.width(newWidth)
            }
        })
        // 第三步，释放
        $("table#moveTable td").mouseup(function (e) {
            // 还原鼠标样式
            // if (isNullOrUndefined(dragTH)) {
            //     dragTH = $(this);
            // }
            dragTH.mouseDown = false;
            // $(dragTH).css({
            //     cursor : "default"
            // });
        });
    }
    registerTableDragEvent()

})
