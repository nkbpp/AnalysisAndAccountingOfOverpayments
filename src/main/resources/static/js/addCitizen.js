let TRUPDATE;
$(document).ready(function () {

    $("body").on('click','button',function(){

        if($(this).hasClass('addCitizenModalOpen')) {
            clearModalCitizen();
            $("#btnModalAddCitizen").removeClass("addPensioner").removeClass("addCarer").removeClass("addDependent");
            $("#btnModalAddCitizen").removeClass("updatePensioner").removeClass("updateCarer").removeClass("updateDependent");
            $("#btnModalAddCitizen").text("Добавить");

            //открыть модальное окно добавления пенсионера
            if ($(this).attr('id')==="btnModalAddPensioner") {
                $("#modalAddCitizenLabel").text("Пенсионер");
                $("#btnModalAddCitizen").addClass("addPensioner");
            }

            //открыть модальное окно добавления Лицо осуществляющее уход
            if ($(this).attr('id')==="btnModalAddCarer") {
                $("#modalAddCitizenLabel").text("Лицо осуществляющее уход");
                $("#btnModalAddCitizen").addClass("addCarer");
            }

            //открыть модальное окно добавления Иждивенец
            if ($(this).attr('id')==="btnModalAddDependent") {
                $("#modalAddCitizenLabel").text("Иждивенец");
                $("#btnModalAddCitizen").addClass("addDependent");
            }
        }

        if($(this).hasClass('updateCitizenModalOpen')) {
            TRUPDATE = $(this).parents('tr');
            let arrTd = $(this).parents('tr').children('td');
            $("#snils").val(arrTd.eq(0).text());
            $("#surname").val(arrTd.eq(1).text());
            $("#name").val(arrTd.eq(2).text());
            $("#patronymic").val(arrTd.eq(3).text());
            $("#fullAdress").val(arrTd.eq(4).text());
            $("#tel").val(arrTd.eq(5).text());

            $("#btnFindCitizenSNILS").addClass('disabled');
            $("#btnModalAddCitizen").text("Изменить");
            $("#btnModalAddCitizen").removeClass("addPensioner").removeClass("addCarer").removeClass("addDependent");
            $("#btnModalAddCitizen").removeClass("updatePensioner").removeClass("updateCarer").removeClass("updateDependent");

            //открыть модальное окно добавления пенсионера
            if ($(this).hasClass("updatePensionerModalOpen")) {
                $("#modalAddCitizenLabel").text("Пенсионер");
                $("#btnModalAddCitizen").addClass("updatePensioner");
            }

            //открыть модальное окно добавления Лицо осуществляющее уход
            if ($(this).hasClass("updateCarerModalOpen")) {
                $("#modalAddCitizenLabel").text("Лицо осуществляющее уход");
                $("#btnModalAddCitizen").addClass("updateCarer");
            }

            //открыть модальное окно добавления Иждивенец
            if ($(this).hasClass("updateDependentModalOpen")) {
                $("#modalAddCitizenLabel").text("Иждивенец");
                $("#btnModalAddCitizen").addClass("updateDependent");
            }
        }

        //кнопка добавления пенсионера в модальном окне
        if ($(this).attr('id')==="btnModalAddCitizen" && $(this).hasClass("addPensioner")) {
            $("#tableAddCitizenPensioner tbody").append(htmlTR("Pensioner"));
            $("#btnModalAddPensioner").addClass("disabled");
        }

        //кнопка добавления Лицо осуществляющее уход в модальном окне
        if ($(this).attr('id')==="btnModalAddCitizen" && $(this).hasClass("addCarer")) {
            $("#tableAddCitizenCarer tbody").append(htmlTR("Carer"));
        }

        //кнопка добавления Иждивенец в модальном окне
        if ($(this).attr('id')==="btnModalAddCitizen" && $(this).hasClass("addDependent")) {
            $("#tableAddCitizenDependent tbody").append(htmlTR("Dependent"));
        }

        //кнопка изменения пенсионера в модальном окне
        if ($(this).attr('id')==="btnModalAddCitizen" &&
            ($(this).hasClass("updatePensioner") ||
                $(this).hasClass("updateCarer") ||
                $(this).hasClass("updateDependent")
            )) {
            $("#btnFindCitizenSNILS").removeClass('disabled');
            TRUPDATE.after(htmlTR());
            TRUPDATE.remove();
        }

        //поиск по снилс
        if ($(this).attr('id')==="btnFindCitizenSNILS") {
            findCitizen();
        }

        //удалить строку в таблице
        if ($(this).hasClass("delAddCitizen")) {
            $(this).parents('tr').remove();
            if($("#tableAddCitizenPensioner tbody").children('tr').length === 0){
                $("#btnModalAddPensioner").removeClass("disabled");
            }
        }

        //ДОБАВИТЬ
        if ($(this).attr('id')==="btnAddCitizen") {
            //todo
            let pensioner = new Object();
            let dependent = new Object();
            let trPensioner = $("#tableAddCitizenPensioner tbody").children('tr').eq(0).children('td');

/*            pensioner.snils = trPensioner.eq(0).text();
            pensioner.surname = trPensioner.eq(1).text();
            pensioner.name = trPensioner.eq(2).text();
            pensioner.patronymic = trPensioner.eq(3).text();
            pensioner.adrreg = trPensioner.eq(4).text();
            pensioner.tel = trPensioner.eq(5).text();*/

            let arrCarer = [];
            let trCarer = $("#tableAddCitizenCarer tbody").children('tr');

            trCarer.each(function(index, element){

                let carer = new Object();
                let tdCarer = $(element).children('td');

                carer.snils = tdCarer.eq(0).text();
                carer.surname = tdCarer.eq(1).text();
                carer.name = tdCarer.eq(2).text();
                carer.patronymic = tdCarer.eq(3).text();
                carer.adrreg = tdCarer.eq(4).text();
                carer.tel = tdCarer.eq(5).text();

                arrCarer[index] = carer;

            });

            let arrDependent = [];
            let trDependent = $("#tableAddCitizenDependent tbody").children('tr');

            trDependent.each(function(index, element){

                let dependent = new Object();
                let tdDependent = $(element).children('td');

                dependent.snils = tdDependent.eq(0).text();
                dependent.surname = tdDependent.eq(1).text();
                dependent.name = tdDependent.eq(2).text();
                dependent.patronymic = tdDependent.eq(3).text();
                dependent.adrreg = tdDependent.eq(4).text();
                dependent.tel = tdDependent.eq(5).text();

                arrDependent[index] = dependent;

            });

            let data = JSON.stringify(
                {
                    "snils" : trPensioner.eq(0).text(),
                    "surname" : trPensioner.eq(1).text(),
                    "name" : trPensioner.eq(2).text(),
                    "patronymic" : trPensioner.eq(3).text(),
                    "adrreg" : trPensioner.eq(4).text(),
                    "tel" : trPensioner.eq(5).text(),
                    "carers":arrCarer,
                    "dependents":arrDependent});
            //data += (", " + JSON.stringify(arrCarer));
/*            alert(data);
            alert(data2);*/
            $.ajax({
                url: "/aaaop/addCitizen/citizen",
                data: data,
                cache: false,
                processData: false,
                contentType: "application/json",
                type: "POST",
                /*beforeSend: function (xhr) {
                    xhr.setRequestHeader($('#_csrf').attr('content'),
                                         $('#_csrf_header').attr('content'));
                },*/
                success: function (response) {
                    alert("добавлено")
                },
                error: function (jqXHR, textStatus) {
                    alert("err " + textStatus + " !!! " +  jqXHR)
                }
            });
        }

    });

})

function clearModalCitizen() {
    $("#snils").val("");
    $("#surname").val("");
    $("#name").val("");
    $("#patronymic").val("");
    $("#fullAdress").val("");
    $("#tel").val("");
}

function htmlTR(typeCitizen) {
    let html = "<tr>" +
        "<td>" + $("#snils").val() + "</td>" +
        "<td>" + $("#surname").val() + "</td>" +
        "<td>" + $("#name").val() + "</td>" +
        "<td>" + $("#patronymic").val() + "</td>" +
        "<td>" + $("#fullAdress").val() + "</td>" +
        "<td>" + $("#tel").val() + "</td>" +
        "<td>" +

        '<div class="d-flex flex-row">' +
        '<div class="block px-1">' +
        '<button ' +
        'class="btn btn-secondary p-1 delAddCitizen" ' +
        'type="button" ' +
        '>Удалить</button>' +
        '</div>' +
        '<div class="block px-1">' +
        '<button ' +
        'class="btn btn-secondary p-1 updateCitizenModalOpen update' + typeCitizen + 'ModalOpen" ' +
        'data-bs-toggle="modal" ' +
        'data-bs-target="#modalAddCitizen" ' +
        'type="button" ' +
        '>Изменить</button>' +
        '</div>' +
        '</div>' +

        "</td>" +
        "</tr>";
    return html;
}

function findCitizen() {

    let snils = $("#snils").val();
    let json = JSON.stringify({ 'snils': snils });

    $.ajax({
        url: "/aaaop/findCitizenSNILS",
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
            $.each(response, function (i, item) {
                $("#surname").val(item.surname);
                $("#name").val(item.name);
                $("#patronymic").val(item.patronymic);
                $("#fullAdress").val(item.adrreg);
                $("#tel").val();
            });
        },
        error: function (jqXHR, textStatus) {
            alert("ERROR");
        }
    });
}