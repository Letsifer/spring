$(document).ready(function () {
    var id2 = $("#sweet_select").find('option:selected').attr('value');
    $.ajax({
        type: "GET",
        url: "/packs/" + id2 + "/ajax"
    })
            .done(function (data) {
                $("#shell").html("<label class=col-xs-offset-2 control-label> Тип оболочки: " + data.sweet.shell.name + "</label>");
                $("#filling").html("<label class=col-xs-offset-2 control-label> Тип начинки: " + data.sweet.filling.name + "</label>");
                $("#description").html("<label class=col-xs-offset-2> Описание: " + data.sweet.description + "</label>");
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
    $("#sweet_select").on("change", function () {
        var id = $(this).find('option:selected').attr('value');
        $.ajax({
            type: "GET",
            url: "/packs/" + id + "/ajax"
        })
                .done(function (data) {
                    $("#shell").html("<label class=col-xs-offset-2 control-label> Тип оболочки: " + data.sweet.shell.name + "</label>");
                    $("#filling").html("<label class=col-xs-offset-2 control-label> Тип начинки: " + data.sweet.filling.name + "</label>");
                    $("#description").html("<label class=col-xs-offset-2 control-label> Описание: " + data.sweet.description + "</label>");
                });
    });
    $("#button_save").click(function () {
        console.log("from button_save handler");
        var id3 = $("#pack_id").val();
        console.log(id3);
        var barcode = $("#barcode").val();
        var sweet = $("#sweet_select").find('option:selected').attr('value');
        var number = $("#number").val();
        var price = $("#price").val();
        var packing_date = $("#packing_date").val();
        var expire_date = $("#expire_date").val();
        $.ajax({
            type: "PUT",
            url: "/packs/" + id3 + "/ajaxput",
            dataType: 'json',
            cache: false,
            timeout: 3000,
            data: {
                barcode: barcode,
                sweet: sweet,
                number: number,
                price: price,
                packing_date: packing_date,
                expire_date: expire_date
            }
        })
                .done(function (data) {
                    console.log("from done button save");
                    $("#answer").html("<h4>" + data.answer + " </h4>");
                    //$("answer").html("<h4> Информация о пачке конфеток с штрих-кодом " + data.pack.barcode + " успешно сохранена </h4>");
                })
                .error(function (jqXHR, exception) {
                    console.log("from error");
                    console.log(exception);
                    if (jqXHR.status === 0) {
                        console.log(jqXHR);
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
        return false;
    });
});