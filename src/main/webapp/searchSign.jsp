<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 铿然
  Date: 2018/12/19
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>签到查询管理</title>
    <link rel="stylesheet" href="../layui/css/layui.css">

</head>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">

    <form class="layui-form" action="querySign">

        <div class="layui-form-item">
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-block">
                <input type="text" name="input" required  lay-verify="required" placeholder="请输入查询数据" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" >查询项</label>
            <div class="layui-input-block">
                <input type="radio" name="query" value="0" title="打卡名称" checked>
                <input type="radio" name="query" value="1" title="打卡ID" >
                <input type="radio" name="query" value="2" title="教师ID" >
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" >查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <a href="./getAllSign">查看所有打卡条目</a>
            </div>
        </div>

    </form>

    <table class="layui-table" >
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
                <td><s:property value="signID" /></td>
                <td><s:property value="name" /></td>
                <td><s:property value="description" /></td>
                <td><s:date format="YYYY-MM-dd"  name="createTime" /> </td>
                <td><s:property value="teaID" /> </td>
                <td>
                    <a href="./getSignInstance?signID=${signID}" style="color: #4476A7">查看</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>


<script src="../layui/layui.js" charset="utf-8"></script>

<script>
    layui.use('form', function () {
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功


        form.render();
    });

</script>

</div>
<%@ include file="UIbottom.jsp" %>
</html>
