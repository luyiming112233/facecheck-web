<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/9
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
    body{font-family:"微软雅黑";font-size:14px;}
    .wrapper{width:800px;margin-right:auto;margin-left:auto;}
</style>
<html>
<%@ include file="UIStuOpeHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        添加学生信息
    </div>
    <form class="layui-form" action="studentAdd">

        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.stuID" required lay-verify="required" placeholder="请输入学号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.name" required lay-verify="required" placeholder="请输入姓名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="student.sex" value="1" title="男">
                <input type="radio" name="student.sex" value="0" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.clazz" required lay-verify="required" placeholder="请输入班级"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.depart" required lay-verify="required" placeholder="请输入专业"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="student.email" required lay-verify="required" placeholder="请输入邮箱"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <script>
        //Demo
        layui.use('form', function () {
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function (data) {
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    </script>
    <div>
        <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
            批量导入
                <font size="2">可以批量导入后缀为xls的excel表格</font>
            </div>
        <div class="layui-input-block">
            <button class="layui-btn test" lay-data="{url: '/inputExcel/', accept: 'file'}" name="file">选择文件</button>
        </div>
            <div class="layui-input-block">
            <button class="layui-btn"  type="submit">上传文件</button>
            </div>
</div>
    <script>

        upload.render({
    elem: '.test'
    ,done: function(res, index, upload){
    //获取当前触发上传的元素，一般用于 elem 绑定 class 的情况，注意：此乃 layui 2.1.0 新增
    var item = this.item;
    }
    })
    </script>
<div>
<%@ include file="UIbottom.jsp" %>
</html>