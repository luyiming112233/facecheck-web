<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/29
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>
    body {
        font-family: "微软雅黑";
        font-size: 14px;
    }

    .wrapper {
        width: 800px;
        margin-right: auto;
        margin-left: auto;
    }
</style>
<html>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        感谢您的反馈！
    </div>
    <form class="layui-form" action="teaSuggestInsert">
        <s:hidden value="%{#session.teacher.teaID}" name="teaID"/>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">反馈</label>
            <div class="layui-input-block">
                <textarea name="suggest" placeholder="请输入您的反馈" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="showMessage()">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
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

        function showMessage() {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg('发送反馈');
            });
        }

    </script>

    <%@ include file="UIbottom.jsp" %>
</html>
