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
<%@ include file="UIAdminHead.jsp" %>
<div class="layui-body">
    <div class="layui-text" style="font-size: 25px; color: #393D49;width: 400px;height: 30px;padding: 35px">
        教师反馈
    </div>

    <ul class="layui-timeline">
        <s:iterator value="#request.teacherSuggestList">
            <li class="layui-timeline-item">
                <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                <div class="layui-timeline-content layui-text">
                    <h3 class="layui-timeline-title"><s:property value="time"/></h3>
                    <p>
                    <h2><s:property value="name"/></h2>
                    <br><s:property value="suggest"/></i>
                    </p>
                </div>
            </li>
        </s:iterator>
    </ul>


    <%@ include file="UIbottom.jsp" %>
</html>