<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DEll
  Date: 2018/12/5
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>模板创建</title>
    <link rel="stylesheet" type="text/css" href="/cssfile/Releasetask.css"/></head>
<link rel="stylesheet" type="text/css" href="/cssfile/DateTimePicker.css" />
<script type="text/javascript" src="/jsfile/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/jsfile/DateTimePicker.js"></script>
</head>
<body>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
<form action="TaskOutCenterAction" method="post" align="center" class="layui-table">




    <div class="layui-form-item">
        <label class="layui-form-label">教师ID</label>
        <div class="layui-input-block">
            <input type="text" name="sign.teaID" style="width: 100px" required value=${teacher.teaID} lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">打卡名</label>
        <div class="layui-input-block">
            <input type="text" name="sign.name" style="width: 100px" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <textarea name="sign.description" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
</div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
