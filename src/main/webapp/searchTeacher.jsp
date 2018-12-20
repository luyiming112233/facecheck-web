<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17
  Time: 13:28
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
        查询教师信息
    </div>
    <form class="layui-form" action="teaSearch">

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
                <input type="radio" name="searchType" value="0" title="工号" checked>
                <input type="radio" name="searchType" value="1" title="姓名">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <table class="layui-table" lay-data="{height:500, page:true, id:'teaTable'}" lay-filter="test" >
        <thead>
        <tr>
            <th lay-data="{field:'teaID', width:100}">工号</th>
            <th lay-data="{field:'name', width:100, sort:true}">姓名</th>
            <th lay-data="{field:'sex', width:100, sort:true}">性别</th>
            <th lay-data="{field:'phone', width:120, sort:true}">电话</th>
            <th lay-data="{field:'ope',width:150}">操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#session['teacherList']">
            <tr>
                <td><s:property value="teaID"/></td>
                <td><s:property value="name"/></td>
                <s:if test="%{sex==1}">
                    <td>男</td>
                </s:if>
                <s:else>
                    <td>女</td>
                </s:else>
                <td><s:property value="phone"/></td>
                <td><a href="teaMessage?teaID=<s:property value="teaID"/>">编辑</a>
                    <a href="teaMessageDelete?teaID=<s:property value="teaID"/>">删除</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>


</div>

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
