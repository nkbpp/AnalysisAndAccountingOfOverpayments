$(document).ready(function () {

    $("form select").selectize({
        create: true,
        sortField: "text",
    });

/*    $("body").on('click', 'button', function () {
        //Добавить модаль
        if ($(this).hasClass("addSpecificationOfTheReasonsForOverpayments")) {
            $("#updateOrAddSpecificationOfTheReasonsForOverpayments").text('Добавить');
        }
    })*/

    //сколько выводить 30 50 100
    $("body").on('click','button',function(){
        if ($(this).attr('id')==="btnStatistics") {
            //todo
        }
    });

    //сколько выводить 30 50 100
    $("body").on('change','#col',function(){
        let params = "col=" + $("#col").val() + "&pagination=" + activeList("#paginationReasonsForOverpayments");
        //ajaxReasonsForOverpaymentsAll(params, ""); //todo что обновлять
    });

    $("body").on('click', 'a', function () {
        //переключатели страниц pagination
        if ($(this).parents("#paginationStatistics").attr("id") === "paginationStatistics") {
            clickPagination($(this), "#paginationStatistics");
            let params = "col=" + $("#col").val() + "&pagination=" + activeList("#paginationStatistics");
            //ajaxReasonsForOverpaymentsAll(params, ""); //todo что обновлять
        }
    });

})