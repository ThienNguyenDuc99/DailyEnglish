$(document).ready(function () {
    vocabulary = new vocabulary();
});

class vocabulary{
    constructor() {
        $(document).on("click", ".btn.re", this.openDialog);
        $(".dialog.re").on("click", ".btn.btn-success", this.setRelationship);
    }

    openDialog(){
        // var x = $(".btn.re")
        // if(x.hasClass("dangmap")) {
        //     $(".btn.re").removeClass("dangmap")
        // }
        // $(this).addClass("dangmap")
        $(".dialog.re").dialog({
            width: 400,
            height: 250,
        })
    }

    setRelationship(){
        var id2 = $(".dialog.re input")[0].value
        var idDom = $(".btn.re")
        var id1 = idDom.next().attr("property")
        var url = "/setRelationship/" + id1 + "/" + id2
        $.ajax({
            url : url,
            contentType : "application/json;charset=UTF-8",
            type : 'PUT',
            async: false,
            dataType: "json",
            // data : JSON.stringify(Vocabulary),
            success: function (data){

            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
        $('.dialog.re').dialog('close')
        window.location.reload(true);
    }


}