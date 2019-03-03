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
		var values=$(".dete_state").val();
		if(values==0){
			return false;
		}else{
			return true;
		}
	},"请至少选择1个标签");
    jQuery.validator.addMethod("checkpark",function (value,element) {
    	var flag;
        $.ajax({
            url:'/Serservice/parknum/'+value,
            async:false,
            success:function (result) {
				if(result.code==1){
                    flag=1;
                    $(".dete_bstate").val(result.park.parkState);
                }
				else{
                    flag=0;
                    $(".dete_bstate").val("（暂未填写正确的车位编号）");
                }
            }
        })
        return this.optional(element)||(flag==1);
	},"判断输入车位信息是否正确");
})

//以下为官方示例
$().ready(function() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules: {
            deteTitle: "required",
            deteParkid: {
				required:true,
                checkpark:true,
			},
            deteAtate:{
				detestate:true,
			},
            deteMeg: "required",
		},
		messages: {
            deteTitle: icon + "请输入报告标题",
            deteParkid:{
				required:icon + "请输入车位编号",
                checkpark:icon+"请输入正确的车位编号",
			} ,
            deteAtate:{
				detestate: icon+"请选择车位状态",
			},
            deteMeg: icon + "请提交详细维修内容",
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
        url: '/Serservice/insertDetect',
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
    window.location.href="/service/serform";
}

function succbtn() {
	window.location.href="/service/mysubmit";
}