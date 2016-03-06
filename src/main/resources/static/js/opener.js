$(document).ready(function () {
    var id2 = $("#sweet_select").find('option:selected').attr('value');
    console.log('o' + id2);
    $('#info' + id2).removeClass('hidden');
    $('#fill' + id2).removeClass('hidden');
    $('#descr' + id2).removeClass('hidden');
    $("#sweet_select").bind("change", function () {
        console.log('from change classes');
        var id = $(this).find('option:selected').attr('value');
        $('.sweets').addClass('hidden');
        $('.fillings').addClass('hidden');
        $('.description').addClass('hidden');
        $('#info' + id).removeClass('hidden');
        $('#fill' + id).removeClass('hidden');
        $('#descr' + id).removeClass('hidden');
    });
});
