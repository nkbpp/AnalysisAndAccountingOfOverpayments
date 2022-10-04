let TRUPDATE;
$(document).ready(function () {

    $("body").on('click','button',function(){

        //поиск по снилс
        if ($(this).hasClass("btnFindCitizenSNILS")) {
            if($(this).parents("form").eq(0).attr("id")==="formAddPensioner"){
                findCitizen("formAddPensioner");
                findDependent();
                findCarer()
            }
            if($(this).parents("form").eq(0).attr("id")==="formAddCarer"){
                findCitizen("formAddCarer");
            }
            if($(this).parents("form").eq(0).attr("id")==="formAddDependent"){
                findCitizen("formAddDependent");
            }

        }


        //ДОБАВИТЬ
        if ($(this).attr('id')==="btnAddCitizen") {

            let formAddDependent = document.getElementById("formAddDependent");
            let fdFormAddDependent = new FormData(formAddDependent);
            let dependent = {};
            fdFormAddDependent.forEach((value, key) => dependent[key] = value);

            let formAddCarer = document.getElementById("formAddCarer");
            let fdFormAddCarer = new FormData(formAddCarer);
            let carer = {};
            fdFormAddCarer.forEach((value, key) => carer[key] = value);

            let addPensioner = document.getElementById("formAddPensioner");
            let fd = new FormData(addPensioner);
            let object = {};
            fd.forEach((value, key) => object[key] = value);
            let arrCarer = [];
            if(carer.snils!=""){
                arrCarer[0]=carer;
                object['carers'] = arrCarer
            }
            let arrDependent = [];
            if(dependent.snils!=""){
                arrDependent[0]=dependent;
                object['dependents'] = arrDependent
            }
            let data = JSON.stringify(object);

            $.ajax({
                url: "/aaaop/addCitizen2/citizen",
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
                    document.location.href = '/aaaop/vievInformationOverpayments'
                },
                error: function (jqXHR, textStatus) {
                    alert("err " + textStatus + " !!! " +  jqXHR)
                }
            });
        }

    });

})

function findCitizen(formId) {
    let snils = $("#"+formId+" #snils").val();
    let json = JSON.stringify({ 'snils': snils });

    $.ajax({
        url: "/aaaop/ros/findCitizenSNILS",
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
                $("#"+formId+" [name='surname']").val(item.surname);
                $("#"+formId+" [name='name']").val(item.name);
                $("#"+formId+" [name='patronymic']").val(item.patronymic);
                $("#"+formId+" [name='adrreg']").val(item.adrreg);
                $("#"+formId+" [name='tel']").val();
            });
        },
        error: function (jqXHR, textStatus) {
            alert("ERROR");
        }
    });
}

function findDependent() {
    let formId = "formAddDependent";
    let snils = $("#formAddPensioner #snils").val();
    let json = JSON.stringify({ 'snils': snils });

    $.ajax({
        url: "/aaaop/ros/findDependentSNILS",
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
                $("#"+formId+" [name='snils']").val(item.snils);
                $("#"+formId+" [name='surname']").val(item.surname);
                $("#"+formId+" [name='name']").val(item.name);
                $("#"+formId+" [name='patronymic']").val(item.patronymic);
                $("#"+formId+" [name='adrreg']").val(item.adrreg);
                $("#"+formId+" [name='tel']").val();
            });
        },
        error: function (jqXHR, textStatus) {
            alert("ERROR");
        }
    });
}

function findCarer() {
    let formId = "formAddCarer";
    let snils = $("#formAddPensioner #snils").val();
    let json = JSON.stringify({ 'snils': snils });

    $.ajax({
        url: "/aaaop/ros/findCarerBySnils",
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
                $("#"+formId+" [name='snils']").val(item.snils);
                $("#"+formId+" [name='surname']").val(item.surname);
                $("#"+formId+" [name='name']").val(item.name);
                $("#"+formId+" [name='patronymic']").val(item.patronymic);
                $("#"+formId+" [name='adrreg']").val(item.adrreg);
                $("#"+formId+" [name='tel']").val();
            });
        },
        error: function (jqXHR, textStatus) {
            alert("ERROR");
        }
    });
}