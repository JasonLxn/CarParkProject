var vm=new Vue({
    el:'#opst_feedback',
    data:{
        feedback:'',
        monthcount:'',
        daycount:'',
        fedinfo:'',
        num:'',
        currentpage:'',
        datevalue:'',
        statevalue:''
    },
    created:function () {
        $.ajax({
            url:'/staffFed/fed',
            success:function (result) {
                vm.feedback=result.fed;
                vm.monthcount=result.monthcount;
                vm.daycount=result.daycount;
                vm.fedinfo=result.fed[0];
                vm.num=result.page.pages;
                vm.currentpage=result.page.current;
                vm.getTime();
                if(vm.num==0){
                    $(".myinfo_right").removeClass("borderred").removeClass("bordergreen");
                    $(".myinfo_right").addClass("bordergray");
                }else{
                    vm.changecolor(vm.fedinfo.febaState);
                }
            }
        })
    },
    methods:{
        turnpage:function (pagenum) {
            var value=vm.datevalue;
            if(value==7||value==15){
                vm.dayajax(pagenum);
            }else{
                vm.dateajax(pagenum);
            }
        },
        getTime:function () {
            var value=$(".mt_timechoose .systemcolor a").html();
            if(value.indexOf("七天信息")!=-1)
                vm.datevalue=7;
            if(value.indexOf("十五天信息")!=-1)
                vm.datevalue=15;
            if(value.indexOf("上月信息")!=-1)
                vm.datevalue=1;
            if(value.indexOf("本月信息")!=-1)
                vm.datevalue=0;
            var state=$(".mt_statechoose .systemcolor a").html();
            if(state.indexOf("未处理")!=-1){
                vm.statevalue='未处理';
            }
            if(state.indexOf("已提交")!=-1){
                vm.statevalue='已处理';
            }
            if(state.indexOf("已丢弃")!=-1){
                vm.statevalue='已丢弃';
            }
        },
        choosetime:function () {
            vm.getTime();
            vm.turnpage(1);
        },
        choosestate:function(){
            vm.getTime();
            vm.turnpage(1);
        },
        choosedate:function(){
            var year=$("#selectyear option:selected").html();
            var month=$("#selectmonth option:selected").html();
            vm.datevalue=year+month;
            vm.turnpage(1);
        },
        chooseinfo:function(id){
            $.ajax({
                url:'/staffFed/infoFed/'+id,
                success:function (result) {
                    vm.fedinfo=result.fedinfo;
                    if(vm.num==0){
                        $(".myinfo_right").removeClass("borderred").removeClass("bordergreen");
                        $(".myinfo_right").addClass("bordergray");
                    }else{
                        vm.changecolor(vm.fedinfo.febaState);
                    }
                }
            })
        },
        changecolor:function(state){
            if(state=='未处理'){
                $(".myinfo_right").removeClass("bordergreen").removeClass("bordergray");
                $(".myinfo_right").addClass("borderred");
            }
            if(state=="已处理"){
                $(".myinfo_right").removeClass("borderred").removeClass("bordergray");
                $(".myinfo_right").addClass("bordergreen");
            }
            if(state=="已丢弃"){
                $(".myinfo_right").removeClass("borderred").removeClass("bordergreen");
                $(".myinfo_right").addClass("bordergray");
            }
            },
        dayajax:function (num) {
            var value="state=" + vm.statevalue + "&day=" + vm.datevalue;
            $.ajax({
                url:'/staffFed/dayFed/'+num,
                data:value,
                success:function (result) {
                    vm.feedback=result.fed;
                    vm.fedinfo=result.fed[0];
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                    if(vm.num==0){
                        $(".myinfo_right").removeClass("borderred").removeClass("bordergreen");
                        $(".myinfo_right").addClass("bordergray");
                    }else{
                        vm.changecolor(vm.fedinfo.febaState);
                    }
                }
            })
        },
        dateajax:function (num) {
            var value="state=" + vm.statevalue + "&date=" + vm.datevalue;
            $.ajax({
                url:'/staffFed/dateFed/'+num,
                data:value,
                success:function (result) {
                    vm.feedback=result.fed;
                    vm.fedinfo=result.fed[0];
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                    if(vm.num==0){
                        $(".myinfo_right").removeClass("borderred").removeClass("bordergreen");
                        $(".myinfo_right").addClass("bordergray");
                    }else{
                        vm.changecolor(vm.fedinfo.febaState);
                    }
                }
            })
        },
        submit:function (id) {
            var state='已处理';
            vm.updateinfo(id,state);
        },
        throwbtn:function (id) {
            var state='已丢弃';
            vm.updateinfo(id,state);
        },
        updateinfo:function (id,state) {
            $.ajax({
                url:'/staffFed/updateFed/'+id+'/'+state,
                success:function (result) {
                    if(result.code==0){
                        alert("状态已被修改，请重新操作");
                    }else{
                        vm.fedinfo=result.fedinfo;
                    }
                    if(vm.num==0){
                        $(".myinfo_right").removeClass("borderred").removeClass("bordergreen");
                        $(".myinfo_right").addClass("bordergray");
                    }else{
                        vm.changecolor(vm.fedinfo.febaState);
                    }
                }
            })
        }
    }
})