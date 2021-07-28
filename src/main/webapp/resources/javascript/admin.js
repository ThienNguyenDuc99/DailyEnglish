$(document).ready(function () {
    admin = new admin();
});

class admin {
    constructor() {
        $(document).on("click", ".btn.add", this.openDialogAdd);
        $(document).on("click", ".btn.edit", this.openDialogEdit);
        $(document).on("click", ".btn.add1", this.openDialogAdd1);
        $(".dialog.add").on("click", ".btn.btn-success", this.addVoca);
        $(document).on("click", ".btn.delete", this.delVoca);
        $(".dialog.edit").on("click", ".btn.btn-success", this.editVoca);
        $(".dialog.add1").on("click", ".btn.btn-success", this.addContext);
    }

    openDialogAdd(){
        $(".dialog.add").dialog({
            width: 650,
            height: 650,
        })
    }

    openDialogEdit(){
        $(".dialog.edit").dialog({
            width: 600,
            height: 550,
        })
        var listEdit = $(".btn.edit");
        listEdit.removeClass("dangsua")
        $(this).addClass("dangsua")
        var idDom = $(this).next();
        var id = idDom.attr("property")
        var url = "/get_voca_id/"+id
        $.ajax({
            url : url,
            contentType : "application/json;charset=UTF-8",
            type : 'GET',
            async: false,
            success: function (data){
                var listInput = $(".dialog.edit input")
                listInput[0].value = data[0][0]
                listInput[1].value = data[0][1]
                listInput[2].value = data[0][2]
                listInput[3].value = data[0][3]
                listInput[4].value = data[0][4]
                listInput[5].value = data[0][5]
            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
    }

    openDialogAdd1(){
        var list = $(".btn.add1");
        list.removeClass("dangthem")
        $(this).addClass("dangthem")
        $(".dialog.add1").dialog({
            width: 500,
            height: 250,
        })
    }

    addVoca(){
        var listInput = $(".dialog.add input")
        var Vocabulary = {}
        Vocabulary["vocaValue"] = listInput[0].value
        Vocabulary["mean"] = listInput[1].value
        Vocabulary["english"] = listInput[2].value
        Vocabulary["spelling"] = listInput[3].value
        Vocabulary["image"] = listInput[4].value
        Vocabulary["partofSpeech"] = $( ".pos option:selected" ).text();
        $.ajax({
            url : "/addVoca",
            contentType : "application/json;charset=UTF-8",
            type : 'POST',
            async: false,
            dataType: "json",
            data : JSON.stringify(Vocabulary),
            success: function (data){

            },
        });
        $('.dialog.add').dialog('close')
        window.location.reload(true);
    }

    delVoca(){
        var idDom = $(this).next();
        var id = idDom.attr("property")
        var url = "/delVoca/"+id
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

    editVoca(){
        var listInput = $(".dialog.edit input")
        var Vocabulary = {}
        var idDom = $(".btn.edit.dangsua")
        var id = idDom.next().attr("property")
        Vocabulary["vocaId"] = id
        Vocabulary["vocaValue"] = listInput[0].value
        Vocabulary["mean"] = listInput[1].value
        Vocabulary["english"] = listInput[2].value
        Vocabulary["spelling"] = listInput[3].value
        Vocabulary["image"] = listInput[4].value
        Vocabulary["partofSpeech"] = listInput[5].value
        $.ajax({
            url : "/updateVoca",
            contentType : "application/json;charset=UTF-8",
            type : 'PUT',
            async: false,
            dataType: "json",
            data : JSON.stringify(Vocabulary),
            success: function (data){

            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
        $('.dialog.edit').dialog('close')
        window.location.reload(true);
    }

    addContext(){
        var listInput = $(".dialog.add1 input")
        var Context = {}
        Context["contextValue"] = listInput[0].value
        var idDom = $(".btn.add1.dangthem")
        var id = idDom.next().attr("property")
        var url = "/addContext/"+id
        $.ajax({
            url : url,
            contentType : "application/json;charset=UTF-8",
            type : 'POST',
            async: false,
            dataType: "json",
            data : JSON.stringify(Context),
            success: function (data){

            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
        $('.dialog.add1').dialog('close')
        window.location.reload(true);
    }

}