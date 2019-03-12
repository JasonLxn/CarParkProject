var fundOption = {
    color:['#1ab394'],
    toolbox: {
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ['line', 'bar']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    tooltip: {
        trigger: 'axis',
    },
    legend: {
        data:['日收益'],
        align: 'right',
		top:10,
        left: 20
    },
    grid: {
        left: '0%',
        right: '3%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: []
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        name:'日收益',
        data: [],
        type: 'line',
        smooth: true,
        areaStyle: {}
    }]
};

//获取当前日期格式 value:1表示获取年月日20190401,其他表示获取年月201904
var getNowDate=function (value) {
    var nowdate=new Date();
    var year=nowdate.getFullYear();
    var months=nowdate.getMonth()+1;
    var day=nowdate.getDate();
    if(months<10)
        months='0'+months;
    if(day<10)
        day='0'+day;
    if(value==1){
        return year+"-"+months+"-"+day;
    }else{
        return year+"-"+months;
    }
};

//获取当前订单状态
var getstate=function () {
    var state=$(".mt_statechoose .systemcolor a").html();
    if(state.indexOf("未支付")!=-1){
        state="未支付"
    }
    if(state.indexOf("已支付")!=-1){
        state="已支付"
    }
    return state;
};

var vm=new Vue({
	el:'#admin_fundlist',
	data:{
		fund:'',
        num:'',
        currentpage:'',
        formatnum:'',
        date:'',
        state:'',
	},
    created:function(){
	    var formatnum="1";
	    var date=getNowDate(1);
	    var state="已支付";
	    var data="date="+date+"&state="+state;
	    $.ajax({
            url:'/admfund/fundlist/1/'+formatnum,
            data:data,
            success:function (result) {
                vm.fund=result.fund;
                vm.num=result.page.pages;
                vm.currentpage=result.page.current;
                vm.formatnum="1";
                vm.date=date;
                vm.state=state;
                vm.getfundecharts(1);
            }
        })
    },
	methods:{
		clicktr:function(id){
			var row='#'+'row'+id;
			var logo='#'+id+' .tb_logo i';
			if($(row).hasClass("hide")){
				$(row).removeClass("hide");
				$(logo).removeClass("fa-plus-square-o").addClass("fa-minus-square-o");
			}else{
				$(row).addClass("hide");
				$(logo).removeClass("fa-minus-square-o").addClass("fa-plus-square-o");
			}
		},
        turnpage:function (num) {
            vm.getfundlist(num);
        },
        choosetoday:function () {
            vm.formatnum="1";
            vm.date=getNowDate(1);
            vm.state=getstate();
            vm.turnpage(1);
            vm.getfundecharts(1);
        },
        choosetomonth:function () {
            vm.formatnum="0";
            vm.date=getNowDate(0);
            vm.state=getstate();
            vm.turnpage(1);
            vm.getfundecharts(0);
        },
        choosedate:function () {
            vm.formatnum="0";
            var year=$("#selectyear option:selected").html();
            var month=$("#selectmonth option:selected").html();
            vm.date=year+'-'+month;
            vm.state=getstate();
            vm.turnpage(1);
            vm.getfundecharts(vm.date);
        },
        choosestate:function(){
		    var datevalue=$(".mt_timechoose .systemcolor a").html();
		    if($(".mt_tosubmit").hasClass("systemcolor")){
                vm.choosedate();
            }else if(datevalue.indexOf("今日订单")!=-1){
                vm.choosetoday();
            }else if (datevalue.indexOf("本月订单")!=-1){
                vm.choosetomonth();
            }
        },
        getfundlist:function (num) {
            var data="date="+vm.date+"&state="+vm.state;
            $.ajax({
                url:'/admfund/fundlist/'+num+'/'+vm.formatnum,
                data:data,
                success:function (result) {
                    vm.fund=result.fund;
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                }
            })
        },
        getfundecharts:function (value) {
            $.ajax({
                url:'/admfund/fundecharts/'+value,
                success:function (result) {
                    fundOption.xAxis.data=result.time;
                    fundOption.series[0].data=result.money;
                    var fundEchart=echarts.init(document.getElementById("mc_chart"));
                    fundEchart.setOption(fundOption);
                }
            })
        }
	}
})