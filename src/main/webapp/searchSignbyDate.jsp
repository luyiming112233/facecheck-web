<%--
  Created by IntelliJ IDEA.
  User: 铿然
  Date: 2018/12/19
  Time: 21:21
  用于按照日期进行签到查询的页面
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>按照日期查询签到</title>
    <link rel="stylesheet" href="/static/build/layui.css" media="all">
</head>
<body>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">

<form class="layui-form" action="querySignbyDate">

    <div class="layui-form-item">
        <label class="layui-form-label" >日期选择</label>
        <div class="layui-input-block">

                <input type="text" class="layui-input" id="test1" name="input" required  lay-verify="required" placeholder="请选择日期" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label" >查询项</label>
        <div class="layui-input-block">
            <input type="radio" name="query" value="0" title="查询该日期签到项" checked>
            <input type="radio" name="query" value="1" title="查询该日期以后有效签到项" >

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo1" >查询</button>

        </div>
    </div>
</form>
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>

            <th lay-data="{field:'stuID', width:100}">打卡ID</th>
            <th lay-data="{field:'name', width:100, sort:true}">打卡名</th>
            <th lay-data="{field:'sex', width:100, sort:true}">打卡描述</th>
            <th lay-data="{field:'clazz', width:120, sort:true}">打卡发布日期</th>
            <th lay-data="{field:'depart', width:120, sort:true}">教师ID</th>
            <th lay-data="{field:'depart', width:120, sort:true}"></th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="signs">
            <tr>
                <td><s:property value="signID"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="description"/></td>
                <td><s:date format="YYYY-MM-dd" name="createTime"/></td>
                <td><s:property value="teaID"/></td>
                <td>
                    <a href="./getSignInstance?signID=${signID}" style="color: #4476A7">查看</a></td>
            </tr>
        </s:iterator>
        </tbody>
<script src="../layui/layui.js"></script>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
    });
</script>
<script >

    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        form.on('submit(formDemo1)', function(data){
        });


        form.render();
    });

</script>
</body>
</html>