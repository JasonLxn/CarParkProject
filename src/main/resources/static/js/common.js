var loginvue=new Vue({
    el:'#navbar',
    data:{
        username:'',
        userrole:''
    },
    created:function () {
        $.ajax({
            url:'/staff/info',
            success:function (result) {
                loginvue.username=result.username;
                loginvue.userrole=result.userrole;
            }
        })
    }
})