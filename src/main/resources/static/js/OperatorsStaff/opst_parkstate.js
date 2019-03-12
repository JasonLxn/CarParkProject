window.onscroll = function () {
    var scrollheight = document.documentElement.scrollTop;
    var div = document.getElementById("carm");
    if (scrollheight != 0) {
        div.style.top = "50px";
    }
    if (scrollheight == 0) {
        div.style.top = "90px";
    }
}

var timeclean;
var vm = new Vue({
    el: '#parkmeg',
    data: {
        parkmeg: '',
        info: '',
        hour: '',
        minute: '',
        parktime: '',
        parkId:''
    },
    created: function () {
        $.ajax({
            url: '/staffpark/carmsg',
            success: function (result) {
                vm.parkmeg = result.park;
                vm.parkinfo(result.park[0].parkId);
            }
        })
    },
    methods: {
        parkinfo: function (parkid) {
            $.ajax({
                url: '/staffpark/parkinfo/' + parkid,
                success: function (result) {
                    vm.info = result.parkinfomeg;
                    vm.parkId=result.parkinfomeg.parkId;
                    vm.hour = new Date().getHours();
                    vm.minute = new Date().getMinutes();
                    clearTimeout(timeclean);
                    if(result.parkinfomeg.parkState=='使用中'){
                        vm.timer(result.parkhour,result.parkmin,result.parksec);
                    }
                }
            })
        },
        //定时器
        timer: function (h, m, s) {
            m=parseInt(m);
            s=parseInt(s);
            s = s + 1;
            if (s == 60) {
                m = m + 1;
                s = 0
            }
            if (m == 60) {
                h = h + 1;
                m = 0;
            }
            m=vm.timeFormatAfert(m);
            s=vm.timeFormatAfert(s);
            vm.parktime = h + ":" + m + ":" + s;
            timeclean = setTimeout(function () {
                    vm.timer(h, m, s);
                }, 1000
            );
        },
        //格式输出时间
        timeFormatAfert:function (num) {
            if(num<10){
                num='0'+num;
            }
            return num;
        }
    },
    filters: {
        timefilter: function (num) {
            if (num < 10) {
                num = '0' + num;
            }
            return num;
        }
    }
})