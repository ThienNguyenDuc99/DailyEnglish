$(document).ready(function () {
    topic1 = new topic1();
});

class topic1 {
    constructor() {
        $(document).on("click", ".btn.add", this.openDialogAdd);
        $(document).on("click", ".btn.edit", this.openDialogEdit);
        $(document).on("click", ".btn.voca", this.openDialogVoca);
        $(".dialog.add").on("click", ".btn.btn-success", this.addTopic);
        $(document).on("click", ".btn.delete", this.delTopic);
        $(document).on("click", ".show_voca", this.showVoca);
        $(document).on("click", ".sub_voca_admin", this.chooseVoca);
        $(".dialog.voca").on("click", ".btn.btn-success", this.mapVoca);
        $(".dialog.edit").on("click", ".btn.btn-success", this.editTopic);
    }

    openDialogAdd(){
        $(".dialog.add").dialog({
            width: 600,
            height: 200,
        })
    }

    openDialogEdit(){
        var listEdit = $(".btn.edit");
        listEdit.removeClass("dangsua")
        $(this).addClass("dangsua")
        var a = $(this).parent().siblings()
        var listInput = $(".dialog.edit input")
        listInput[0].value = a[0].innerText
        $(".dialog.edit").dialog({
            width: 600,
            height: 200,
        })
    }

    openDialogVoca(){
        var list = $(".btn.voca");
        list.removeClass("dangthem")
        $(this).addClass("dangthem")
        $(".dialog.voca").dialog({
            width: 500,
            height: 650,
        })
    }

    showVoca(){
        $(this).next().toggleClass("togo");
    }

    chooseVoca(){
        var x = $(this)[0].innerText
        var x1 = $(".choose_voca")[0].value
        $(".choose_voca")[0].value = x;
        // $(".topic_admin").toggleClass("togo1")
    }

    addTopic(){
        var element = $('.form-control.to');
        var topic = {}
        topic["topicValue"] = element[0].value;
        $.ajax({
            url : "/addTopic",
            contentType : "application/json;charset=UTF-8",
            type : 'POST',
            async: false,
            dataType: "json",
            data : JSON.stringify(topic),
            success: function (data){
            },
        });
        $('.dialog.add').dialog('close')
        window.location.reload(true);
    }

    delTopic(){
        var idDom = $(this).next();
        var id = idDom.attr("property")
        var url = "/delTopic/"+id
        $.ajax({
            url : url,
            contentType : "application/json;charset=UTF-8",
            type : 'DELETE',
            async: false,
            success: function (){
            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
        window.location.reload(true);
    }

    mapVoca(){
        // var listInput = $(".dialog.voca input")
        var idDom = $(".btn.voca.dangthem")
        var topicId = idDom.next().attr("property")
        var n = $("input:checked")
        var n1 = n.next().toArray()
        debugger
        n1.forEach(function (item){
            var vocaId = item.getAttribute("property")
            var url = "/setTopic_Voca/" + topicId + "/" + vocaId
            $.ajax({
                url : url,
                contentType : "application/json;charset=UTF-8",
                type : 'GET',
                async: false,
                dataType: "json",
                success: function (data){

                },
                error : function(error) {
                    console.log("ERROR: ", error);
                }
            });
            $('.dialog.voca').dialog('close')
            window.location.reload(true);
        })
    }

    editTopic(){
        var listInput = $(".dialog.edit input")
        var Topic = {}
        var idDom = $(".btn.edit.dangsua")
        var id = idDom.next().attr("property")
        Topic["topicId"] = id
        Topic["topicValue"] = listInput[0].value
        $.ajax({
            url : "/updateTopic",
            contentType : "application/json;charset=UTF-8",
            type : 'PUT',
            async: false,
            dataType: "json",
            data : JSON.stringify(Topic),
            success: function (data){
                debugger
            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
        $('.dialog.edit').dialog('close')
        window.location.reload(true);
    }

}