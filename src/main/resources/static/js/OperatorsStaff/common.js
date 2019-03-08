var controlchoose = {
	//时间选择样式的变换
	timebuttonchoose: function() {
		$(".mt_timechoose a").click(function() {
			$(".mt_tosubmit").removeClass("systemcolor").addClass("nocolor");
			$(".mt_timechoose span").removeClass("systemcolor").addClass("nocolor");
			$(this).parent("span").removeClass("nocolor").addClass("systemcolor");
		});
	},
	timechoose:function(){
		$(".mt_tosubmit").click(function(){
			$(".mt_timechoose span").removeClass("systemcolor").addClass("nocolor");
			$(".mt_tosubmit").removeClass("nocolor").addClass("systemcolor");
		});
	},
	statebuttonchoose:function(){
		$(".mt_statechoose a").click(function() {
			$(".mt_sosubmit").removeClass("systemcolor").addClass("nocolor");
			$(".mt_statechoose span").removeClass("systemcolor").addClass("nocolor");
			$(this).parent("span").removeClass("nocolor").addClass("systemcolor");
		});
	},
	statechoose:function(){
		$(".mt_sosubmit").click(function(){
			$(".mt_statechoose span").removeClass("systemcolor").addClass("nocolor");
			$(".mt_sosubmit").removeClass("nocolor").addClass("systemcolor");
		});
	},
	//统计图表的显示与隐藏
	hidechart:function(){
		$(".mc_tihide a").click(function(){
			if($(this).children("i").hasClass("fa-angle-down")){
				$(this).children("i").removeClass("fa-angle-down").addClass("fa-angle-up");
				$(".mc_chart").hide(1000);
				$(".spinner-box").hide(1000);
			}else{
				$(this).children("i").removeClass("fa-angle-up").addClass("fa-angle-down");
				$(".spinner-box").show(1000);
				$(".mc_chart").show(1000);
			}		
		});
	}
};

//根据时间自动填充select标签的年月
var selectedDate={
    selectedYear:function(){
        var nowdate=new Date();
        var nowyear=nowdate.getFullYear();
        var nowmonth=nowdate.getMonth()+1;
        var yearoption;
        for(var i=2018;i<=nowyear;i++){
            if(i==nowyear){
                yearoption="<option selected>"+i+"</option>";
            }else{
                yearoption="<option>"+i+"</option>"
            }
            $("#selectyear").append(yearoption);
        }
        this.selectMonth();
    },
    selectMonth:function(){
        $("#selectmonth").empty();
        var nowdate=new Date();
        var nowyear=nowdate.getFullYear();
        var nowmonth=nowdate.getMonth()+1;
        var selectyear=$("#selectyear option:selected").html();
        var monthlen;
        var monthoption;
        if(selectyear==nowyear){
            monthlen=nowmonth;
        }else{
            monthlen=12;
        }
        for(var i=1;i<=monthlen;i++){
        	var num;
        	if(i<10){
                num='0'+i;
			} else{
        		num=i;
			}

            if(i==nowmonth&&selectyear==nowyear){
                monthoption="<option selected>"+num+"</option>";
            }else{
                monthoption="<option>"+num+"</option>"
            }
            $("#selectmonth").append(monthoption);
        }
    }
};

$(function() {
	controlchoose.timechoose();
	controlchoose.timebuttonchoose();
	controlchoose.statechoose();
	controlchoose.statebuttonchoose();
	controlchoose.hidechart();
    selectedDate.selectedYear();
    $("#selectyear").change(function(){
        console.log("123");
        selectedDate.selectMonth();
    })
});