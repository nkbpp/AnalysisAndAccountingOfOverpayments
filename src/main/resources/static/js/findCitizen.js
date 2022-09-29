$(document).ready(function () {

    $("#numDistrict").selectize({
        create: true,
        //sortField: "text",
    });

    $("body").on('change','#col',function(){
        // кнопка поиск по снилс
        if ($("#btnFindCitizenSNILS").length > 0) {
            findCitizen("SNILS");
        }

        // кнопка поиск по фио
        if ($("#btnFindCitizenFIO").length > 0) {
            findCitizen("FIO");
        }

        // кнопка поиск по району
        if ($("#btnFindCitizenDistrict").length > 0) {
            findCitizen("District");
        }
    });

    //обработка ссылок
    $("body").on('click', 'button', function () {

        // кнопка поиск по снилс
        if ($(this).attr('id') === "btnFindCitizenSNILS") {
            findCitizen("SNILS");
        }

        // кнопка поиск по фио
        if ($(this).attr('id') === "btnFindCitizenFIO") {
            findCitizen("FIO");
        }

        // кнопка поиск по району
        if ($(this).attr('id') === "btnFindCitizenDistrict") {
            findCitizen("District");
        }

    });

    $("body").on('click', 'a', function () {
        //переключатели страниц pagination
        if ($(this).parents("#paginationFindCitizen").attr("id") === "paginationFindCitizen") {
            clickPagination($(this),"#paginationFindCitizen");

            let howFind;
            if($("#btnFindCitizenDistrict").length > 0){
                howFind = "District";
            }
            if($("#btnFindCitizenSNILS").length > 0){
                howFind = "SNILS";
            }
            if($("#btnFindCitizenFIO").length > 0){
                howFind = "FIO";
            }
            findCitizen(howFind);
        }
    });

})

function findCitizen(howFind) {
    let myform = document.getElementById("formFindCitizen");
    let fd = new FormData(myform);
    let object = {};
    fd.forEach((value, key) => object[key] = value);
    let json = JSON.stringify(object);
    let params = "col=" + $("#col").val() + "&pagination=" + activeList("#paginationFindCitizen");

    $('#tablefindresult tbody').html('<tr>' +
        '<th>' + getSpinner() + '</th>' +
        '<td></td>' +
        '<td></td>' +
        '<td></td>' +
        '<td></td>' +
        '<td></td>' +
        '<td></td>' +
        '<td></td>' +
        '</tr>');
    $.ajax({
        url: "/aaaop/findCitizen" + howFind + "?" + params,
        data: json,
        cache: false,
        processData: false,
        contentType: "application/json",
        type: 'POST',
        /*beforeSend: function (xhr) {
            xhr.setRequestHeader($('#_csrf').attr('content'),
                                 $('#_csrf_header').attr('content'));
        },*/
        success: function (response) {
            var trHTML = '';
            $('#tablefindresult tbody').html("");
            $.each(response, function (i, item) {
                trHTML +=
                    '<tr>' +
                    '<th>' + (+$("#col").val()*+activeList("#paginationFindCitizen") - +$("#col").val() + (+i+1)) + '</th>' +
                    '<td>' + replaceNull(item.snils) + '</td>' +
                    '<td>' + replaceNull(item.surname) + '</td>' +
                    '<td>' + replaceNull(item.name) + '</td>' +
                    '<td>' + replaceNull(item.patronymic) + '</td>' +
                    '<td>' + replaceNull(item.rdat) + '</td>' +
                    '<td>' + replaceNull(item.adrreg) + '</td>' +
                    '<td><a href="#" id="' + item.id + '">Выбрать</a></td>' +
                    '</tr>';
            });
            $('#tablefindresult').append(trHTML);
        },
        error: function (jqXHR, textStatus) {
            alert("ERROR")
            $('#tablefindresult tbody').html("");
        }
    });
}

function replaceNull(val){
    return val===null?"":val;
}