$(document).ready(function () {

    //обработка ссылок
    $("body").on('click', 'input', function () {

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
            let list = clickPagination($(this),"#paginationFindCitizen");
            console.log(list);
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

    $.ajax({
        url: "/aaaop/findCitizen" + howFind + "?" + params,
        data: json,
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
            $('#tablefindresult tbody').html("");
            $.each(response, function (i, item) {
                trHTML +=
                    '<tr>' +
                    '<td>' + item.snils + '</td>' +
                    '<td>' + item.surname + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' + item.patronymic + '</td>' +
                    '<td>' + item.rdat + '</td>' +
                    '<td>' + item.adrreg + '</td>' +
                    '<td><a href="#" id="' + item.id + '">Выбрать</a></td>' +
                    '</tr>';
            });
            $('#tablefindresult').append(trHTML);
        },
        error: function (jqXHR, textStatus) {

        }
    });


}

