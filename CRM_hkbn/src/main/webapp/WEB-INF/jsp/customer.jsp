<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="owen" uri="owenlin" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>酒店管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
          type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation"
         style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand">酒店管理系统 v1.0</a>
        </div>

        <!-- /.navbar-header -->
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
                <i class="fa fa-caret-down"></i></a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="${pageContext.request.contextPath}/user/login"
                           onclick="logout()"> <i class="fa fa-sign-out fa-fw"></i>退出登录
                    </a></li>
                </ul>
            </li>
        </ul>

        <!-- /.navbar-top-links -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li><a href="${pageContext.request.contextPath}/customer/list"
                           class="active"><i class="fa fa-edit fa-fw"></i> 客户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/room/list"
                           class="active"><i class="fa fa-dashboard fa-fw"></i> 酒店管理</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- 查询筛选条件 -->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">客户管理</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <div class="panel-body">
                <form class="form-inline"
                      action="${pageContext.request.contextPath }/customer/list.action"
                      method="post">
                    <div class="form-group">
                        <label for="name">客户名称</label> <input type="text"
                                                              class="form-control" id="name" value="${name }"
                                                              name="name">
                    </div>
                    <div class="form-group">
                        <label for="telephone">手机号码</label> <input type="text"
                                                                   class="form-control" id="telephone"
                                                                   value="${telephone }"
                                                                   name="telephone">
                    </div>
                    &nbsp;&nbsp;
                    <button type="submit" class="btn btn-primary">查询</button>
                    &nbsp;&nbsp;
                    <!-- data-toggle指以什么事件触发  data-target指事件的目标-->
                    <a href="#" class="btn btn-primary" data-toggle="modal"
                       data-target="#customerAddDialog">添加客户信息</a>
                </form>

            </div>
        </div>

        <!-- 客户信息列表 -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">客户信息列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>客户ID</th>
                            <th>客户名称</th>
                            <th>手机</th>
                            <th>身份证</th>
                            <th>房间号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.rows}" var="row">
                            <tr>
                                <td>${row.id}</td>
                                <td>${row.name}</td>
                                <td>${row.telephone}</td>
                                <td>${row.identity}</td>
                                <td>${row.roomId}</td>
                                    <%--										<td><fmt:formatDate type="date"--%>
                                    <%--												value="${row.cust_createtime }" /></td>--%>
                                <td>
<%--                                    <form class="form-inline"--%>
<%--                                          action="${pageContext.request.contextPath}/customer/getDetail.action"--%>
<%--                                          method="post">--%>
<%--                                        <button value="${row.name}" name="name"--%>
<%--                                                type="submit" class="btn btn-primary btn-xs">详情--%>
<%--                                        </button>--%>
                                    <a href="#" class="btn btn-success btn-xs"
                                       data-toggle="modal" data-target="#getDetail"
                                       onclick="getDetail(${row.id})">详情</a>
                                    <a href="#" class="btn btn-primary btn-xs"
                                       data-toggle="modal" data-target="#customerEditDialog"
                                       onclick="editCustomer(${row.id})">修改</a> <a href="#"
                                                                                   class="btn btn-danger btn-xs"
                                                                                   onclick="deleteCustomer(${row.id})">删除</a>
                                    <a href="#" class="btn btn-success btn-xs"
                                       data-toggle="modal" data-target="#getLiveIn"
                                       onclick="getLiveIn(${row.id})">办理入住</a>
<%--                                    </form>--%>
                                </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="col-md-12 text-right">
                        <owen:page
                                url="${pageContext.request.contextPath }/customer/list.action"/>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>


<!-- 客户编辑对话框 -->
<div class="modal fade" id="customerEditDialog" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_customer_form">
                    <input type="hidden" id="edit_id" name="id"/>
                    <div class="form-group">
                        <label for="edit_name" class="col-sm-2 control-label">客户名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_name"
                                   placeholder="客户名称" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_identity" class="col-sm-2 control-label">身份证</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_identity"
                                   placeholder="身份证" name="identity" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_phone" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_phone"
                                   placeholder="电话号码" name="telephone">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"
                        onclick="updateCustomer()">保存修改
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div>
    </div>
</div>
<!-- /#wrapper -->

<!-- 获取入住信息-->
<div class="modal fade" id="getLiveIn" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">入住办理</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="get_living_form">
                    <input type="hidden" id="live_id" name="id"/>
                    <input type="hidden" id="live_roomId" name="roomId"/>
                    <input type="hidden" id="live_recordId" name="recordId"/>
                    <div class="form-group">
                        <label for="get_roomNumber" class="col-sm-2 control-label">房间号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="get_roomNumber"
                                   placeholder="房间号" name="roomNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="get_inTime" class="col-sm-2 control-label">入住时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="get_inTime"
                                   placeholder="入住时间" name="inTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="get_outTime" class="col-sm-2 control-label">离开时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="get_outTime"
                                   placeholder="入住时间" name="outTime">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="get_breakfast" class="col-sm-2 control-label">含早餐</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="get_breakfast"
                                   placeholder="是否含早餐" name="breakfast">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"
                        onclick="updateLiveIn()">保存修改
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div>
    </div>
</div>

<!-- 客户添加对话框 -->
<div class="modal fade" id="customerAddDialog" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">添加客户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="add_customer_form">
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">客户名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_name"
                                   placeholder="客户名称" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_identity" class="col-sm-2 control-label">身份证</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_identity"
                                   placeholder="身份证" name="identity">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_phone" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_phone"
                                   placeholder="电话号码" name="telephone">
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"
                        onclick="addCustomer()">添加用户
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div>
    </div>
</div>

<!-- 获取客户详情 -->
<div class="modal" tabindex="-1" role="dialog" id="getDetail">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">客户详情</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="name">客户名称</label> <input type="text"
                                                          class="form-control" id="detailName" value="${detailName}"
                                                          name="detailName" disabled>
                </div>
                <div class="form-group">
                    <label for="telephone">手机号码</label> <input type="text"
                                                               class="form-control" id="detailTelephone"
                                                               value="${detailTelephone}"
                                                               name="detailTelephone" disabled>
                </div>
                <div class="form-group">
                    <label for="telephone">身份证</label> <input type="text"
                                                               class="form-control" id="detailIdentity"
                                                               value="${detailIdentity}"
                                                               name="detailIdentity" disabled>
                </div>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>房间号码</th>
                        <th>入住时间</th>
                        <th>离开时间</th>
                        <th>含早餐</th>
                        <th>每晚价格</th>
                    </tr>
                    </thead>
                    <tbody id="recordList">
                    </tbody>
                </table>
                <div class="col-md-12 text-right">
                    <owen:page
                            url="${pageContext.request.contextPath }/customer/getDetail.action"/>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="<%=basePath%>js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath%>js/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=basePath%>js/sb-admin-2.js"></script>

<script type="text/javascript">
    function editCustomer(id) {
        $.ajax({
            type: "get",
            url: "<%=basePath%>customer/edit.action",
            data: {"id": id},
            success: function (data) {
                $("#edit_id").val(data.id);
                $("#edit_name").val(data.name);
                $("#edit_phone").val(data.telephone);
                $("#edit_identity").val(data.identity);
            }
        });
    }

    function updateCustomer() {
        $.post("<%=basePath%>customer/update.action", $("#edit_customer_form").serialize(), function (data) {
            alert("客户信息更新成功！");
            window.location.reload();
        });
    }

    function deleteCustomer(id) {
        if (confirm('确实要删除该客户吗?')) {
            $.post("<%=basePath%>customer/delete.action", {"id": id}, function (data) {
                alert("客户删除成功！");
                window.location.reload();
            });
        }
    }


    function addCustomer() {
        $.post("<%=basePath%>customer/add.action", $("#add_customer_form").serialize(), function (data) {
            alert("客户信息添加成功！");
            window.location.reload();
        });
    }

    function logout() {
        $.post("<%=basePath%>user/logout.action", function (data) {
            alert("成功退出登录！");
        });
    }

    function getLiveIn(id) {
        $.ajax({
            type: "get",
            url: "<%=basePath%>customer/getLiveIn.action",
            data: {"id": id},
            success: function (data) {
                $("#get_roomNumber").val(data.roomNumber);
                $("#get_inTime").val(formatDate(data.inTime));
                $("#get_outTime").val(formatDate(data.outTime));
                $("#get_breakfast").val(data.breakfast);
                $("#live_id").val(data.id);
                $("#live_roomId").val(data.roomId);
                $("#live_recordId").val(data.recordId);
            }
        });
    }

    function formatDate(timestamp) {
    	var now = new Date(timestamp);
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        var date = now.getDate();
        var hour = now.getHours();
        var minute = now.getMinutes();
        var second = now.getSeconds();
        return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
    }

    function updateLiveIn() {
        $.post("<%=basePath%>customer/updateLiveIn.action", $("#get_living_form").serialize(), function (data) {
            if (data){
                alert("入住信息更新成功！");
                window.location.reload();
            }else {
                alert("入住失败，房间正在维修中...");
            }
        });
    }

    function getDetail(id) {
        $.ajax({
            type: "get",
            url: "<%=basePath%>customer/getDetail.action",
            data: {"id": id},
            success: function (data) {
                console.log("data: "+JSON.stringify(data));
                $("#detailName").val(data.name);
                $("#detailTelephone").val(data.telephone);
                $("#detailIdentity").val(data.identity);

                for(var i = 0; i < data.recordList.rows.length; i ++){
                    var dataList = [];
                    var obj = data.recordList.rows[i];
                    dataList[0] = obj.roomNumber;
                    dataList[1] = obj.inTime;
                    dataList[2] = obj.outTime;
                    dataList[3] = obj.breakfast;
                    dataList[4] = obj.price;
                    console.log("dataList: "+JSON.stringify(dataList));
                    creatTable(dataList, "recordList")
                }

            }
        });
    }

    function creatTable(data, id){
        var tableData = "<tr>";
        for(var i = 0; i < data.length; i++){
            tableData += "<td>" + data[i] + "</td>"
        }
        tableData += "</tr>";
        document.getElementById(id).innerHTML=tableData;
    }

</script>

</body>

</html>
