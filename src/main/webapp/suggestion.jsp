s:hidden=""s:property=""
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Shen Kai
  Date: 2018/12/28
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../layui/css/layui.css">
<html>
<head>
    <title>教师反馈</title>
</head>
<body>
<%@ include file="UITeaHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">

    </div>
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        教师反馈
    </div>
    <form action="suggest" method="post">
        <s:hidden  name ="suggest.teacher" value="#session.teacher"></s:hidden>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">反馈</label>
            <div class="layui-input-block">
                <textarea name="suggest.suggestion" placeholder="请输入内容" class="layui-textarea" ></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" type="submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>
