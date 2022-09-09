$(document).ready(function () {



    $("body").on('click','button',function(){

        if ($(this).attr('id')==="nav-OverpaymentData-tab") { //Данные о переплате

            if($("#redemptionOrHolding1").is(':checked')){//выбрано погашение
                holding();
            }
            if($("#redemptionOrHolding2").is(':checked')){//выбрано удержание
                redemption();
            }
        }

    });

    $("body").on('click','input',function(){

        if ($(this).attr('id')==="redemptionOrHolding1") { //Данные о переплате
            currentYearAndMounth();
            holding();
        }

        if ($(this).attr('id')==="redemptionOrHolding2") { //Данные о переплате
            currentYearAndMounth();
            redemption();
        }

    });

});

function holding(){
    $(".datePayment").removeClass('visually-hidden');
    $(".holding").removeClass('visually-hidden');
    $(".redemption").addClass('visually-hidden');
}

function redemption(){
    $(".datePayment").removeClass('visually-hidden');
    $(".holding").addClass('visually-hidden');
    $(".redemption").removeClass('visually-hidden');
}

function currentYearAndMounth(){
    $("#currentYear").val((new Date()).getFullYear());
    let selectize = $('#mounth')[0].selectize;
    selectize.setValue((new Date()).getMonth() + 1,true) //SELECTIZE
}