(function () {
    
    "use strict";
    var rangeInputElement = $('#range-bar');
    var buttonBoxOutput = $('#button-box');
    var rangeValueOutputELement = $('#range-value');

    $(rangeInputElement).trigger('input');

    $(rangeInputElement).on('input', function () {

        var selectedRange = $(rangeInputElement).val();
        $(rangeValueOutputELement).html(selectedRange);
        $(buttonBoxOutput).html("");

        for (var i = 0; i < selectedRange; i++) {
            buttonBoxOutput.append('<button class="generatedButton" value=' + (i + 1) + '>' + (i + 1) + '</button>');
        }
    });

    $(document).on('click', '.generatedButton', function () {
        console.log($(this).val());
    });
})();