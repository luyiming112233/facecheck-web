<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        查询学生信息
    </div>
    <form class="layui-form" action="stuSearch">

        <div class="layui-form-item">
            <label class="layui-form-label">查询框</label>
            <div class="layui-input-block" style="width: 200px;">
                <input type="text" name="searchMess" required lay-verify="required" placeholder="请输入查询内容"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">查询方式</label>
            <div class="layui-input-block">
                <input type="radio" name="searchType" value="0" title="学号" checked>
                <input type="radio" name="searchType" value="1" title="姓名">
                <input type="radio" name="searchType" value="2" title="班级">
                <input type="radio" name="searchType" value="3" title="专业">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <table class="layui-table" lay-data="{height:500, page:true, id:'stuTable'}" lay-filter="test" >
        <thead>
        <tr>
            <th lay-data="{field:'stuID', width:100}">学号</th>
            <th lay-data="{field:'name', width:100, sort:true}">姓名</th>
            <th lay-data="{field:'sex', width:100, sort:true}">性别</th>
            <th lay-data="{field:'clazz', width:120, sort:true}">班级</th>
            <th lay-data="{field:'depart', width:120, sort:true}">专业</th>
            <th lay-data="{field:'email', width:150}">邮箱</th>
            <th lay-data="{field:'ope',width:150}">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#session['studentList']">
            <tr>
                <td><s:property value="stuID"/></td>
                <td><s:property value="name"/></td>
                <s:if test="%{sex==1}">
                    <td>男</td>
                </s:if>
                <s:else>
                    <td>女</td>
                </s:else>
                <td><s:property value="clazz"/></td>
                <td><s:property value="depart"/></td>
                <td><s:property value="email"/></td>
                <td><a href="stuMessage?stuID=<s:property value="stuID"/>">编辑</a>
                    <a href="stuMessageDelete?stuID=<s:property value="stuID"/>">删除</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

</div>

<script src="../layui/layui.js" charset="utf-8"></script>

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

</div>
<%@ include file="UIbottom.jsp" %>
</body>
</html>