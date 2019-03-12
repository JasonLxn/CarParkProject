var labelOption = {
	normal: {
		show: true,
		position: 'insideBottom',
		distance: 15,
		align: 'left',
		verticalAlign: 'middle',
		rotate: 90,
		formatter: '{c}',
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
	title: {
        text: '车位信息统计图',
        top:10,
		textStyle:{
        	color:'#999999',
        	fontStyle:'normal',
　　　　 	fontSize:16
    	}
    },
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
		top:10,
        right: 10
	},
	xAxis: [{
		type: 'category',
		axisTick: {
			show: false
		},
		data: []
	}],
	yAxis: [{
		type: 'value'
	}],
	series: [{
			name: '使用次数',
			type: 'bar',
			barGap: 0,
			label: labelOption,
			data: []
		},
		{
			name: '故障次数',
			type: 'bar',
			label: labelOption,
			data: []
		},
		{
			name: '维修次数',
			type: 'bar',
			label: labelOption,
			data: []
		},
	]
};


var fundOption = {
    color:['#2A9D8F'],
    title: {
        text: '停车场日收益趋向图',
        top:10,
		textStyle:{
        	color:'#999999',
        	fontStyle:'normal',
　　　　 	fontSize:16
    	}
    },
    tooltip: {
        trigger: 'axis',
    },
    legend: {
        data:['日收益'],
        align: 'right',
		top:10,
        right: 20
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


var vm=new Vue({
	el:'#common_home',
	data:{
        usernum:'',
        unusernum:'',
        errornum:'',
        servicenum:'',
        userCountnow:'',
        userSpeed:'',
        errorCountnow:'',
        errorSpeed:'',
        serviceCountnow:'',
        serviceSpeed:'',
        fundCountnow:'',
        fundSpeed:'',
		nowtime:'',
		nowmonth:''
	},
	created:function () {
		$.ajax({
			url:'/common/home',
			success:function (result) {
				vm.usernum=result.usernum;
				vm.unusernum=result.unusernum;
                vm.errornum=result.errornum;
                vm.servicenum=result.servicenum;
                parkOption.xAxis[0].data=result.timelist;
                parkOption.series[0].data=result.uselist;
                parkOption.series[1].data=result.errorlist;
                parkOption.series[2].data=result.servicelist;
                fundOption.xAxis.data=result.timelist;
                fundOption.series[0].data=result.moneylist;
                vm.userCountnow=result.userCountnow;
                vm.userSpeed=result.userSpeed;
                vm.errorCountnow=result.errorCountnow;
                vm.errorSpeed=result.errorSpeed;
                vm.serviceCountnow=result.serviceCountnow;
                vm.serviceSpeed=result.serviceSpeed;
                vm.fundCountnow=result.fundCountnow;
                vm.fundSpeed=result.fundCountnow;
                var parkEchart=echarts.init(document.getElementById("pe_echart"));
                parkEchart.setOption(parkOption);
                var fundEchart=echarts.init(document.getElementById("pf_echart"));
                fundEchart.setOption(fundOption);
                vm.nowtime=vm.getNowtime();
                vm.nowmonth=new Date().getMonth()+1;
            }
		});
    },
	methods:{
		getNowtime:function () {
			var hours=vm.timeFormat(new Date().getHours());
			var min=vm.timeFormat(new Date().getMinutes());
			return hours+':'+min;
        },
        timeFormat:function (value) {
			if(value<10){
				value='0'+value;
			}
			return value;
        },
	},
    filters:{
        negativeFormat:function (num) {
			if(num<0){
				num=num.substring(1);
			}
        }
	}

	
})