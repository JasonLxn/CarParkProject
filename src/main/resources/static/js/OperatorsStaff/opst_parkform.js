//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
	highlight: function(element) {
		$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	},
	success: function(element) {
		element.closest('.form-group').removeClass('has-error').addClass('has-success');
	},
	errorElement: "span",
	errorPlacement: function(error, element) {
		if(element.is("textarea")){
			error.appendTo(element.parent());
		}else {
			error.appendTo(element.parent().parent());
		}
	},
	errorClass: "help-block m-b-none",
	validClass: "help-block m-b-none"

});

$(function() {
	jQuery.validator.addMethod("detestate",function (value,element) {
		var values=$(".parcAstate").val();
		if(values==0){
			return false;
		}else{
			return true;
		}
	},"请至少选择1个标签");
})

var urlnum;

//以下为官方示例
$().ready(function() {
    var urlparknum=window.location.href;
    var urlparknum=urlparknum.substring(urlparknum.length-3);
    urlnum=urlparknum;
    $.ajax({
        url:'/Serservice/parknum/'+urlparknum,
        success:function (result) {
            $(".parcParkid").val(urlparknum);
            $(".parcBstate").val(result.park.parkState);
        }
    });

	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules: {
            parcAstate:{
				detestate:true,
			},
		},
		messages: {
            parcAstate:{
				detestate: icon+"请选择车位状态",
			},
		}
	});
});

function submitTip() {
    if ($("#signupForm").valid()) {
        $("#tipModal").modal("show");
    }
};

function submitForm(){
    var formData = new FormData($("#signupForm")[0]);
    $.ajax({
        type: 'post',
        url: '/staffpark/updatepark',
        data: formData,
        cache: false,
        async: false,
        processData: false,  //必须false才会避开jQuery对 formdata 的默认处理   
        contentType: false,
        success: function (result) {
            if(result.code==1){
                $("#tipModal").modal("hide");
                $("#successModal").modal("show");
            }else{
                $("#tipModal").modal("hide");
                $("#failModal").modal("show");
            }
        },
    })
}

function failbtn() {
    window.location.href="/staff/updateParkInfo"+urlnum;
}

function succbtn() {
	window.location.href="/staff/parkstate";
}