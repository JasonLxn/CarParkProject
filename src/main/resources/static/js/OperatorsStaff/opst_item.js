var labelOption = {
	normal: {
		show: true,
		position: 'insideBottom',
		distance: 15,
		align: 'left',
		verticalAlign: 'middle',
		rotate: 90,
		formatter: '{c}  {name|{a}}',
		fontSize: 16,
		rich: {
			name: {
				textBorderColor: '#fff'
			}
		}
	}
};

var parkOption = {
	color: ['#2A9D8F', '#e76f51', '#f4a261'],
	tooltip: {
		trigger: 'axis',
		axisPointer: {
			type: 'shadow'
		}
	},
	grid: {
		left: '0%',
		right: '0%',
		bottom: '3%',
		containLabel: true
	},
	legend: {
		data: ['使用次数', '故障次数', '维修次数'],
		align: 'right',
		top: 10,
		right: 10
	},
	xAxis: [{
		type: 'category',
		axisTick: {
			show: false
		},
		data: [],
	}],
	yAxis: [{
		type: 'value'
	}],
	series: [{
			name: '使用次数',
			type: 'bar',
			barGap: 0,
			label: labelOption,
			data: [],
		},
		{
			name: '故障次数',
			type: 'bar',
			label: labelOption,
			data: [],
		},
		{
			name: '维修次数',
			type: 'bar',
			label: labelOption,
			data: [],
		},
	]
};

// var loadingstart=function(){
//
// };
//
// window.onload=function () {
//     var parkEchart = echarts.init(document.getElementById("mc_chart"));
//     parkEchart.setOption(parkOption);
// };


var vm=new Vue({
	el:'#opst_parkitem',
	data:{
		parkitem:'',
		num:'',
		currentpage:'',
		datevalue:'',
	},
	created:function(){
        $(document).ajaxStart(function () {
            $(".spinner-box").removeClass("hide");
            $(".mc_chart").addClass("hide");
        }).ajaxStop(function () {
            $(".mc_chart").removeClass("hide");
            $(".spinner-box").addClass("hide");
        });
		$.ajax({
			url:'/staffpark/parkitem',
			success:function (result) {
;				vm.parkitem=result.parkinfo;
				vm.num=result.page.pages;
				vm.currentpage=result.page.current;
                vm.getTime();
                vm.echartparkajax(vm.datevalue);
            }
		})
	},
	methods:{
        turnpage:function (num) {
        	var value=vm.datevalue;
			if(value==7||value==15){
				vm.dayajax(num,value);
			}else if(value==0||value==1){
				vm.monthajax(num,value);
			}else{
				vm.dateajax(num,value);
			}
        },
        chooseInfo:function () {
        	vm.getTime();
			vm.turnpage(1);
			vm.echartparkajax(vm.datevalue);
        },
        choosedate:function(){
			vm.getYearMonth();
			vm.turnpage(1);
			vm.echartparkajax(vm.datevalue);
		},
		getTime:function () {
			 var value=$(".systemcolor a").html();
			 if(value.indexOf("七天信息")!=-1)
			 	vm.datevalue=7;
			 if(value.indexOf("十五天信息")!=-1)
                vm.datevalue=15;
			 if(value.indexOf("上月信息")!=-1)
                vm.datevalue=1;
			 if(value.indexOf("本月信息")!=-1)
                vm.datevalue=0;
        },
		getYearMonth:function(){
			var year=$("#selectyear option:selected").html();
			var month=$("#selectmonth option:selected").html();
			vm.datevalue=year+month;
			console.log(vm.datevalue);
		},
		dayajax:function (num,day) {
            $.ajax({
                url:'/staffpark/turndaypark/'+num+'/'+day,
                success:function (result) {
                    vm.parkitem=result.parkinfo;
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                }
            })
        },
		monthajax:function (num,month) {
            $.ajax({
                url:'/staffpark/turnmonthpark/'+num+'/'+month,
                success:function (result) {
                    vm.parkitem=result.parkinfo;
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                }
            })
        },
		dateajax:function(num,date){
            $.ajax({
                url:'/staffpark/turndatepark/'+num+'/'+date,
                success:function (result) {
                    vm.parkitem=result.parkinfo;
                    vm.num=result.page.pages;
                    vm.currentpage=result.page.current;
                }
            })
		},
		echartparkajax:function (value) {
        	$(document).ajaxStart(function () {
        		$(".spinner-box").removeClass("hide");
        		$(".mc_chart").addClass("hide");
            }).ajaxStop(function () {
                $(".mc_chart").removeClass("hide");
                $(".spinner-box").addClass("hide");
            });
            $.ajax({
                url:'/staffpark/echartpark/'+value,
                success:function (result) {
                	parkOption.xAxis[0].data=result.time;
                	parkOption.series[0].data=result.useNum;
                    parkOption.series[1].data=result.errorNum;
                    parkOption.series[2].data=result.serviceNum;
                    var chooseEchart = echarts.init(document.getElementById("mc_chart"));
                    chooseEchart.setOption(parkOption);
                }
            })
        }
	}
})