window.onscroll = function () {
    var scrollheight = document.documentElement.scrollTop;
    var div = document.getElementById("mydetect");
    if (scrollheight == 0) {
        div.style.top = "223px";
    }else if(scrollheight >=200){
        div.style.top = "95px";
    }else{
        div.style.top = "124px";
    }
}

//获取当前年月格式：201904
var getNowDate=function () {
    var nowdate=new Date();
    var year=nowdate.getFullYear();
    var months=nowdate.getMonth()+1;
    if(months<10)
        months='0'+months;
    var date=year+months;
    return date;
};

var vm =new Vue({
    el:'#opse_mysubmit',
    data:{
        list:'',
        detect:'',
        num:'',
        currentpage:'',
        monthcount:'',
        daycount:'',
        datevalue:'',
    },
    created:function () {
        var data=getNowDate();
        $.ajax({
            url:'/Serservice/pageservice/1/'+data,
            success:function (result) {
                vm.datevalue=data;
                vm.list=result.list;
                vm.detect=result.list[0];
                vm.num=result.page.pages;
                vm.currentpage=result.page.current;
                vm.monthcount=result.monthcount;
                vm.daycount=result.daycount;
            }
        })
    },
    methods:{
        turnpage:function (currentpage) {
            vm.getDetectlist(currentpage,vm.datevalue);
        },
        choosemonth:function(){
            vm.datevalue=getNowDate();
            vm.turnpage(1);
        },
        choosedate:function(){
            var year=$("#selectyear option:selected").html();
            var month=$("#selectmonth option:selected").html();
            vm.datevalue=year+month;
            vm.turnpage(1);
        },
        getDetectlist:function (currentpage,date) {
            $.ajax({
                url:'/Serservice/pageservice/'+currentpage+'/'+date,
                success:function (result) {
                    vm.list=result.list;
                    vm.detect=result.list[0];
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                }
            })
        },
        getOneInfo:function (id) {
            $.ajax({
                url:'/Serservice/onedetect/'+id,
                success:function (result) {
                    vm.detect=result.detect;
                }
            })
        }
    }
})