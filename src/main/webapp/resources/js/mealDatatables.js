var ajaxUrl = "ajax/profile/meals/";
var datatableApi;

$(function () {
    datatableApi = $("#datatable").DataTable(
        {
            "paging": false,
            "info": true,
            "columns": [
                {"data": "dateTime"},
                {"data": "description"},
                {"data": "calories"},
                {
                    "defaultContent": "Edit",
                    "orderable": false
                },
                {
                    "defaultContent": "Delete",
                    "orderable": false
                }
            ],
            "order": [
                [
                    0,
                    "asc"
                ]
            ]
        }
    );
    makeEditable();
});

function filter() {
    var form = $("#filterForm");
    $.ajax({
        type : "POST",
        url : "ajax/profile/meals/filter",
        data: form.serialize(),
        success: function (data) {
            datatableApi.clear().rows.add(data).draw();
            successNoty("Filtered")
        }
    });
}