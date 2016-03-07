$(document).ready(function () {
    var id2 = $("#sweet_select").find('option:selected').attr('value');
    //console.log('start ' + id2);
    $.ajax({
        type: "GET",
        url: "/packs/" + id2 + "/ajax"
    })
        .done(function (data) {
            //console.log("from ajax function init ");
            $("#shell").html("<label class=col-xs-offset-2 control-label> Тип оболочки: "+ data.sweet.shell.name +"</label>");
            $("#filling").html("<label class=col-xs-offset-2 control-label> Тип начинки: "+ data.sweet.filling.name +"</label>");
            $("#description").html("<label class=col-xs-offset-2> Описание: "+ data.sweet.description +"</label>");
        })
        .error(function (jqXHR, exception) {
            if (jqXHR.status === 0) {
                console.log('Not connect.\n Verify Network.');
            } else if (jqXHR.status === 404) {
                console.log('Requested page not found. [404]');
            } else if (jqXHR.status === 500) {
                console.log(jqXHR);
                console.log('Internal Server Error [500].');
            } else if (exception === 'parsererror') {
                console.log('Requested JSON parse failed.');
            } else if (exception === 'timeout') {
                console.log('Time out error.');
            } else if (exception === 'abort') {
                console.log('Ajax request aborted.');
            } else {
                console.log('Uncaught Error.\n' + jqXHR.responseText);
            }

    });
    $("#sweet_select").bind("change", function () {
        var id = $(this).find('option:selected').attr('value');
        //console.log(id);
        $.ajax({
            type: "GET",
            url: "/packs/" + id + "/ajax"
        })
                .done(function (data) {
                    //console.log("from ajax function change");
                    $("#shell").html("<label class=col-xs-offset-2 control-label> Тип оболочки: " + data.sweet.shell.name + "</label>");
                    $("#filling").html("<label class=col-xs-offset-2 control-label> Тип начинки: "+ data.sweet.filling.name +"</label>");
                    $("#description").html("<label class=col-xs-offset-2 control-label> Описание: "+ data.sweet.description +"</label>");
                });

    });
});