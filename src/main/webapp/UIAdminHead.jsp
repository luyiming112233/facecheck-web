<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>签到系统管理员端</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">签到系统管理员端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left"></ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <s:property value="#session.admin.name"/>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">教师信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="addTeacher.jsp">添加教师</a></dd>
                        <dd><a href="allTeachers">教师信息查询</a></dd>
                    </dl>

                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">学生信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="addStudent.jsp">添加学生</a></dd>
                        <dd><a href="allStudents">学生信息查询</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

