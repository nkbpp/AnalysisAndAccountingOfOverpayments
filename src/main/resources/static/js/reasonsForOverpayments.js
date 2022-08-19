$(document).ready(function () {

    let params = "col=" + $("#col").val() + "&pagination=" + activeList("#paginationReasonsForOverpayments");

    $('#tableReasonsForOverpayments tbody').html('<tr><td></td><td>' + getSpinner() + '</td><td></td></tr>');
    $.ajax({
        url: "/aaaop/referenceBook/reasonsForOverpayments/All?" + params,
        data: "",
        cache: false,
        processData: false,
        contentType: "application/json",
        dataType: 'json',
        type: 'POST',
        /*beforeSend: function (xhr) {
            xhr.setRequestHeader($('#_csrf').attr('content'),
                                 $('#_csrf_header').attr('content'));
        },*/
        success: function (response) {
            var trHTML = '';
            $('#tableReasonsForOverpayments tbody').html("");
            $.each(response, function (i, item) {
                trHTML +=
                    '<tr>' +
                    '<td>' + item.id + '</td>' +
                    '<td>' + item.reasonsForOverpayments + '</td>' +
                    '<td>' +
                       '<div>' +
                            '<a class="deleteReasonsForOverpayments" name="' + item.id + '" href="#">Удалить</a>' +
                       '</div>' +
                        '<div>' +
                            '<a class="updateReasonsForOverpayments" name="' + item.id + '" href="#">Изменить</a>' +
                        '</div>' +
                    '</td>' +

                    //'<td><a href="#" id="' + item.id + '">Выбрать</a></td>' +
                    '</tr>';
            });
            $('#tableReasonsForOverpayments').append(trHTML);
        },
        error: function (jqXHR, textStatus) {

        }
    });

    $("body").on('click', 'a', function () {

        //кнопка удалить
        if ($(this).hasClass("deleteReasonsForOverpayments")) {
            let id = $(this).attr('name');
            $.ajax({
                url: "/aaaop/referenceBook/reasonsForOverpayments/" + id,
                cache: false,
                processData: false,
                type: 'DELETE',
                /*beforeSend: function (xhr) {
                xhr.setRequestHeader($('#_csrf').attr('content'),
                         $('#_csrf_header').attr('content'));
                },*/
                success: function (response) {
                    $("a.deleteReasonsForOverpayments[name='" + id + "']").parents('tr').remove()
                },
                error: function (jqXHR, textStatus) {
                }
            });
        }
        //изменить
        if ($(this).hasClass("updateReasonsForOverpayments")) {

            let id = $(this).attr('name');
            $.ajax({
                url: "/aaaop/referenceBook/reasonsForOverpayments",
                cache: false,
                processData: false,
                type: 'DELETE',
                /*beforeSend: function (xhr) {
                xhr.setRequestHeader($('#_csrf').attr('content'),
                         $('#_csrf_header').attr('content'));
                },*/
                success: function (response) {
                    //$("a.deleteReasonsForOverpayments[name='" + id + "']").parents('tr').remove()
                },
                error: function (jqXHR, textStatus) {
                }
            });
        }
    });

    $("body").on('click', 'a', function () {
        //переключатели страниц pagination
        if ($(this).parents("#paginationReasonsForOverpayments").attr("id") === "paginationReasonsForOverpayments") {
            let list = clickPagination($(this),"#paginationReasonsForOverpayments");
            /*let howFind;
            findCitizen(howFind);*/
        }
    });
});