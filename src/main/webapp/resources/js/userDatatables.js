var ajaxUrl = "ajax/admin/users/";
var datatableApi;

// $(document).ready(function () {
$(function () {
    datatableApi = $("#datatable").DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "email"
            },
            {
                "data": "roles"
            },
            {
                "data": "enabled"
            },
            {
                "data": "registered"
            },
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
    });
    makeEditable();
});

function setUserActiveOrInactiveStatus(userId) {
    var checkbox = $("#userActiveOrInactiveStatusCheckbox_" + userId);
    if (checkbox.is(":checked")) {
        setActive(userId)
    } else {
        setInactive(userId)
    }
}

function setActive(userId) {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "set_active",
        data : {"id" : userId},
        success: function () {
            successNoty("User Active");
        }
    })
    ;
}

function setInactive(userId) {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "set_inactive",
        data : {"id" : userId},
        success: function () {
            successNoty("User Inactive");
        }
    });
}
