<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <script src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/macarons.js"></script>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">统计</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">统计</li>
                        <li class="breadcrumb-item active">统计</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

            <div id="main" style="width: 900px;height:600px;"></div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>


    var zdTypesOptions = [];
    var lxTypesOptions = [];
    var data = [];



    // 获取数据列表
    function getDataList() {
        http("chengji/group/bar", "GET", {
        }, (res) => {
            if(res.code == 0){
                draw(res.data);
            }else{
                return alert("查询的数据为空");
        }
      });
    }

    function draw(map) {

        // 基于准备好的dom，初始化echarts实例
        var myChart2 = echarts. init( document. getElementById( 'main'));
        // myChart2. showLoading();
        myChart2. setOption({
            title:{
                text: '分布图', //标题 },
                xAxis:{ data:[] },
                yAxis:{
                    type : 'value', //默认为值类型        
                    splitLine:{
                        show: true
                    }
                },
                series:[]
            }});

                    /*var map={
                        'categ': ['男', '女'],
                        'data': [
                            [2, 136, 38, 4, 1, 7],
                            [3, 75, 25, 5, 1, 0]
                        ],
                        'name': ['青少年', '青年人', '中年人', '老年前期', '老年人', '长寿老人']
                    }*/
                    var series=[];
                    for ( var i= 0; i<map. data. length; i++){
                        var item={
                            name:map.categ[ i],
                            data:map. data[ i],
                            type: 'bar',
                            label: { normal: { show: true, position: 'top' } }
                        };
                        series. push( item); }
//将数据加载到图形中
                    myChart2.setOption({
                        title: {
                            text: map.title,
                            textStyle: { fontSize: 14}
                        },
                        legend: {
                            data: map.categ,
                            left: 'right'
                        },
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: { type: 'shadow' }
                        },
                        xAxis: {
                            type: 'category',
                            data: map. name,
                            axisLabel: { interval: 0} //x轴数据显示完整
                        },
                        yAxis: { name: '分数'},
                        series: series
                    });

    }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.location.href = "list.jsp";
    }


    $(document).ready(function () {

        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });

        getDataList();

        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>