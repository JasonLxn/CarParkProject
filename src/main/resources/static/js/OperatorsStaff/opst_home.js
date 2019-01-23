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
		data: ['1', '2', '3', '4', '5','6','7','8','9','10']
	}],
	yAxis: [{
		type: 'value'
	}],
	series: [{
			name: '使用次数',
			type: 'bar',
			barGap: 0,
			label: labelOption,
			data: [320, 332, 301, 334, 390,320, 332, 301, 334, 390]
		},
		{
			name: '故障次数',
			type: 'bar',
			label: labelOption,
			data: [220, 182, 191, 234, 290,220, 182, 191, 234, 290]
		},
		{
			name: '维修次数',
			type: 'bar',
			label: labelOption,
			data: [150, 232, 201, 154, 190,150, 232, 201, 154, 190]
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
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        name:'日收益',
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line',
        smooth: true,
        areaStyle: {}
    }]
};


$(function(){
	var parkEchart=echarts.init(document.getElementById("pe_echart"));
	parkEchart.setOption(parkOption);
	var fundEchart=echarts.init(document.getElementById("pf_echart"));
	fundEchart.setOption(fundOption);
});
