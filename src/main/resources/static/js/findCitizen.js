$(document).ready(function () {

    //обработка ссылок
    $("body").on('click', 'input', function () {

        if ($(this).attr('id') === "btnFindCitizenSNILS") {
            alert("test");
        }

    });

})
